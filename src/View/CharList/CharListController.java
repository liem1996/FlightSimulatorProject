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


    public XYChart.Series<String, Number> series = new XYChart.Series<>();




    public CharListController() {
        fetures = FXCollections.observableArrayList();
        listview=new ListView<>();


    }



    public ObservableList<String> getListview() {
        return listview.getItems();
    }

    public static ObservableList<String> fetures;





    public ObservableList<String> getFetures(){
        return fetures;
    }






}