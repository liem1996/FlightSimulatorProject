package ModelView;

import Model.AnomalyDetactor.TimeSeries;
import Model.ModelFg;
import Model.XmlWrite;
import Model.property;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import test.TimeSeriesAnomalyDetector;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Observable;
import java.util.Observer;

public class ViewModel extends Observable implements Observer {

    public ModelFg model;
    public TimeSeries ts;
    public property pt;
    public ObservableList<String> fetures;
    public IntegerProperty TimeLine = new SimpleIntegerProperty();
    public Runnable Play,Pause,Stop;

    public String altimeterVM = "21";


    public IntegerProperty timeStep;

    //load the fetures of the time series
    public void load(){
        fetures = FXCollections.observableArrayList();
        fetures.addAll(ts.getFetureName());

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
    public void loadClass(String directory) {

        URLClassLoader urlClassLoader = null;
        try {
            urlClassLoader = URLClassLoader.newInstance(new URL[] {
                    new URL("D:\\aven derech 3 part 2")
            });
            Class<?> c=urlClassLoader.loadClass("test."+directory);

            TimeSeriesAnomalyDetector sc=(TimeSeriesAnomalyDetector) c.newInstance();
            model.SetAnomalyDetactor(sc);
            //model.SetAnomalyDetactor(sc);
        } catch (MalformedURLException e) {

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    // constructor - initialize the view model
    public ViewModel(ModelFg model) {
        this.model = model;
        model.addObserver(this);

        // Connecting the time line to it's current value
        TimeLine.addListener((old, oldValue, newValue) -> model.setTimeLine((int)newValue));

    }


    //intelizing the runnbles of the viewmodel for the player section
    public void Players(){
        Play=()->{model.play();};
        Pause=()->{model.pause();};
        Stop=()->{model.pause();};
    }


    //we need to run it in the background in the model by a therd



    @Override
    public void update(java.util.Observable o, Object arg) {


    }


}
