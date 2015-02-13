package Fibs;

public class FNumbers {
	
	public static void main (String[] args) {
		System.out.print(recF(9));
		System.out.println();
		iterF(10);
	}
	
	private static int recF(int x){
		return (x > 2) ? recF(x-1) + recF(x-2) : x;
	}

	private static void iterF(int x){
		int[] result = new int[x];
		for (int i = 0; i < x; i++){
			if (i < 2) {
				result[i] = 1;
			}
			else {
				result[i] = result[i-1] + result[i-2]; 
			}
			System.out.print(result[i] + " ");	
		}
	}
}
