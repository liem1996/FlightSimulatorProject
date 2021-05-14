package View;

import ModelView.ViewModel;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable{

    ViewModel viewModel;
    JoyStickController joyStickController;

    @FXML
    Player Player;
    @FXML
    private BorderPane joystickPane;
    @FXML
    private BorderPane clocksPane;
    @FXML
    private BorderPane playerPane;
    @FXML
    private BorderPane chartslistPane;


    @FXML
    JoyStick joystick;
    @FXML
    Slider rudderSlider;
    @FXML
    Slider throttleSlider;


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

    public void init(ViewModel vm ){
        this.viewModel=vm;
        Player =new Player();
        viewModel.CreateTimeSeries(Player.path);

        System.out.println("yess");

        vm.rudder.bind(this.rudderSlider.valueProperty());
        vm.throttle.bind(this.throttleSlider.valueProperty());

        vm.aileron.bind(joystick.aileron);
        vm.elevator.bind(joystick.elevators);

    }


    public void paint() {
        GraphicsContext gc;

    }


}