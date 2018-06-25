package stack;

/*
 * Given an encoded string, return it's decoded string.
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
 * You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
 * Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
 * Examples:
 *
 * s = "3[a]2[bc]", return "aaabcbc".
 * s = "3[a2[c]]", return "accaccacc".
 * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 */
import java.util.Stack;

public class DecodeString {
	public static void main(String[]args) {
		System.out.println(decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));
	}
	public static String decodeString(String s) {
		String res = "";
        Stack<String> st = new Stack();
        st.push(s.charAt(0)+"");
        int i=1;
        while(!st.isEmpty() && i<s.length()) {
        	String sb = "";
        	StringBuilder num = new StringBuilder();
        	int n = 0;
        	while(i<s.length() && s.charAt(i)!=']') {
        		st.push(s.charAt(i)+"");
        		i++;
        	}
        	if(i<s.length() &&s.charAt(i)==']') {
        		while(!st.isEmpty() && !st.peek().equals("[")) {
        			sb = (st.pop()) + sb;
        		}
        		st.pop();
        		while(!st.isEmpty() && !(st.peek().charAt(0)>='a' && st.peek().charAt(0)<='z') && !st.peek().equals("[")) {
        			num.append(st.pop());
        		}
        		n = Integer.parseInt(num.reverse().toString());
        	}
        	st.push(createString(sb.toString(), n));
        	i++;
        }
        while(!st.isEmpty())
        	res  = (st.pop())+res;
        return res;
    }
	public static String createString(String s, int n) {
		String sb = "";
		for(int i=0;i<n;i++) {
			sb = s+sb;
		}
		return sb;
	}
}
