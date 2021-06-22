package View;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class Charlist extends BorderPane {
    CharListController charListController;

    public Charlist() {
        try {
            FXMLLoader loder = new FXMLLoader();
            BorderPane charlist = loder.load(getClass().getResource("ChartsList.fxml").openStream());
            charListController = loder.getController();


            this.getChildren().add(charlist);
        } catch (IOException e) {
            e.printStackTrace();
        }

     }
}
