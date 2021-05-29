package Model;

import Model.AnomalyDetactor.TimeSeries;
import Model.AnomalyDetactor.TimeSeriesAnomalyDetector;
import Property.property;

import java.util.Observable;

public class ModelFg extends Observable implements Model.runningfunc.Model {

        TimeSeries timeSeries;
        property pr;


  public ModelFg(String s) {

            XmlWrite xml=new XmlWrite();
            pr=new property();
            pr=xml.deserializeFromXML();
   }


   @Override
   public void SetTimeSeries(TimeSeries ts) {
            this.timeSeries = timeSeries;
   }

    @Override
    public void play() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void stop() {

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
