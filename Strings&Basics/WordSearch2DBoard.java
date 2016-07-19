package String;

public class WordSearch2DBoard {

	public static void main(String[] args) {
		char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		String word = "ABC";

		System.out.println("Does This word :"+ word + " exist in the board :" + exist(board,word));
	}



	public static boolean exist(char[][] board, String word)
	{
		if(word == null || word.isEmpty())
			return false;
		else if(board.equals(null))
			return false;

		boolean dp[] = new boolean[word.length()];
		

		int k = 0;
		int length = word.length();

		for(int i = 0; i < board.length; i++)
		{
			for(int j = 0; j < board[i].length; j++)
			{
				if(!(k > length) && word.charAt(k) == board[i][j] - '\0')
				{
					dp[k] = true;
					findWords(i,j,k,word,board,dp);
					if(!dp[word.length() - 1])
					{
						dp = new boolean[word.length()];
						continue;
					}
				}
			}
		}

		return dp[word.length() - 1];
	}

	public static void findWords(int i, int j, int k, String word, char[][] board, boolean dp[])
	{

		if(k >= word.length() - 1){
			return;
		}

		char wordChar = word.charAt(k);
		if(board[i][j] - '\0' == wordChar)
		{
			dp[k] = true;
			char nextChar = word.charAt(k+1);
			if(i >= 0 && i < board.length && j-1 < board[i].length && j-1 >= 0 && board [i][j-1] - '\0' == nextChar){
				dp[k+1] = true;
				findWords(i,j-1,k+1,word,board,dp);
			}
			if(i >= 0 && i < board.length && j+1 < board[i].length && j+1 >= 0 && board[i][j+1] - '\0' == nextChar){
				dp[k+1] = true;
				findWords(i,j+1,k+1,word,board,dp);
			}
			if(i-1 >= 0 && i < board.length && j < board[i].length && j >= 0 && board[i-1][j] - '\0' == nextChar){
				dp[k+1] = true;
				findWords(i-1,j,k+1,word,board,dp);
			}
			if(i+1 >= 0 && i+1 < board.length && j < board[i].length && j >= 0 && board[i+1][j] - '\0' == nextChar){
				dp[k+1] = true;
				findWords(i+1,j,k+1,word,board,dp);
			}
		}
		return;
	}
}
