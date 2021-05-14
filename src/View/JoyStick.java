package View;

import ModelView.ViewModel;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Circle;

import java.awt.event.MouseEvent;

public class JoyStick extends BorderPane {

    public DoubleProperty aileron, elevators, rudder, throttle;

    public JoyStick(){
        super();
        try{
            FXMLLoader fxl = new FXMLLoader();
            BorderPane joy = fxl.load(getClass().getResource("JoyStick.fxml").openStream());

            JoyStickController JoyStickController = fxl.getController();

            aileron = JoyStickController.aileron;
            elevators = JoyStickController.elevators;
            rudder = JoyStickController.rudder.valueProperty();
            throttle = JoyStickController.throttle.valueProperty();

            this.getChildren().add(joy);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

/*
    @FXML
    Circle innerCircle, outerCircle;
    @FXML
    Slider Rudder, Throttle;

    DoubleProperty aileron, elevator;

    // Constructor in order to connect between the FXML's id's to the other functions in VM
    public void Joystick(Circle innerCircle, Circle outerCircle, Slider rudder, Slider throttle) {
        this.innerCircle = innerCircle;
        this.outerCircle = outerCircle;
        this.Rudder = rudder;
        this.Throttle = throttle;

        this.aileron = new SimpleDoubleProperty(); // Creating aileron
        this.elevator = new SimpleDoubleProperty(); // Creating elevator

    }
*/
//------------------------------------------------------------------------//



}
