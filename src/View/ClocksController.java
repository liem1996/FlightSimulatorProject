package View;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ClocksController {
    @FXML
    public Label altimeter;

    @FXML
    public Label yaw;

    @FXML
    public Label pitch;

    @FXML
    public Label direction;

    @FXML
    public Label roll;

    @FXML
    public Label airspeed;

    /*
    public String getAltimeter() {
        return altimeter.getText();
    }

     */

    public ClocksController() {
        altimeter=new Label();
        yaw=new Label();
        roll=new Label();
        pitch=new Label();
        direction=new Label();
        airspeed=new Label();

     }



}