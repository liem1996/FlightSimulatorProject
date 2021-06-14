

package Controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;


public class FxmlLoader {

    AnchorPane root=new AnchorPane();


    /*
    public AnchorPane createAnchor(String Filename){
        AnchorPane root = new AnchorPane();
        try {
           root = FXMLLoader.load(getClass().getResource(Filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return root;

    }

     */
//אם יש לך רעיון לפונקציה שתוכל לקחת כל פעם שם אחר תגידי לי

    public void start(Stage primaryStage) {
        try {

            root = FXMLLoader.load(getClass().getResource("../Controller/MainWindowController.fxml"));
            AnchorPane Joystick= FXMLLoader.load(getClass().getResource("JoyStick.fxml"));
            AnchorPane Clocks = FXMLLoader.load(getClass().getResource("Clocks.fxml"));
            AnchorPane Player = FXMLLoader.load(getClass().getResource("Player.fxml"));
            AnchorPane ChartsList = FXMLLoader.load(getClass().getResource("ChartsList.fxml"));
            AnchorPane.setRightAnchor(Joystick,10.0);
            AnchorPane.setLeftAnchor(ChartsList,10.0);
            AnchorPane.setBottomAnchor(Player,65.0);

            root.getChildren().setAll(Clocks,Joystick,ChartsList,Player);
            Scene s = new Scene(root);
            primaryStage.setScene(s);

        } catch (IOException e) {
            System.err.println("Error loading EventHandlerDemo.fxml!");
            e.printStackTrace();
        }
    }



}




