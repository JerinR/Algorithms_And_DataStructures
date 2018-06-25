package string;

/*
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * Note: For the purpose of this problem, we define empty string as valid palindrome.
 *
 * Example 1:
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 * 
 * Example 2:
 * Input: "race a car"
 * Output: false
 */
public class ValidPalindrome {
	public static void main(String[]args) {
		System.out.println(isPalindrome("ab2a"));
	}
	public static boolean isPalindrome(String s) {
        String str = s.toLowerCase();
        for(int i=0,j=s.length()-1;i<=j;){
            while(i<=j &&!((str.charAt(i)>='a' && str.charAt(i)<='z') || (str.charAt(i)>='0' && str.charAt(i)<='9')))
                i++;
            while(j>=i && !((str.charAt(j)>='a' && str.charAt(j)<='z') || (str.charAt(j)>='0' && str.charAt(j)<='9')))
                j--;
            if(i<=j && str.charAt(i) != str.charAt(j))
                return false;
            else{
                i++;j--;
            }
        }
        return true;
    }
}
