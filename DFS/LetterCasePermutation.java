package dfs;

/*
 * Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.  Return a list of all possible strings we could create.
 *
 * Examples:
 * Input: S = "a1b2"
 * Output: ["a1b2", "a1B2", "A1b2", "A1B2"]
 *
 * Input: S = "3z4"
 * Output: ["3z4", "3Z4"]
 * 
 * Input: S = "12345"
 * Output: ["12345"]
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LetterCasePermutation {
	public static void main(String[]args) {
		List<String> ls = letterCasePermutation("RmR");
	}

	public static List<String> letterCasePermutation(String S) {
		 List<String> ls = new ArrayList();
	        ls.add(S);
	        
	        int i=0,index = 0;
	        while(index<S.length()){
	        	int len = ls.size();
	            for(int j=0;j<len;j++) {
	                if(ls.size()==3)
	            		ls.remove(0);
	            	S = ls.get(j);
	            	 StringBuilder str = new StringBuilder(S);
	            	if((S.charAt(index)>='a' && S.charAt(index)<='z')||(S.charAt(index)>='A' && S.charAt(index)<='Z')){
	                    str.setCharAt(index,Character.toLowerCase(S.charAt(index)));
		            	//S = S.replace(S.charAt(index),Character.toLowerCase(S.charAt(index)));
		                ls.add(str.toString());
	                    str.setCharAt(index,Character.toUpperCase(S.charAt(index)));
		                //S = S.replace(S.charAt(index),Character.toUpperCase(S.charAt(index)));
		                ls.add(str.toString());
	            	}
	            	else break;
	                
	                
	            }
	            index++;
	            //else ls.add(S);
	        }
	        Set<String> s = new HashSet(ls);
	        
	        return new ArrayList(s);
    }
}
