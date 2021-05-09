package ModelView;

import Model.AnomalyDetactor.TimeSeries;
import Model.Model;

import java.util.Observable;
import java.util.Observer;

public class ViewModel extends Observable implements Observer {

    public Model model;

    public void CreateTimeSeries(String fileName){
        //create time series
        TimeSeries ts = new TimeSeries(fileName);
        model.setTimeSeries(ts);

    }

    public ViewModel(Model model) {
        this.model = model;
        model.addObserver(this);
    }


    @Override
    public void update(java.util.Observable o, Object arg) {


    }

    //public Properties CreateProperties(String Filename){
        //create with decoder

    //}

}
