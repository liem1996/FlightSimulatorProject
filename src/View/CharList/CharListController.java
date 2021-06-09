package View.CharList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class CharListController  {

    public static ObservableList<String> fetures;

    public CharListController() {
       this.fetures =FXCollections.observableArrayList() ;
    }

    public ObservableList<String> getFetures(){
    return fetures;
    }

}
