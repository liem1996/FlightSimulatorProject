package View.Player;


import View.fxmlController.FxmlLoader;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class Player extends BorderPane {

        /*
    String username = nameTextField.getText();

    FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene2.fxml"));
    root = loader.load();

    Scene2Controller scene2Controller = loader.getController();
		scene2Controller.displayName(username);

    //root = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    scene = new Scene(root);
		stage.setScene(scene);

     */

    public FxmlLoader fxl =new FxmlLoader();

    public String path;

    public Player(){
        super();

        try {
            FXMLLoader FXL = new FXMLLoader((getClass()).getResource("Player.fxml"));
            BorderPane play =FXL.load();
            playerController pc =FXL.getController();
            path =pc.ChooseFile();

           this.getChildren().add(play);
        } catch (IOException e) {
            e.printStackTrace();
        }




    }







}
