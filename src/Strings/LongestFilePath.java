package Strings;

public class LongestFilePath {

	public static void main(String[] args) {
		String input = "dir\n\tsubdir1\n\t\tfile1.txt\n\t\tsubsubdir1\n\tsubdir2\n\t\tfile.txt\n\t\tsubsubdir2\n\t\t\tfile2.txt\n";
		LongestFilePath lf = new LongestFilePath();
		System.out.println(lf.lengthLongestPath(input));
	}

	public int lengthLongestPath(String input) {
		if(input == null || input.length() == 0) {
			return 0;
		}

		String[] paths = input.split("\n");
		String[] array = new String[paths.length];
		String cur = "";
		int level = 0;
		int max = 0;
		String path = "";
		String trim = "";
		String maxPath = "";

		for(int i = 0; i < paths.length; ++i) {
			cur = paths[i];
			trim = cur.replaceAll("\t", "");
			level = cur.length() - trim.length();
			array[level] = trim;

			if(trim.contains(".")) {
				path = "";
				for(int j = 0; j < level; ++j) {
					path = path + "" + array[j] + "/";
				}
				path = path + "" + array[level];
				if(max < path.length()) {
					max = path.length();
					maxPath = path;
				}
			}
		}
		System.out.println(maxPath);
		return max;
	}
}
