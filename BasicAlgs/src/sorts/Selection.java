package sorts;

public class Selection extends Algorithm{

	public Selection (){}
	
	public int[] sort (int[] arr){
		long startTime = System.nanoTime();		
		numberOfSteps = 0;
		for (int i = 0; i < arr.length -1; i++) {
			int min = i;
			for (int j = i+1; j < arr.length; j++) {
				numberOfSteps++;
//				System.out.println("Iteration: " + numberOfSteps + "\nElements: " + arr[j] + "vs" +arr[min]);
				if (arr[j] < arr[min]) min = j;
			}
			Utils.swap(arr, i, min);
//			Utils.printArray(arr);
		}
		long endTime = System.nanoTime();
		duration = (float) ((endTime - startTime)/Math.pow(10, 6));
		return arr;
	}
}
