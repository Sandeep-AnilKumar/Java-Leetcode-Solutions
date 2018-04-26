package Strings;

import java.util.Arrays;

public class ValidNumber {
    public static void main(String[] args) {
        String[] numbers = {"-.81", "46.e3", "e.", "abc", "."};
        ValidNumber Number = new ValidNumber();
        Arrays.stream(numbers).forEach(number -> System.out.println("Is " + number + " a valid number? " + Number.isNumber(number)));
    }

    private boolean isNumber(String s) {
        if (s == null) {
            return false;
        }

        s = s.trim();

        if (s.length() == 0) {
            return false;
        }

        boolean decimalOcc = false;
        int minusOcc = 0;
        int plusOcc = 0;
        boolean expOcc = false;
        int length = s.length();
        char c;

        for (int i = 0; i < length; ++i) {
            c = s.charAt(i);
            if (!isDigit(c)) {
                if ('e' == c && !expOcc) {
                    if (i == 0 || i == length - 1) {
                        return false;
                    }
                    expOcc = true;
                } else if ('-' == c && minusOcc <= 1) {
                    minusOcc++;
                    if (i == length - 1 || length == 1 || (i != 0 && s.charAt(i - 1) != 'e') || (i == 0 && s.charAt(i + 1) == 'e')) {
                        return false;
                    }
                } else if ('+' == c && plusOcc <= 1) {
                    plusOcc++;
                    if (i == length - 1 || length == 1 || (i != 0 && s.charAt(i - 1) != 'e') || (i == 0 && s.charAt(i + 1) == 'e')) {
                        return false;
                    }
                } else if ('.' == c && !decimalOcc) {
                    if (length == 1 || (i != 0 && s.charAt(i - 1) == 'e') || (i == length - 1 && (s.charAt(i - 1) == '+' || s.charAt(i - 1) == '-')) || (i == 0 && s.charAt(i + 1) == 'e') || expOcc) {
                        return false;
                    }
                    decimalOcc = true;
                } else {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isDigit(char c) {
        int ascii = (int) c;
        return ascii >= 48 && ascii <= 57;
    }
}
