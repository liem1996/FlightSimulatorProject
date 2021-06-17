package View.Joystick;

import javafx.scene.paint.Color;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;

public class JoyStickController extends BorderPane {

    @FXML
    public Canvas joystick0;
    @FXML
    public  Slider throttle;
    @FXML
    public  Slider rudder;

    public  DoubleProperty aileron, elevator;
    private DoubleProperty Ax, Ay;

    // Constructor to the joystick
    public JoyStickController() {
        // Initialize each part of axis x and axis y

        // joystick = new Canvas();
        aileron= new SimpleDoubleProperty();
        elevator= new SimpleDoubleProperty();
        rudder= new Slider();
        throttle= new Slider();
    }


    public void paint() {
        // by using addListener function the screen gets update and move by axis x and axis y
       // System.out.println("yossi");

        GraphicsContext gc = joystick0.getGraphicsContext2D();

        gc.clearRect(0,0, joystick0.getWidth(), joystick0.getHeight());

        gc.fillOval((aileron.doubleValue()*150)  +83, (elevator.doubleValue()*150)+62, 50, 50);

        gc.setStroke(Color.BLACK);

    }




}