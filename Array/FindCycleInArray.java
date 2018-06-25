package arrays;

/* Input: arr
 * Output: true/false depending on whether the arr has cycle or not
 * implementation - Tortoise and hare algo
 * Eg of cycle:
 * 1 2 1 3 4 8
 * 
 * Eg of not cycle:
 * 1 2 3 4 5 6*/
public class FindCycleInArray {
	public static void main(String[]args) {
		System.out.println(cyclic(new int[] {0,2,3,4,4,5}));
	}

	public static int cyclic(int arr[]) {
		int p=0,q=0;
		while(true) {
			if(p<0 || q<0 || p>=arr.length || q>=arr.length){
				return -1;
			}
			p = arr[p];
			if(q==p)
				return p;
			if(p<0 || p>=arr.length)
				return -1;
			p = arr[p];
			if(q==p)
				return p;
			q = arr[q];
			if(q==p)
				return p;
		}
	}
}
