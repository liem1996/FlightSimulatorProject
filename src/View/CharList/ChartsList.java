package View.CharList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class ChartsList extends BorderPane {


    /*

   public ObservableList fetures1 = FXCollections.observableArrayList();
   public CharListController cp =new CharListController();



        public ChartsList(){

            super();
            FXMLLoader FXL = new FXMLLoader();
            try {
                BorderPane charlist =FXL.load(getClass().getResource("/View/fxmlfiels/ChartsList.fxml").openStream());
                cp =FXL.getController();
                this.getChildren().add(charlist);
            } catch (IOException e) {
                e.printStackTrace();
            }

            // this.getChildren().add(charlist);



        }

        public void init(){
            //cp.fetures.addAll(fetures1);
            cp.init(fetures1);
        }

        /*
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Pane chartslistView = new FxmlLoader().getPage("ChartsList");
        ChartListPane.setCenter(chartslistView);
    }

         */






}
