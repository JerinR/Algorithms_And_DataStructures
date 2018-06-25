package arrays;

/*
 * Given a sorted array consisting of only integers where every element appears twice except for one element which appears once. Find this single element that appears only once.
 *
 * Example 1:
 * Input: [1,1,2,3,3,4,4,8,8]
 * Output: 2
 * 
 * Example 2:
 * Input: [3,3,7,7,10,11,11]
 * Output: 10
 */

public class SingleElementInSortedArray {
	public static void main(String[]args) {
		System.out.println(singleNonDuplicate(new int[] {3,3,7,7,10,11,11}));
	}
	public static int singleNonDuplicate(int[] nums) {
		if(nums.length==0)
			return -1;
        int start = 0;
        int end = nums.length-1;
        int mid = (start+end)/2;
        while(start!=end){
        	mid = (start+end)/2;
            if(mid>0 && mid%2==0 && nums[mid-1]==nums[mid]){
                end = mid;
            }
            else if(mid>0 && mid%2==0 && nums[mid-1]!=nums[mid]){
                start = mid;
            }
            else if(mid<nums.length-1 && mid%2!=0 && nums[mid+1]!=nums[mid]){
                start = mid+1;
            }
            else if(mid<nums.length-1 && mid%2!=0 && nums[mid+1]==nums[mid]){
                end = mid-1;
            }
        }
        return nums[start];
    }
}
