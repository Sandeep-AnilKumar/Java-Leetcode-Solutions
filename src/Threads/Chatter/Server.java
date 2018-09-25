package Threads.Chatter;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Server {
  private ServerSocket serverSocket;
  static Map<String, User> users;
  
  private Server(int port) {
    try {
      serverSocket = new ServerSocket(port);
      users = new ConcurrentHashMap<>();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  
  private void listen() {
    while (true) {
      try {
        Socket socket = serverSocket.accept();
        System.out.println("New client request initiated");

        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        Executors.newSingleThreadExecutor().submit(() -> {
          String userName = "";
          User user;
          try {
            
            //Adding client with a unique user-chosen name.
            do {
              userName = in.readUTF().toLowerCase();
              
              if (users.containsKey(userName)) {
                out.writeUTF("Please enter a different username, this name is already taken");
                continue;
              }
              user = new User(userName, in, out);
              users.put(userName, user);
              
              System.out.println("User " + userName + " added");
              out.writeUTF("User added");
              break;
              
            } while(true);
            
            //Starting the client
            Future<?> userHandle = Executors.newSingleThreadExecutor().submit(user);
            user.setUserHandle(userHandle);
            
          } catch (IOException e) {
            System.out.println("Exception occurred while adding user");
          }
        });
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
  
  public static void main(String[] args) {
    if (args.length == 0) {
      throw new RuntimeException("Port to listen to is not provided");
    }
    
    int port = Integer.parseInt(args[0]);
    Server server = new Server(port);
    System.out.println("Server is now listening at port : " + port);
    server.listen();
  }
}
