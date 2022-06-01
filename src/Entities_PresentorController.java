import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;

public class Entities_PresentorController {

	//final's used for this exercise demands, can be easily changed for forwarder updates 
	private static final int pointDiameter = 30;	//uses to put the center of the POI on the exact coordinate
	private static final int pointShiftToFeetCenter = pointDiameter/2;	//the relevant shift according to point diameter
	private static final int shiftTextDown = pointShiftToFeetCenter +15;	//according to point diameter the text will be constantly below by 15 pixels
	private static final int boundRightShift = 40;	//the canvas is intentionally bigger by 40 pixels from each side so the point & name will get cut
	private static final int boundDownShift = 15;	// the canvas top is intentionally bigger by 15 pixels from top so the POI will get cut
	private static final Color blackName = new Color(0,0,0,1);	//constant of text color - can be easily changed
	private static final Color redPoint = new Color(1,0,0,0.8);	//constant of POI color - can be easily changed

	public Entities_PresentorController() {
		super();
	}

	@FXML
	private Canvas canv;
	private static GraphicsContext gc;

	@FXML
	public void initialize() {
		gc = canv.getGraphicsContext2D();
		gc.setTextAlign(TextAlignment.CENTER); //sets text alignment centered according to the POI
	
	}

	//sets new point of interest on the map, according to exercise demands and class finals
	//the point of interest center will always be on map coordinates (the edges which less important might get slightly out of map but stay inside the window)
	//the point of interest name will always be below & centered to the coordinate - according to final can be easily changed 
	public static void setPointOfInterest(PointOfInterest p) {
		gc.setFill(blackName); 
		gc.fillText(p.getName(),(double)(p.getX_coordinate() + boundRightShift), (double)(p.getY_coordinate()+ shiftTextDown + boundDownShift)); /*max function to avoid the Name to be out of bounds, assuming the point edge not critical*/
		gc.setFill(redPoint);
		gc.fillOval((double)(p.getX_coordinate() - pointShiftToFeetCenter + boundRightShift), (double)(p.getY_coordinate() - pointShiftToFeetCenter + boundDownShift), pointDiameter, pointDiameter);
	}
}
