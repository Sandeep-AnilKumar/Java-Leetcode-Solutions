package Strings;

public class IntegerToRoman {

    public static void main(String[] args) {
        int num = 1245;
        System.out.println("The value of " + num + " in roman numerals is := " + intToRoman(num));
    }

    //A naive solution., Second runner-up. Very fast but very big solution.
    public static String intToRoman(int num) {
        if(num <= 0) {
            return "";
        }

        int temp = num;
        StringBuilder result = new StringBuilder();
        while(temp > 0) {
            if(temp >= 1 && temp <= 3) {
                result.append("I");
                temp -= 1;
            } else if(temp == 4) {
                result.append("IV");
                break;
            } else if(temp >= 5 && temp <= 8) {
                result.append("V");
                temp -= 5;
            } else if(temp == 9) {
                result.append("IX");
                break;
            } else if(temp >= 10 && temp <= 39) {
                result.append("X");
                temp -= 10;
            } else if(temp >= 40 && temp <= 49) {
                result.append("XL");
                temp -= 40;
            } else if(temp >= 50 && temp <= 89) {
                result.append("L");
                temp -= 50;
            } else if(temp >= 90 && temp <= 99) {
                result.append("XC");
                temp -= 90;
            } else if(temp >= 100 && temp <= 399) {
                result.append("C");
                temp -= 100;
            } else if(temp >= 400 && temp <= 499) {
                result.append("CD");
                temp -= 400;
            } else if(temp >= 500 && temp <= 899) {
                result.append("D");
                temp -= 500;
            } else if(temp >= 900 && temp <= 999) {
                result.append("CM");
                temp -= 900;
            } else {
                result.append("M");
                temp -= 1000;
            }
        }
        return result.toString();
    }

    //First runner-up, using enum.

    public enum Roman {
        M(1000), CM(900), D(500), CD(400), C(100), XC(90), L(50), XL(40), X(10), IX(9), V(5), IV(4), I(1);
        private final int value;
        Roman(int value){
            this.value = value;
        }
    };

    public static String intToRomanGood(int num) {
        if(num <= 0) {
            return "";
        }
        int temp = num;
        StringBuilder result = new StringBuilder();
        for(Roman r : Roman.values()) {
            while(num >= r.value) {
                result.append(r);
                num -= r.value;
            }
        }
        return result.toString();
    }

    //Winner
    public static String integerToRomanBest(int num) {
        String M[] = {"", "M", "MM", "MMM"};
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[num%10];
    }
}
