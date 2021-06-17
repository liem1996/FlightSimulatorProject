package ModelView;

import Model.AnomalyDetactor.TimeSeries;

import Model.ModelFg;
import Model.XmlWrite;
import Model.property;
import javafx.application.Platform;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;
import test.TimeSeriesAnomalyDetector;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;

public class ViewModel extends Observable implements Observer {

    public ModelFg model;
    public TimeSeries ts;
    public property pt;
    public ObservableList<String> fetures;
    public ObservableList<String> sereis;
    public IntegerProperty TimeLine = new SimpleIntegerProperty();
    public Runnable Play,Pause,Stop;
    public HashMap<String, DoubleProperty> DisplaVaribales = new HashMap<>();
    public int index=0;
    public IntegerProperty seconds;
    public HashMap<String, IntegerProperty> ClockTimerValues = new HashMap<>();
    public IntegerProperty minutes;
    public IntegerProperty hours;
    public ObservableList<XYChart.Series<String, Number>> service;
    public ObservableList<XYChart.Series<String, Number>> service1;
    public Timer time;
    public int timeSeriesRow;
    public IntegerProperty timealgo;
    public TimeSeriesAnomalyDetector tsd;


    public StringProperty feturecoulme;

    public IntegerProperty timeStep;

    public DoubleProperty playSpeed;

    public void setPlaySpeed(double playSpeed) {
        this.playSpeed.set(playSpeed);
        this.pt.setTimeperSeconed(playSpeed);
    }



    //load the fetures of the time series
    public void load(){
        fetures = FXCollections.observableArrayList();
        fetures.addAll(ts.getFetureName());


    }

    public void CreateTimeSeriesAnomalyDetector(String filename){
        tsd=loadClass(filename);
        model.SetAnomalyDetactor(tsd);
    }


    //create the time series fron the csv we got
    public void CreateTimeSeries(String fileName){
        //create time series
        ts = new TimeSeries(fileName);
        model.SetTimeSeries(ts);
        load();


    }


    public void CreateProperty(String fileName){
        //create time series
        XmlWrite xml=new XmlWrite();
        pt=xml.deserializeFromXML(fileName);
        model.SetProperty(pt);
    }


    //loading the classes of the algorithems of the TimeAnomalyDetector
    public TimeSeriesAnomalyDetector loadClass(String directory) {
        TimeSeriesAnomalyDetector sc = null;
        URLClassLoader urlClassLoader = null;
        try {
            urlClassLoader = URLClassLoader.newInstance(new URL[] {
                    new URL("file://C:\\Users\\amitb\\IdeaProjects\\aven derech 3 part 2\\out\\artifacts\\aven_derech_3_part_2_jar")
            });
            Class<?> c=urlClassLoader.loadClass("test."+directory);

            sc=(TimeSeriesAnomalyDetector) c.newInstance();

            //model.SetAnomalyDetactor(sc);
        } catch (MalformedURLException e) {

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return sc;

    }

    // constructor - initialize the view model
    public ViewModel(ModelFg model) {
        this.model = model;
        model.addObserver(this);
        this.pt = new property();
        this.ts=new TimeSeries();
        this.pt=model.pr;
        this.timeSeriesRow = 0;
        seconds = new SimpleIntegerProperty(0);
        minutes = new SimpleIntegerProperty(0);
        hours = new SimpleIntegerProperty(0);
        playSpeed = new SimpleDoubleProperty(this.pt.timeperSeconed);
        this.model.playSpeed.bind(this.playSpeed);
        this.model.playSpeed.addListener((old, oldValue, newValue)->{  this.model.setPlaySpeed(Double.parseDouble(newValue.toString()));
        });
        service = FXCollections.observableArrayList();
        feturecoulme = new SimpleStringProperty();
        timealgo = new SimpleIntegerProperty();
        service1=FXCollections.observableArrayList();

        for(int i=0;i<pt.nameColIndex.size();i++){
            DisplaVaribales.put(pt.nameColIndex.get(i),new SimpleDoubleProperty());
        }
        ClockTimerValues.put("Seconds", new SimpleIntegerProperty());
        ClockTimerValues.put("Minutes", new SimpleIntegerProperty());
        ClockTimerValues.put("Hours", new SimpleIntegerProperty());

        this.model.seconds.addListener((old, oldValue, newValue) -> {
            this.seconds = model.seconds;
            Platform.runLater(() -> ClockTimerValues.get("Seconds").set(this.seconds.getValue()));
        });
        this.model.minutes.addListener((old, oldValue, newValue) -> {
            this.minutes = model.minutes;

            Platform.runLater(() -> ClockTimerValues.get("Minutes").set(this.minutes.getValue()));
        });
        this.model.hours.addListener((old, oldValue, newValue) -> {
            this.hours = model.hours;

            Platform.runLater(() -> ClockTimerValues.get("Hours").set(this.hours.getValue()));
        });

        // Connecting the time line to it's current value
        this.TimeLine.addListener((old, oldValue, newValue)-> {
            this.model.TimeLine.set(newValue.intValue());
            this.TimeLine.set(newValue.intValue());
        });

        // Connecting the time line to it's current value
        this.model.TimeLine.addListener((old, oldValue, newValue) -> {
            TimeLine.set(model.TimeLine.get());

            model.timeSeriesRow = model.TimeLine.getValue();
            for (int j = 0; j < model.pr.nameColIndex.size(); j++) {
                int finalJ = j;
                if(DisplaVaribales.containsKey("altimeter_pressure-alt-ft")) {
                    Platform.runLater(() -> DisplaVaribales.get(this.pt.nameColIndex.get(finalJ)).set(ts.getTimeStep(pt.nameColIndex.get(finalJ), TimeLine).getValue()));
                }

            }
            int Hours = (model.TimeLine.getValue())/3600;
            int Minutes = (model.TimeLine.getValue())/60;
            int Seconds = (model.TimeLine.getValue())%60;
            Platform.runLater(()-> {
                this.model.seconds.set(Seconds);
                this.model.minutes.set(Minutes);
                this.model.hours.set(Hours);
            });
        });

    }


    //intelizing the runnbles of the viewmodel for the player section
    public void Players(){
        Play=()->{model.play();};
        Pause=()->{model.pause();};
        Stop=()->{model.stop();};
    }


    //we need to run it in the background in the model by a therd

    @Override
    public void update(java.util.Observable o, Object arg) {


    }

    public void getfeture(String filename) {
        XYChart.Series<String,Number> series= new XYChart.Series<String,Number>();

        if (this.time == null) {
            time = new Timer();

            time.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    Platform.runLater(() -> {
                        String selectedItem = filename;
                        feturecoulme.setValue(selectedItem);
                        if(timeSeriesRow <ts.features.get(filename).size()) {
                            timealgo.set(timealgo.get() + 1);
                            series.getData().add(new XYChart.Data<String,Number>(timealgo.getValue().toString(),Double.parseDouble(ts.features.get(filename).get(timeSeriesRow))));
                            service1.add(series);
                            service.add(series);


                            //series.getData().add(new XYChart.Data<String,Number>(timealgo.getValue().toString(),Double.parseDouble(ts.features.get(filename).get(timeSeriesRow))));
                            timeSeriesRow++;
                        }



                    });

                }

            }, 0, ((long) pt.timeperSeconed * 1000)/* pr.timespeed */); //pr.timepeed = 10000

        }
    }


}