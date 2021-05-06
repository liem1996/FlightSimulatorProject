package View;

import View.fxmlController.MainWindowController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        FXMLLoader fxml = new FXMLLoader((getClass()).getResource("fxmlfiels/MainWindowController.fxml"));
        Parent root = (Parent) fxml.load();

        primaryStage.setScene(new Scene(root));

        primaryStage.setTitle("Flight Simulator");
        primaryStage.show();

        MainWindowController mwc = fxml.getController();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
