package BitManipulation;

import java.util.ArrayList;
import java.util.List;

public class ValidateUTF8 {

    public static void main(String[] args) {
        int[] data = {240,162,138,147,145};
        System.out.println("Are numbers in UTF-8 format? " + validUtf8Easier(data));
    }

    //First attempt, failed because of less memory constraints. Algorithm worked fine.
    public static boolean validUtf8(int[] data) {
        if(data == null || data.length == 0) {
            return true;
        }

        List<Integer> dataDup = new ArrayList<>();
        for(int i : data) {
            dataDup.add(i);
        }

        return validator(dataDup);
    }

    public static boolean validator(List<Integer> data) {
        if(data == null || data.size() == 0) {
            return true;
        }
        int first = data.get(0) & 240;
        int size = data.size();
        List<Integer> temp = new ArrayList<>();
        if(first >= 240 && size >= 4) {
            for(int i = 0; i < 4; ++i) {
                temp.add(data.get(i));
            }
            temp.remove(temp.get(0));
            if(validate(temp, 3)) {
                remove(data, 4);
                return validator(data);
            } else {
                return false;
            }
        } else if(first >= 224 && size >= 3) {
            for(int i = 0; i < 3; ++i) {
                temp.add(data.get(i));
            }
            temp.remove(temp.get(0));
            if(validate(temp, 2)) {
                remove(data, 3);
                return validator(data);
            } else {
                return false;
            }
        } else if(first >= 192 && size >= 2) {
            for(int i = 0; i < 2; ++i) {
                temp.add(data.get(i));
            }
            temp.remove(temp.get(0));
            if(validate(temp, 1)) {
                remove(data, 2);
                return validator(data);
            } else {
                return false;
            }
        } else if(first < 128) {
            temp.add(data.get(0));
            remove(data, 1);
            return validator(data);
        } else {
            return false;
        }
    }

    public static boolean validate(List<Integer> data, int type) {
        if(type > data.size()) {
            return false;
        }
        for(int i = 0; i < type; ++i) {
            if((data.get(i) & 128) < 128) {
                return false;
            }
        }
        return true;
    }

    public static void remove(List<Integer> data, int type) {
        for(int i = 0; i < type; ++i) {
            data.remove(0);
        }
    }

    //Easier solution, is that instead of deleting, just move on to check the next numbers. Damn!!


    public static boolean validUtf8Easier(int[] data) {
        if(data==null || data.length==0) return false;
        boolean isValid = true;
        for(int i=0;i<data.length;i++) {
            if(data[i]>255) return false; // 1 after 8th digit, 100000000
            int numberOfBytes = 0;
            if((data[i] & 128) == 0) { // 0xxxxxxx, 1 byte, 128(10000000)
                numberOfBytes = 1;
            } else if((data[i] & 224) == 192) { // 110xxxxx, 2 bytes, 224(11100000), 192(11000000)
                numberOfBytes = 2;
            } else if((data[i] & 240) == 224) { // 1110xxxx, 3 bytes, 240(11110000), 224(11100000)
                numberOfBytes = 3;
            } else if((data[i] & 248) == 240) { // 11110xxx, 4 bytes, 248(11111000), 240(11110000)
                numberOfBytes = 4;
            } else {
                return false;
            }
            for(int j=1;j<numberOfBytes;j++) { // check that the next n bytes start with 10xxxxxx
                if(i+j>=data.length) return false;
                if((data[i+j] & 192) != 128) return false; // 192(11000000), 128(10000000)
            }
            i=i+numberOfBytes-1;
        }
        return isValid;
    }
}
