package Threads.GroupChatter;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

import static Threads.GroupChatter.Server.broadcast;
import static Threads.GroupChatter.Server.users;

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
    String input = "";

    while (true) {
      try {
        if (in.available() > 0) {
          input = in.readUTF();
          if (input.length() > 0) {
            if (input.equals("logout")) {
              out.writeUTF("*************** Bye! See you soon ***************");
              broadcast(name, "*************** " + name + " left ***************");
              break;
            } else if (input.equals("show users")) {
              out.writeUTF(users.keySet().stream().filter(key -> !key.equals(name)).collect(Collectors.toList()).toString());
            } else {
              broadcast(name, "\t\t\t\t" + name + " : " + input);
            }
          }
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
