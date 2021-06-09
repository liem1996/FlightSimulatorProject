package View.Player;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.io.File;

public class playerController {

    public static Runnable onPlay, onPause, onStop;

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
