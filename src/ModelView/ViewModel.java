package ModelView;

import com.sun.javafx.charts.ChartLayoutAnimator;
import javafx.animation.AnimationTimer;
import test.TimeSeries;

import Model.ModelFg;
import Model.XmlWrite;
import Model.property;
import javafx.application.Platform;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;
import test.SimpleAnomalyDetector;
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
    public IntegerProperty TimeLine = new SimpleIntegerProperty();
    public Runnable Play,Pause,Stop;
    public HashMap<String, DoubleProperty> DisplaVaribales = new HashMap<>();
    public IntegerProperty seconds;
    public HashMap<String, IntegerProperty> ClockTimerValues = new HashMap<>();
    public IntegerProperty minutes;
    public IntegerProperty hours;
    public int index;
    public AnimationTimer time;
    public int timeSeriesRow;
    public TimeSeriesAnomalyDetector tsd;
    public XYChart.Series<String,Number> series= new XYChart.Series<String,Number>();
    public XYChart.Series<String,Number> seriesseconed= new XYChart.Series<String,Number>();
    public XYChart.Series<String,Number> seriesthird= new XYChart.Series<String,Number>();
    public XYChart.Series<String,Number> seriesforth= new XYChart.Series<String,Number>();
    public XYChart.Series<String,Number> seriesfifth= new XYChart.Series<String,Number>();
    public ObservableList<XYChart.Data<String, Number>> service2;

    public SimpleAnomalyDetector feture;

    public Runnable FastRewind,Forward,FastForward,Rewind;

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
    public TimeSeriesAnomalyDetector loadClass(String directory) { // directory is the algorithm that was chosen
        TimeSeriesAnomalyDetector sc = null;
        URLClassLoader urlClassLoader = null;
        try {
            urlClassLoader = URLClassLoader.newInstance(new URL[] {
                    new URL("file://D:\\aven derech 3 part 2.jar")
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
        index=0;
        time=new AnimationTimer() {
            @Override
            public void handle(long l) {
                time=model.timer;
            }
        };
        seconds = new SimpleIntegerProperty(0);
        minutes = new SimpleIntegerProperty(0);
        hours = new SimpleIntegerProperty(0);
        playSpeed = new SimpleDoubleProperty(this.pt.timeperSeconed);
        this.model.playSpeed.bind(this.playSpeed);
        feture = new SimpleAnomalyDetector();
        service2=FXCollections.observableArrayList();

        this.model.playSpeed.addListener((old, oldValue, newValue)->{  this.model.setPlaySpeed(Double.parseDouble(newValue.toString()));
        });

        model.service1.addListener(new ListChangeListener<XYChart.Data<String, Number>>() {
            @Override
            public void onChanged(Change<? extends XYChart.Data<String, Number>> change) {

                series.getData().add(model.series.getData().get(index));
                time=model.timer;


                if(model.flag==true){
                    seriesseconed.getData().add(model.seriesseconed.getData().get(index));

                }

                if(model.flag3)
                {
                    seriesthird.getData().add(model.seriesthird.getData().get(index));

                }

                if (model.flag4)
                {
                    if (model.isOne) {
                        seriesthird.getData().add(model.seriesthird.getData().get(index));
                    }
                    if (model.isTwo) {
                        seriesforth.getData().add(model.seriesfourth.getData().get(index));
                    }
                    if (model.isThree) {
                        seriesfifth.getData().add(model.seriesfifth.getData().get(index));

                    }
                    service2.add(seriesfifth.getData().get(index));

                }

                index++;

            }
        });



        feturecoulme = new SimpleStringProperty();



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

        Rewind=()->{model.rewind();};
        FastRewind=()->{model.fastRewind();};
        Forward=()->{model.forward();};
        FastForward=()->{model.fastForward();};

    }



    //we need to run it in the background in the model by a therd

    @Override
    public void update(java.util.Observable o, Object arg) {


    }




    //timer that runs on the fetures acording to time and give the values of each coulme that has benn chose
    public void getfeture(String fetureName) {
        model.getfeture(fetureName);

    }









}