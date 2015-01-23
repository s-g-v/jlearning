package sorts;

public abstract class Algorithm {
	
	protected float duration;
	protected int numberOfSteps;
	
	abstract public int[] sort(int[] arr);

	public float getDuration() {
		return duration;
	}

	public int getTotalSteps() {
		return numberOfSteps;
	}

}
