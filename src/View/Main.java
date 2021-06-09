package View;

import Model.AnomalyDetactor.TimeSeries;
import Model.ModelFg;
import ModelView.ViewModel;

import Model.XmlWrite;
import Property.property;
import View.fxmlController.Clocks;
import View.fxmlController.MainWindowController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.time.Clock;
import java.util.ArrayList;
import java.util.HashMap;


public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
       // FXMLLoader fxml1 = new FXMLLoader();
       // Parent root = (Parent)fxml1.load((getClass()).getResource("fxmlfiels/MainWindowController.fxml"));
        FXMLLoader fxml1 = new FXMLLoader((getClass()).getResource("fxmlfiels/MainWindowController.fxml"));
        Parent root = (Parent) fxml1.load();

        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("Flight Simulator");

        MainWindowController mwc=new MainWindowController();
        mwc =fxml1.getController(); //Set the Controller to the right fxml file

        ModelFg model = new ModelFg("Properties.xml"); //Set the model with the property object we created in main
        ViewModel viewModel = new ViewModel(model); // initialize the data member "model" in viewModel to be ModelFG
        mwc.init(viewModel); //initialize the data member "viewModel" in the MainWindowController
         /////////////////////////////////////////////////// added by Rotem
        mwc.viewModel.CreateTimeSeries("src/reg_file.csv");
        mwc.viewModel.ClocksAttributesArr();

        /////////////////////////////////////////////// - end
        primaryStage.show();


    }


    public static void main(String[] args) {
        TimeSeries tk = new TimeSeries("src/reg_file.csv");
        TimeSeries tm = new TimeSeries("src/anomaly_flight.csv");
        property test3 = new property();
        HashMap<String,Integer> tamp1 = new HashMap<>(); // map between feature to his index in the TimeSeries
        HashMap<String,Integer> min = new HashMap<>(); // map with min value 1 for each feature
        HashMap<String,Integer> max = new HashMap<>(); // map with max value 2 for each feature
        test3.setIp(80);
        test3.setPort(560);
        test3.setTimeperSeconed(1.5);
        for(int i=0;i<tk.fetureName.size();i++)
        {
            tamp1.put(tk.fetureName.get(i),i);
            min.put(tk.fetureName.get(i),1);
            max.put(tk.fetureName.get(i),2);

        }

        test3.setNameColIndex(tamp1);
        test3.setMaximum(max);
        test3.setMinimum(min);

   /*     Clocks myclock = new Clocks();
        myclock.altimeterList = tk.features.get("roll-deg");
        for (int i = 0; i <myclock.altimeterList.size() ; i++) {
            System.out.println(myclock.altimeterList.get(i));
        }*/

    /*
        XMLpraser XML1 =new XMLpraser();
        List<coulmename> test3 = new LinkedList<>();
        test3 = XML1.XMLpras("playback_small.xml");
        System.out.println(test3);

         */



        TimeSeries ts = new TimeSeries("src/anomaly_flight.csv");
        XmlWrite XML =new XmlWrite();
        XML.serializeToXML(test3); // Writing the property object named "test3" to an XMLFile named "Properties"
        launch(args);
    }
}