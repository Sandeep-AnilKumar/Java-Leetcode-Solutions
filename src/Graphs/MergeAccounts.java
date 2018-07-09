package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MergeAccounts {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        DSU dsu = new DSU();
        Map<String, String> emailToName = new HashMap<>();
        Map<String, Integer> emailToID = new HashMap<>();
        int id = 0;
        for (List<String> account : accounts) {
            String name = "";
            for (String email : account) {
                if (name.equals("")) {
                    name = email;
                    continue;
                }
                emailToName.put(email, name);
                if (!emailToID.containsKey(email)) {
                    emailToID.put(email, id++);
                }
                dsu.union(emailToID.get(account.get(1)), emailToID.get(email));
            }
        }

        Map<Integer, List<String>> ans = new HashMap<>();
        for (String email : emailToName.keySet()) {
            int index = dsu.find(emailToID.get(email));
            ans.computeIfAbsent(index, x -> new ArrayList<>()).add(email);
        }
        for (List<String> component : ans.values()) {
            Collections.sort(component);
            component.add(0, emailToName.get(component.get(0)));
        }
        return new ArrayList<>(ans.values());
    }

    class DSU {
        int[] parent;

        public DSU() {
            parent = new int[10001];
            for (int i = 0; i <= 10000; ++i)
                parent[i] = i;
        }

        public int find(int x) {
            if (parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }

        public void union(int x, int y) {
            parent[find(x)] = find(y);
        }
    }

    public static void main(String[] args) {
        MergeAccounts mergeAccounts = new MergeAccounts();
        List<List<String>> accounts = Arrays.asList(
                new ArrayList<>(Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com")),
                new ArrayList<>(Arrays.asList("John", "johnnybravo@mail.com")),
                new ArrayList<>(Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com")),
                new ArrayList<>(Arrays.asList("Mary", "mary@mail.com")));
        List<List<String>> mergedAccounts = mergeAccounts.accountsMerge(accounts);
        System.out.println("The merged accounts are := ");
        for (List<String> account : mergedAccounts) {
            System.out.println(account);
        }
    }
}
