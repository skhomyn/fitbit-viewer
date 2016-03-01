package ca.uwo.csd.cs2212.team13;

class FakeAPI {

	//for Lifetime Totals
	private static float ltDistance = 143;
	private static int ltFloors = 54;
	private static int ltSteps = 189770;

	public static float getLtDistance() {
		return ltDistance;
	}
	public static int getLtFloors() {
		return ltFloors;
	}

	public static int getLtSteps() {
		return ltSteps;
	}

	//for Best Days
	private static float bdDistance = 125;
	private static int bdFloors = 25;
	private static int bdSteps = 325;

	public static float getbdDistance() {
		return bdDistance;
	}
	
	public static int getbdFloors() {
		return bdFloors;
	}
	
	public static int getbdSteps() {
		return bdSteps;
	}

}
