package arrays;

/*
 * Given a non-negative integer, you could swap two digits at most once to get the maximum valued number. Return the maximum valued number you could get.
 *
 * Example 1:
 * Input: 2736
 * Output: 7236
 * Explanation: Swap the number 2 and the number 7.
 * Example 2:
 * Input: 9973
 * Output: 9973
 * Explanation: No swap.
 */
public class MaximumSwap {
	public static void main(String[]args) {
		System.out.println(maximumSwap(99901));
	}
	 public static int maximumSwap(int num) {
	        String n = num+"";
	        char[] arr = n.toCharArray();
	        int minIndex = -1,maxIndex = 0,start =0;
	        char max='0';
	        for(int i=0;i<arr.length-1;i++) {
	        	if(arr[i]<arr[i+1]) {
	        		start = i;
	        		break;
	        	}
	        }
	        maxIndex = start;
	        for(int i=start+1;i<arr.length;i++){
	            if(arr[i]>=arr[i-1] && arr[i]>=arr[maxIndex]){
	                 maxIndex = i;
	            }
	        }
	        for(int i=0;i<=maxIndex;i++) {
	        	if(arr[i]<arr[maxIndex]) {
	        		swap(arr, i, maxIndex);
	        		break;
	        	}
	        }
	        return Integer.parseInt(new String(arr));
	    }
	    public static void swap(char[]arr,int min, int max){
	        char temp = arr[max];
	        arr[max] = arr[min];
	        arr[min] = temp;
	    }
}
