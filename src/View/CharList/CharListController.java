package View.CharList;


import View.fxmlController.FxmlLoader;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import View.fxmlController.MainWindowController;

import java.io.IOException;
import java.net.URL;
import java.sql.Struct;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;



public class CharListController  {


    /*
    @FXML
    ListView<Item> list;

     */





    public void initialize(){
        fetures = FXCollections.observableArrayList();
       //        registerEventHandlers();
    }


    public CharListController() {
       this.fetures =FXCollections.observableArrayList() ;
       fetures.clear();
       /*
       list=new ListView<>();
       fetures.add("hi");
       list.getItems().addAll(fetures);
       list.setOrientation(Orientation.VERTICAL);

        */

    }



    public static ObservableList<String> fetures;

    /*
    public ListView<String> getList() {
        return list;
    }

     */

    public ObservableList<String> getFetures(){
        return fetures;
    }


    /*

    public void init(){
        list=new ListView<>();
        for(int i=0;i<fetures.size();i++){
            list.getItems().add(fetures.get(i));
        }
        list.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }

     */



}




