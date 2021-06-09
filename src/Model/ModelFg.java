package Model;

import Model.AnomalyDetactor.TimeSeries;
import Model.AnomalyDetactor.TimeSeriesAnomalyDetector;
import Property.property;

import java.util.Observable;

public class ModelFg extends Observable implements Model.runningfunc.Model {

        TimeSeries timeSeries;
        property pr;


  public ModelFg(String s) { //we don't use the String "s" in the constructor

            XmlWrite xml=new XmlWrite();
            pr=new property();
            pr=xml.deserializeFromXML(); //create a property object from "Properties.xml"
   }


   @Override
   public void SetTimeSeries(TimeSeries ts) {
            this.timeSeries = ts;
   } //why not "this.timeSeries = ts"?

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
