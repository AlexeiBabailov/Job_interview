
public class PointOfInterest {

	private String name;
	private int X_coordinate;
	private int Y_coordinate;

	//constructor - point of interest
	public PointOfInterest(String name, int X_coordinate,int Y_coordinate) {
		this.name = name;
		this.X_coordinate = X_coordinate;
		this.Y_coordinate = Y_coordinate;
	}

	public String getName() {
		return name;
	}

	//currently not in use - for forwarder development such as updating
	public void setName(String name) {
		this.name = name;
	}

	public int getX_coordinate() {
		return X_coordinate;
	}

	//currently not in use - for forwarder development such as updating
	public void setX_coordinate(int x_coordinate) {
		X_coordinate = x_coordinate;
	}

	public int getY_coordinate() {
		return Y_coordinate;
	}

	//currently not in use - for forwarder development such as updating
	public void setY_coordinate(int y_coordinate) {
		Y_coordinate = y_coordinate;
	}
}
