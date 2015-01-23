package sorts;

public class Utils {

	public static void swap(int[] arr, int i, int j){
        System.out.println("Change: " + arr[i] + "<->" +arr[j]);
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;		
	}
	
	public static void printArray(int[] arr) {
		System.out.println(java.util.Arrays.toString(arr));
	}

}
