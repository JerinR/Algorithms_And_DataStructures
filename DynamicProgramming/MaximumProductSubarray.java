package dynamicProgramming;

/*
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
 *
 * Example 1:
 *
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * Example 2:
 *
 * Input: [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 */
public class MaximumProductSubarray {
	public int maxProduct(int[] nums) {
        if(nums.length==0)
            return 0;
        int[] dp = new int[nums.length];
        int max = Integer.MIN_VALUE;
        dp[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            
            int mul=1;
            for(int j=i;j>=0;j--){
                mul *= nums[j];
                max = Math.max(mul,Math.max(nums[i], max));
            }
            dp[i] = Math.max(max,dp[i-1]);
        }
        return dp[nums.length-1];
    }

}
