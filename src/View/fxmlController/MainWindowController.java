package View.fxmlController;

import ModelView.ViewModel;
import View.CharList.ChartsList;
import View.Player.Player;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class MainWindowController  implements Initializable{


    public ViewModel viewModel;

    @FXML
    Player Player;

    @FXML
    ChartsList ChartList;

    @FXML
    private BorderPane JoyStickPane;
    @FXML
    private BorderPane ClocksPane;
    @FXML
    private BorderPane PlayerPane;
    @FXML
    private BorderPane ChartListPane;






    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Pane jostickView = new FxmlLoader().getPage("JoyStick");
        JoyStickPane.setCenter(jostickView);
        Pane clocksView = new FxmlLoader().getPage("Clocks");
        ClocksPane.setCenter(clocksView);
        Pane playerView = new FxmlLoader().getPage("Player");
        PlayerPane.setCenter(playerView);
        Pane chartslistView = new FxmlLoader().getPage("ChartsList");
        ChartListPane.setCenter(chartslistView);

    }


    public void init(ViewModel vm ){
        this.viewModel=vm;
        Player =new Player();
        viewModel.CreateTimeSeries(Player.path);

        System.out.println("yess");


    }


}