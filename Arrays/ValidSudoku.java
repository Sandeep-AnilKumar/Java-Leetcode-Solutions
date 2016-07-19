package Arrays;

public class ValidSudoku {

	public static void main(String[] args) {
		char board[][] = {{'.','.','.','.','5','.','.','1','.'},
				{'.','4','.','3','.','.','.','.','.'},
				{'.','.','.','.','.','3','.','.','1'},
				{'8','.','.','.','.','.','.','2','.'},
				{'.','.','2','.','7','.','.','.','.'},
				{'.','1','5','.','.','.','.','.','.'},
				{'.','.','.','.','.','2','.','.','.'},
				{'.','2','.','9','.','.','.','.','.'},
				{'.','.','4','.','.','.','.','.','.'}};
		System.out.println(isValidSudoku(board));
	}

	public static boolean isValidSudoku(char[][] board) {
		if(board == null || board.length == 0) {
			return false;
		} 

		int length = 9;
		boolean isDuplicateRow[] = new boolean[10];
		boolean isDuplicateColumn[] = new boolean[10];
		int tempRow = 0;
		int tempColumn = 0;

		for(int i = 0; i < length; i++) {
			isDuplicateRow = new boolean[10];
			isDuplicateColumn = new boolean[10];
			for(int j = 0; j < length; j++) {
				tempRow = (int) board[i][j] - 48;
				tempColumn = (int) board[j][i] - 48;

				if(board[i][j] != '.' && !isDuplicateRow[tempRow]) {
					isDuplicateRow[tempRow] = true;
				}
				else if(board[i][j] != '.' && isDuplicateRow[tempRow]){
					return false;
				}

				if(board[j][i] != '.' && !isDuplicateColumn[tempColumn]) {
					isDuplicateColumn[tempColumn] = true;
				}
				else if(board[j][i] != '.' && isDuplicateColumn[tempColumn]){
					return false;
				}
			}
		}

		boolean tempDuplicate[] = new boolean[10];
		int temp = 0;
		for(int k = 0; k <= 6; k += 3) {
			for(int l = 0; l <=6; l += 3) {
				tempDuplicate = new boolean[10];

				for(int i = l; i <= l+2; i++) {
					for(int j = k; j <= k+2; j++) {
						temp = (int) board[i][j] - 48;
						if(board[i][j] != '.' && !tempDuplicate[temp]) {
							tempDuplicate[temp] = true;
						}
						else if(board[i][j] != '.' && tempDuplicate[temp]) {
							return false;
						}
					}
				}
			}
		}
		return true;
	}
}
