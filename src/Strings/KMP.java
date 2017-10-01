package Strings;

public class KMP {
	/**
	 * Compute temporary array to maintain size of suffix which is same as prefix
	 * Time/space complexity is O(size of pattern)
	 */
	private int[] computeTemporaryArray(char pattern[]){
		int [] lps = new int[pattern.length];
		int index = 0;
		for(int i = 1; i < pattern.length;){
			if(pattern[i] == pattern[index]){
				lps[i++] = ++index;
			}else{
				if(index != 0){
					index = lps[index-1];
				}else{
					lps[i++] =0;
				}
			}
		}
		return lps;
	}

	/**
	 * KMP algorithm of pattern matching.
	 */
	public boolean KMPAlgo(char []text, char []pattern){

		int lps[] = computeTemporaryArray(pattern);
		int i = 0;
		int j = 0;
		while(i < text.length && j < pattern.length){
			if(text[i] == pattern[j]){
				i++;
				j++;
			}else{
				if(j!=0){
					j = lps[j-1];
				}else{
					i++;
				}
			}
		}
		if(j == pattern.length){
			return true;
		}
		return false;
	}

	public static void main(String args[]){

		String str = "abcxabcdabcdabcy";
		String subString = "abcdabcy";
		KMP ss = new KMP();
		boolean result = ss.KMPAlgo(str.toCharArray(), subString.toCharArray());
		System.out.print(result);
	}
}