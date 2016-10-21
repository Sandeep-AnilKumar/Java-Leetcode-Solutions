package Arrays;

import java.util.ArrayList;
import java.util.List;

public class MinimumGeneticMutation {

    public static void main(String[] args) {
        String start = "AAAAACCC";
        String end = "AACCCCCC";
        String[] bank = new String[]{"AAAACCCC", "AAACCCCC", "AACCCCCC"};
        System.out.println("Number of possible genetic mutations required is : " + minMutation(start, end, bank));
    }

    public static int minMutation(String start, String end, String[] bank) {
        if(bank == null || start == null || start.length() == 0 || end == null || end.length() == 0) {
            return 0;
        }

        List<String> bankStrings = new ArrayList<>();
        for(String s : bank) {
            bankStrings.add(s);
        }

        int count = minMutation(start, end, bank, 0, bankStrings);
        return count == 0 ? -1 : count;
    }

    public static int minMutation(String start, String end, String[] bank, int count, List<String> bankStrings) {
        List<Integer> indices = new ArrayList<>();
        int length = start.length();
        for(int i = 0; i < length; ++i) {
            if(start.charAt(i) != end.charAt(i)) {
                indices.add(i);
            }
        }
        int curCount = 0;
        String temp = "";
        for(int i : indices) {
            temp = start.substring(0, i) + "" + end.charAt(i) + "" + start.substring(i+1, length);
            if(bankStrings.contains(temp)) {
                curCount = 1 + minMutation(temp, end, bank, count, bankStrings);
            }
        }
        return curCount;
    }
}
