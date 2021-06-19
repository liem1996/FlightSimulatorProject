package test;

import javafx.scene.chart.XYChart;

import java.util.ArrayList;
import java.util.List;

public interface TimeSeriesAnomalyDetector {
	void learnNormal(TimeSeries ts);
	List<AnomalyReport> detect(TimeSeries ts);
	ArrayList <XYChart.Series<String,Number>> paint(TimeSeries ts, String name);
}
