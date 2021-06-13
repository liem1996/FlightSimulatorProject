package View.fxmlController;

import View.CharList.CharListController;
import View.Joystick.JoyStickController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class JoyStick extends BorderPane {
    JoyStickController joyStickController ;

    public JoyStick() {
        try {
            FXMLLoader loder = new FXMLLoader();
            BorderPane joystick = loder.load(getClass().getResource("../fxmlfiels/JoyStick.fxml").openStream());
            joyStickController = loder.getController();
            this.getChildren().add(joystick);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

