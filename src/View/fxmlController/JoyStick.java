package View.fxmlController;

import View.CharList.CharListController;
import View.Joystick.JoyStickController;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Circle;

import java.io.IOException;

public class JoyStick extends BorderPane {
    JoyStickController joyStickController ;

    public JoyStick() {
        try {
            FXMLLoader loder = new FXMLLoader();
            BorderPane joystick = loder.load(getClass().getResource("../fxmlfiels/JoyStick.fxml").openStream());
            joyStickController = loder.getController();
            joyStickController.aileron=new SimpleDoubleProperty();
            joyStickController.outerCircle=new Circle();
            joyStickController.elevator=new SimpleDoubleProperty();
            joyStickController.rudder=new Slider();
            joyStickController.throttle=new Slider();
            joyStickController.innerCircle=new Circle();
            this.getChildren().add(joystick);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}