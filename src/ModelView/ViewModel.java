package ModelView;

import Model.AnomalyDetactor.TimeSeries;

import Model.AnomalyDetactor.TimeSeriesAnomalyDetector;
import Model.ModelFg;
import Model.ModelFg;
import Model.property;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Observable;
import java.util.Observer;
import java.util.Properties;

public class ViewModel extends Observable implements Observer {

    public ModelFg model;
    public TimeSeries ts;
    public property pt;


    public void CreateTimeSeries(String fileName){
        //create time series
        ts = new TimeSeries(fileName);
        model.SetTimeSeries(ts);

    }
    public void CreateProperty(String fileName){
        //create time series
       pt= model.insertProperty(fileName);
    }


    public void loadClass(String directory) {
        try {
            URLClassLoader urlClassLoader = URLClassLoader.newInstance(new URL[]{new URL("")});


        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }

    public ViewModel(ModelFg model) {
        this.model = model;
        model.addObserver(this);

    }

    //we need to run it in the background in the model by a therd



    @Override
    public void update(java.util.Observable o, Object arg) {


    }

    //public Properties CreateProperties(String Filename){
    //create with decoder

    //}

}