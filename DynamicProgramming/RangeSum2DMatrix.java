package dynamicProgramming;

/*
 * Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
 * 
 * Example:
 * Given matrix = [
 * [3, 0, 1, 4, 2],
 * [5, 6, 3, 2, 1],
 * [1, 2, 0, 1, 5],
 * [4, 1, 0, 1, 7],
 * [1, 0, 3, 0, 5]
 * ]
 *
 * sumRegion(2, 1, 4, 3) -> 8
 * sumRegion(1, 1, 2, 2) -> 11
 * sumRegion(1, 2, 2, 4) -> 12
 */
public class RangeSum2DMatrix {
	public static void main(String[]args) {
		int[][] matrix = {{1},{-7}};
		NumMatrix obj = new NumMatrix(matrix);
		int param_1 = obj.sumRegion(1,0,1,0);
		System.out.println(param_1);
	}
}

class NumMatrix {
    int sumMatrix [][];
    public NumMatrix(int[][] matrix) {
        sumMatrix = new int[matrix.length][matrix[0].length];
        // row sum
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
            	if(j==0)
            		sumMatrix[i][j] = matrix[i][j];
            	else sumMatrix[i][j] += matrix[i][j]+sumMatrix[i][j-1];
            }
        }
        
        // col sum
        for(int i=1;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
            	
                sumMatrix[i][j] += sumMatrix[i-1][j];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
    	if(sumMatrix.length==0 || sumMatrix[0].length==0)
    		return 0;
        int sum = sumMatrix[row2][col2];
        sum -= (row1-1>=0)?sumMatrix[row1-1][col2]:0;
        sum -= (col1-1>=0)?sumMatrix[row2][col1-1]:0;
        sum += (row1-1>=0 && col1-1>=0)?sumMatrix[row1-1][col1-1]:0;
        return sum;
    }
}