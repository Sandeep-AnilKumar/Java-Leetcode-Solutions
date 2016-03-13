package Arrays;

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

public class UserPages {

	public static void main(String[] args) {
		List<String> userPages = new ArrayList<String>();
		List<String> users = new ArrayList<String>();

		FileInputStream fs = null;
		DataInputStream ds = null;
		BufferedReader br = null;

		try {
			fs = new FileInputStream("C:\\Users\\Sandeep\\Desktop\\Users.txt");
			ds = new DataInputStream(fs);
			br = new BufferedReader(new InputStreamReader(ds));

			String currentLine = "";

			while((currentLine = br.readLine()) != null) {
				userPages.add(currentLine);
			}

			users = getCommonUsers(userPages);
			for(int i = 0; i < users.size(); i++) {
				System.out.println(users.get(i));
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

	public static List<String> getCommonUsers(List<String> userPages) {

		List<String> users = new ArrayList<String>();
		if(userPages == null || userPages.size() == 0){
			return users;
		}

		int length = userPages.size();
		String parts[];
		String user = "";
		String page = "";
		String temp1 = "";
		String temp2 = "";
		String temp = "";
		int size = 0;
		Map<String,List<String>> pageToUserMap = new HashMap<String,List<String>>();
		Map<String,List<String>> userToPageMap = new HashMap<String,List<String>>();
		List<String> pages1 = new ArrayList<String>();
		List<String> pages2 = new ArrayList<String>();
		List<String> tempList = new ArrayList<String>();

		for(int i = 0; i < length; i++) {
			if(userPages.get(i) != null && userPages.get(i).length() > 0) {
				parts = userPages.get(i).split("\\s+");

				tempList = new ArrayList<String>();

				if(parts != null && parts.length == 2) {
					user = parts[0];
					page = parts[1];
				}

				if(!userToPageMap.containsKey(user)) {
					tempList.add(page);
					userToPageMap.put(user,tempList);
				}

				else {
					tempList = userToPageMap.get(user);
					if(!tempList.contains(page)) {
						tempList.add(page);
						userToPageMap.put(user, tempList);
					}
				}

				tempList = new ArrayList<String>();

				if(!pageToUserMap.containsKey(page)) {
					tempList.add(user);
					pageToUserMap.put(page,tempList);
				}

				else {
					tempList = pageToUserMap.get(page);
					if(!tempList.contains(user)) {
						tempList.add(user);
						pageToUserMap.put(page, tempList);
					}
				}
			}
		}

		Set<Entry<String,List<String>>> set = pageToUserMap.entrySet();

		for(Iterator<Entry<String,List<String>>> i = set.iterator(); i.hasNext();) {
			tempList = new ArrayList<String>();
			tempList =  i.next().getValue();
			size = tempList.size();

			for(int j = 0; j < tempList.size(); j++) {
				temp1 = tempList.get(j);
				pages1 = userToPageMap.get(temp1);

				for(int k = j + 1; k < tempList.size(); k++) {
					temp2 = tempList.get(k);
					pages2 = userToPageMap.get(temp2);

					if(pages1.size() == pages2.size() && pages1.containsAll(pages2) && pages2.containsAll(pages1)) {
						int val = temp1.compareTo(temp2);

						if(val == 1) {
							temp = temp2 + "," + temp1;
						}
						else {
							temp = temp1 + "," + temp2;
						}

						if(!users.contains(temp)) {
							users.add(temp);
						}
					}
				}
			}
		}
		return users;
	}
}
