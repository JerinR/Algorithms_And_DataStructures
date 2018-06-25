package backtracking;

/*
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 * The same repeated number may be chosen from candidates unlimited number of times.
 *
 * Note:
 *
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 * [7],
 * [2,2,3]
 * ]
 */
import java.util.ArrayList;
import java.util.List;


public class CombinationSum {

	 public List<List<Integer>> combinationSum(int[] candidates, int target) {
	        List<Integer> singleLs = new ArrayList();
	        List<List<Integer>> ls = new ArrayList();
	        backtrack(candidates, target, singleLs, ls,0);
	        return ls;
	    }
	    
	    public void backtrack(int[] candidates, int target, List<Integer> singleLs,List<List<Integer>> ls, int start){
	        if(target==0){
	            ls.add(new ArrayList(singleLs));
	            return;
	        }
	        for(int i=start;i<candidates.length;i++){
	            
	            
	            if(candidates[i]<=target){
	                singleLs.add(candidates[i]);
	                backtrack(candidates, target - candidates[i], singleLs, ls,i);
	                singleLs.remove(singleLs.size()-1);
	            }
	            else {
	                //i++;
	                //start++;
	            }
	        }
	    }
}
