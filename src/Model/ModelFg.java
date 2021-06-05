package Model;

import Model.AnomalyDetactor.TimeSeries;
import Model.AnomalyDetactor.TimeSeriesAnomalyDetector;
import javafx.scene.canvas.GraphicsContext;

import java.util.Observable;

public class ModelFg extends Observable implements Model.runningfunc.Model {

   public TimeSeries timeSeries;
    public property pr;


    public ModelFg() {
        pr=new property();
        timeSeries=new TimeSeries();
    }


    public property insertProperty(String s) {
        XmlWrite xml=new XmlWrite();
        pr=xml.deserializeFromXML(s);
        return pr;

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