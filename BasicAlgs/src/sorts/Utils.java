package sorts;

import java.util.Random;

public class Utils {
	
	public static int[] genArray(int size){
		int[] arr = new int[size];
		Random rnd = new Random();
		for (int i=0; i < size; i++){
			arr[i] = rnd.nextInt(100);
		}
		return arr;
	}
	
	public static void swap(int[] arr, int i, int j){
        //System.out.println("Change: " + arr[i] + "<->" +arr[j]);
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;		
	}
	
	public static void printArray(int[] arr) {
		System.out.println(java.util.Arrays.toString(arr));
	}

}
