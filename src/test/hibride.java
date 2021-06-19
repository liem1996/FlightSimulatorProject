

package test;

import javafx.scene.chart.XYChart;

import java.util.*;


public class hibride implements TimeSeriesAnomalyDetector {
    private  double HighCorralation = 0.95;
    private  double LowCorralation = 0.5;
    private Map<CorrelatedFeatures, Circle> MyHash = new HashMap<>();
    Zscore ZscoreDet = new Zscore();
    SimpleAnomalyDetector SimpleDet =new SimpleAnomalyDetector();
    List<CorrelatedFeatures> col =new ArrayList<>();
    List<AnomalyReport> defects = new LinkedList<>();
    TimeSeries simple = new TimeSeries();

    @Override
    public void learnNormal(TimeSeries ts) {
         col = learnNormalCor(ts);

        //like detect but study a different by study a different time series and save it in data base like corlativefeture
        for (int i = 0; i <col.size() ; i++) {
            TimeSeries tm = new TimeSeries();
            findTimeSeries(ts, col, tm, i);
            if (Math.abs(col.get(i).corrlation) >= HighCorralation) {
                SimpleDet.learnNormal(tm);


            } else if (col.get(i).corrlation< LowCorralation) {
                ZscoreDet.learnNormal(tm);

            } else {
                //////////////////////////////////////////////////////////////////////////////////
                learnWlzl(i, tm);

            }

        }

    }



    @Override
    public List<AnomalyReport> detect (TimeSeries ts) {


        TimeSeries tk = new TimeSeries();
        TimeSeries tm = new TimeSeries();
        //creating a map in order to compare without knowing each index of the list of the correlative feature
        HashMap<String,CorrelatedFeatures> compareCorlativefe = new HashMap<>();
        SimpleAnomalyDetector sim = new SimpleAnomalyDetector();
        int size1=0;

        //puting acording to the key of the corletive and taking the same value as the key
        for(int j=0;j<SimpleDet.corletivfeture.size();j++){
            compareCorlativefe.put(SimpleDet.corletivfeture.get(j).feature1 + "" + SimpleDet.corletivfeture.get(j).feature2,SimpleDet.corletivfeture.get(j));
        }


        for (int i = 0; i < col.size(); i++) {
            //putting the column and there data in the time series
           
            if(SimpleDet.corletivfeture.size()>i) {
                if (compareCorlativefe.containsKey(col.get(i).feature1 + "" + col.get(i).feature2)) {
                    findTimeSeries(ts, col, simple, i);
                    sim.corletivfeture.add(col.get(i));
                    sim.thereholdper= SimpleDet.thereholdper;

                }
            }

             //choosing all of the column that is uo the 0.95 and use algorithm 2
                if ((ZscoreDet.ZscoreMax.containsKey(col.get(i).feature2) || ZscoreDet.ZscoreMax.containsKey(col.get(i).feature1))) {
                    findTimeSeries(ts, col, tk, i);
                    ZscoreDet.detect(tk);
                    defects.addAll(ZscoreDet.detect(tk));
                }


                //using the algorithm 3 as finding a point and the dis between the center point and each point in the column

              if (MyHash.containsKey(col.get(i))) {
                    hybridCircle(defects, tm, i);

                }


        }

        defects.addAll(sim.detect(simple));





        return defects;
    }

    private void hybridCircle(List<AnomalyReport> defects, TimeSeries tm, int i) {
        float tamp;
        float tamp1;
        Circle tempCircle = MyHash.get(col.get(i));//get Circle for coralleted features
        for (int m = 0; m < tm.fetureName.size()-1; m++) {
            int size = tm.features.get(tm.getFetureName().get(i)).size();

            for (int j = 0; j < size; j++) {
                tamp= Float.parseFloat(tm.features.get(tm.fetureName.get(m)).get(j));
                tamp1 =Float.parseFloat(tm.features.get(tm.fetureName.get(m+1)).get(j));
                double TwoPointsdis=Math.sqrt(Math.pow(tempCircle.c.x - tamp,2) + Math.pow(tempCircle.c.y - tamp1,2));
                if (TwoPointsdis > tempCircle.r) {
                    AnomalyReport tamp2 = new AnomalyReport(tm.fetureName.get(m) + " " +tm.fetureName.get(m+1)  , j + 1);
                    defects.add(tamp2);
                }


            }



        }
    }

    private void findTimeSeries(TimeSeries ts, List<CorrelatedFeatures> col, TimeSeries tk, int i) {
        tk.fetureName.add(col.get(i).feature1);
        tk.fetureName.add(col.get(i).feature2);
        tk.features.put(col.get(i).feature1, ts.features.get(col.get(i).feature1));
        tk.features.put(col.get(i).feature2, ts.features.get(col.get(i).feature2));
    }

    private float[] praseFloat(ArrayList<String> array) {
        float[] transform = new float[array.size()];
        for (int i = 0; i < array.size(); i++) {
            transform[i] = Float.parseFloat(array.get(i));
        }
        return transform;
    }
    private List<Point> Listpoint(float[] aray1, float[] array2){
        Point[] tamp = new Point[aray1.length];
        List<Point> Pointslist = new ArrayList<>();
        for(int i=0;i<aray1.length;i++){
            tamp[i] = new Point(aray1[i],array2[i]);
        }
        Pointslist.addAll(Arrays.asList(tamp));
        return Pointslist;
    }

    public List<CorrelatedFeatures> learnNormalCor(TimeSeries ts) {
        SimpleAnomalyDetector simple = new SimpleAnomalyDetector();
        simple.learnNormal1(ts, 0.0);
        return simple.corletivfeture;
    }
    private void learnWlzl(int i, TimeSeries tm) {
        SmallestEnclosingCircle circle = null;
        float[] colm1;
        float[] colm2;
        colm1 = praseFloat(tm.getFeatures().get(col.get(i).feature1)); //column of corraleted feature A for example
        colm2 = praseFloat(tm.getFeatures().get(col.get(i).feature2));
        List<Point> Pointslist = Listpoint(colm1,colm2);
        Circle temp = circle.makeCircle(Pointslist); //The smallest circle created from the list of points of the corraleted features
        MyHash.put(col.get(i),temp);
    }


    public XYChart.Series<String, Number> paint(TimeSeries ts, String name) {
        return null;
    }
}


