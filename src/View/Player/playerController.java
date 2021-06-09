package View.Player;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class playerController  implements Initializable {


    public Runnable onPlay, onPause, onStop;

    @FXML
    public ImageView StartBotton;

    public void play(){
        if(onPlay!=null){
            onPlay.run();
        }
    }
    public void pause(){
        if(onPause!=null){
            onPause.run();
        }
    }
    public void stop(){
        if(onPlay!=null){
            onPlay.run();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //StartBotton.onMouseClickedProperty({()-> System.out.println("You click it right"))});
        StartBotton.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                System.out.println("You clicked the play button!!!");
            }
        });
    }
}
