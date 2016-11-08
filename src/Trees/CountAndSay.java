package Trees;

public class CountAndSay {

    public static void main(String[] args) {
        int n = 5;
        System.out.println("Nth sequence is := " + countAndSay(n));
    }

    public static String countAndSay(int n) {
        if(n == 1) {
            return "1";
        }

        String current = "";
        String prev = "1";
        n -= 1;
        while(n-- > 0) {
            current = generateCount(prev);
            prev = current;
        }
        return current;
    }

    public static String generateCount(String prev) {
        int length = prev.length();
        StringBuilder sb = new StringBuilder();
        char pChar = prev.charAt(0);
        char cur;
        int count = 1;
        for(int i = 1; i < length; ++i) {
            cur = prev.charAt(i);
            if(pChar != cur) {
                sb.append(count + "" + pChar);
                pChar = cur;
                count = 1;
            } else {
                count++;
            }
        }
        sb.append(count + "" + pChar);
        return sb.toString();
    }
}
