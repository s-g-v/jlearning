package sorts;

public class Merge extends Algorithm {

	@Override
	public int[] sort(int[] arr) {
		long startTime = System.nanoTime();
		numberOfSteps = 0;
		mergeSort(arr, 0, arr.length -1);
		long endTime = System.nanoTime();
		duration = (float) ((endTime - startTime)/Math.pow(10, 6));
		return arr;
	}
	
	private void mergeSort(int[] arr, int left, int right) {
		if (left + 1 < right) {
			int center = (left + right) >>> 1;
			mergeSort(arr, left, center);
			mergeSort(arr, center, right);
			merge(arr, left, center, right);
		}
	}
	
	private void merge(int[] arr, int left, int center, int right){
		int size = right - left;
		int[] result = new int[size];
		int i = left;
		int j = center;
		for (int k = 0; k < size; k++) {
			if (j >= right || i < center && arr[i] < arr[j]) {
				result[k] = arr[i++];
			} else {
				result[k] = arr[j++];
			}
			numberOfSteps++;
		}
		System.arraycopy(result, 0, arr, left, size);
	}

}
