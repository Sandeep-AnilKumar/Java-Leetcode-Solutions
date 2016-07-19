package Arrays;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FraudTransactionsUsingList {
	public static void main(String[] args) {
		List<String> transactions = new ArrayList<String>();
		List<String> users = new ArrayList<String>();

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

			users = fradulentUsers(transactions);

			if(users != null && users.size() > 0) {
				for(Iterator<String> i = users.iterator(); i.hasNext();) {
					System.out.println(i.next());
				}
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

	public static List<String> fradulentUsers(List<String> transactions) {

		List<String> fraudulentUsers = new ArrayList<String>();
		if(transactions == null || transactions.size() == 0)
			return fraudulentUsers;

		String transaction = "";
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

		for(Iterator<String> i = transactions.iterator(); i.hasNext();) {
			transaction = i.next();

			if(transaction != null && transaction.length() != 0) {

				parts = transaction.split("\\|");
				name = parts[0];
				amount = Integer.parseInt(parts[1]);

				if(amount > 3000 && !fraudulentUsers.contains(name)) {
					fraudulentUsers.add(name);
					continue;
				}

				if(!nameTransactionPair.containsKey(name)) {
					nameTransactionPair.put(name,transaction);
				}

				else {
					oldTransaction = nameTransactionPair.get(name);
					oldTransactionParts = oldTransaction.split("\\|");

					location = parts[2];
					oldLocation = oldTransactionParts[2];

					if(!location.equals(oldLocation)) {
						time = Integer.parseInt(parts[3]);
						oldTransactionTime = Integer.parseInt(oldTransactionParts[3]);

						if(time - oldTransactionTime < 60 && !fraudulentUsers.contains(name)) {
							fraudulentUsers.add(name);
						}
					}
					nameTransactionPair.put(name,transaction);
				}
			}
		}
		return fraudulentUsers;
	}
}