package sorts;

public class Tests {

	public static void main(String[] args){
		int[] arr = Utils.genArray(7);
		Utils.printArray(arr);
		Algorithm[] algs = {new Buble(), new Selection()};
		for (Algorithm impl:algs){
			System.out.println("Sort method: " + impl.getClass().getSimpleName());
			Utils.printArray(impl.sort(arr));
			System.out.print("Total iterations: " + impl.getTotalSteps() + "; ");			
			System.out.println("Duration: " + impl.getDuration() + " ms");			
		}
		
	}
}
