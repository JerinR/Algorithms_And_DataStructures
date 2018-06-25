package backtracking;

/*
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
 * Note: The solution set must not contain duplicate subsets.
 *
 * Example:
 *
 * Input: [1,2,2]
 * Output:
 * [
 * [2],
 * [1],
 * [1,2,2],
 * [2,2],
 * [1,2],
 * []
 * ]
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Subsets11 {
	public static void main(String[]args) {
		int[]nums = {4,4,4,1,4};
		List<List<Integer>> l = subsetsWithDup(nums);
	}
	public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        List<Integer> ls = new ArrayList<>();
        createList(set,ls,nums,0);
        return new ArrayList(set);
    }
    public static void createList(Set<List<Integer>> set, List<Integer> ls,int[] nums,int start){
        set.add(new ArrayList((ls)));
        for(int i=start;i<nums.length;i++){
            if(i != start && nums[i] == nums[i-1]) continue;
            ls.add(nums[i]);
            createList(set,ls,nums,i+1);
            ls.remove(ls.size()-1);
        }
    }
}
