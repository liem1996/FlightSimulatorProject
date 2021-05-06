package View.fxmlController;

import Model.AnomalyDetactor.TimeSeries;
import ModelView.ViewModel;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.File;

public class Player {
        //DOING A FUNCTION FOR THE OPEN CSV
        //doing a function to the open xml file

    Button CSVbutton =new Button();

    public ViewModel viewModel;

    public void MouseTouchCsvFile(Stage primaryStage){
        //להסתכל לראות איך אלי שם את הפונקציה הזו

        FileChooser fileccsv = new FileChooser();
        fileccsv.setTitle("csv Files for the application ");
        CSVbutton.addActionListener(e->{
            File selectedFile =fileccsv.showOpenDialog(primaryStage);
            fileccsv.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("csv Files", "*.csv")
           );
            //File csvfilechoose = fileccsv.

        });


    }
}
