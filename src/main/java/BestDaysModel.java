
public class BestDaysModel {

	private float distance;
	private int floors;
	private int steps;

	//constructor which populates fields with data from API call
	//currently we are using fake sample data instead of an API call
	BestDaysModel() {
		distance = FakeAPI.getbdDistance();
		floors = FakeAPI.getbdFloors();
		steps = FakeAPI.getbdSteps();
	}


	public float getDistance(){
		return distance;
	}


	public int getFloors(){
		return floors;
	}

	public int getSteps(){
		return steps;
	}

}
