package DynamicProgramming;

public class NumDecodings {

    public static void main(String[] args) {
        String s = "320656";
        System.out.println("Number of possible decodings is : " + numDecodings(s));
    }

    public static int numDecodings(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int length = s.length();
        int[] dp = new int[length + 1];
        dp[length] = 1;
        dp[length - 1] = s.charAt(length - 1) == '0' ? 0 : 1;
        char present;
        String previous = "";
        int combination = 0;
        for(int i = length - 2; i >= 0; --i) {
            present = s.charAt(i);
            previous = present + "" + s.charAt(i + 1);
            if(present >= '1' && present <= '9') {
                dp[i] += dp[i + 1];
            }
            combination = Integer.parseInt(previous);
            if(combination >= 10 && combination <= 26) {
                dp[i] += dp[i + 2];
            }
        }
        return dp[0];
    }
}
