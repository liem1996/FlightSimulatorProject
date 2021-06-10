package View.fxmlController;

import ModelView.ViewModel;
import View.CharList.CharListController;
import View.Clocks.ClocksController;
import View.Joystick.JoyStickController;
import View.Player.playerController;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable {


    public ViewModel viewModel;


    CharListController ChartList;
    ClocksController Clocks;
    JoyStickController Joystick;
    playerController player;

    @FXML
    private BorderPane JoyStickPane;
    @FXML
    private BorderPane ClocksPane;

    @FXML
    private BorderPane PlayerPane;

    @FXML
    public BorderPane ChartListPane;


    @FXML
    public Button CSVbutton;

    @FXML
    public Button Xmlbutton;

    @FXML
    public Button Classopen;

    public StringProperty path;

    public IntegerProperty timestep;


    public MainWindowController() {
        path = new SimpleStringProperty();
        timestep = new SimpleIntegerProperty();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxmlfiels/ChartsList.fxml"));
        try {
            Parent r = loader.load();
            ChartList = (CharListController) loader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FXMLLoader loader1 = new FXMLLoader(getClass().getResource("../fxmlfiels/JoyStick.fxml"));
            Parent r = loader1.load();
            Joystick = (JoyStickController) loader1.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }
        FXMLLoader loader2 = new FXMLLoader(getClass().getResource("../fxmlfiels/Clocks.fxml"));
        try {
            Parent r = loader2.load();
            Clocks = (ClocksController) loader2.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }
        FXMLLoader loader3 = new FXMLLoader(getClass().getResource("../fxmlfiels/Player.fxml"));
        try {
            Parent r = loader3.load();
            player = (playerController) loader3.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void ChooseFile() {
        FileChooser fileccsv = new FileChooser();
        File file = fileccsv.showOpenDialog(null);
        String pathtest = file.toURI().toString();
        Path p3 = Paths.get(URI.create(pathtest));
        pathtest = p3.getFileName().toString();
        path.setValue(pathtest);
        if (pathtest.contains("csv")) {
            viewModel.CreateTimeSeries(path.getValue().toString());
        } else if (pathtest.contains("xml")) {
            viewModel.CreateProperty(path.getValue().toString());
        } else if (pathtest != null) {
            viewModel.loadClass(path.getValue().toString());
        }

        loadData();


    }


    public void loadData() {
         ChartList.fetures.addAll(viewModel.fetures);
//       ChartList.Listfetures.setItems(ChartList.fetures);
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       BorderPane jostickView = new FxmlLoader().getPage("JoyStick");
       JoyStickPane.setCenter(jostickView);
        BorderPane clocksView = new FxmlLoader().getPage("Clocks");
        ClocksPane.setCenter(clocksView);
        BorderPane playerView = new FxmlLoader().getPage("Player");
        PlayerPane.setCenter(playerView);
        BorderPane chartslistView = new FxmlLoader().getPage("ChartsList");
        ChartListPane.setCenter(chartslistView);
    }


    public void init(ViewModel vm) {
        this.viewModel = vm;
        this.viewModel.timestep.bind(this.viewModel.model.timestepProperty());
        this.timestep.bind(this.viewModel.timestep);
        //ChartList = new CharListController();

    }

    public void players(){

        player.onPlay =viewModel.Play;
        player.onPause = viewModel.Pause;
        player.onStop = viewModel.Stop;

    }


}