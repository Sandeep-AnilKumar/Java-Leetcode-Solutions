package Google;

import java.util.HashMap;
import java.util.Map;

public class Logger {
	int window = 10;
	Map<String, Integer> mMap = null;
	/** Initialize your data structure here. */
	public Logger() {
		mMap = new HashMap<>();
	}

	/** Returns true if the message should be printed in the given timestamp, otherwise returns false.
	        If this method returns false, the message will not be printed.
	        The timestamp is in seconds granularity. */
	//Will work, but is not efficient. This will also store the old messages that are not needed.
	public boolean shouldPrintMessage(int timestamp, String message) {
		if(message != null && message.length() != 0) {
			if(!mMap.containsKey(message) || timestamp - mMap.get(message) >= window) {
				mMap.put(message, timestamp);
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Logger logger = new Logger();
		System.out.println(logger.shouldPrintMessage(1, "foo")); //true
		System.out.println(logger.shouldPrintMessage(2, "bar")); //true
		System.out.println(logger.shouldPrintMessage(3, "foo")); //false
		System.out.println(logger.shouldPrintMessage(8, "bar")); //false
		System.out.println(logger.shouldPrintMessage(10, "foo")); //false
		System.out.println(logger.shouldPrintMessage(11, "foo")); // true
		System.out.println(logger.shouldPrintMessage(13, "bar")); //true
	}
}
