package Arrays;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Excel {

    private int[][] grid;
    private Map<String, Set<String>> sumToCell;
    private Map<String, List<String>> cellToSum;

    public Excel(int H, char W) {
        grid = new int[H + 1][W - 'A' + 2];
        sumToCell = new HashMap<>();
        cellToSum = new HashMap<>();
    }

    public void set(int r, char c, int v) {
        removeSumToCell(r, c);
        int diff =  v - grid[r][c - 'A' + 1];
        grid[r][c - 'A' + 1] = v;
        Deque<String> dq = new ArrayDeque<>();
        String key = r + "" + c;
        dq.offer(key);
        
        while (!dq.isEmpty()) {
            key = dq.poll();
            if (cellToSum.containsKey(key)) {
                for (String s : cellToSum.get(key)) {
                    grid[Integer.parseInt(s.substring(0, s.length() - 1))][s.charAt(s.length() - 1) - 'A' + 1] += diff;
                    if (sumToCell.containsKey(s)) {
                        dq.offer(s);
                    }
                }
            }
        }
    }

    public int get(int r, char c) {
        return grid[r][c - 'A' + 1];
    }

    public int sum(int r, char c, String[] strs) {
        removeSumToCell(r, c);
        int sum = 0, rowStart, colStart, rowEnd, colEnd;
        String start, end, cur;
        String[] parts;
        String key = r + "" + c;
        sumToCell.put(key, new HashSet<>());

        for (String s : strs) {
            if (s.contains(":")) {
                parts = s.split(":");
                start = parts[0];
                end = parts[1];
                colStart = start.charAt(0) - 'A' + 1;
                rowStart = Integer.parseInt(start.substring(1));
                colEnd = end.charAt(0) - 'A' + 1;
                rowEnd = Integer.parseInt(end.substring(1));

                if (rowStart > rowEnd || colStart > colEnd) continue;

                for (int i = rowStart; i <= rowEnd; ++i) {
                    for (int j = colStart; j <= colEnd; ++j) {
                        sum += grid[i][j];
                        cur = i + "" + (char) ('A' + j - 1);
                        sumToCell.get(key).add(cur);
                        if (!cellToSum.containsKey(cur)) {
                            cellToSum.put(cur, new ArrayList<>());
                        }
                        cellToSum.get(cur).add(key);
                    }
                }
            } else {
                colStart = s.charAt(0) - 'A' + 1;
                rowStart = Integer.parseInt(s.substring(1));
                cur = rowStart + "" + s.charAt(0);
                sum += grid[rowStart][colStart];
                sumToCell.get(key).add(cur);
                if (!cellToSum.containsKey(cur)) {
                    cellToSum.put(cur, new ArrayList<>());
                }
                cellToSum.get(cur).add(key);
            }
        }
        grid[r][c - 'A' + 1] = sum;
        return sum;
    }

    private void removeSumToCell(int r, char c) {
        String key = r + "" + c;
        if (sumToCell.containsKey(key)) {
            for (String child : sumToCell.get(key)) {
                cellToSum.get(child).removeAll(Collections.singletonList(key));
            }
            sumToCell.remove(key);
        }
    }

    public static void main(String[] args) {
        Excel excel = new Excel(3, 'C');
        excel.set(1, 'A', 2);
        System.out.println(excel.get(1, 'A'));
        System.out.println(excel.sum(3, 'C', new String[]{"A1", "A1:B2"}));
        excel.set(1, 'A', 3);
        System.out.println(excel.get(3, 'C'));
        excel.set(2, 'B', 2);
        System.out.println(excel.get(3, 'C'));
        excel.set(2, 'B', -4);
        System.out.println(excel.get(3, 'C'));
        excel.set(1, 'B', 4);
        System.out.println(excel.get(3, 'C'));
        excel.set(1, 'B', 100);
        System.out.println(excel.get(3, 'C'));
        excel.set(3, 'C', 60);
        System.out.println(excel.get(3, 'C'));
        excel.set(1, 'B', -50);
        System.out.println(excel.get(3, 'C'));
        System.out.println(excel.sum(3, 'C', new String[]{"A1:A2"}));
        
        System.out.println(excel.sum(1, 'A', new String[]{"A2"}));
        excel.set(2, 'A', 1);
        System.out.println(excel.get(1, 'A'));
        
    }
}
