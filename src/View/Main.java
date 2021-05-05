package View;

import Controller.FxmlLoader;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("../ModelView/sample.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("../Controller/MainWindowController.fxml"));
        primaryStage.setTitle("Flight Simulator");
        primaryStage.setScene(new Scene(root, 1700, 1700));
        FxmlLoader fx =new FxmlLoader();
        fx.start(primaryStage);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
