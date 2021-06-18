package Model;

import Model.AnomalyDetactor.TimeSeries;
import javafx.application.Platform;
import javafx.beans.property.*;
import javafx.collections.ObservableList;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
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
    public IntegerProperty seconds;
    public IntegerProperty minutes;
    public IntegerProperty hours;
    public DoubleProperty playSpeed;
    public ArrayList<String> TimeStep;
    public IntegerProperty TimeLine = new SimpleIntegerProperty();

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
        seconds = new SimpleIntegerProperty(0);
        minutes = new SimpleIntegerProperty(0);
        hours = new SimpleIntegerProperty(0);
        playSpeed = new SimpleDoubleProperty(this.pr.timeperSeconed);

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
                        System.out.println("The timeSeriesRow in Model changed to " + timeSeriesRow);
                    }
                    else{
                        System.out.println("You pause me!");
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



}