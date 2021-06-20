package View.JoyStick;

import javafx.scene.paint.*;
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

    // Constructor to the joystick
    public JoyStickController() {
        // Initialize each part of axis x and axis y

        aileron= new SimpleDoubleProperty();
            elevator= new SimpleDoubleProperty();
            rudder= new Slider();
            throttle= new Slider();
        }


    public void paint() {
        // by using addListener function the screen gets update and move by axis x and axis y
        GraphicsContext gc = joystick0.getGraphicsContext2D();

        gc.clearRect(0,0, joystick0.getWidth(), joystick0.getHeight());

        gc.strokeOval(20, 25, 160, 160);


        //Setting the linear gradient
        LinearGradient cycleGrad = new LinearGradient(50, // start X
                50, // start Y
                70, // end X
                70, // end Y
                false, // proportional
                CycleMethod.REFLECT, // cycleMethod
                new Stop(0f, Color.rgb(227, 35, 108, .784)), new Stop(1.0f, Color.rgb(132,
                55, 83, .784)));

        gc.setFill(cycleGrad);

        gc.fillOval((aileron.doubleValue()*50)  +75, (elevator.doubleValue()*50)+78, 50, 50);

    }

}
