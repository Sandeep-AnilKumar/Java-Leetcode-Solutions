package BitManipulation;

import java.util.ArrayList;
import java.util.List;

public class ValidateUTF8 {

    public static void main(String[] args) {
        int[] data = {240,162,138,147,145};
        System.out.println("Are numbers in UTF-8 format? " + validUtf8(data));
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
}
