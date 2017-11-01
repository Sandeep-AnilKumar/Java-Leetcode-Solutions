package Strings;

/**
 * @author sandeepa
 */

public class AtoI {	
    public int myAtoi(String str) {
        if(str == null || str.length() == 0) return 0;
        
        long value = 0;
        boolean negative = false, positive = false, endWhiteSpace = false;
        int length = str.length();
        char c;
        
        for(int i = 0; i < length; ++i) {
            c = str.charAt(i);
            if(c == ' ' && !endWhiteSpace) continue;
            
            endWhiteSpace = true;
            
            if(!isInt(c) && c != '-' && c != '+') break;
            
            if(c == '-' && !negative && !positive) {
                negative = true; continue;
            } else if (c == '-' && (positive || negative)) break;
            
            if(c == '+' && !negative && !positive) {
                positive = true; continue;
            } else if (c == '+' && (positive || negative)) break;
            
            if(isInt(c)) {
                value = value * 10 + (c - '0');
                if(value > Integer.MAX_VALUE) break;
            }
        }

        if(!negative && value > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        else if(negative && (value - 1) >= Integer.MAX_VALUE) return Integer.MIN_VALUE;
        return negative ? (int) value * -1 : (int) value;
    }
    
    public boolean isInt(char c) {
        int asciiValue = (int) c;
        if(asciiValue >= 48 && asciiValue <= 57) return true;
        return false;
    }
}
