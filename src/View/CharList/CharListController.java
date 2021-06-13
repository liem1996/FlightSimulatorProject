package View.CharList;



import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.input.*;


public class CharListController  {

    public static Runnable choosingName;

    @FXML
    public  static ListView<String> list = new ListView<>();


    public void initialize(){
        fetures = FXCollections.observableArrayList();
        //        registerEventHandlers();

    }


    public CharListController() {
        this.list = new ListView<>();
        this.fetures =FXCollections.observableArrayList() ;
        fetures.clear();


    }



    public static ObservableList<String> fetures;


    public ObservableList<String> getFetures(){
        return fetures;
    }



}