package View.CharList;



import View.fxmlController.MainWindowController;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.*;
import javafx.scene.control.ListView;

import javax.xml.crypto.Data;
import java.util.ArrayList;


public class CharListController  {

    public static Runnable choosingName;
    public static StringProperty feturecoulme;


    @FXML
    public ListView<String> listview;

    @FXML
    public LineChart<String,Number> linechart;

    @FXML
    public  LineChart<String,Number> linechart2;

    @FXML
    public LineChart<String, Number> linechart3;


    public XYChart.Series<String, Number> series = new XYChart.Series<>();


    public CharListController() {
        fetures = FXCollections.observableArrayList();
        listview=new ListView<>();

        //defining the axes
        final CategoryAxis xAxis = new CategoryAxis(); // we are gonna plot against time
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setAnimated(false); // axis animations are removed
        yAxis.setAnimated(false); // axis animations are removed

        //creating the line chart with two axis created above
        linechart = new LineChart<>(xAxis, yAxis);
        linechart2 = new LineChart<>(xAxis, yAxis);
        linechart3 = new LineChart<>(xAxis, yAxis);

        linechart.setAnimated(false); // disable animations

        linechart2.setAnimated(false); // disable animations

        linechart3.setAnimated(false); // disable animations


    }



    public static ObservableList<String> fetures;





    public ObservableList<String> getFetures(){
        return fetures;
    }






}