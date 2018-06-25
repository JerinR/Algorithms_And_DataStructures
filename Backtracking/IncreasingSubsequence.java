package backtracking;

/*
 * Given an integer array, your task is to find all the different possible increasing subsequences of the given array, and the length of an increasing subsequence should be at least 2 .
 *
 * Example:
 * Input: [4, 6, 7, 7]
 * Output: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
 */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IncreasingSubsequence {
	public static void main(String[]args) {
		int [] nums = {3,2,1,4,6,7,7};
		List<List<Integer>> ls = findSubsequences(nums);
	}
	
	public static List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> ls = new HashSet<>();
        List<Integer> l = new ArrayList<>();
        createSub(nums,ls,l,0);
        return new ArrayList(ls);
    }
    public static void createSub(int[]nums, Set<List<Integer>> ls, List<Integer> l, int start){
        if(l.size()>1)
            ls.add(new ArrayList(l));
        for(int i=start;i<nums.length;i++){
        	 if(!l.isEmpty() && nums[i]<l.get(l.size()-1)){
                 //l.remove(l.size()-1);
                 continue;
             }
            l.add(nums[i]);
            createSub(nums,ls,l,i+1);
            l.remove(l.size()-1);
        }
    }
}
