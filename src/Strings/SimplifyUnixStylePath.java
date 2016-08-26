package Strings;

import java.util.ArrayDeque;
import java.util.Deque;

public class SimplifyUnixStylePath {

    public static void main(String[] args) {
        String[] paths = new String[]{"/", "/home//foo", "/a/./b/../../c/", "/../", "/./", "/abc/..."};
        for(String path : paths) {
            System.out.println("The simplified unix path for '" + path + "' is '" + simplifyPath(path) + "'");
        }
    }

    public static String simplifyPath(String path) {
        if(path == null || path.length() == 0) {
            return path;
        }

        String[] paths = path.split("/");
        Deque<String> subPaths = new ArrayDeque<>();

        for(String p : paths) {
            if(p != null && p.length() != 0) {
                if(p.equals("..")) {
                    subPaths.pollLast();
                }
                else if(!p.equals(".")){
                    subPaths.offerLast(p);
                }
            }
        }

        StringBuilder result = new StringBuilder();
        result.append("/");
        while(subPaths.size() > 1) {
            result.append(subPaths.pollFirst() + "/");
        }
        if(subPaths != null && subPaths.size() == 1) {
            result.append(subPaths.pollFirst());
        }
        return result.toString();
    }
}
