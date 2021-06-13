package View.CharList;



import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;


public class CharListController  {

    public static Runnable choosingName;
    public static StringProperty feturecoulme;

    public static ListView<String> listview;

    public CharListController() {
        this.listview = new ListView<>();
        this.fetures =FXCollections.observableArrayList() ;
       fetures.clear();


    }

    public ObservableList<String> getListview() {
        return listview.getItems();
    }

    public static ObservableList<String> fetures;




    public ObservableList<String> getFetures(){
        return fetures;
    }




    public void registerEventHandlers() {
        listview.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends String> ov, String old_val, String new_val) -> {
            String selectedItem = listview.getSelectionModel().getSelectedItem();
            feturecoulme.setValue(selectedItem);
        });
    }



    }










