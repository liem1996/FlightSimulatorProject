package View.fxmlController;

import View.JoyStick.JoyStickController;
import javafx.beans.property.DoubleProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class JoyStick extends BorderPane {
    JoyStickController joyStickController ;

    DoubleProperty aileron, elevator, rudder, throttle;

    public JoyStick() {
        try {
            FXMLLoader loder = new FXMLLoader();
            BorderPane joystick = loder.load(getClass().getResource("../fxmlfiels/JoyStick.fxml").openStream());
            joyStickController = loder.getController();

            aileron=joyStickController.aileron;
            elevator=joyStickController.elevator;
            rudder=joyStickController.rudder.valueProperty();
            throttle=joyStickController.throttle.valueProperty();


            this.getChildren().add(joystick);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

