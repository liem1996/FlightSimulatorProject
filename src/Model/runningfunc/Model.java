package Model.runningfunc;

import test.TimeSeries;
import test.TimeSeriesAnomalyDetector;


public interface Model {
  public void SetTimeSeries(TimeSeries ts);
  public void play();
  public void pause();
  public void stop();
  public void SetAnomalyDetactor(TimeSeriesAnomalyDetector tsa);
  public void Start();
  public Runnable getPainter();
}