package sorts;

public class Selection {

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
		for (int i = 0; i < arr.length -1; i++) {
			int min = i;
			for (int j = i+1; j < arr.length; j++) {
				k++;
				System.out.println("Iteration: " + k + "\nElements: " + arr[j] + "vs" +arr[min]);
				if (arr[j] < arr[min]) min = j;
			}
			Utils.swap(arr, i, min);
			Utils.printArray(arr);
		}
		return arr;
	}
}
