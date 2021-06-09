package View.fxmlController;

import ModelView.ViewModel;
import View.CharList.ChartsList;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.Clock;
import java.util.ResourceBundle;

public class MainWindowController  implements Initializable{


    public ViewModel viewModel;

   /* @FXML
    Clocks clock;*/

    @FXML
    ChartsList ChartList;

    @FXML
    private BorderPane JoyStickPane;
    @FXML
    private BorderPane ClocksPane;

    @FXML
    Clocks Controller;

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
   /*     Controller = new Clocks();
        Controller.Clockrun = ()-> System.out.println("I did it!");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Clocks.fxml"));
        Clocks ctrl = loader.getController();
        ctrl.Clockrun = ()-> System.out.println("I did it!");
        Pane clocksView =loader.getController();*/
      /*  try {
            FXMLLoader fx1 = new FXMLLoader();
            BorderPane root = fx1.load(getClass().getResource("Clocks.fxml").openStream());
            Controller = fx1.getController();
            Controller.Clockrun = ()-> System.out.println("I did it");

        } catch (IOException e) {
            e.printStackTrace();
        }*/


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
    /*    clock = new Clocs();
        clock.altimeterList.add("4.0");
        System.out.println(clock.altimeterList.get(0));*/

        //  ClocksPane.


    }


}