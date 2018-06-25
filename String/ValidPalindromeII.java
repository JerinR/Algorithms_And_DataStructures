package string;

/*
 *	Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
 *
 *	Example 1:
 * 	Input: "aba"
 *	Output: True
 *	
 *	Example 2:
 *	Input: "abca"
 *	Output: True
 *	Explanation: You could delete the character 'c'.
 *	
 */
public class ValidPalindromeII {
	public static void main(String[]args) {
		System.out.println(validPalindrome("atbbga"));
	}
	public static boolean validPalindrome(String s) {
        for(int i=0,j=s.length()-1;i<=j;i++,j--){
            if(s.charAt(i)!=s.charAt(j)){
            	return isPal(s,i+1,j) || isPal(s,i,j-1);
            }
        }
        return true;
    }
	public static boolean isPal(String s, int start, int end) {
		while (start < end) 
	        if (s.charAt(start++) != s.charAt(end--)) return false;
	    return true;
	}
}
