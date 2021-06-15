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
    public ObservableList<XYChart.Data<String, Number>> service;
    public Timer time;
    public int timeSeriesRow;

    public StringProperty feturecoulme;

     //public IntegerProperty timeStep;

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
    public void loadClass(String directory) {

        URLClassLoader urlClassLoader = null;
        try {
            urlClassLoader = URLClassLoader.newInstance(new URL[] {
                    new URL("file://C:\\Users\\amitb\\IdeaProjects\\aven derech 3 part 2\\out\\artifacts\\aven_derech_3_part_2_jar")
            });
            Class<?> c=urlClassLoader.loadClass("test."+directory);

            TimeSeriesAnomalyDetector sc=(TimeSeriesAnomalyDetector) c.newInstance();
            model.SetAnomalyDetactor(sc);
            //model.SetAnomalyDetactor(sc);
        } catch (MalformedURLException e) {

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


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
        System.out.println("Hi "+playSpeed.getValue());
        this.model.playSpeed.bind(this.playSpeed);
        this.model.playSpeed.addListener((old, oldValue, newValue)->{  this.model.setPlaySpeed(Double.parseDouble(newValue.toString()));
            System.out.println("Its Liem birthday Mazal Tov!");
        });

       /* playSpeed.addListener((old, oldValue, newValue) -> {System.out.println("ggg");
            System.out.println(playSpeed.getValue());
        });*/
        /*seconds.bind(this.model.seconds);
        minutes.bind(this.model.minutes);
        hours.bind(this.model.hours);

        seconds.addListener((old, oldValue, newValue)->{
            System.out.println("The Seconds in ViewModel are " + seconds.getValue());
        });
        minutes.addListener((old, oldValue, newValue)->{
            System.out.println("The Minutes in ViewModel are " + minutes.getValue());
        });
        hours.addListener((old, oldValue, newValue)->{
            System.out.println("The Hours in ViewModel are " + hours.getValue());
        });*/

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
        /*    this.model.TimeLine = new SimpleIntegerProperty(newValue.intValue());
            this.TimeLine = new SimpleIntegerProperty(newValue.intValue());*/

            System.out.println("PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP");
            this.model.TimeLine.set(newValue.intValue());
            this.TimeLine.set(newValue.intValue());
            System.out.println("PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP");
            System.out.println(this.model.TimeLine.getValue());
            System.out.println(newValue);
            System.out.println(this.TimeLine.getValue());
            System.out.println("KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK");

        });
        this.model.TimeLine.addListener((old, oldValue, newValue) -> {
           /* this.pt.setTimeperSeconed(this.playSpeed.getValue());
            System.out.println("The vm timepersecond is: "+ this.pt.getTimeperSeconed());*/
            TimeLine = model.TimeLine;
            for (int j = 0; j < model.pr.nameColIndex.size(); j++) {
                int finalJ = j;
                if(DisplaVaribales.containsKey("altimeter_pressure-alt-ft")) {
                    Platform.runLater(() -> DisplaVaribales.get(this.pt.nameColIndex.get(finalJ)).set(ts.getTimeStep(pt.nameColIndex.get(finalJ), TimeLine).getValue()));
                /*    System.out.println(ts.getTimeStep(pt.nameColIndex.get(finalJ), TimeLine).getValue());
                    System.out.println(DisplaVaribales.get(this.pt.nameColIndex.get(finalJ)));
                    System.out.println(DisplaVaribales.get("altimeter_pressure-alt-ft").getValue());*/
                }

            }

        });



    }


    //intelizing the runnbles of the viewmodel for the player section
    public void Players(){
        Play=()->{model.play();};
        Pause=()->{model.pause();};
        Stop=()->{model.stop();};
    }


    //we need to run it in the background in the model by a therd


    /*
    //creating an chart according to the feture
    public XYChart.Series choose(String feturename){
        XYChart.Series<String,Number> series= new XYChart.Series<String,Number>();
        System.out.println(Double.parseDouble(ts.features.get(feturename).get(index)));
        System.out.println(feturename);
        ArrayList<XYChart.Series> seri = new ArrayList<>();


    }

     */

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
                            series.getData().add(new XYChart.Data<String,Number>(ts.features.get(filename).get(index),Double.parseDouble(ts.features.get(filename).get(index))));
                            service.add(series.getData().get(timeSeriesRow));
                            timeSeriesRow++;
                        }

                    });

                }

            }, 0, ((long) pt.timeperSeconed * 1000)/* pr.timespeed */); //pr.timepeed = 10000

        }
    }


}