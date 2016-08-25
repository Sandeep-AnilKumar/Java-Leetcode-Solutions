package Strings;

import java.util.ArrayDeque;
import java.util.Deque;

public class LongestAbsoluteFilePath {

    public static void main(String[] args) {
        String s = "dir1\n\tfile1.png\n\tfile2.jpeg\n\tfile3.gif\n\tdir11\n\t\tno_image.txt\n\t\tdir23\n\t\t\tno_image2.txt\n\t\t\tdir34\n\tdir12\n\tdir13\n\tdir14\n\t\tfile5.gip\n\tdir15\n\t\tfile6.gif";
        System.out.println("Image SUm Path Path is: " + imageSumPath(s));
    }

    public static int lengthLongestPath(String input) {
        if(input == null || input.length() == 0) {
            return 0;
        }

        Deque<String> dq = new ArrayDeque<>();
        String[] paths = input.split("\n");
        int level = 0;
        int curLength = 0;
        int result = 0;

        for(String path : paths) {
            level = getLevel(path);

            while(dq.size() > level) {
                curLength -= dq.pollLast().length() + 1;
            }

            path = path.replaceAll("\t", "");
            curLength += path.length() + 1;

            if(path.contains(".")) {
                result = Math.max(curLength - 1, result);
            }
            dq.offerLast(path);
        }
        return result;
    }

    public static int getLevel(String s) {
        String cur = s.replaceAll("\t", "");
        return s.length() - cur.length();
    }

    //Interview question: - Get the sums of all the paths with images.
    //"dir1\n\tdir11\n\tdir12\n\t\tpicture.jpeg\n\t\tdir121\n\t\tfile1.txt\ndir2\n\tfile2.gif"

    public static int imageSumPath(String input) {
        if(input == null || input.length() == 0) {
            return 0;
        }

        Deque<String> dq = new ArrayDeque<>();
        String[] paths = input.split("\n");
        int level = 0;
        int curLength = 0;
        int result = 0;

        for(String path : paths) {
            level = getLevel(path);

            while(dq.size() > level) {
                curLength -= dq.pollLast().length() + 1;
            }

            path = path.replaceAll("\t", "");
            curLength += path.length() + 1;

            if(path.contains(".jpeg") || path.contains(".gif") || path.contains(".png")) {
                result += curLength - 1;
            }
            dq.offerLast(path);
        }
        return result;
    }
}
