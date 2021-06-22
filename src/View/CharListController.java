package View;

import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.chart.*;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import test.Circle;


public class CharListController extends BorderPane {

    public static Runnable choosingName;
    public static StringProperty feturecoulme;


    @FXML
    public javafx.scene.canvas.Canvas canvas;

    @FXML
    public ListView<String> listview;

    @FXML
    public LineChart<String,Number> linechart;

    @FXML
    public  LineChart<String,Number> linechart2;

    @FXML
    public LineChart<String, Number> linechart3;



    public XYChart.Series<String, Number> series = new XYChart.Series<>();


    public CharListController() {
        fetures = FXCollections.observableArrayList();
        listview=new ListView<>();

        //defining the axes
        final CategoryAxis xAxis = new CategoryAxis(); // we are gonna plot against time
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setAnimated(false); // axis animations are removed
        yAxis.setAnimated(false); // axis animations are removed

        //creating the line chart with two axis created above
        linechart = new LineChart<>(xAxis, yAxis);
        linechart2 = new LineChart<>(xAxis, yAxis);
        linechart3 = new LineChart<>(xAxis, yAxis);

        linechart.setAnimated(false); // disable animations

        linechart2.setAnimated(false); // disable animations

        linechart3.setAnimated(false); // disable animations


    }

    public static ObservableList<String> fetures;




    public ObservableList<String> getFetures(){
        return fetures;
    }

    public void paint(Circle circle) {
        // by using addListener function the screen gets update and move by axis x and axis y
        GraphicsContext gc = canvas.getGraphicsContext2D();

        //   Circle circle = new Circle(p.getX(), p.getY(),Color.BLACK,radius);

        gc.clearRect(0,0, canvas.getWidth(), canvas.getHeight());

        gc.setFill(Color.WHITE);
        gc.setStroke(Color.BLACK);

        canvas.getGraphicsContext2D().strokeOval(circle.c.x-circle.r, circle.c.y-circle.r, circle.r, circle.r);

        //    canvas.getGraphicsContext2D().fillOval(circle.c.x-circle.r, circle.c.y-circle.r, circle.r, circle.r);

    }






}