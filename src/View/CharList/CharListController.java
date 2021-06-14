package View.CharList;



import View.fxmlController.MainWindowController;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.ListView;

import java.util.ArrayList;


public class CharListController  {

    public static Runnable choosingName;
    public static StringProperty feturecoulme;

    @FXML
    public ListView<String> listview;

    @FXML
    public LineChart<Number,Number> linechart;





    public CharListController() {
        fetures = FXCollections.observableArrayList();
        listview=new ListView<>();
        registerEventHandlers();
    }

    public ObservableList<String> getListview() {
        return listview.getItems();
    }

    public static ObservableList<String> fetures;




    public ObservableList<String> getFetures(){
        return fetures;
    }



    @FXML
    public void registerEventHandlers() {
        // mc.ChoosingOption(listview.getSelectionModel().getSelectedItem());
        System.out.println();
    }


    public void Paint(){
        NumberAxis xAxis = new NumberAxis(0,5,1);
        xAxis.setLabel("run");
        NumberAxis yAxis  =new NumberAxis(0,500,100);
        yAxis.setLabel("hi");
        linechart = new LineChart<Number,Number>(xAxis,yAxis);
    }



}