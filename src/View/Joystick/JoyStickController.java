package View.JoyStick;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Circle;

public class JoyStickController extends BorderPane {
    public Circle innerCircle;
    public Circle outerCircle;
    public Slider throttle;
    public Slider rudder;

    @FXML
    Circle innerCircle1;
    @FXML
    Circle outerCircle1;
    @FXML
    Slider throttle1;
    @FXML
    Slider rudder1;

    public DoubleProperty aileron, elevators;

    // Initialize each part of axis x and axis y
    private double jx, jy;
    private double Ax, Ay;

    // Constructor to the joystick
    public JoyStickController() {
        Ax = 0;
        Ay = 0;
        aileron = new SimpleDoubleProperty();
        elevators = new SimpleDoubleProperty();

        this.innerCircle1 = innerCircle;
        this.outerCircle1 = outerCircle;
        this.rudder1 = rudder;
        this.throttle1 = throttle;

/////
    }

}