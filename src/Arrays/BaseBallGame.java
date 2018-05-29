package Arrays;

import java.util.ArrayDeque;
import java.util.Deque;

public class BaseBallGame {

    public int calPoints(String[] ops) {
        Integer total = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        Integer temp;
        Integer temp2;

        for (String op : ops) {
            if (op.equals("C")) {
                total -= stack.pollLast();
                
            } else if (op.equals("D")) {
                temp = stack.peekLast() * 2;
                total += temp;
                stack.offer(temp);
                
            } else if (op.equals("+")) {
                temp = stack.pollLast();
                temp2 = stack.peekLast() + temp;
                stack.offer(temp);
                stack.offer(temp2);
                total += temp2;
                
            } else {
                temp = Integer.parseInt(op);
                stack.offer(temp);
                total += temp;
            }
        }

        return total;
    }
    
    public static void main(String[] args) {
        BaseBallGame game = new BaseBallGame();
        String[] ops = {"5","-2","4","C","D","9","+","+"};
        System.out.println("The total number of points is := " + game.calPoints(ops));
    }
}
