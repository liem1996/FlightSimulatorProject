package View.CharList;

import View.fxmlController.FxmlLoader;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.sql.Struct;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;



public class CharListController{


    @FXML
    public ListView<String> Listfetures =new ListView<>();

    public ObservableList fetures=FXCollections.observableArrayList();


    public void init(ObservableList ob){
        fetures.clear();
        fetures.addAll(ob);

        /*
      fetures.addListener(new ListChangeListener() {
           @Override
           public void onChanged(Change change) {

               Listfetures.setItems(null);
                Listfetures.setItems(fetures);
           }
       });

         */
        Listfetures.setItems(fetures);


    }



}
