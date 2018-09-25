package DesignPatterns.CreationalPatterns.ObjectPool;

public class JDBCConnectionPool extends AConnectionPool<Connection> {

  private String ds;
  private String userName;
  private String password;
  private int maxConnections;
  private long maxKeepAlive;


  private JDBCConnectionPool(Builder builder) {
    super(builder.getMaxConnections(), builder.getMaxKeepAlive());
    setDs(builder.getDs());
    setUserName(builder.getUserName());
    setPassword(builder.getPassword());
  }
  
  public static Builder getPool() { return new Builder(); }
  
  public String getDs() { return ds; }

  private void setDs(String ds) { this.ds = ds; }

  public String getUserName() { return userName; }

  private void setUserName(String userName) { this.userName = userName; }

  public String getPassword() { return password; }

  private void setPassword(String password) { this.password = password; }

  public int getMaxConnections() { return maxConnections; }

  private void setMaxConnections(int maxConnections) { this.maxConnections = maxConnections; }

  @Override
  protected Connection create() {
    return new Connection(getDs(), getUserName(), getPassword());
  }

  @Override
  public boolean validate(Connection connection) {
    return !connection.isClosed();
  }
  
  @Override
  protected void expire(Connection connection) {
    connection.close();
  }
  
  public static class Builder {
    private String ds;
    private String userName;
    private String password;
    private int maxConnections;
    private long maxKeepAlive;
    
    private Builder() { }
    
    public Builder withDs(String ds) {
      this.ds = ds;
      return this;
    }

    public Builder withUsername(String userName) {
      this.userName = userName;
      return this;
    }

    public Builder withPassword(String password) {
      this.password = password;
      return this;
    }

    public Builder withMaxConnections(int maxConnections) {
      this.maxConnections = maxConnections;
      return this;
    }
    
    public Builder withMaxKeepAlive(long maxKeepAlive) {
      this.maxKeepAlive = maxKeepAlive;
      return this;
    }

    private String getDs() { return ds; }

    private String getUserName() { return userName; }

    private String getPassword() { return password; }

    private int getMaxConnections() { return maxConnections; }
    
    private long getMaxKeepAlive() { return maxKeepAlive; }
    
    public JDBCConnectionPool build() {
      return new JDBCConnectionPool(this);
    }
  }
}
