package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * Given a string, find the length of the longest substring without repeating characters.

 * Examples:
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * Given "bbbbb", the answer is "b", with the length of 1.
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestStringWithoutRepeatingChar {
	public static void main(String[]args) {
		System.out.println(lengthOfLongestSubstringHash("abcabcbb"));
	}
	// using List
	public static int lengthOfLongestSubstring(String s) {
		if(s.length()==0)
            return 0;
        List<Character> ls = new ArrayList();
        ls.add(s.charAt(0));
        int max = 1;
        for(int i=1;i<s.length();i++){
            while(ls.contains(s.charAt(i))){
                max = Math.max(max,ls.size());
                ls.remove(0);
            }
            ls.add(s.charAt(i));
        }
        return Math.max(max,ls.size());
    }
	
	// using HashMap. Less Time Complexity 
	public static int lengthOfLongestSubstringHash(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max=0;
        for (int i=0, j=0; i<s.length(); ++i){
            if (map.containsKey(s.charAt(i))){
            	System.out.println("J before"+j);
                j = Math.max(j,map.get(s.charAt(i))+1);
                System.out.println("J after"+j);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-j+1);
        }
        return max;
    }
}
