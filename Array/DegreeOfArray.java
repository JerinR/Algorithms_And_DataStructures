package arrays;

/*
 * Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.
 * Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.
 * Example 1:
 * Input: [1, 2, 2, 3, 1]
 * Output: 2
 * Explanation: 
 * The input array has a degree of 2 because both elements 1 and 2 appear twice.
 * Of the subarrays that have the same degree:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * The shortest length is 2. So return 2.
 * 
 * Example 2:
 * Input: [1,2,2,3,1,4,2]
 * Output: 6
 */
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class DegreeOfArray {
	public static void main(String[]args) {
		System.out.println(findShortestSubArray(new int[] {1,2}));
	}
	public static int findShortestSubArray(int[] nums) {
        Map<Integer,Integer> map = new HashMap();
        Map<Integer,Integer[]> map2 = new HashMap();
        int max = 0;
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            max = Math.max(max,map.get(nums[i]));
            if(map2.get(nums[i])==null){
                map2.put(nums[i],new Integer[]{i,i});
            }
            else{
                map2.put(nums[i],new Integer[]{map2.get(nums[i])[0],i});
            }
        }
        Set<Integer> key = map.keySet();
        Iterator it = key.iterator();
        int len =Integer.MAX_VALUE;
        while(it.hasNext()){
            int j = (int) it.next();
            if(map.get(j)==max){
                Integer[] startEnd = map2.get(j);
                len = Math.min(len,startEnd[1]-startEnd[0]+1);
            }
        }
        return len;
    }
}
