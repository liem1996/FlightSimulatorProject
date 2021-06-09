package View.JoyStick;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;


public class JoyStickController extends BorderPane {

    @FXML
    Canvas canvasOnBorder;
    @FXML
    BorderPane JoyStick;
    @FXML
    Slider throttle;
    @FXML
    Slider rudder;

    public DoubleProperty aileron,  elevators;

    private double jx, jy;
    private double mx, my;

    public JoyStickController(){
        jx = 0;
        jy = 0;
        aileron = new SimpleDoubleProperty();
        elevators = new SimpleDoubleProperty();
    }
/*
    void paint() {
        GraphicsContext canvasOnBorder = JoyStick.getGraphicsContext2D();
        mx = JoyStick.getWidth() /2;
        my = JoyStick.getHeight()/2;
        canvasOnBorder.clearRect(0,0, JoyStick.getWidth(), JoyStick.getHeight());
        canvasOnBorder.strokeOval(jx-50, jy-50, 100, 100);
        aileron.set(((jx-mx)/my));
        elevators.set((my-jy)/my);
    }
    */


}
