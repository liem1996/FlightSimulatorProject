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
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Popup;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
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
    popupcontroller popup;

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


    //constructor that create and intalize all the four part the includes int the main window controller
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



    //fubction for choosing the file itself
    public String  chooseFile(){
        FileChooser fileccsv = new FileChooser();
        File file = fileccsv.showOpenDialog(null);
        String pathtest = file.toURI().toString();
        Path p3 = Paths.get(URI.create(pathtest));
        pathtest = p3.getFileName().toString();
        return pathtest;
    }

    //function to choose specificly the csv file and intalize the player
    public void ChooseFileCsv() {

        String pathtocompare = chooseFile();
        path.setValue(pathtocompare);
        if (pathtocompare.contains("csv")) {
            viewModel.CreateTimeSeries(path.getValue().toString());
            loadData();

        } else {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("the csv is not correct or not been upload");
            a.show();
        }
        players();

    }

    //function to choose specificly the xml file for the properties
   public void ChooseFilexml() {
       String pathtocompare = chooseFile();
       path.setValue(pathtocompare);
        if (pathtocompare.contains("xml")) {
            viewModel.CreateProperty(path.getValue().toString());
        }
        else {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("the xml is not correct or not been upload");
            a.show();
        }

    }





    //loding the data of the fetures to the view itself - intlize the observable list
    public void loadData() {
         ChartList.fetures.addAll(viewModel.fetures);
         //ChartList.init();
    }



    //the function that makes all the four parts in the screen to upload on the gui itself
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


    //intalize the viewmodel
    public void init(ViewModel vm) {
        this.viewModel = vm;
        //ChartList = new CharListController();
    }


    //intelize the function from the viemodel to the view itself and run them
    public void players(){

        viewModel.Players();
        player.onPlay =viewModel.Play;
        player.onPause = viewModel.Pause;
        player.onStop = viewModel.Stop;


    }


    //load the anomaly detector from the popup that we got and put in the viewmodel
    public void ClassLoadPop(String path){
        if(path.equals("hibride") || path.equals("Zscore") || path.equals("SimpleAnomalyDetector")) {
            popup.mc.viewModel.loadClass(path);
        }else {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("the class is not correct or not been upload");
            a.show();

        }
    }


    //load the pop up to choose the class of the anomaly detector from him
    public void Classload(javafx.event.ActionEvent event) {
        try {
          Button btn = (Button) event.getSource();
           FXMLLoader loader1 = new FXMLLoader(getClass().getResource("../fxmlfiels/popupClass.fxml"));
           Parent r = loader1.load();
           popup = (popupcontroller) loader1.getController();
           Scene secene = new Scene(r);
           Stage stage = new Stage();
           popup.mc=this;
           stage.setTitle("Algorithm choosing ");
         stage.setScene(secene);
           stage.show();
       } catch (IOException e) {


        e.printStackTrace();
        }

    }



}