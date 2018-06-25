package dynamicProgramming;

/*
 * Given a string, your task is to count how many palindromic substrings in this string.
 * The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.
 *
 * Example 1:
 * Input: "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 * 
 * Example 2:
 * Input: "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 */
public class PalindromicSubstring {
	public static void main(String[]args) {
		PalindromicSubstring pal = new PalindromicSubstring();
		System.out.println(pal.countSubstrings("cbbd"));
	}
	public int countSubstrings(String s) {
		int count = 0;
		int[]arr = new int[s.length()];
        for(int i =1;i<s.length();i++) {
        	oddPalindrome(s, i, arr);
        	evenPalindrome(s, i, arr);
        }
        return arr[s.length()-1]+1;
    }
	public static void oddPalindrome(String s,int i,int []arr) {
		int start = i-1,end=i+1,count=1;
		while(start>=0 && end<s.length()) {
			if(s.charAt(start)!=s.charAt(end))break;
			else count++;
			start--;end++;
		}
		arr[i] = arr[i-1] + count;
	}
	public static void evenPalindrome(String s,int i,int []arr) {
		int start = i-1,end=i,count=0;
		while(start>=0 && end<s.length()) {
			if(s.charAt(start)!=s.charAt(end))break;
			else count++;
			start--;end++;
		}
		arr[i] = arr[i] + count;
	}
}
