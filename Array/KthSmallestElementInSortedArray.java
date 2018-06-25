package arrays;

/*
 * Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.
 * Note that it is the kth smallest element in the sorted order, not the kth distinct element.
 *
 * Example:
 *
 * matrix = [
 *  [ 1,  5,  9],
 *  [10, 11, 13],
 *  [12, 13, 15]
 * ],
 * k = 8,
 *
 * return 13.
 */
import java.util.PriorityQueue;
import java.util.Queue;

public class KthSmallestElementInSortedArray {
	public static void main(String[]args) {
		int[][] matrix = {{1,  5,  10},
						{10, 11, 13},
						{12, 13, 15}};
		System.out.println(kthSmallest(matrix, 8));
	}
	public static int kthSmallest(int[][] matrix, int k) {
		Queue<Integer> q = new PriorityQueue<>();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
            	q.add(matrix[i][j]);
            }
        }
        while(k>1) {
        	q.poll();
        	k--;
        }
        return q.poll();
    }
}
