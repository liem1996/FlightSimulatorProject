package View.JoyStick;

import javafx.beans.property.DoubleProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

public class JoyStick extends BorderPane{


    public DoubleProperty aileron, elevators, rudder, throttle;

    public JoyStick() {
        super();
        try {
            FXMLLoader fxl = new FXMLLoader();
            BorderPane joy = fxl.load(getClass().getResource("JoyStick.fxml").openStream());

            JoyStickController JoyStickController = fxl.getController();
/*
            aileron = JoyStickController.aileron;
            elevators = JoyStickController.elevators;
            rudder = JoyStickController.rudder.valueProperty();
            throttle = JoyStickController.throttle.valueProperty();
            */

            this.getChildren().add(joy);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
