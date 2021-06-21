package View.Player;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TextField;
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
    @FXML
    public TextField PlaySpeed;
    @FXML
    public ScrollBar ScrollFlight;


    public static Runnable onPlay, onPause, onStop, onRewind, onFastRewind, onForward, onFastForward;


    public playerController() {
        TimerClock=new Label();
        SecondsTimer = new Label();
        MinutesTimer = new Label();
        HoursTimer = new Label();
        PlaySpeed = new TextField();
        ScrollFlight = new ScrollBar();
    }
    public void rewind() {
        if (onRewind != null)
            onRewind.run();

    }
    public void fastRewind() {
        if (onFastRewind != null)
            onFastRewind.run();

    }
    public void forward() {
        if (onForward != null)
            onForward.run();

    }
    public void fastForward() {
        if (onFastForward != null)
            onFastForward.run();

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