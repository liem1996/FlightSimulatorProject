package View.fxmlController;

import ModelView.ViewModel;
import View.CharList.ChartsList;
import View.JoyStick.JoyStickController;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable{



    // את כל ההגדרה של המיין ווינדואו קונטרולר אני צריכה לעשות אידי לכל סליידר ולהגדיר אותו
    // להגידר אותו בג'וייסטיק קונטרולר עצמו

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
    public JoyStickController JoyStick;

    @FXML
    public Button CSVbutton;

    public StringProperty path;
    public IntegerProperty timestep;


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
        path=new SimpleStringProperty();
        timestep=new SimpleIntegerProperty();
    }


/*
    public void setViewModel(ViewModel viewModel) {
// לכרוך לטיים סטפ לשורה מסויימת
      //  joyStickController

        // connect the view model by using view model object and joystick controller object using binding
        JoyStick.aileron.bind(viewModel.ts.getTimeStep(viewModel.pt.nameColIndex.get(JoyStick.aileron.toString()),timestep));
        JoyStick.elevators.bind(viewModel.ts.getTimeStep(viewModel.pt.nameColIndex.get(JoyStick.elevators.toString()),timestep));
        JoyStick.aileron.bind(viewModel.ts.getTimeStep(viewModel.pt.nameColIndex.get(JoyStick.aileron.toString()),timestep));


    }
*/







}