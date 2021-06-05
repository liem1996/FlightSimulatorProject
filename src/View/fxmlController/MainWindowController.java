package View.fxmlController;

import ModelView.ViewModel;
import View.CharList.CharListController;
import View.CharList.ChartsList;
import View.Player.Player;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;

import java.io.File;
import java.net.URI;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable {


    public ViewModel viewModel;



    @FXML
    ChartsList ChartList=new ChartsList();

    @FXML
    public ListView<String> Listfetures =new ListView<>();

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

    public StringProperty path=new SimpleStringProperty();



    public void ChooseFile() {
        FileChooser fileccsv = new FileChooser();
        File file = fileccsv.showOpenDialog(null);
        String pathtest = file.toURI().toString();
        Path p3 = Paths.get(URI.create(pathtest));
        pathtest=p3.getFileName().toString();
        path.setValue(pathtest);
        if(pathtest.contains("csv")){
            viewModel.CreateTimeSeries(path.getValue().toString());
        }else if(pathtest.contains("xml")) {
            viewModel.CreateProperty(path.getValue().toString());
        }
        else if(pathtest!=null){
            viewModel.loadClass(path.getValue().toString());
        }

        loadData();
    }




    public void loadData() {
        ChartList.fetures1.removeAll(ChartList.fetures1);
        ChartList.fetures1.addAll(viewModel.fetures);
        ChartList.init();
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
       // ChartList = new ChartsList();


    }


}