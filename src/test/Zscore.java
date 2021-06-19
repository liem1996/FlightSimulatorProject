package test;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.chart.XYChart;

import java.util.*;

import static test.StatLib.*;

public class Zscore implements test.TimeSeriesAnomalyDetector {

    HashMap<String, Double> ZscoreMax = new HashMap<>();


    //a function that makes an array of string to a List array
    private float[] praseFloat(ArrayList<String> array) {
        float[] transform = new float[array.size()];
        for (int i = 0; i < array.size(); i++) {
            transform[i] = Float.parseFloat(array.get(i));
        }
        return transform;
    }

    //return the array of the zscore of each column
    public double Zscore(ArrayList<String> array, int index) {
        float average = 0;
        double Zscore = 0;
        float[] avglist = new float[2]; // to initialize the 2 first indexes
        float[] XArrayOLD = praseFloat(array);
        if (index == 0 || index == 1) {
            Zscore = 0;
        } else {
            avglist = Arrays.copyOfRange(XArrayOLD, 0, index);

            //it is a variance in square
            float daviationOld = Math.abs(var(avglist));

            double daviationNEW = Math.sqrt(daviationOld);

            average = avg(avglist);

            if (daviationNEW != 0) {

                Zscore = (Math.abs(XArrayOLD[index] - average)) / daviationNEW;

            } else {
                Zscore = 0;
            }

        }
        return Zscore;


    }

    //learn according to the insert values and calculating according to the zscore algorithm
    @Override
    public void learnNormal(TimeSeries ts) {
        ArrayList<Double> ZscoreCoulme = new ArrayList<>();
        double max = 0;
        double zscoreresult;
        ArrayList<String> tscoulmen = new ArrayList<>();

        //put the result of the equation into the map according to the columns
        for (int i = 0; i < ts.getFetureName().size(); i++) {

            tscoulmen = ts.features.get(ts.fetureName.get(i));
            ZscoreCoulme = new ArrayList<>();
            for (int m = 0; m < tscoulmen.size(); m++) {

                zscoreresult = Zscore(tscoulmen, m);

                ZscoreCoulme.add(zscoreresult);

            }
            max = Collections.max(ZscoreCoulme);
            ZscoreMax.put(ts.getFetureName().get(i), max);


        }


    }

    //detect the anomly report
    @Override
    public List<AnomalyReport> detect(TimeSeries ts) {
        ArrayList<Double> ZscoreCoulme = new ArrayList<>();
        ArrayList<String> tscoulmen = new ArrayList<>();
        List<AnomalyReport> Zscoreexaption = new LinkedList<>();
        double zscoreresult;


        //find exception and warned about it
        for (int i = 0; i < ts.getFetureName().size(); i++) {
            tscoulmen = ts.features.get(ts.fetureName.get(i));
            ZscoreCoulme = new ArrayList<>();


            for (int m = 0; m < tscoulmen.size(); m++) {

                zscoreresult = Zscore(tscoulmen, m);
                ZscoreCoulme.add(zscoreresult);

                //get the exception into an list of anomaly report

                // System.out.println(ZscoreMax.get(ts.fetureName.get(i)));
                // System.out.println(m);
                ZscoreCoulme.get(m);
                if (ZscoreMax.containsKey(ts.fetureName.get(i))) {
                    if (ZscoreCoulme.get(m) > ZscoreMax.get(ts.fetureName.get(i))) {
                        test.AnomalyReport tamp = new test.AnomalyReport(ts.fetureName.get(i), m + 1);
                        Zscoreexaption.add(tamp);
                    }


                }

            }
        }
        return Zscoreexaption;
    }

    @Override
    public XYChart.Series<String, Number> paint(TimeSeries ts, String name) {
        XYChart.Series<String, Number> series = new XYChart.Series<>();


        double zscoreresult;
        ArrayList<String> tscoulmen = new ArrayList<>();
        IntegerProperty index =new SimpleIntegerProperty();
        tscoulmen = ts.features.get(name); // get from the time series features ->the name of the giving name

        for (int m = 0; m < tscoulmen.size(); m++){
            index.setValue(m);
            zscoreresult = Zscore(tscoulmen, m);
            series.getData().add(new XYChart.Data<String, Number>(index.toString(),zscoreresult));

        }
        return series;
    }

}
