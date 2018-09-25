package DesignPatterns.CreationalPatterns.ObjectPool;

public class Connection {

  private String ds;
  private String username;
  private String password;
  private boolean closed;

  public Connection(String ds, String username, String password) {
    setDs(ds);
    setUsername(username);
    setPassword(password);
    close(false);
  }

  public String getDs() {
    return ds;
  }

  public void setDs(String ds) {
    this.ds = ds;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
  
  public void close() {
    close(true);
  }
  
  public void close(boolean flag) {
    closed = flag;
  }
  
  public boolean isClosed() {
    return closed;
  }
  
  public String prepareStatement() {
    return "preparing statement";
  }
  
  public String execute() {
    return "executing statement";
  }
}
