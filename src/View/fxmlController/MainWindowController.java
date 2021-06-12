package View.fxmlController;

import Controller.Controller;
import ModelView.ViewModel;
import View.CharList.CharListController;
import View.Clocks.ClocksController;
import View.Joystick.JoyStickController;
import View.Player.playerController;
import javafx.application.Platform;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
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
            viewModel.model.play();
            loadData();
            //Clocks.altimeter.setText("200");


        } else if (pathtest.contains("xml")) {
            viewModel.CreateProperty(path.getValue().toString());
        } else if (pathtest != null) {
            viewModel.loadClass(path.getValue().toString());
        }

     //   players();


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
        // Clocks.altimeter.setTextFill(Color.RED);
        // roll.setText("200");
        //System.out.println("Hi");
       // altimeter.setTextFill(Color.RED);

    }



    public void init(ViewModel vm) {
        String s = "dd";
        this.viewModel = vm;
        this.viewModel.timestep.bind(this.viewModel.model.timestepProperty());

        this.timestep.bind(this.viewModel.timestep);
        this.timestep.addListener((obs, old, nw) -> System.out.println("sending row view "+ timestep.get()));
        //this.Clocks.altimeter.textProperty().bind(this.viewModel.sp); //valueproperty
          this.Clocks.altimeter.setText("5");

     /*   System.out.println("altimeter val is: "+Clocks.altimeter.textProperty().getValue());
        this.Clocks.altimeter.textProperty().bind(this.viewModel.sp); //valueproperty
        System.out.println("altimeter val is: "+Clocks.altimeter.textProperty().getValue());
        this.viewModel.sp.set("8");
        System.out.println("altimeter val is: "+Clocks.altimeter.textProperty().getValue());*/
     //   Clocks.altimeter.textProperty().addListener((observable, oldValue, newValue) -> Platform.runLater(() -> Clocks.altimeter.setText(newValue)));

     /*   StringProperty s2 = new SimpleStringProperty("5");
        this.Clocks.altimeter.textProperty().bind(s2);*/
        //this.timestep.addListener((obs, old, nw) -> this.Clocks.altimeter.setText("7"));
   /*     this.Clocks.altimeter.textProperty().bind(this.viewModel.timestep.asString());
        this.Clocks.altimeter.textProperty().addListener((obs, oldValue, newValue)->{
        *//*    switch(newValue){
                case "3":
                    this.Clocks.altimeter.setTextFill(Color.RED);
                    break;
                //Your rules
            }*//*
            System.out.println("altimeter value need to be changed ");
            //this.Clocks.altimeter.setText("80");
        });*/

       // this.timestep.addListener(System.out.println("sending row view  " + timestep.get()));

    /*    roll.textProperty().bind(vm.getProperty("roll-deg").asString());
        pitch.textProperty().bind(vm.getProperty("pitch-deg").asString());
        roll.textProperty().bind(vm.getProperty("airspeed-kt").asString());*/


        //ChartList = new CharListController();

    }

    public void players(){

       // viewModel.Players();
        player.onPlay =viewModel.Play;
        player.onPause = viewModel.Pause;
        player.onStop = viewModel.Stop;


    }





}