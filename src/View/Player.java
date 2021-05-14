package View;

import View.JoyStick;
import View.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class Player extends BorderPane {

    public FxmlLoader fxl =new FxmlLoader();

    public String path;

    public Player(){
        super();

        try {
            FXMLLoader FXL = new FXMLLoader();
            BorderPane play =FXL.load(getClass().getResource("Player.fxml").openStream());
            playerController pc =FXL.getController();

            this.getChildren().add(play);
        } catch (IOException e) {
            e.printStackTrace();
        }




    }







}