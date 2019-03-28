package Strings;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ClusterTable {
	public static void main(String[] args) {
		String clusterInfo = "c1:table1|c2:table2|c1:table3";
		Map<String, List<String>> map = Arrays.stream(clusterInfo.split("\\|"))
				.collect(Collectors.toList())
				.stream()
				.collect(Collectors.groupingBy(clusterTableInfo -> clusterTableInfo.split(":")[0],
						Collectors.mapping(clusterTableInfo -> clusterTableInfo.split(":")[1], Collectors.toList())));

		System.out.println(map);
	}
}
