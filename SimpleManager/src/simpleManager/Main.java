
package simpleManager;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author PLRAD2SIU
 */
public class Main extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        
        Scene scene = new Scene(root);
        stage.getIcons().add(new Image("/img/simple.png"));
        stage.setTitle(" Simple Manager");
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();
    }

  
    public static void main(String[] args) {
        launch(args);
    }
    
}
