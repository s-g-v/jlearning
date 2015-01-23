package sorts;

public class Buble {

	public static void main(String[] args) {
		int[] arr = {4, 3, 65, 5, 8,2, 7, 0};
		long startTime = System.nanoTime();
		arr = sort(arr);
		long endTime = System.nanoTime();
		int duration = (int) ((endTime - startTime)/Math.pow(10, 6));
		System.out.println("Duration: " + duration + " ms");
	}
	
	private static int[] sort (int[] arr){
		int k = 0;
		for (int i = 0; i < arr.length; i++) {
	        for (int j = arr.length-1; j >= i ; j--) {
	        	k++;
	            System.out.println("Iteration: " + k + "\nElements: " + arr[i] + "vs" +arr[j]);
	            if (arr[i] < arr[j]) Utils.swap(arr, i, j);
	            Utils.printArray(arr);
	        }
		}
		return arr;
	}
}
