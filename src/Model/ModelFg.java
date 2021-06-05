package Model;

import Model.AnomalyDetactor.TimeSeries;
import Model.AnomalyDetactor.TimeSeriesAnomalyDetector;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.canvas.GraphicsContext;

import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;

public class ModelFg extends Observable implements Model.runningfunc.Model {

        TimeSeries timeSeries;
        property pr;
        Timer ts;
        IntegerProperty TimeStep;


  public ModelFg() {
      pr=new property();
      timeSeries=new TimeSeries();
      TimeStep=new SimpleIntegerProperty();
   }


    public void SetProperty(String s) {
        XmlWrite xml=new XmlWrite();
        pr=xml.deserializeFromXML(s);

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
                    TimeStep.set(TimeStep.get()+1);
                }
            },0,1000);
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
       TimeStep.set(TimeStep.get());
    }

    @Override
    public void SetAnomalyDetactor(TimeSeriesAnomalyDetector tsa) {

    }

    @Override
    public void Start() {

    }


    @Override
    public Runnable getPainter() {
        return null;
    }


}
