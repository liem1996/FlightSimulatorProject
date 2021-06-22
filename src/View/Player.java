package View;


import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class Player extends BorderPane {
    playerController playerController ;

    public Player() {
        try {
            FXMLLoader loder = new FXMLLoader();

            BorderPane player = loder.load(getClass().getResource("Player.fxml").openStream());
            playerController = loder.getController();
            this.getChildren().add(player);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}