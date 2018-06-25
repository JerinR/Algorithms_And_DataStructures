package dynamicProgramming;

/* Input: Matrix
 * Output: largest square of ones
 * 
 * implementation: ITERATIVE
 * Consider 2x2 matrix and computer bottom right. Store the value in a 2D matrix
 * for 1st col and 1st row the value will be itself since the neighbors fall outside the matrix
 * if the cell has one calculate the surrounding square with 1 + min of all the neighbors
 * */
public class LargestSquareOf1InMatrix {
	public static void main(String[]args) {
		int[][] mat = {{1,1,0,1,0},
				{0,1,1,1,0},
				{1,1,1,1,0},
				{0,1,1,1,1}};
		System.out.println(largestSquare(mat));
	}
	public static int largestSquare(int[][] mat) {
		//int dp[][] = mat.clone();
		int max = 0;
		for(int i=0;i<mat.length;i++) {
			for(int j=0;j<mat[i].length;j++) {
				if(i==0 || j==0) {
					continue;
				}
				else if(mat[i][j]==1) {
					mat[i][j] = 1 + Math.min(mat[i-1][j-1], Math.min(mat[i][j-1], mat[i-1][j]));
					max = Math.max(max, mat[i][j]);
				}
			}
		}
		return max;
	}

}
