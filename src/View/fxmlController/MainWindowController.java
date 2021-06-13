package View.fxmlController;

import ModelView.ViewModel;
import javafx.beans.property.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import javafx.stage.FileChooser;
import javafx.stage.Stage;


import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MainWindowController  {

    public ViewModel viewModel;

    @FXML
    Charlist ChartList;
    @FXML
    Clocks Clocks;
    @FXML
    JoyStick Joystick;
    @FXML
    Player player;
    popupcontroller popup;

    public StringProperty path;

    public IntegerProperty timestep;

    public StringProperty feturecoulme;



    //constructor that create and intalize all the four part the includes int the main window controller
    public MainWindowController() {
        path = new SimpleStringProperty();

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

//initialize the view model
    public void init(ViewModel vm) {
        this.viewModel = vm;


        Joystickbind();

    }

    //load the pop up to choose the class of the anomaly detector from him

    public void loadData() {
        ChartList.charListController.getFetures().setAll(viewModel.fetures);
        ChartList.charListController.listview.setItems( ChartList.charListController.getFetures());
    }




    //interline the function from the view model to the view itself and run them
    public void players(){
        viewModel.Players();
        player.playerController.onPlay =viewModel.Play;
        player.playerController.onPause = viewModel.Pause;
        player.playerController.onStop = viewModel.Stop;
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

    // Setting the time series by binding from the view to model view
    public void Joystickbind()
    {
        /*
        // connect the view model by using view model object and joystick controller object using binding
        Joystick.joyStickController.aileron.bind(viewModel.ts.getTimeStep(viewModel.pt.nameColIndex.get("aileron") , viewModel.TimeLine));
        Joystick.joyStickController.elevators.bind(viewModel.ts.getTimeStep(viewModel.pt.nameColIndex.get("elevator") , viewModel.TimeLine));
        Joystick.joyStickController.rudder.valueProperty().bind(viewModel.ts.getTimeStep(viewModel.pt.nameColIndex.get("rudder") , viewModel.TimeLine));
        Joystick.joyStickController.throttle.valueProperty().bind(viewModel.ts.getTimeStep(viewModel.pt.nameColIndex.get("throttle") , viewModel.TimeLine));

         */


        // binding to Circles ------

    }



    //choosing an option fron the fetures list
    public void ChoosingOption(){

    }



}