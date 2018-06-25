package dynamicProgramming;

public class CoinChangeMin {
	public static void main(String[]args) {
		//System.out.println(count(new int[] {1,3,5},11));
		System.out.println(countR(new int[] {1,2,3},5, new int[6]));
	}
	
	// ITERATIVE
	public static int count(int []coins, int amount) {
		if(amount<1)
			return 0;
		int[] dp = new int[amount+1];
		int sum = 0;
		while(++sum<amount) {
			int min = -1;
			for(int coin : coins) {
	    		if(sum >= coin && dp[sum-coin]!=-1) {
	    			int temp = dp[sum-coin]+1;
	    			min = min<0 ? temp : (temp < min ? temp : min);
	    		}
	    	}
			dp[sum] = min;
		}
		return dp[amount];
	}
	
	//RECURSIVE
	public static int countR(int[] coins, int amount, int[]num) {
		if(amount==0)
			return 0;
		countR(coins,amount-1,num);
		for(int coin:coins) {
			
			if(amount==coin) {
				
				num[amount] = 1;
				break;
			}
			if(amount>coin) {
				
				num[amount] = num[amount-coin]==0?1:num[amount-coin]+1;
			}
		}
		return num[amount];
	}
}
