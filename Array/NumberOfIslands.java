package arrays;

/*
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 * Example 1:
 * 
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 * Output: 1
 * 
 * Example 2:
 *
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 * Output: 3
 */
public class NumberOfIslands {
	public static void main(String[] args) {
		char [][]grid = {{'1','1','0','0','0'},
				{'1','1','0','0','0'},
				{'0','0','1','0','0'},
				{'0','0','0','1','1'}};
		System.out.println(numIslands(grid));
	}
	public static int numIslands(char[][] grid) {
		if(grid.length==0)
			return 0;
        int count = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    count++;
                    fillIsland(grid,i,j);
                }
            }
        }
        return count;
    }
    
    public static void fillIsland(char[][] grid, int i ,int j){
        if(i<0 || j< 0 || i>=grid.length || j>=grid[0].length || grid[i][j]!='1')
            return;
        grid[i][j] = '*';
        fillIsland(grid,i,j-1);
        fillIsland(grid,i,j+1);
        fillIsland(grid,i-1,j);
        fillIsland(grid,i+1,j);
    }
}
