package View.Player;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.io.File;

public class playerController {
    @FXML
    public Label TimerClock;
    @FXML
    public Label SecondsTimer;
    @FXML
    public Label MinutesTimer;
    @FXML
    public Label HoursTimer;


    public static Runnable onPlay, onPause, onStop;


    public playerController() {
        TimerClock=new Label();
        SecondsTimer = new Label();
        MinutesTimer = new Label();
        HoursTimer = new Label();
    }

    public void play() {
        if (onPlay != null)
            onPlay.run();

    }

    public void pause() {
        if (onPause != null)
            onPause.run();

    }

    public void stop() {
        if (onStop != null)
            onStop.run();

    }
}
