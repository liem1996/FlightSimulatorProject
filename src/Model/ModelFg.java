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

    public void setTimeLine(int timeLine) {
        this.TimeLine.set(timeLine);
    }

    public ArrayList<String> TimeStep;
    public IntegerProperty TimeLine = new SimpleIntegerProperty();


    public ModelFg() {
        pr=new property();
        timeSeries=new TimeSeries();
        TimeStep=new ArrayList<>();
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
                    for (int j = 0; j < timeSeries.getNumLine(); j++) {

                        TimeLine.set(TimeLine.get() + 1);
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
                }

            },0, (long) pr.timeperSeconed);
        }
    }

    @Override
    public void pause() {
        ts.cancel();
        ts=null;
    }

    @Override
    public void stop() {
        ts.cancel();
        ts=null;

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