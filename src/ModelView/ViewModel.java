package ModelView;

import Model.AnomalyDetactor.TimeSeries;

import Model.ModelFg;
import javafx.beans.property.DoubleProperty;

import java.util.Observable;
        import java.util.Observer;

public class ViewModel extends Observable implements Observer {

    public DoubleProperty aileron;
    public DoubleProperty elevator;
    public DoubleProperty throttle;
    public DoubleProperty rudder;

    public ModelFg model;
    public TimeSeries ts;

    public void CreateTimeSeries(String fileName){
        //create time series
        ts = new TimeSeries(fileName);
        model.SetTimeSeries(ts);

    }

    public ViewModel(ModelFg model) {
        this.model = model;
        model.addObserver(this);


    }


    @Override
    public void update(java.util.Observable o, Object arg) {


    }

    //public Properties CreateProperties(String Filename){
    //create with decoder

    //}




}