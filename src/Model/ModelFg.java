package Model;

import Model.AnomalyDetactor.TimeSeries;
import test.TimeSeriesAnomalyDetector;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
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

    public void setTimeLine(int timeLine) {
        this.TimeLine.set(timeLine);
    }

    public ArrayList<String> TimeStep;
    public IntegerProperty TimeLine = new SimpleIntegerProperty();


    public ModelFg() {
        pr=new property();
        //pr.timeperSeconed =1000;
        timeSeries=new TimeSeries();
        TimeStep=new ArrayList<>();
        timeSeriesRow =0;
        seconds = new SimpleIntegerProperty(0);
        minutes = new SimpleIntegerProperty(0);
        hours = new SimpleIntegerProperty(0);
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
                    if(timeSeriesRow < timeSeries.getNumLine()) {
                        TimeLine.set(TimeLine.get() + 1);
                        System.out.println("The time in Model changed to " + TimeLine.get());
                        timeSeriesRow++;
                        incSeconds();

                    }

                   /*     try {
                            Socket fg = new Socket(pr.ip, pr.port);
                            PrintWriter ps = new PrintWriter(fg.getOutputStream());
                            for (int i = 0; i < timeSeries.getNumLine(); i++) {
                                TimeLine.set(TimeLine.get() + 1);
                                ps.println(timeSeries.getline(i));
                                ps.flush();

                            }
                            fg.close();
                            ps.close();

                        } catch (UnknownHostException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }*/
                }

            },0, ((long)pr.timeperSeconed*1000)/* pr.timespeed */); //pr.timepeed = 10000
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
    /*  public void runTimerClock(){
          if(this.ts==null){
              ts=new Timer();

              ts.scheduleAtFixedRate(new TimerTask() {
                  @Override
                  public void run() {
      }*/
    public void incSeconds(){
        if(seconds.getValue() == 59){
            incMinutes();
            seconds.set(0);
            System.out.println("The Seconds in Model are " + seconds.getValue());
        }
        else {
            seconds.set(seconds.getValue() + 1);
            System.out.println("The Seconds in Model are " + seconds.getValue());
        }
    }
    public void incMinutes(){
        if(minutes.getValue() == 59){
            incHours();
            minutes.set(0);
            System.out.println("The Minutes in Model are " + minutes.getValue());
        }
        else {
            minutes.set(minutes.getValue() + 1);
            System.out.println("The Minutes in Model are " + minutes.getValue());
        }
    }
    public void incHours(){
        if(hours.getValue() == 59){
            hours.set(0);
            System.out.println("The Hours in Model are " + hours.getValue());
        }
        else {
            hours.set(hours.getValue() + 1);
            System.out.println("The Hours in Model are " + hours.getValue());
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