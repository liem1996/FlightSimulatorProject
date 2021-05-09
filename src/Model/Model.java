package Model;

import Model.AnomalyDetactor.TimeSeries;

import java.util.Observable;
import java.util.Properties;

public class Model extends Observable {
    TimeSeries timeSeries;
    property pr;

    public Model(String s) {
        XmlWrite xml=new XmlWrite();
        pr=new property();
        pr=xml.deserializeFromXML();
    }

    public void setTimeSeries(TimeSeries timeSeries) {
        this.timeSeries = timeSeries;


    }


}
