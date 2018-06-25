package arrays;

/*
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * Your algorithm should run in O(n) complexity.
 *
 * Example:
 * Input: [100, 4, 200, 1, 3, 2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 */
import java.util.PriorityQueue;
import java.util.Queue;

public class LongestConsecutiveSequence {
	public static void main(String[]args) {
		System.out.println(longestConsecutive(new int[] {1,2}));
	}
	
	public static int longestConsecutive(int[] nums) {
        Queue<Integer> q = new PriorityQueue();
        for(int i=0;i<nums.length;i++){
            q.add(nums[i]);
        }
        int count = 0;
        int max = Integer.MIN_VALUE;
        int i = q.poll();
        while(!q.isEmpty()) {
        	
        	int j = q.poll();
        	if(j==i+1) {
        		count++;
        	}
        	else  if(j>=i+2){
        		count++;
        		max = Math.max(max, count);
        		count=0;
        	}
        	i = j;
        }
        count++;
		max = Math.max(max, count);
        return max;
    }


}
