package View.CharList;

import View.fxmlController.FxmlLoader;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
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


    public CharListController() {
       this.fetures =FXCollections.observableArrayList() ;
    }

    public static ObservableList<String> fetures;

    //private final ObservableList<String> fetures2=FXCollections.observableArrayList() ;

    public ObservableList<String> getFetures(){
    return fetures;
    }

}
