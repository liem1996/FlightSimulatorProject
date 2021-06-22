package View;

import test.TimeSeries;
import Model.ModelFg;
import ModelView.ViewModel;

import Model.XmlWrite;
import Model.property;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.util.HashMap;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        FXMLLoader fxnl1=new FXMLLoader();
        Parent root;
        root = (Parent)fxnl1.load((getClass()).getResource("MainWindowController.fxml").openStream());

        primaryStage.setScene(new Scene(root));

        primaryStage.setTitle("Flight Simulator");
        MainWindowController mwc=new MainWindowController();

        mwc =fxnl1.getController();

        ModelFg model = new ModelFg();
        XmlWrite xml=new XmlWrite();
        model.pr=xml.deserializeFromXML("Properties.xml");
        ViewModel viewModel = new ViewModel(model);
        mwc.init(viewModel);

        primaryStage.show();


    }


    public static void main(String[] args) {
        
        launch(args);
    }
}