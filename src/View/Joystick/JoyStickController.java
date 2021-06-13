package View.JoyStick;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXML;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Circle;

public class JoyStickController extends BorderPane {

    @FXML
    public static Circle innerCircle;
    @FXML
    public static Circle outerCircle;
    @FXML
    public static Slider throttle;
    @FXML
    public static Slider rudder;

    public static DoubleProperty aileron, elevators;

    public static Circle getInnerCircle() {
        return innerCircle;
    }

    public static Circle getOuterCircle() {
        return outerCircle;
    }

    public static Slider getThrottle() {
        return throttle;
    }

    public static Slider getRudder() {
        return rudder;
    }

    public static double getAileron() {
        return aileron.get();
    }

    public static DoubleProperty aileronProperty() {
        return aileron;
    }

    public static double getElevators() {
        return elevators.get();
    }

    public static DoubleProperty elevatorsProperty() {
        return elevators;
    }


    // Initialize each part of axis x and axis y
    private double jx, jy;
    private double Ax, Ay;

    // Constructor to the joystick
    public JoyStickController() {
        Ax = 0;
        Ay = 0;
        aileron = new SimpleDoubleProperty();
        elevators = new SimpleDoubleProperty();

        rudder = new Slider();
        throttle = new Slider();

    }




}