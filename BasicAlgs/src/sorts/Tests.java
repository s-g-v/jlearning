package sorts;

public class Tests {

	public static void main(String[] args){
		int[] arr = Utils.genArray(10);
		Utils.printArray(arr);
		Algorithm[] algs = {new Buble(), new Selection(), new Insertion()};
		for (Algorithm impl:algs){
			System.out.println("Sort method: " + impl.getClass().getSimpleName());
			Utils.printArray(impl.sort(arr.clone()));
			System.out.print("Total iterations: " + impl.getTotalSteps() + "; ");			
			System.out.println("Duration: " + impl.getDuration() + " ms");			
		}
		
	}
}
