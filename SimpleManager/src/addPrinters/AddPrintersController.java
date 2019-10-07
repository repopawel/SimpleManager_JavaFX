/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addPrinters;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import simpleManager.FXMLDocumentController;
import simpleManager.PrintersList;

/**
 * FXML Controller class
 *
 * @author PLRAD2SIU
 */
public class AddPrintersController extends FXMLDocumentController implements Initializable {

    @FXML
    private ImageView logo;
    @FXML
    private JFXTextField departmentTextField;
    @FXML
    private JFXTextField modelTextField;
    @FXML
    private JFXTextField materialsTextField;
    @FXML
    private JFXTextField ipTextField;
    @FXML
    private JFXTextField infoTextField;
    @FXML
    private JFXButton saveBtnPrintersEvent;
    @FXML
    private JFXButton cancelBtnPrintersEvent;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        saveBtnPrintersEvent.setOnMouseClicked((MouseEvent event) -> {
            try {
                Connection connection = dbConnection.DbConnection.getConnection();
                Statement stm = connection.createStatement();
                stm.executeUpdate("INSERT INTO `simplemanager_db`.`printers` ( `DZIAL`, `MODEL` , `RODZAJ_TUSZU`, `IP`,`INFO` ) VALUES ('" + departmentTextField.getText() + "','" + modelTextField.getText() + "','" + materialsTextField.getText() + "','" + ipTextField.getText() + "','" + infoTextField.getText() + "');");
                Stage stage = (Stage) departmentTextField.getScene().getWindow();
                stage.close();
                connection.close();

                alert(9);
            } catch (SQLException ex) {
                System.err.println(ex);
                System.err.println("Problem z insertem !");
            }
            try {

                Connection conn = dbConnection.DbConnection.getConnection();
                listaDrukarek.clear();
                ResultSet reg = conn.createStatement().executeQuery("SELECT * FROM simplemanager_db.printers;");
                while (reg.next()) {
                    listaDrukarek.add(new PrintersList(reg.getInt("IDPRINTERS"), reg.getString("DZIAL"), reg.getString("MODEL").toUpperCase(), reg.getString("RODZAJ_TUSZU"), reg.getString("IP"), reg.getString("INFO")));
                }
                conn.close();

            } catch (SQLException ex) {
                Logger.getLogger(AddPrintersController.class.getName()).log(Level.SEVERE, null, ex);
            }

          
        });

        cancelBtnPrintersEvent.setOnMouseClicked((event) -> {
            closePrinters();
        });

// ++++ LOGO APLIKACJI        
        logo.setImage(new Image("/img/simple.png"));
    }

    @FXML
    private void closeWindow(MouseEvent event) {
        closePrinters();
    }

    @FXML
    private void minWindow(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setFullScreenExitHint("");
        stage.setIconified(true);
    }

    @FXML
    private void maxWindow(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setResizable(false);
        stage.setMaximized(true);
        stage.setFullScreen(true);
    }

    @FXML
    public void dragMouseEvent(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setX(event.getScreenX() - x);
        stage.setY(event.getScreenY() - y);
    }

    @FXML
    public void mousePressEvent(MouseEvent event) {
        x = event.getSceneX();
        y = event.getSceneY();
    }

    private void closePrinters() {

        Stage stage = (Stage) cancelBtnPrintersEvent.getScene().getWindow();
        stage.close();

    }
}
