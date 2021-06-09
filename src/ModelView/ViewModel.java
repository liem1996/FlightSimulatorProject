package ModelView;

import Model.AnomalyDetactor.TimeSeries;

import Model.AnomalyDetactor.TimeSeriesAnomalyDetector;
import Model.ModelFg;
import Model.ModelFg;
import View.fxmlController.Clocks;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.control.Label;

import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class ViewModel extends Observable implements Observer {

    public ModelFg model;
    public TimeSeries ts;
    //IntegerProperty num;
    public ArrayList<String> altimeterList;
    public ArrayList<String> directionList;
    public ArrayList<String> airspeedList;
    public ArrayList<String> pitchList;
    public ArrayList<String> rollList;
    public ArrayList<String> yawList;

    public void CreateTimeSeries(String fileName){
        //create time series
        ts = new TimeSeries(fileName);
        model.SetTimeSeries(ts);

    }
    public void ClocksAttributesArr() { //Create the ClockFeatures arrays for Clock Controller
        rollList = this.ts.features.get("roll-deg");
        pitchList = this.ts.features.get("pitch-deg");
        airspeedList = this.ts.features.get("airspeed-kt");

    }


    public ViewModel(ModelFg model) {
        this.model = model;
        model.addObserver(this);
        altimeterList = new ArrayList<>();
        directionList = new ArrayList<>();
        airspeedList = new ArrayList<>();
        pitchList = new ArrayList<>();
        rollList = new ArrayList<>();
        yawList = new ArrayList<>();

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
