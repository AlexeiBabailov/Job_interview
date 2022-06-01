import javax.swing.JOptionPane;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Entities_CreatorController {

	private static final int nameMaxLength = 30;	//default max name length, can easily be changed
	private static final int mapWidth = 1272;	//default world map width, can easily be changed accordingly to the image itself
	private static final int mapHeight = 666;	//default world map Height, can easily be changed accordingly to the image itself
	
	@FXML
	public void initialize() { 
		//the entities creator is the master window which automatically opens the entities presenter window
		try {
			Parent root1 = (Parent) FXMLLoader.load(getClass().getResource("Entities_Presentor.fxml")); 
			Scene scene1 = new Scene(root1);
			Stage stage1 = new Stage();
			stage1.setTitle("Entities_Presentor"); 
			stage1.setScene(scene1); 
			stage1.show();
		} catch (Exception e) {
			System.out.println("cant open map");
		}
	}

	@FXML
	private Button sendBtn;

	@FXML
	private TextField textName;

	@FXML
	private TextField textX;

	@FXML
	private TextField textY;

	@FXML
	void btnPressed(ActionEvent event) {
		try {	//try-catch in case non integer values entered to coordinate text box
			int int_X = Integer.parseInt(textX.getText());
			int int_Y = Integer.parseInt(textY.getText()); 
			PointOfInterest p1 = new PointOfInterest(textName.getText(),int_X,int_Y);
			if (int_X < 0 || int_X > mapWidth) {	//X coordinate bounds
				JOptionPane.showMessageDialog(null, "X coordinate out of bounds, please try again");
				textX.clear();
				return;
			}
			if (int_Y < 0 || int_Y > mapHeight) {	//Y coordinate bounds
				JOptionPane.showMessageDialog(null, "Y coordinate out of bounds, please try again");
				textY.clear();
				return;
			}
			if (textName.getText().length() > nameMaxLength || textName.getText().length() == 0) {	//name length limits
				JOptionPane.showMessageDialog(null, "Name error, you didnt enter a name or try name shorter than " + nameMaxLength + " letters");
				textName.clear();
				return;
			}
			Entities_PresentorController.setPointOfInterest(p1);
		} catch(Exception e){
			JOptionPane.showMessageDialog(null, "you didnt enter proper Values, please try again");
			return;
		}
	}

}



