package sorts;

public class Buble implements Algorithm {
	
	private float duration;
	private int numberOfSteps;

	public Buble (){}
	
	public int[] sort (int[] arr){
		long startTime = System.nanoTime();		
		numberOfSteps = 0;
		for (int i = 0; i < arr.length; i++) {
	        for (int j = i; j < arr.length ; j++) {
	        	numberOfSteps++;
//	            System.out.println("Iteration: " + numberOfSteps + "\nElements: " + arr[i] + "vs" +arr[j]);
	            if (arr[i] > arr[j]) Utils.swap(arr, i, j);
//	            Utils.printArray(arr);
	        }
		}
		long endTime = System.nanoTime();
		duration = (float) ((endTime - startTime)/Math.pow(10, 6));
		return arr;
	}

	@Override
	public float getDuration() {
		return duration;
	}

	@Override
	public int getTotalSteps() {
		return numberOfSteps;
	}
}
