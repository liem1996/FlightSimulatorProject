package View.Clocks;

import View.fxmlController.MainWindowController;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

public class ClocksController {
    @FXML
    public static Label altimeter;



    public String getAltimeter() {
        return altimeter.getText();
    }

    public ClocksController() {

        this.altimeter=new Label("MY LABEL");
      ;

    /*
        this.altimeter.textProperty().bind(temp);
        this.temp = new SimpleStringProperty();
        temp.set("12");
        this.fetures =FXCollections.observableArrayList() ;
*/

    }




/*    public void ChangeVal() {
        if (this.timer == null) {
            timer = new Timer();


            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    System.out.println("Liem Kaki" + timestep);
                    //altimeter.setText((String)timestep.asString());
                    altimeter.setText(timestep.toString());
                    timestep++;

                    //System.out.println("Liem Kaki " + timestep);
                    //  altimeter.setText(Integer.toString(timestep));
                }

            }, 0, 1000);

        }*/
      //  altimeter.setTextFill(Color.GREEN);

    //}
}
