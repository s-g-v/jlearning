package tut;

public class RtriangleImpl implements Rtriangle {
	
	private int x1 = -4;
	private int y1 = 3;
	private int x2 = 2;
	private int y2 = 7;
	private int x3 = 8;
	private int y3 = -2;
	
	@Override
	public int getApexX1() {
		return x1;
	}

	@Override
	public int getApexY1() {
		return y1;
	}

	@Override
	public int getApexX2() {
		return x2;
	}

	@Override
	public int getApexY2() {
		return y2;
	}

	@Override
	public int getApexX3() {
		return x3;
	}

	@Override
	public int getApexY3() {
		return y3;
	}

}
