
package View.fxmlController;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

import java.net.URL;

public class FxmlLoader {

    public BorderPane view;

   public MainWindowController MC=new MainWindowController();

    public FXMLLoader FXL = new FXMLLoader();

    public BorderPane getPage(String fileName){
        try{
            URL fileUrl =MC.getClass().getResource("/View/fxmlfiels/" + fileName + ".fxml");
            if (fileUrl == null){
                throw  new java.io.FileNotFoundException("Fxml can't be found");
            }
            view = new FXMLLoader().load(fileUrl);
        }
        catch (Exception e)
        {
            System.out.println("No page " + fileName + " please check FxmlLoader.");
        }
        return view;
    }
////

}

