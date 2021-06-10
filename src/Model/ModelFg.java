package Model;

import Model.AnomalyDetactor.TimeSeries;
import Model.AnomalyDetactor.TimeSeriesAnomalyDetector;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.canvas.GraphicsContext;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;

public class ModelFg extends Observable implements Model.runningfunc.Model {

    TimeSeries timeSeries;
    property pr;
    Timer ts;
    ArrayList<String> TimeStep;
    IntegerProperty timestep;

    public int getTimestep() {
        return timestep.get();
    }

    public IntegerProperty timestepProperty() {
        return timestep;
    }

    public void setTimestep(int timestep) {
        this.timestep.set(timestep);
    }



    public ModelFg() {
        pr=new property();
        timeSeries=new TimeSeries();
        TimeStep=new ArrayList<>();
        timestep = new SimpleIntegerProperty(0);
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
                    System.out.println("sending row" + timestep.get());
                    timestep.set(timestep.get()+1);
                    //timestep.set();
 /*                   try {
                        Socket fg = new Socket(pr.ip, pr.port);
                        PrintWriter ps=new PrintWriter(fg.getOutputStream());
                        for(int i=0;i<timeSeries.getNumLine();i++){
                           // ps.println(timeSeries.getline(i));
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
            },0, 1000);
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

    }

    @Override
    public void Start() {

    }


    @Override
    public Runnable getPainter() {
        return null;
    }


}