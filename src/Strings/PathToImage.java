package Strings;

public class PathToImage {

    public static void main(String[] args) {
        //String s = "dir1\n dir11\n dir12\n  picture.jpeg\n  dir121\n  file1.txt\ndir2\n file2.gif";
        String s = "dir1\n file1.png\n file2.jpeg\n file3.gif\n dir11\n  no_image.txt\n  dir23\n   no_image2.txt\n   "
                + "dir34\n dir12\n dir13\n dir14\n  file5.gip\n dir15\n  file6.gif\n"; 
        System.out.println(totalPathToImages(s));
    }

    public static int totalPathToImages(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }

        s = s.replaceAll("\\n","+");

        String inner = "@";
        while(s.contains(" ")) {
            s = s.replaceAll("\\s{1}", inner);
        }

        String parts[] = s.split("\\+");

        String mostRecent = "";
        StringBuilder path = new StringBuilder();
        StringBuilder totalPath = new StringBuilder();
        path.append('/');

        StringBuilder inter = new StringBuilder();
        String previous = "";
        String previousPath = "";

        for(String t : parts) {

            inter = new StringBuilder();
            for(char c : t.toCharArray()) {
                if(c == '@') {
                    inter.append(c);
                }
                else {
                    break;
                }
            }

            if(t.contains(".jpeg") || t.contains(".gif") || t.contains(".png")) {
                t = t.replaceAll("@", "");
                path.append("/" + t);
                totalPath.append(path.toString());
                previousPath = path.toString();
                previousPath = previousPath.replaceAll("/" + t, "");
                path = new StringBuilder(previousPath);
                previous = inter.toString();
                mostRecent = t;
                continue;
            }

            if(inter == null || inter.toString().length() == 0) {
                mostRecent = t;
                previous = "";
                path = new StringBuilder();
                path.append("/" + t);
            }
            else if(inter.toString().equals(previous)) {
                previousPath = path.toString();
                previousPath = previousPath.replaceAll("/" + mostRecent, "");
                path = new StringBuilder(previousPath);
                t = t.replaceAll("@", "");
                path.append("/" + t);
                previous = inter.toString();
                mostRecent = t;
            }
            else {
                t = t.replaceAll("@", "");
                mostRecent = t;
                path.append("/" + mostRecent);
                previous = inter.toString();
            }
        }
        System.out.println(totalPath.toString());
        return ((totalPath == null || totalPath.toString().length() == 0) ? 0 : totalPath.toString().length());
    }

}
