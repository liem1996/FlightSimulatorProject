package View;

import Model.AnomalyDetactor.TimeSeries;
import Model.ModelFg;
import ModelView.ViewModel;

import Model.XmlWrite;
import Model.property;
import View.fxmlController.MainWindowController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.util.HashMap;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        FXMLLoader fxml1 = new FXMLLoader((getClass()).getResource("fxmlfiels/MainWindowController.fxml"));
        Parent root = (Parent) fxml1.load();

        primaryStage.setScene(new Scene(root));

        primaryStage.setTitle("Flight Simulator");
        MainWindowController mwc=new MainWindowController();

        mwc =fxml1.getController();

        ModelFg model = new ModelFg();
        XmlWrite xml=new XmlWrite();
        model.pr=xml.deserializeFromXML("Properties.xml");
        ViewModel viewModel = new ViewModel(model);
        mwc.init(viewModel);
        primaryStage.show();


    }


    public static void main(String[] args) {
        TimeSeries tk = new TimeSeries("reg_flight.csv");
        TimeSeries tm = new TimeSeries("anomaly_flight.csv");
        property test3 = new property();
        HashMap<Integer,String> tamp1 = new HashMap<>();
        HashMap<String,Integer> min = new HashMap<>();
        HashMap<String,Integer> max = new HashMap<>();
        test3.setIp("127.0.0.1");
        test3.setPort(5400);
        test3.setTimeperSeconed(1.5);
        for(int i=0;i<tk.fetureName.size();i++)
        {
            tamp1.put(i,tk.fetureName.get(i));
            min.put(tk.fetureName.get(i),1);
            max.put(tk.fetureName.get(i),2);

        }

        test3.setNameColIndex(tamp1);
        test3.setMaximum(max);
        test3.setMinimum(min);

        /*
        XMLpraser XML1 =new XMLpraser();
        List<coulmename> test3 = new LinkedList<>();
        test3 = XML1.XMLpras("playback_small.xml");
        System.out.println(test3);

         */
        TimeSeries ts = new TimeSeries("anomaly_flight.csv");
        XmlWrite XML =new XmlWrite();
        XML.serializeToXML(test3);
        launch(args);
    }
}