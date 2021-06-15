package View.Clocks;

import View.fxmlController.MainWindowController;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

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