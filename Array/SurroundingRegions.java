package arrays;

/* Input: array
 * Output: array with O replaced with X
 * implementaion
 * First, check the four border of the matrix. If there is a element is
 * ’O’, alter it and all its neighbor ‘O’ elements to ‘1’.
 * Then ,alter all the ‘O’ to ‘X’
 * At last,alter all the ‘1’ to ‘O’
*/
public class SurroundingRegions {
	public static void main(String[]args) {
		char[][] board = {{'X','X','X','X'},
				{'X','O','O','X'},
				{'X','X','O','X'},
				{'X','O','X','X'}};
		solve(board);
	}
	public static void solve(char[][] board) {
		if(board.length==0)
            return;
		int i=0,j=0;
		for(j=0;j<board[0].length;j++) {
			if(board[i][j]=='O')
				fillIsland(board, i, j);
		}
		j = board[0].length-1;
		for(i=1;i<board.length;i++) {
			if(board[i][j]=='O')
				fillIsland(board, i, j);
		}
		i = board.length-1;
		for(j=board[0].length-1;j>=0;j--) {
			if(board[i][j]=='O')
				fillIsland(board, i, j);
		}
		j=0;
		for(i=board.length-2;i>=1;i--) {
			if(board[i][j]=='O')
				fillIsland(board, i, j);
		}
		for(int l=0;l<board.length;l++) {
			for(int m=0;m<board[0].length;m++) {
				if(board[l][m]=='O')
					board[l][m]='X';
				if(board[l][m]=='*')
					board[l][m]='O';
			}
		}
    }
	
	public static void fillIsland(char[][] grid, int i ,int j){
        if(i<0 || j< 0 || i>=grid.length || j>=grid[0].length || grid[i][j]!='O')
            return;
        grid[i][j] = '*';
        fillIsland(grid,i,j-1);
        fillIsland(grid,i,j+1);
        fillIsland(grid,i-1,j);
        fillIsland(grid,i+1,j);
    }
}
