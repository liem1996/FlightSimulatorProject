package ModelView;

import Model.AnomalyDetactor.TimeSeries;

import Model.AnomalyDetactor.TimeSeriesAnomalyDetector;
import Model.ModelFg;
import Model.ModelFg;
import Model.property;
import javafx.application.Platform;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;

public class ViewModel extends Observable implements Observer {

    public ModelFg model;
    public TimeSeries ts;
    public property pt;
    public ObservableList<String> fetures;
    public IntegerProperty timestep;
    public Runnable Play,Pause,Stop;
    public  Timer timer;
    private HashMap<String, DoubleProperty> displayVariables;
    public StringProperty sp = new SimpleStringProperty("5");


    public DoubleProperty getProperty(String name){
        return displayVariables.get(name);
    }

    public void load(){
        fetures= FXCollections.observableArrayList(ts.getFetureName());
    }

  /*  public void setTimestep(IntegerProperty timestep){
        this.timestep = 3;
    }*/

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

/*    public int getTimestep() {
        return timestep.get();
    }

    public IntegerProperty timestepProperty() {
        return timestep;
    }

    public void setTimestep(int timestep) {
        this.timestep.set(timestep);
    }*/

    public ViewModel(ModelFg model, ArrayList<String> ClocksFeaturesList) {
        sp = new SimpleStringProperty("5");
        this.model = model;
        model.addObserver(this);
        timestep = new SimpleIntegerProperty(0);
        displayVariables = new HashMap<String, DoubleProperty>();
        //read the clock features from the Arraylist
        for (int i = 0; i < ClocksFeaturesList.toArray().length; i++) {
            displayVariables.put(ClocksFeaturesList.get(i), new SimpleDoubleProperty());
            System.out.println(ClocksFeaturesList.get(i));
        }
        // get data of display variables at time step (nw)
        timestep.addListener((obs, old, nw) -> {
            //////////////////////////////////////Amit

            ///////////////////////////////////////
            for (String s : ClocksFeaturesList) { //change to read from property or ts
               Platform.runLater(() ->displayVariables.get(s).set(nw.doubleValue()));
                System.out.println("HashMap updated to current Feature "+s+" for time: "+nw.toString() );
            }
        });
        if (this.timer == null) {
            timer = new Timer();


            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    System.out.println("sending row view Model " + timestep.get());
                    sp.set("2");
                }

            }, 0, 1000);

        }

    }

 /*   public void Players(){
        Play->{model;};

    }*/

    //we need to run it in the background in the model by a therd



    @Override
    public void update(java.util.Observable o, Object arg) {


    }



    //public Properties CreateProperties(String Filename){
    //create with decoder

    //}

}