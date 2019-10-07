/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editPrinters;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;
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
public class EditPrintersController extends FXMLDocumentController implements Initializable {

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
    private JFXButton saveBtnPrinters;
    @FXML
    private JFXButton cancelBtnPrinters;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // ++++ LOGO APLIKACJI        
        logo.setImage(new Image("/img/simple.png"));

        cancelBtnPrinters.setOnMouseClicked((MouseEvent event) -> {
            closeEdit();
        });

    }

    @FXML
    private void closeWindow(MouseEvent event) {
        closeEdit();
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

    private void closeEdit() {

        Stage stage = (Stage) cancelBtnPrinters.getScene().getWindow();
        stage.close();

    }

    public void betweenFXMLandPrinters(PrintersList selectedItem) {

        departmentTextField.setText(selectedItem.getDzial());
        modelTextField.setText(selectedItem.getModel());
        materialsTextField.setText(selectedItem.getRodzaj_tuszu());
        ipTextField.setText(selectedItem.getIp());
        infoTextField.setText(selectedItem.getInfo());

        saveBtnPrinters.setOnMouseClicked((MouseEvent event) -> {

            try {
                Connection connection = dbConnection.DbConnection.getConnection();
                String now = "UPDATE `simplemanager_db`.`printers`\n"
                        + "SET\n"
                        + "`DZIAL` = \"" + departmentTextField.getText() + "\",\n"
                        + "`MODEL` = \"" + modelTextField.getText() + "\",\n"
                        + "`RODZAJ_TUSZU` = \"" + materialsTextField.getText() + "\",\n"
                        + "`IP` = \"" + ipTextField.getText() + "\",\n"
                        + "`INFO` = \"" + infoTextField.getText() + "\"\n"
                        + "WHERE `IDPRINTERS` = \"" + selectedItem.getIdprinters()+ "\";";
                //System.out.println(now);
                connection.createStatement().executeUpdate(now);

                refreshDbPrinters();
                connection.close();
                Stage stage = (Stage) departmentTextField.getScene().getWindow();
                stage.close();
            } catch (SQLException ex) {

                System.err.println("Problem z updatem Printers Edit Context Menu ! ");
            }

        });
    }

}
