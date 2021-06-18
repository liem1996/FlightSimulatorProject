package Model;

import Model.AnomalyDetactor.TimeSeries;
import javafx.application.Platform;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import test.SimpleAnomalyDetector;
import test.TimeSeriesAnomalyDetector;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;


public class ModelFg extends Observable implements Model.runningfunc.Model {

    public TimeSeries timeSeries;
    public property pr;
    public Timer ts;
    public TimeSeriesAnomalyDetector timeSeriesAnomalyDetector;
    public int timeSeriesRow;
    public int timerow;
    public IntegerProperty seconds;
    public IntegerProperty minutes;
    public IntegerProperty hours;
    public DoubleProperty playSpeed;
    public ArrayList<String> TimeStep;
    public IntegerProperty TimeLine = new SimpleIntegerProperty();
    public XYChart.Series<String,Number> series= new XYChart.Series<String,Number>();
    public XYChart.Series<String,Number> seriesseconed= new XYChart.Series<String,Number>();
    public Timer time;
    public StringProperty feturecoulme;
    public IntegerProperty timealgo;
    public String selectedItem;
    public boolean flag;
    public ObservableList<XYChart.Data<String, Number>> service1;

    public SimpleAnomalyDetector feture;

    public void setPlaySpeed(double playSpeed) {
        this.pr.setTimeperSeconed(playSpeed);
    }


    public void setTimeLine(int timeLine) {
        this.TimeLine.set(timeLine);
    }


    public ModelFg() {
        pr=new property();
        //pr.timeperSeconed =1000;
        timeSeries=new TimeSeries();
        TimeStep=new ArrayList<>();
        timeSeriesRow =0;
        feture=new SimpleAnomalyDetector();
        seriesseconed=new XYChart.Series<>();
        series=new XYChart.Series<>();
        flag=false;
        seconds = new SimpleIntegerProperty(0);
        minutes = new SimpleIntegerProperty(0);
        hours = new SimpleIntegerProperty(0);
        playSpeed = new SimpleDoubleProperty(this.pr.timeperSeconed);

        feturecoulme = new SimpleStringProperty();

        timealgo = new SimpleIntegerProperty();

        service1 = FXCollections.observableArrayList();

    }

    public void SetProperty(property pr) {
        this.pr = pr;

    }

    @Override
    public void SetTimeSeries(TimeSeries ts) {
        this.timeSeries = ts;

    }

    @Override
    public void play() {
        if(this.ts==null){
            ts=new Timer();
            ts.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    if(timeSeriesRow < timeSeries.getNumLine()-1) {
                        TimeLine.set(TimeLine.get() + 1);


                    }
                    else{

                        pause();
                    }

                }

            },0, ((long)(pr.timeperSeconed*1000))/* pr.timespeed */); //pr.timepeed = 10000
        }
    }

    @Override
    public void pause() {
        if(ts!= null) {
            ts.cancel();
        }
        ts=null;
    }

    @Override
    public void stop() {
        if(ts!=null) {
            ts.cancel();
        }
        TimeLine.set(0);
        ts=null;
        seconds.set(0);
        minutes.set(0);
        hours.set(0);

    }




    public String getfeturecorlative(String name, test.TimeSeries ts, double treshhold){
        feture.learnNormal1(ts,0);
        String feturename = "";
        for(int i=0;i<feture.corletivfeture.size();i++){
            if(feture.corletivfeture.get(i).feature2.equals(name)){
                feturename=feture.corletivfeture.get(i).feature1;
                return feturename;

            }else if(feture.corletivfeture.get(i).feature1.equals(name)){
                feturename=feture.corletivfeture.get(i).feature2;
                return feturename;

            }

        }
        return feturename;
    }

    //timer that runs on the fetures acording to time and give the values of each coulme that has benn chose
    public void getfeture(String fetureName) {

        if(timealgo.getValue()==0){
            selectedItem = fetureName;
        }

        if(!selectedItem.equals(fetureName)){ // check id the selected item changed if so - time algo is zero
            timealgo.setValue(0);
            System.out.printf(timealgo.getValue().toString());
            series.getData().clear();
            seriesseconed.getData().clear();
            timerow=0;
            flag=false;
        }
        selectedItem = fetureName;

        //series=new XYChart.Series<>();
        //if (this.time == null) {
         time = new Timer();

        time.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> {
                    String name="";
                    feturecoulme.setValue(selectedItem);
                    if(timerow <timeSeries.features.get(fetureName).size()) {
                        timealgo.set(timealgo.get() + 1);

                        name= getfeturecorlative(fetureName, timeSeries, 0);
                        if(!name.equals("")) {
                          seriesseconed.getData().add(new XYChart.Data<String, Number>(timealgo.getValue().toString(), Double.parseDouble(timeSeries.features.get(name).get(timerow))));
                           flag=true;
                        }
                        series.getData().add(new XYChart.Data<String,Number>(timealgo.getValue().toString(),Double.parseDouble(timeSeries.features.get(fetureName).get(timerow))));
                        service1.add(series.getData().get(timerow));

                        timerow++;
                    }



                });

            }

        }, 0, ((long) pr.timeperSeconed * 1000)/* pr.timespeed */); //pr.timepeed = 10000

        // }
    }

    @Override
    public void SetAnomalyDetactor(TimeSeriesAnomalyDetector tsa) {
        timeSeriesAnomalyDetector = tsa;
    }

    @Override
    public void Start() {

    }


    @Override
    public Runnable getPainter() {
        return null;
    }

    public void rewind() {
        int rewindVal = (this.timeSeries.getNumLine()-1)/ 200;
        int fixedRow = TimeLine.get()-rewindVal; //The current row after rewind
        if(fixedRow<0){ // check if the current row is in the bounds of the Timeline of the Flight
            TimeLine.set(0); //set TimeLine to first row in csv Flight file
        }
        else {
            TimeLine.set(fixedRow);
        }
    }

    public void fastRewind() {
        int fastRewindVal = (this.timeSeries.getNumLine()-1)/ 20;
        int fixedRow = TimeLine.get()-fastRewindVal; //The current row after fastRewind
        if(fixedRow<0){ // check if the current row is in the bounds of the Timeline of the Flight
            TimeLine.set(0); //set TimeLine to first row in csv Flight file
        }
        else {
            TimeLine.set(fixedRow);
        }
    }

    public void forward() {
        int forwardVal = (this.timeSeries.getNumLine()-1)/ 200;
        int fixedRow = TimeLine.get()+forwardVal; //The current row after forward
        if(fixedRow>this.timeSeries.getNumLine()-1){ // check if the current row is in the bounds of the Timeline of the Flight
            TimeLine.set(this.timeSeries.getNumLine()-1); //set TimeLine to last row in csv Flight file
        }
        else {
            TimeLine.set(fixedRow);
        }
    }

    public void fastForward() {
        int fastForwardVal = (this.timeSeries.getNumLine()-1)/ 20;
        int fixedRow = TimeLine.get()+fastForwardVal; //The current row after fastForward
        if(fixedRow>this.timeSeries.getNumLine()-1){ // check if the current row is in the bounds of the Timeline of the Flight
            TimeLine.set(this.timeSeries.getNumLine()-1); //set TimeLine to last row in csv Flight file
        }
        else {
            TimeLine.set(fixedRow);
        }
    }


}

