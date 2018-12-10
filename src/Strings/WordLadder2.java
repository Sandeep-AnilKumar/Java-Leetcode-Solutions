package Strings;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLadder2 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> visited = new HashSet<>();
        Deque<String> dq = new ArrayDeque<>();
        int cur = 1, temp = 0, depth = 1;
        String curStr = "";
        dq.offer(beginWord);
        visited.add(beginWord);

        while (!dq.isEmpty()) {
            curStr = dq.poll();

            if (cur == 0) {
                depth++;
                cur = temp;
                temp = 0;
            }
            cur--;

            for (String next : wordList) {
                if (curStr != null && !visited.contains(next) && oneEditDistance(curStr, next)) {
                    if (next.equals(endWord)) return depth + 1;
                    dq.offer(next);
                    visited.add(next);
                    temp++;
                }
            }
        }
        return 0;
    }

    public List<String> findOneLadder(String beginWord, String endWord, List<String> wordList) {
        Set<String> visited = new HashSet<>();
        Deque<String> dq = new ArrayDeque<>();
        int cur = 1, temp = 0, depth = 1;
        Map<String, String> parent = new HashMap<>();
        String curStr = "";
        dq.offer(beginWord);
        visited.add(beginWord);
        parent.put(beginWord, "none");
        boolean found = false;
        List<String> transformations = new ArrayList<>();

        while (!dq.isEmpty()) {
            curStr = dq.poll();
            found = false;

            if (cur == 0) {
                depth++;
                cur = temp;
                temp = 0;
            }
            cur--;

            for (String next : wordList) {
                if (curStr != null && !visited.contains(next) && oneEditDistance(curStr, next)) {
                    parent.put(next, curStr);
                    if (next.equals(endWord)) {
                        found = true;
                        break;
                    }
                    dq.offer(next);
                    visited.add(next);
                    temp++;
                }
            }

            if (found) break;
        }

        if (found) {
            curStr = endWord;
            while (!curStr.equals("none")) {
                transformations.add(0, curStr);
                curStr = parent.get(curStr);
            }
        }
        return transformations;
    }

    public List<List<String>> findLadders(String start, String end, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        List<List<String>> res = new ArrayList<>();
        Map<String, ArrayList<String>> nodeNeighbors = new HashMap<>();// Neighbors for every node
        Map<String, Integer> distance = new HashMap<>();// Distance of every node from the start node
        ArrayList<String> solution = new ArrayList<>();

        dict.add(start);
        bfs(start, end, dict, nodeNeighbors, distance);
        dfs(start, end, nodeNeighbors, distance, solution, res);
        return res;
    }

    // BFS: Trace every node's distance from the start node (level by level).
    private void bfs(String start, String end, Set<String> dict, Map<String, ArrayList<String>> nodeNeighbors, Map<String, Integer> distance) {
        for (String str : dict)
            nodeNeighbors.put(str, new ArrayList<>());

        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        distance.put(start, 0);

        while (!queue.isEmpty()) {
            int count = queue.size();
            boolean foundEnd = false;
            for (int i = 0; i < count; i++) {
                String cur = queue.poll();
                int curDistance = distance.get(cur);
                ArrayList<String> neighbors = getNeighbors(cur, dict);

                for (String neighbor : neighbors) {
                    nodeNeighbors.get(cur).add(neighbor);
                    if (!distance.containsKey(neighbor)) {// Check if visited
                        distance.put(neighbor, curDistance + 1);
                        if (end.equals(neighbor))// Found the shortest path
                            foundEnd = true;
                        else
                            queue.offer(neighbor);
                    }
                }
            }

            if (foundEnd)
                break;
        }
    }

    // Find all next level nodes.    
    private ArrayList<String> getNeighbors(String node, Set<String> dict) {
        ArrayList<String> res = new ArrayList<>();
        char chs[] = node.toCharArray();

        for (char ch ='a'; ch <= 'z'; ch++) {
            for (int i = 0; i < chs.length; i++) {
                if (chs[i] == ch) continue;
                char old_ch = chs[i];
                chs[i] = ch;
                if (dict.contains(String.valueOf(chs))) {
                    res.add(String.valueOf(chs));
                }
                chs[i] = old_ch;
            }

        }
        return res;
    }

    // DFS: output all paths with the shortest distance.
    private void dfs(String cur, String end, Map<String, ArrayList<String>> nodeNeighbors, 
                     Map<String, Integer> distance, List<String> solution, List<List<String>> res) {
        solution.add(cur);
        if (end.equals(cur)) {
            res.add(new ArrayList<>(solution));
        } else {
            for (String next : nodeNeighbors.get(cur)) {
                if (distance.get(next) == distance.get(cur) + 1) {
                    dfs(next, end, nodeNeighbors, distance, solution, res);
                }
            }
        }
        solution.remove(solution.size() - 1);
    }

    private boolean oneEditDistance(String cur, String next) {
        int count = 0;
        int length = cur.length();
        for (int i = 0; i < length; ++i) {
            if (cur.charAt(i) != next.charAt(i)) {
                count++;
                if (count == 2) return false;
            }
        }
        return count == 1;
    }

    public static void main(String[] args) {
        WordLadder2 wordLadder2 = new WordLadder2();
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "lot", "dog", "log", "cog");
        System.out.println("Minimum distance is := " + wordLadder2.ladderLength(beginWord, endWord, wordList));
        System.out.println("One short transformation is := " + wordLadder2.findOneLadder(beginWord, endWord, wordList));
        System.out.println("All Transformations are := " + wordLadder2.findLadders(beginWord, endWord, wordList));
    }
}
