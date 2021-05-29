
package View.fxmlController;

import View.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.net.URL;

public class FxmlLoader {

    public BorderPane view;

    public Pane getPage(String fileName){
        try{
            URL fileUrl = Main.class.getResource("/View/fxmlfiels/" + fileName + ".fxml");
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

