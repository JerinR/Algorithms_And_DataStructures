package dynamicProgramming;

/*
 * Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.
 *
 * Example:
 * Given n = 2, return 91. (The answer should be the total numbers in the range of 0 ≤ x < 100, excluding [11,22,33,44,55,66,77,88,99])
 */
public class CountNumberWithUniqueDigits {
	public static void main(String[]args) {
		System.out.println(countNumbersWithUniqueDigits(2));
	}
	public static int countNumbersWithUniqueDigits(int n) {
        int dp[] = new int[n+1];
        dp[0]=1;
        for(int i=1;i<=n;i++){
            if(i>10)
                return dp[10];
            int j=i,comb = 9,res=9;
            while(j-->1){
                res *= comb--;
            }
            dp[i] = dp[i-1] + res;
        }
        return dp[n];
    }
}
