package Threads.Chatter;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.concurrent.Future;
import static Threads.Chatter.Server.users;

public class User implements Runnable {
  private String name;
  private DataInputStream in;
  private DataOutputStream out;
  private Future<?> userHandle;
  
  public User(String name, DataInputStream in, DataOutputStream out) {
    setName(name);
    setIn(in);
    setOut(out);
  }
  
  public void setName(String name) { this.name = name;}
  public String getName() { return name; }

  public DataInputStream getIn() { return in; }
  public void setIn(DataInputStream in) { this.in = in; }

  public DataOutputStream getOut() { return out; }
  public void setOut(DataOutputStream out) { this.out = out; }

  public Future<?> getUserHandle() { return userHandle; }
  public void setUserHandle(Future<?> userHandle) { this.userHandle = userHandle; }

  @Override
  public void run() {
    String input = "", recipient = "";
    String[] parts;
    StringBuilder sb;
    
    while (true) {
      try {
        if (in.available() > 0) {
          input = in.readUTF();
          if (input.length() > 0 && input.equals("logout")) {
            out.writeUTF("*************** Bye! See you soon ***************");
            break;
          }

          if (!input.startsWith("@")) {
            out.writeUTF("*************** Please add '@username' before the message. ***************");
            continue;
          }

          parts = input.split("\\s+");
          recipient = parts[0].replaceAll("@", "");
          if (!users.containsKey(recipient.toLowerCase())) {
            out.writeUTF("*************** User - " + recipient + " does not exists ***************");
            continue;
          }

          sb = new StringBuilder();
          sb.append("\t\t\t\t").append(name).append(" : ");
          for (int i = 1; i < parts.length; ++i) {
            sb.append(parts[i]).append(" ");
          }

          users.get(recipient.toLowerCase()).getOut().writeUTF(sb.toString());
        }
      } catch (IOException e) {
        try {
          out.writeUTF("*************** Something is wrong with the server, please try again later ***************");
        } catch (IOException io) { 
          System.out.println("Failed to write the error message to client");
        }
        System.out.println("*************** Couldn't construct the message, please re-try ***************");
        e.printStackTrace();
        break;
      }
    }
    users.remove(name);
  }
}
