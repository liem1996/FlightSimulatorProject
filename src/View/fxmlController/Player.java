package View.fxmlController;

import ModelView.ViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.FileChooser;
import javafx.scene.control.Button;

import java.io.File;

public class Player  {
        //DOING A FUNCTION FOR THE OPEN CSV
        //doing a function to the open xml file

    @FXML
    public Button CSVbutton;
    public ViewModel viewModel;
    public String path;


    void init(ViewModel vm){
        this.viewModel=vm;

    }


    @FXML
    public void ChooseFile(ActionEvent event) {
        FileChooser fileccsv = new FileChooser();
        File file = fileccsv.showOpenDialog(null);
        path = file.toURI().toString();
        if(path!=null) {

            viewModel.CreateTimeSeries(path);
        }
        System.out.println("i did it");

    }



}



