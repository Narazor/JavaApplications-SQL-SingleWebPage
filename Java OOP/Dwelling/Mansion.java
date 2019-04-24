package ua.myDwelling;

public class Mansion extends Estate {

	public Mansion(String type, String district, int price, int numberOfRooms, double distanceToKindergarten,
			double distanceToSchool, double distanceToPlayground) {
		super(type, district, price, numberOfRooms, distanceToKindergarten, distanceToSchool, distanceToPlayground);
	}

	@Override
	public String getTypeOfwelling() {
		return "mansion";
	}

}
