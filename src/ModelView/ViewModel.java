package ModelView;

import Model.AnomalyDetactor.TimeSeries;

import Model.AnomalyDetactor.TimeSeriesAnomalyDetector;
import Model.ModelFg;
import Model.ModelFg;

import java.net.URL;
import java.net.URLClassLoader;
import java.util.Observable;
import java.util.Observer;

public class ViewModel extends Observable implements Observer {

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

    //we need to run it in the background in the model by a therd
    public void createAnomalyDetactor(TimeSeriesAnomalyDetector ts){
        //URLClassLoader urlClassLoader = URLClassLoader.newInstance(new URL[]{new URL("")})

    }


    @Override
    public void update(java.util.Observable o, Object arg) {


    }

    //public Properties CreateProperties(String Filename){
        //create with decoder

    //}

}
