package DesignPatterns.CreationalPatterns.Prototype;

import java.util.HashMap;
import java.util.Map;

public class ConnectionFactory {
  
  private static final Map<String, AConnection> cache; 
  
  static { 
    cache = new HashMap<String, AConnection>()
    {{
      put("jdbc", new JDBCConnection());
      put("http", new HTTPConnection());
    }};
  }
  
  public static AConnection getConnection(String type) throws Exception {
    if (!cache.containsKey(type)) throw new Exception("Illegal connection type");
    return (AConnection) cache.get(type).clone();
  }
}
