package View.fxmlController;

import View.Joystick.JoyStickController;
import View.Player.playerController;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class Player extends BorderPane {
    View.Player.playerController playerController ;

    public Player() {
        try {
            FXMLLoader loder = new FXMLLoader();
            BorderPane player = loder.load(getClass().getResource("../fxmlfiels/Player.fxml").openStream());
            playerController = loder.getController();
            this.getChildren().add(player);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}