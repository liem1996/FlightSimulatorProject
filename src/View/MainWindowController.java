package View;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable {

    @FXML
    private BorderPane joystickPane;
    @FXML
    private BorderPane clocksPane;
    @FXML
    private BorderPane playerPane;
    @FXML
    private BorderPane chartslistPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Pane jostickView = new FxmlLoader().getPage("JoyStick");
        joystickPane.setCenter(jostickView);

        Pane clocksView = new FxmlLoader().getPage("Clocks");
        clocksPane.setCenter(clocksView);

        Pane playerView = new FxmlLoader().getPage("Player");
        playerPane.setCenter(playerView);

        Pane chartslistView = new FxmlLoader().getPage("ChartsList");
        chartslistPane.setCenter(chartslistView);

    }
}