package Model;

import Model.AnomalyDetactor.TimeSeries;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import test.TimeSeriesAnomalyDetector;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.*;

public class ModelFg extends Observable implements Model.runningfunc.Model {

        TimeSeries timeSeries;
        property pr;
        Timer ts;
        IntegerProperty TimeLine;
        TimeSeriesAnomalyDetector tsad;


  //contructor for the model itself
  public ModelFg() {
      pr=new property();
      timeSeries=new TimeSeries();
      TimeLine=new SimpleIntegerProperty();
   }


   //set the properties from the user
    public void SetProperty(property p) {
       pr =p;

    }



    //set the time series from the view model and the csv
   @Override
   public void SetTimeSeries(TimeSeries ts) {
            this.timeSeries = ts;

   }


   //run the simulator itself and the time acording the lines in the timeseries
    @Override
    public void play() {
        if(this.ts==null){
            ts=new Timer();


            ts.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    try {
                        Socket fg = new Socket(pr.ip, pr.port);
                        PrintWriter ps=new PrintWriter(fg.getOutputStream());
                        for(int i=1;i<timeSeries.getNumLine()-1;i++){
                         //   System.out.println(timeSeries.getline(i)[i]);
                            ps.println(Arrays.toString(timeSeries.getline(i)));
                            ps.flush();

                        }
                        fg.close();
                        ps.close();

                    } catch (UnknownHostException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }



                }
            },0, (long) pr.timeperSeconed);
        }
    }

    //pasue the simulator itself and the time acording the lines in the timeseries
    @Override
    public void pause() {
        ts.cancel();
        ts=null;
    }

    //stop the simulator itself and the time acording the lines in the timeseries
    @Override
    public void stop() {
       ts.cancel();
       ts=null;
        TimeLine.set(0);

    }

    //need to run in a seprate therd
    @Override
    public void SetAnomalyDetactor(TimeSeriesAnomalyDetector tsa) {
        tsad = tsa;

    }

    @Override
    public void Start() {

    }


    @Override
    public Runnable getPainter() {
        return null;
    }


}
