package View.Player;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.io.File;

public class playerController {


    @FXML
    public Button CSVbutton;

    public String path;



    public void ChooseFile() {
        FileChooser fileccsv = new FileChooser();
        File file = fileccsv.showOpenDialog(null);
        path = file.toURI().toString();
        System.out.println("i did it");


    }






}
