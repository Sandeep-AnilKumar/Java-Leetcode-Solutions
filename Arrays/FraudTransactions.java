package Arrays;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FraudTransactions {

	public static void main(String[] args) {
		DataInputStream ds = null;
		FileInputStream fs = null;
		BufferedReader br = null;

		try {
			String currentLine;
			String parts[];
			Map<String,String> nameTransactionPair = new HashMap<String,String>();
			List<String> fraudulentUsers = new ArrayList<String>();
			String name = "";
			int amount = 0;
			String location = "";
			int time = 0;
			String oldTransaction = "";
			String oldTransactionParts[];
			String oldLocation = "";
			int oldTransactionTime = 0;

			fs = new FileInputStream("C:\\Users\\Sandeep\\Desktop\\Transactions.txt");
			ds = new DataInputStream(fs);
			br = new BufferedReader(new InputStreamReader(ds));

			while((currentLine = br.readLine()) != null) {
				parts = currentLine.split("\\|");

				amount = Integer.parseInt(parts[1]);
				if(amount > 3000) {
					fraudulentUsers.add(name);
					continue;
				}
				name = parts[0];

				if(!nameTransactionPair.containsKey(name)) {
					nameTransactionPair.put(name,currentLine);
				}

				else {
					oldTransaction = nameTransactionPair.get(name);
					oldTransactionParts = oldTransaction.split("\\|");

					location = parts[2];
					oldLocation = oldTransactionParts[2];

					if(!location.equals(oldLocation)) {
						time = Integer.parseInt(parts[3]);
						oldTransactionTime = Integer.parseInt(oldTransactionParts[3]);

						if(time - oldTransactionTime < 60) {
							fraudulentUsers.add(name);
						}
					}
				}
			}
		}
		catch(IOException e){
			e.printStackTrace();
		}

		finally {
			try {
				if(br != null)
					br.close();
				if(fs != null)
					fs.close();
				if(ds != null)
					ds.close();
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}
