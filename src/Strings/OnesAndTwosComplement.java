package Strings;

public class OnesAndTwosComplement {

    public static void main(String[] args) {
        String binary = "1100";
        getOnesAndTwosComplement(binary);
    }

    public static void getOnesAndTwosComplement(String binary)
    {
        if(binary.length() == 0 || binary == null)
            System.out.println("Cannot find complements because the binary string is empty");

        StringBuilder ones = new StringBuilder();
        char twos[];
        int length = binary.length();
        int i = 0;

        for(i = 0; i < length; i++)
        {
            ones.append(binary.charAt(i) == '0' ? '1' : '0');
        }
        System.out.println("1's complement is : " + ones);

        twos = ones.toString().toCharArray();
        for(i = length - 1; i >= 0; i--)
        {
            if(ones.charAt(i) == '1')
                twos[i] = '0';
            else
            {
                twos[i] = '1';
                break;
            }
        }

        String twosC = new String(twos);
        if(i == -1)
        {
            twosC = '1' + twosC;
        }

        System.out.println("2's complement is : " + twosC);
    }
}
