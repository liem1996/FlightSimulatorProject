package ModelView;

import Model.AnomalyDetactor.TimeSeries;

import Model.AnomalyDetactor.TimeSeriesAnomalyDetector;
import Model.ModelFg;
import Model.ModelFg;
import Model.property;
import javafx.beans.property.IntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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
    public ObservableList<String> fetures;
    public IntegerProperty timestep;
    public Runnable Play,Pause,Stop;

    public void load(){
        fetures= FXCollections.observableArrayList(ts.getFetureName());
    }


    public void CreateTimeSeries(String fileName){
        //create time series
        ts = new TimeSeries(fileName);
        model.SetTimeSeries(ts);
        load();

    }
    public void CreateProperty(String fileName){
        //create time series
        model.SetProperty(fileName);
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

    public void Players(){


    }

    //we need to run it in the background in the model by a therd



    @Override
    public void update(java.util.Observable o, Object arg) {


    }



    //public Properties CreateProperties(String Filename){
    //create with decoder

    //}

}