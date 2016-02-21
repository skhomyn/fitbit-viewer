package sharkzilla;

public class LifetimeRecord extends RecordModel {
	
	private float distance;
	
	//constructor which populates fields with data from API call
	//currently we are using fake sample data instead of an API call
	LifetimeRecord() {
		distance = FakeAPI.getLtDistance();
	}
	
	//access methods
	public float getDistance() {
		return distance;
	}
}
