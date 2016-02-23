
public class BestDaysModel {

	private float distance;



	//CHECK
	//constructor which populates fields with data from API call
	//currently we are using fake sample data instead of an API call
	BestDaysModel() {
		distance = FakeAPI.getbdDistance();
	}



	public float getDistance(){
		return distance;
	}



}
