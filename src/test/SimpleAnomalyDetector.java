package test;

import javafx.scene.chart.XYChart;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static test.StatLib.*;

//amit ben basat -207523630
public class SimpleAnomalyDetector implements TimeSeriesAnomalyDetector {
	public List<CorrelatedFeatures> corletivfeture;
	public List<CorrelatedFeatures> corletivfeture1;
	public double thereholdper=0.9;

	public XYChart.Series<String, Number> seriesLinearReg = new XYChart.Series<>(); // learnNormal
	public XYChart.Series<String, Number> seriesPointsRightFlight= new XYChart.Series<>(); // learnNormal
	public XYChart.Series<String, Number> seriesPoints = new XYChart.Series<>(); // detect

	public SimpleAnomalyDetector() {
		corletivfeture = new ArrayList<CorrelatedFeatures>();
		corletivfeture1=new LinkedList<>();

	}

	public double setThereholdper(double thereholdper) {
		this.thereholdper = thereholdper;
		return thereholdper;
	}

	private float[] praseFloat(ArrayList<String> array) {
		float[] transform = new float[array.size()];
		for (int i = 0; i < array.size(); i++) {
			transform[i] = Float.parseFloat(array.get(i));
		}
		return transform;
	}

	private float maxdev(Point[] p, Line l) {
		float dev1;
		float max = 0;
		for (int i = 0; i < p.length; i++) {
			dev1 = dev(p[i], l);
			if (max < dev1) {
				max = dev1;
			}
		}
		return max;
	}

	private Point[] arraypoint(float[] aray1, float[] array2){
		Point[] tamp = new Point[aray1.length];
		for(int i=0;i<aray1.length;i++){
			tamp[i] = new Point(aray1[i],array2[i]);
		}
		return tamp;
	}

	@Override
	public void learnNormal(TimeSeries ts) {
		learnNormal1(ts, thereholdper);
	}

	public void learnNormal1(TimeSeries ts, double treshhold) {
		float threshold;
		float[] colm1;
		float[] colm2;
		float[] saving1 = null;
		float[] saving2 = null;
		float pear;
		float corlletion1=0;
		Line reggrision;
		String feture1=null;
		String feture2 =null;
		Point[] corelliton;
		for (int i = 0; i < ts.getFetureName().size(); i++) {
			for (int j = i; j < ts.getFetureName().size(); j++) {
				if (i != j) {
					colm1 = praseFloat(ts.getFeatures().get(ts.getFetureName().get(i))); //column of corraleted feature A for example
					colm2 = praseFloat(ts.getFeatures().get(ts.getFetureName().get(j)));
					pear = pearson(colm1,colm2);
					if(pear>corlletion1){
						corlletion1=pear;
						feture1 = ts.getFetureName().get(i);
						feture2 = ts.getFetureName().get(j);
						saving1 = colm1;
						saving2 = colm2;
					}

				}

			}

			if(corlletion1>treshhold){
				corelliton = arraypoint(saving1,saving2);
				reggrision = linear_reg(corelliton);
				threshold=maxdev(corelliton,reggrision);
				CorrelatedFeatures tamp = new CorrelatedFeatures(feture1,feture2,corlletion1,reggrision,threshold);
				corletivfeture.add(tamp);
				corletivfeture1.add(tamp);
			}
			corlletion1=0;
		}
	}




	@Override
	public List<AnomalyReport> detect(TimeSeries ts) {
		List<AnomalyReport> cf = new LinkedList<>();
		float line1=0;
		float line2=0;
		String stri1;
		String stri2;
		float thereholdmax;

		for (int i = 0; i < corletivfeture.size(); i++) {
			int size = ts.features.get(ts.getFetureName().get(i)).size();

			for (int j = 0; j < size; j++) {
				stri1 = ts.features.get(corletivfeture.get(i).feature1).get(j);
				stri2 = ts.features.get(corletivfeture.get(i).feature2).get(j);

				float x = Float.parseFloat(stri1);
				float y = Float.parseFloat(stri2);

				Point strir1 = new Point(x,y);

				thereholdmax = dev(strir1,corletivfeture.get(i).lin_reg);

				if(thereholdmax>corletivfeture.get(i).threshold+0.1) {
					AnomalyReport tamp = new AnomalyReport(corletivfeture.get(i).feature1+"-"+corletivfeture.get(i).feature2, j+1);
					cf.add(tamp);

				}
			}


		}
		return cf;


	}


	public List<CorrelatedFeatures> getNormalModel() {

		return corletivfeture;
	}
	public ArrayList<XYChart.Series<String, Number>> paint(TimeSeries ts, String name) {
		Line line  =new Line();

		ArrayList<XYChart.Series<String, Number>> finalseries = new ArrayList<>();

		List<AnomalyReport> cf = new LinkedList<>();

		String stri1;
		String stri2;
		float thereholdmax;

		String corrlativeName=null;
		float thershold = 0;

		/// !!!!! ------- To activate the learn on the model ------ !!!!
			for (int k=0; k<corletivfeture.size(); k++)
			{
				//check if the name of the feature equal to feature 1 or 2 and built the line
				if(corletivfeture.get(k).feature1.equals(name))
				{
					corrlativeName = corletivfeture.get(k).feature2;
					line=corletivfeture.get(k).lin_reg;
					thershold=corletivfeture.get(k).threshold;
				}
				if (corletivfeture.get(k).feature2.equals(name)){
					corrlativeName = corletivfeture.get(k).feature1;
					line=corletivfeture.get(k).lin_reg;
					thershold=corletivfeture.get(k).threshold;
				}

			}

			int size = ts.features.get(name).size();

			if (ts.features.get(corrlativeName)!=null) {
				for (int j = 0; j < size; j++) {
					stri1 = ts.features.get(name).get(j);
					stri2 = ts.features.get(corrlativeName).get(j);

					float x = Float.parseFloat(stri1);
					float y = Float.parseFloat(stri2);

					Point strir1 = new Point(x, y);
					seriesPointsRightFlight.getData().add(new XYChart.Data<String, Number>(String.valueOf(strir1.x), strir1.y));

					thereholdmax = dev(strir1, line);

					if (thereholdmax > thershold + 0.1) {
						AnomalyReport tamp = new AnomalyReport(name + "-" + corrlativeName, j + 1);
						seriesPoints.getData().add(new XYChart.Data<String, Number>(String.valueOf(strir1.x), strir1.y));
						cf.add(tamp);

					}

				}

				for (int i = 0; i < ts.features.get(name).size(); i++) {
					seriesLinearReg.getData().add(new XYChart.Data<>(String.valueOf(i), line.f(i))); // entering the regression into series
				}

				finalseries.add(seriesPoints);
				finalseries.add(seriesLinearReg);
				finalseries.add(seriesPointsRightFlight);
			}

		return finalseries;

			}
	}