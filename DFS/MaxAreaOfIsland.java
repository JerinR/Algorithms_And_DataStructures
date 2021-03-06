package dfs;
/*
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
 *
 * Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)
 */
public class MaxAreaOfIsland {
	public static void main(String[]args) {
		int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
				{0,0,0,0,0,0,0,1,1,1,0,0,0},
				{0,1,1,0,1,0,0,0,0,0,0,0,0},
				{0,1,0,0,1,1,0,0,1,0,1,0,0},
				{0,1,0,0,1,1,0,0,1,1,1,0,0},
				{0,0,0,0,0,0,0,0,0,0,1,0,0},
				{0,0,0,0,0,0,0,1,1,1,0,0,0},
				{0,0,0,0,0,0,0,1,1,0,0,0,0}};
		System.out.println(maxAreaOfIsland(grid));
	}

	public static int maxAreaOfIsland(int[][] grid) {
        int count = 0;
         for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1)
                    count = Math.max(count,countArea(grid,i,j));
            }
        }
        return count;
    }
    
    public static int countArea(int[][] grid,int i, int j){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]!=1)
            return 0;
        
       if(grid[i][j]==1)
    	   grid[i][j]=-1;
            
        return 1 + countArea(grid,i-1,j) + countArea(grid,i+1,j) + countArea(grid,i,j-1) + countArea(grid,i,j+1);
        
        
    }
}
