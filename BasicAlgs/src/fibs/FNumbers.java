package fibs;

public class FNumbers {
	
	public static void main (String[] args) {
		System.out.println(recF(9));
		iterF(10);
	}
	
	private static int recF(int x){
		return (x > 2) ? recF(x-1) + recF(x-2) : x;
	}

	private static void iterF(int x){
		int[] result = new int[x+1];
		for (int i = 0; i <= x; i++){
			if (i < 2) {
				result[i] = i;
			}
			else {
				result[i] = result[i-1] + result[i-2]; 
			}
			System.out.print(result[i] + " ");	
		}
	}
}
