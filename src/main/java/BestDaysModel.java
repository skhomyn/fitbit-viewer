


public class BestDaysModel {

	private float distance;
	private int floors;



	//CHECK
	//constructor which populates fields with data from API call
	//currently we are using fake sample data instead of an API call
	BestDaysModel() {
		distance = FakeAPI.getbdDistance();
		floors = FakeAPI.getbdFloors();
	}


	public float getDistance(){
		return distance;
	}


	public int getFloors(){
		return floors;
	}


}
