package Threads.Chatter;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;

public class Client {

  private DataInputStream in;
  private DataOutputStream out;
  private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

  private Client(DataInputStream in, DataOutputStream out) {
    setIn(in);
    setOut(out);
  }

  public DataInputStream getIn() {
    return in;
  }

  public void setIn(DataInputStream in) {
    this.in = in;
  }

  public DataOutputStream getOut() {
    return out;
  }

  public void setOut(DataOutputStream out) {
    this.out = out;
  }

  private void createClientAccount() throws IOException {
    String username = "";
    int index = 0;
    System.out.print("Please enter your username : ");

    do {
      if (index > 0) {
        System.out.println("*************** Please enter a different username, this name is already taken ***************");
        System.out.print("Please enter a username : ");
      }
      username = bufferedReader.readLine();
      out.writeUTF(username);
      index++;
    } while (!in.readUTF().equals("User added"));
  }

  public static void main(String[] args) throws IOException {
    if (args.length == 0) {
      throw new RuntimeException("Port to connect to is not provided");
    }

    InetAddress inetAddress = InetAddress.getByName("localhost");
    int port = Integer.parseInt(args[0]);
    Socket socket = new Socket(inetAddress, port);

    DataInputStream in = new DataInputStream(socket.getInputStream());
    DataOutputStream out = new DataOutputStream(socket.getOutputStream());

    Client client = new Client(in, out);
    client.createClientAccount();

    //read messages
    Thread reader = new Thread(() -> {
      while (true) {
        try {
          String message = in.readUTF();
          System.out.println(message);
        } catch (IOException io) {
          System.out.println("*************** Something is wrong, please restart the client ***************");
          try {
            in.close();
            out.close();
            socket.close();
            break;
          } catch (IOException inIO) { inIO.printStackTrace(); }
        }
      }
    });

    reader.start();

    //write messages
    Thread writer = new Thread(() -> {
      while (true) {
        try {
          String message = "";
          while ((message = bufferedReader.readLine()) != null) {
            if (message.length() > 0) {
              out.writeUTF(message);
            }
          }
        } catch (IOException io) {
          io.printStackTrace();
          System.out.println("*************** Couldn't construct the message. Please restart the client ***************");
          break;
        }
      }
    });

    writer.start();

    try {
      reader.join();
      writer.join();
    } catch (InterruptedException ie) {
      reader.interrupt();
      writer.interrupt();
    } finally {
      bufferedReader.close();
    }
  }
}
