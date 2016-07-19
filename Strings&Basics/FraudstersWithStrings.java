package String;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class FraudstersWithStrings {

	public static void main(String[] args) {
		List<String> transactions = new ArrayList<String>();
		String users[] = new String[]{};

		FileInputStream fs = null;
		DataInputStream ds = null;
		BufferedReader br = null;

		try {
			fs = new FileInputStream("C:\\Users\\Sandeep\\Desktop\\Transactions.txt");
			ds = new DataInputStream(fs);
			br = new BufferedReader(new InputStreamReader(ds));

			String currentLine = "";

			while((currentLine = br.readLine()) != null) {
				transactions.add(currentLine);
			}

			users = getSuspiciousList(transactions);
			for(int i = 0; i < users.length; i++) {
				System.out.println(users[i]);
			}
		}

		catch(IOException e) {
			e.printStackTrace();
		}

		finally {
			try {
				if(br != null)
					br.close();
				if(ds != null)
					ds.close();
				if(fs != null)
					fs.close();
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static String[] getSuspiciousList(List<String> transactions) {
		if(transactions == null || transactions.size() == 0) {
			return new String[0];
		}
		int length = transactions.size();
		String parts[];
		Map<String,String> nameTransactionPair = new HashMap<String,String>();
		String name = "";
		int amount = 0;
		String location = "";
		int time = 0;
		String oldTransaction = "";
		String oldTransactionParts[];
		String oldLocation = "";
		int oldTransactionTime = 0;
		Map<Integer,String> orderedMap = new TreeMap<Integer,String>();

		for(int i = 0; i < length; i++) {
			if(transactions.get(i) != null && transactions.get(i).length() != 0) {
				parts = transactions.get(i).split("\\|");
				name = parts[0];
				amount = Integer.parseInt(parts[1]);
				time = Integer.parseInt(parts[3]);

				if(!nameTransactionPair.containsKey(name)) {               
					if(amount > 3000 && !orderedMap.containsValue(name)) {
						orderedMap.put(time,name);
					}
					nameTransactionPair.put(name, transactions.get(i));
				}

				else if(amount > 3000 && !orderedMap.containsValue(name)) {
					orderedMap.put(time,name);
				}

				else if (!orderedMap.containsValue(name)) {
					oldTransaction = nameTransactionPair.get(name);
					oldTransactionParts = oldTransaction.split("\\|");
					location = parts[2];
					oldLocation = oldTransactionParts[2];

					if(!location.equals(oldLocation)) {
						time = Integer.parseInt(parts[3]);
						oldTransactionTime = Integer.parseInt(oldTransactionParts[3]);

						if(time - oldTransactionTime < 60 ) {
							orderedMap.put(oldTransactionTime,name);
						}
					}
					nameTransactionPair.put(name, transactions.get(i));  
				}
			}
		}

		Set<Entry<Integer, String>> set = orderedMap.entrySet();
		String[] fraudsters = new String[orderedMap.size()];
		Iterator<Entry<Integer, String>> i = set.iterator();

		int j = 0;
		while(i.hasNext()) {
			Entry<Integer, String> m = i.next();
			fraudsters[j] = m.getValue().toString();
			j++;
		}
		return fraudsters;
	}
}
