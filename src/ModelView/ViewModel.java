package ModelView;

import Model.AnomalyDetactor.TimeSeries;
import Model.ModelFg;
import Model.property;
import javafx.beans.property.IntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import test.TimeSeriesAnomalyDetector;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;

public class ViewModel extends Observable implements Observer {

    public ModelFg model;
    public TimeSeries ts;
    public property pt;
    public ObservableList<String> fetures;
    public IntegerProperty TimeLine;
    public Runnable Play,Pause,Stop;


    public void load(){
       fetures= FXCollections.observableArrayList(ts.getFetureName());
    }


    public void CreateTimeSeries(String fileName){
        //create time series
        ts = new TimeSeries(fileName);
        model.SetTimeSeries(ts);
        load();


    }
    public void CreateProperty(String fileName){
        //create time series
       model.SetProperty(fileName);
    }



    //
    public void loadClass(String directory) {

        URLClassLoader urlClassLoader = null;
        try {
            urlClassLoader = URLClassLoader.newInstance(new URL[] {
                    new URL("file://C:\\Users\\amitb\\IdeaProjects\\aven derech 3 part 2\\out\\artifacts\\aven_derech_3_part_2_jar")
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






    public ViewModel(ModelFg model) {
        this.model = model;
        model.addObserver(this);

    }

   public void Players(){
       Play=()->{model.play();};
       Pause=()->{model.pause();};
       Stop=()->{model.pause();};
    }

    //we need to run it in the background in the model by a therd



    @Override
    public void update(java.util.Observable o, Object arg) {


    }



    //public Properties CreateProperties(String Filename){
        //create with decoder

    //}

}
