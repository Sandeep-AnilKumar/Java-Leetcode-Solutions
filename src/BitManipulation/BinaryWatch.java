package BitManipulation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BinaryWatch {
    public List<String> readBinaryWatch(int num) {
        List<String> times = new ArrayList<>();
        if (num < 0 || num >= 9) return times;
        Map<Integer, List<Integer>> pos = new HashMap<>();
        generatePos(pos, 0, 59);

        int hour = Math.min(3, num);
        int min = Math.min(5, num - hour);
        String tempHour = "", tempMin = "";

        while (hour >= 0 && min <= 5) {
            for (int posHour : pos.get(hour)) {
                if (posHour >= 12) continue;
                tempHour = String.valueOf(posHour);
                for (int posMin : pos.get(min)) {
                    tempMin = "";
                    if (posMin <= 9) {
                        tempMin += "0";
                    }
                    tempMin += String.valueOf(posMin);
                    times.add(tempHour + ":" + tempMin);
                }
            }
            hour--;
            min++;
        }
        return times;
    }

    private void generatePos(Map<Integer, List<Integer>> pos, int start, int end) {
        int bits = 0, cur = 0;
        for (int i = start; i <= end; ++i) {
            bits = 0;
            cur = i;
            while (cur > 0) {
                bits += cur & 1;
                cur >>>= 1;
            }
            if (!pos.containsKey(bits)) pos.put(bits, new ArrayList<>());
            pos.get(bits).add(i);
        }
    }

    public static void main(String[] args) {
        int num = 0;
        System.out.println("The possible times are := " + new BinaryWatch().readBinaryWatch(num));
    }
}
