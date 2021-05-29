package View.fxmlController;

import ModelView.ViewModel;
import View.CharList.ChartsList;
import View.Player.Player;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;

import java.io.File;
import java.net.URL;
import java.nio.file.Path;
import java.util.ResourceBundle;

public class MainWindowController  implements Initializable{


    public ViewModel viewModel;



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

    @FXML
    public Button CSVbutton;

    public StringProperty path;



    public void ChooseFile() {
        FileChooser fileccsv = new FileChooser();
        File file = fileccsv.showOpenDialog(null);
        String pathtest = file.toURI().toString();
        path.setValue(pathtest);
        viewModel.CreateTimeSeries(path.toString());
        System.out.println("yess");
        System.out.println("i did it");
    }






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



    }


}