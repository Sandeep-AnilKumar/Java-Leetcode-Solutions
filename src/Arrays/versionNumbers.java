package Arrays;
public class versionNumbers {

	public static void main(String[] args) {
		System.out.println(compareVersions("1","0"));
	}

	public static int compareVersions(String version1, String version2) {
		String version1Parts[] = version1.split("\\.");
		String version2Parts[] = version2.split("\\.");

		int length1 = version1Parts.length;
		int length2 = version2Parts.length;

		int maxLength = Math.max(length1, length2);
		
		int version1Value = 0;
		int version2Value = 0;
		

		for(int i = 0; i < maxLength; i++) {
			version1Value = (i < length1 ? Integer.parseInt(version1Parts[i]) : 0);
			version2Value = (i < length1 ? Integer.parseInt(version1Parts[i]) : 0);

			if(version1Value > version2Value) {
				return 1;
			}
			else if(version1Value < version2Value) {
				return -1;
			}

			if(version1Value == version2Value) {
				continue;
			}
		}
		return 0;
	}
}
