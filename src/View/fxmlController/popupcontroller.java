package View.fxmlController;

import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;

public class popupcontroller extends BorderPane {

    public MainWindowController mc;

    public popupcontroller() {
        //this.mc = new MainWindowController();
    }

    @FXML
    public Button zscore;

    @FXML
    public Button simple;

    @FXML
    public Button hybride;


    public void Classloadpop(javafx.event.ActionEvent event) {
        Button sourceButton = (Button) event.getSource();


        String name = sourceButton.getText();
        System.out.println(name);

        if(name.equals("SimpleAnomalyDetector")){
            mc.ClassLoadPop(name);

        }

        else if(name.equals("hibride")){
            mc.ClassLoadPop(name);

        }else if(name.equals("Zscore")){
            mc.ClassLoadPop(name);
        }


    }
}