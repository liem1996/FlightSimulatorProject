package View;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;

public class JoyStickController {

    @FXML
    Slider throttle, rudder;
    @FXML
    Pane joystick;

    public DoubleProperty aileron, elevators;

    public JoyStickController(){
        aileron = new SimpleDoubleProperty(); // Creating aileron
        aileron = new SimpleDoubleProperty(); // Creating aileron
        elevators = new SimpleDoubleProperty(); // Creating elevator
    }

}
