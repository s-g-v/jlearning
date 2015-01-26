package sorts;

import java.util.*;

public class Insertion extends Algorithm{

	public Insertion(){}
	
	public int[] sort (int[] arr){
		long startTime = System.nanoTime();		
		for (int i = 1; i< arr.length; i++){
			int newIndex = Arrays.binarySearch(arr, 0, i, arr[i]);
			if (newIndex < 0) {
				newIndex = -1*(newIndex+1);
			}
			int tmp = arr[i];
			System.arraycopy(arr, newIndex, arr, newIndex+1, i-newIndex);
			arr[newIndex] = tmp;
		}
		long endTime = System.nanoTime();
		numberOfSteps = arr.length;
		duration = (float) ((endTime - startTime)/Math.pow(10, 6));
		return arr;
	}
}
