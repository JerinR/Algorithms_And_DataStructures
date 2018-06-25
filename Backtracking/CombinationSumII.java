package backtracking;

/*
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 * Each number in candidates may only be used once in the combination.
 *
 * Note:
 *
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 *
 * Input: candidates = [10,1,2,7,6,1,5], target = 8,
 * A solution set is:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSumII {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
	    List<Integer> singleLs = new ArrayList();
	        Set<List<Integer>> ls = new HashSet();
	        backtrack(candidates, target, singleLs, ls,0);
	        return new ArrayList(ls);
	    }

	    public void backtrack(int[] candidates, int target, List<Integer> singleLs,Set<List<Integer>> set, int start){
	        if(target==0){
	        	List ls = new ArrayList(singleLs);
	        	Collections.sort(ls);
	            set.add(ls);
	            return;
	        }
	        for(int i=start;i<candidates.length;i++){


	            if(candidates[i]<=target){
	                singleLs.add(candidates[i]);
	                backtrack(candidates, target - candidates[i], singleLs, set,i+1);
	                singleLs.remove(singleLs.size()-1);
	            }
	        }
	    }
}
