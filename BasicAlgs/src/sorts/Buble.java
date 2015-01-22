package sorts;

public class Buble {

	public static void main(String[] args) {
		int[] arr = {4, 3, 65, 5, 8,2, 7, 0};
		arr = sort(arr);
	}
	
	private static int[] sort (int[] arr){
		int k = 0;
		for (int i = 0; i < arr.length; i++) {
	        for (int j = arr.length-1; j >= i ; j--) {
	        	k++;
	            System.out.println("Iteration: " + k + "\nElements: " + arr[i] + "vs" +arr[j]);
	            if (arr[i] < arr[j]) swap(arr, i, j);
	            printArray(arr);
	        }
		}
		return arr;
	}
	
	private static void swap(int[] arr, int i, int j){
        System.out.println("Change: " + arr[i] + "<->" +arr[j]);
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;		
	}
	
	private static void printArray(int[] arr) {
		System.out.println(java.util.Arrays.toString(arr));
	}
}
