package Arrays;

public class ArrangeCoins {

    public static void main(String[] args) {
        int n = 7;
        System.out.println("Number of steps needed to arrange " + n + " coins in step by step format is : " + arrangeCoinsAdvanced(n));
    }

    //O(n) time.
    public static int arrangeCoins(int n) {
        if(n == 0) {
            return 0;
        }
        if(n == 1) {
            return 1;
        }

        int value = n;
        int i = 1;
        while(value > 0) {
            value -= i;
            i++;
        }
        if(value < 0) {
            return i - 2;
        }
        return i - 1;
    }

    //O(1) time.
    //x * (x + 1) / 2 => (Math.sqrt(8.0 * n + 1) - 1) / 2.0
    public static int arrangeCoinsAdvanced(int n) {
        return ((int)((Math.sqrt(8.0 * n + 1) - 1) / 2.0));
    }
}
