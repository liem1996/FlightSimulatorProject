package View.CharList;

import View.Player.playerController;
import View.fxmlController.FxmlLoader;
import javafx.beans.Observable;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ChartsList extends BorderPane {


   public ObservableList fetures1 = FXCollections.observableArrayList();


        public void init(){
         //   FXMLLoader FXL = new FXMLLoader();
            // BorderPane charlist =FXL.load(getClass().getResource("/View/fxmlfiels/ChartsList.fxml").openStream());
            CharListController pc =new CharListController();
            pc.fetures.addAll(fetures1);
            pc.init(fetures1);
            // this.getChildren().add(charlist);


        }

        /*
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Pane chartslistView = new FxmlLoader().getPage("ChartsList");
        ChartListPane.setCenter(chartslistView);
    }

         */






}
