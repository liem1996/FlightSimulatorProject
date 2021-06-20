package View.fxmlController;


import View.Clocks.ClocksController;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class Clocks extends BorderPane {
    ClocksController clocksController;

    public Clocks() {

        try {
            FXMLLoader loder = new FXMLLoader();
            BorderPane clocks = loder.load(getClass().getResource("../fxmlfiels/Clocks.fxml").openStream());
            clocksController = loder.getController();
            this.getChildren().add(clocks);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

