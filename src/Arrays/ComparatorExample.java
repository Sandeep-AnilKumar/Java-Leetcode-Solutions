package Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class ComparatorExample {

	public static void main(String[] args) {

		Map<String,Double> codenames = new HashMap<String,Double>();
		codenames.put("Java1.2", 1.2);
		codenames.put("Java1.0.1", 12.0);
		codenames.put("Java1.3", 12.1);
		codenames.put("Java1.5", 1.23);
		codenames.put("Java1.1.2", 1.02);
		codenames.put("Java1.6", 12.23);

		System.out.println("The map in random order is");
		int i = 1;
		for(Map.Entry<String,Double> entry : codenames.entrySet())
			System.out.printf("Entry #%d --> %s : %.3f %n",i++,entry.getKey(),entry.getValue());

		TreeMap<String,Double> treeMapSorted = new TreeMap<String,Double>(codenames);
		Set<Entry<String,Double>> entrySet = treeMapSorted.entrySet();

		System.out.println("Map sorted by key");
		i=1;
		for(Entry<String,Double> entry : entrySet)
			System.out.printf("Entry #%d --> %s : %.3f %n",i++, entry.getKey(),entry.getValue());

		Comparator<Entry<String,Double>> valueComparator = new Comparator<Entry<String,Double>>(){
			@Override
			public int compare(Entry<String,Double> v1, Entry<String,Double> v2)
			{
				return v1.getValue().compareTo(v2.getValue());
			}
		};

		List<Entry<String,Double>> listEntries = new ArrayList<Entry<String,Double>>(codenames.entrySet());
		Collections.sort(listEntries,valueComparator);

		System.out.println("The map after sorting is");

		i=1;
		for(Iterator<Entry<String,Double>> iList = listEntries.iterator(); iList.hasNext();)
		{
			Entry<String,Double> listEntry = iList.next();
			System.out.printf("Entry #%d --> %s : %.3f %n",i++,listEntry.getKey(),listEntry.getValue());
		}
	}
}
