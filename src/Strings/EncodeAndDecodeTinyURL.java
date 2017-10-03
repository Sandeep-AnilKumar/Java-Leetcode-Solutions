package Strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author sandeepa
 */

public class EncodeAndDecodeTinyURL {

	public static void main(String[] args) {
		EncodeAndDecodeTinyURL codec = new EncodeAndDecodeTinyURL();
		String longUrl = "https://stackoverflow.com/question/why_do_i_like_java?awesome=true&sandeep=true";

		String encoded = codec.encode(longUrl);
		System.out.println("The encoded short url is := " + encoded);
		System.out.println("The decoded url is := " + codec.decode(encoded));
	}


	Map<String, String> longToShort;
	Map<String, String> shortToLong;

	String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	Random rand;

	public EncodeAndDecodeTinyURL() {
		longToShort = new HashMap<>();
		shortToLong = new HashMap<>();
		rand = new Random();
	}

	public String getRand() {
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < 6; ++i) {
			sb.append(chars.charAt(rand.nextInt(62)));
		}
		return sb.toString();
	}

	// Encodes a URL to a shortened URL.
	public String encode(String longUrl) {
		if(longToShort.containsKey(longUrl)) return longToShort.get(longUrl);

		String hashCode = "";

		do {
			hashCode = getRand();
		} while(shortToLong.containsKey(hashCode));

		shortToLong.put(hashCode, longUrl);
		return "http://tinyurl.com/" + hashCode;
	}

	// Decodes a shortened URL to its original URL.
	public String decode(String shortUrl) {
		return shortToLong.get(shortUrl.replace("http://tinyurl.com/", ""));
	}
}