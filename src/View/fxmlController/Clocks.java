package View.fxmlController;

import Model.AnomalyDetactor.TimeSeries;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Timer;

public class Clocks implements Initializable {
    public ArrayList<String> altimeterList = new ArrayList<>();
    public ArrayList<String> directionList;//= new ArrayList<>();
    public ArrayList<String> airspeedList;// = new ArrayList<>();
    public ArrayList<String> pitchList;// = new ArrayList<>();
    public ArrayList<String> rollList;// = new ArrayList<>();
    public ArrayList<String> yawList;// = new ArrayList<>();
    Timer t = null;
    IntegerProperty num = new SimpleIntegerProperty(2);
    IntegerProperty num2 = new SimpleIntegerProperty();
    Runnable Clockrun;

    @FXML
    public Label altimeterValue;
    @FXML
    public Label directionValue;
    @FXML
    public Label airspeedValue;
    @FXML
    public Label pitchValue;
    @FXML
    public Label rollValue;
    @FXML
    public Label yawValue;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        System.out.println("This is the fucking clocks power!");

        System.out.println("The roll is 10 now");
        rollValue.setText("10");

        System.out.println("And noww the color of the pitch value will be red");
        pitchValue.setTextFill(Color.RED);

        if(Clockrun!= null){
            Clockrun.run();
        }
       // System.out.println(altimeterList.get(0));

   /*     num2.bind(num);

        TimeSeries tk = new TimeSeries("src/reg_file.csv");
        rollList = tk.features.get("roll-deg");
        pitchList = tk.features.get("pitch-deg");
        airspeedList = tk.features.get("airspeed-kt");
      *//*  altimeterList = tk.features.get("roll-deg");
        altimeterList = tk.features.get("roll-deg");
        altimeterList = tk.features.get("roll-deg");*//*
        System.out.println("");
        System.out.println("");
        System.out.println("roll values: ");
        PrintArr(rollList, rollValue);
        System.out.println("pitch values: ");
        PrintArr(pitchList, pitchValue);
        System.out.println("airspeed values: ");
        PrintArr(airspeedList, airspeedValue);

 *//*       for (int i = 0; i <altimeterList.size() ; i++) {
            System.out.println(altimeterList.get(i));
        }
        if(altimeterList == null){
            System.out.println("Altimeter list in empty!!");
        }*//*
         *//*  for ( String s  :  altimeterList) {
            System.out.println(s);
        }*//*
    }

    private void PrintArr(ArrayList<String> List, Label Valuename) {
        for (int i = 0; i < List.size() ; i++) {
            if(i%100 == 3) {
                System.out.println(List.get(i));
                Valuename.setText(List.get(i));
                Valuename.setText(List.get(i));

            }
        }
        System.out.println("");
        System.out.println("");
        */
    }
}
