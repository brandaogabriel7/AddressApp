package brandao.gabriel.address.initializer;

import brandao.gabriel.address.MainApp;;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class RootLayoutInitializer implements IInitializer {

    private volatile static RootLayoutInitializer instance;
    private BorderPane loadedFXML;

    public RootLayoutInitializer() {
        
    }  
    
    public static RootLayoutInitializer getInstance() {
        if(instance == null) {
            synchronized(RootLayoutInitializer.class) {
                if(instance == null) instance = new RootLayoutInitializer();
            }
        }
        return instance;
    }

    public Pane getLoadedFXML(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class
                    .getResource("/fxml/RootLayout.fxml"));
            loadedFXML = (BorderPane) loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

   
        return loadedFXML;
    };

}