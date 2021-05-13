package ModelView;

import Model.*;
import javafx.beans.property.DoubleProperty;

import java.util.Observable;
import java.util.Observer;

public class ViewModel {

    Model model;

    public DoubleProperty aileron, throttle, rudder, elevator;

    public ViewModel(Model model){

    }
}
