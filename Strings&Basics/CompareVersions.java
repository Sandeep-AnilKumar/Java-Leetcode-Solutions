
public class CompareVersions {

	public static void main(String[] args) {
		String version1 = "1.2";
		String version2 = "1.10";
		isUniqueChars("Abadefghji");
		//System.out.println(compareVersions(version1, version2));
	}

	public static int compareVersions(String version1, String version2)
	{
		String firstVersion = version1;
		String secondVersion = version2;

		String parts1[] = firstVersion.split("\\.");
		String parts2[] = secondVersion.split("\\.");

		int length = Math.max(parts1.length,parts2.length);

		for(int i = 0; i < length; i++)
		{
			Integer v1 = i < parts1.length ? Integer.parseInt(parts1[i]) : 0;
			Integer v2 = i < parts2.length ? Integer.parseInt(parts2[i]) : 0;

			int compare = v1.compareTo(v2);
			if(compare != 0)
			{
				return compare;
			}
		}

		return 0;
	}

	public static boolean isUniqueChars(String str)
	{
		int checker = 0;
		for(int i = 0; i < str.length(); i++)
		{
			int val = str.charAt(i) - 'a';
			if((checker & (1 << val)) > 0)
				return false;

			checker |= (1 << val);
		}
		return true;
	}
}