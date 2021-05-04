package View;

import javafx.scene.layout.Pane;

import java.net.URL;

public class FxmlLoader {

    private Pane view;

    public Pane getPage(String fileName){
        try{
            URL fileUrl = Main.class.getResource("/View/" + fileName + ".fxml");
            if (fileUrl == null){

            }
        }
    }

}
