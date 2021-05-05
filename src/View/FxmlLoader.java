

package View;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.URL;


public class FxmlLoader {


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

           AnchorPane root = FXMLLoader.load(getClass().getResource("MainWindowController.fxml"));
           AnchorPane Joystick= FXMLLoader.load(getClass().getResource("JoyStick.fxml"));
           AnchorPane Clocks = FXMLLoader.load(getClass().getResource("Clocks.fxml"));
           AnchorPane Player = FXMLLoader.load(getClass().getResource("Player.fxml"));
           AnchorPane ChartsList = FXMLLoader.load(getClass().getResource("ChartsList.fxml"));
            root.getChildren().setAll(Joystick,Clocks,Player,ChartsList);
            Scene s = new Scene(root);
            primaryStage.setScene(s);

        } catch (IOException e) {
            System.err.println("Error loading EventHandlerDemo.fxml!");
            e.printStackTrace();
        }
    }



}




