/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editWindow;

import simpleManager.EventsList;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Connection;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author PLRAD2SIU
 */
public class EditWindowController extends simpleManager.FXMLDocumentController implements Initializable {

    @FXML
    private ImageView logo;
    @FXML
    public JFXTextField eventEditField;
    @FXML
    private JFXDatePicker endDatePEdit;
    @FXML
    private JFXRadioButton rb1;
    @FXML
    private JFXRadioButton rb2;
    @FXML
    private JFXRadioButton rb3;
    @FXML
    private JFXButton saveBtnEditEvent;
    @FXML
    private JFXButton cancelBtnEditEvent;

    final ToggleGroup group = new ToggleGroup();
    @FXML
    private JFXDatePicker startDPicekerEdit;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        

         

// ++++ RADIO BUTTONY Z OKNA EDYCJI        
        rb1.setSelected(true);
        rb1.setToggleGroup(group);
        rb2.setToggleGroup(group);
        rb3.setToggleGroup(group);

        cancelBtnEditEvent.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                closeEdit();
            }

        });

// ++++ LOGO APLIKACJI        
        logo.setImage(new Image("/img/simple.png"));

    }

// ++++ PUBLICZNA KLASA TYPU STRING SLUZY DO ZAPISU DO BAZY DANYCH 
    public String getGender() {
        String gen = "";
        if (rb1.isSelected()) {
            gen = "Ok";

        } else if (rb2.isSelected()) {

            gen = "WAIT";
        } else if (rb3.isSelected()) {

            gen = "CANCEL";

        }
        return gen;
    }
// ++++ ZAMYKANANIE OKNA EDYCJI KRZYŻYKIEM 

    @FXML
    private void close(MouseEvent event) {

        closeEdit();
    }
// ++++ MIN OKNA

    @FXML
    private void minWindow(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setFullScreenExitHint("");
        stage.setIconified(true);
    }
// ++++ MAX OKNA 

    @FXML
    private void maxWindow(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setResizable(false);
        stage.setMaximized(true);
        stage.setFullScreen(true);
    }

    @FXML
    public void dragMousEvent(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setX(event.getScreenX() - x);
        stage.setY(event.getScreenY() - y);
    }

    @FXML
    public void mousePressEvent(MouseEvent event) {
        x = event.getSceneX();
        y = event.getSceneY();
    }
// ++++ ZAMYKANIE POJEDYNCZEJ SCENY 

    private void closeEdit() {

        Stage stage = (Stage) cancelBtnEditEvent.getScene().getWindow();
        stage.close();

    }

    public void betweenControllers(EventsList listaE) {
        eventEditField.setText(listaE.getEvent());

        startDPicekerEdit.setValue(LocalDate.parse(listaE.getData()));
        endDatePEdit.setValue(LocalDate.parse(listaE.getEnddate()));

        saveBtnEditEvent.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (eventEditField.getText().equals("")) {

                    alert(1);

                } else if (startDPicekerEdit.getValue() == null) {

                    alert(6);

                } else if (endDatePEdit.getValue() == null) {

                    alert(6);
                } else {

                    try {

                        Connection connection = dbConnection.DbConnection.getConnection();

                        String now = "UPDATE `simplemanager_db`.`addevents`\n"
                                + "SET\n"
                                + "`DATE` = \""+startDPicekerEdit.getValue()+"\",\n"
                                + "`EVENT` = \""+eventEditField.getText()+"\",\n"
                                + "`OK` = \""+getGender()+"\",\n"
                                + "`ENDDATE` = \""+endDatePEdit.getValue()+"\"\n"
                                + "WHERE `id` = \""+listaE.getId()+"\";";
                        //System.out.println(now);
                        connection.createStatement().executeUpdate(now);
                        refreshDB();
                        connection.close();

                        Stage stage = (Stage) eventEditField.getScene().getWindow();
                        stage.close();

                    } catch (Exception e) {

                        System.err.println("Bład z updatem!!");
                    }

                }

            }

        });

    }

}
