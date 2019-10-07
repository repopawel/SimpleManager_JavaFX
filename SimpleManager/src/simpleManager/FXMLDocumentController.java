/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpleManager;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import editPrinters.EditPrintersController;
import editWindow.EditWindowController;
import eu.hansolo.enzo.notification.NotificationBuilder;
import eu.hansolo.enzo.notification.NotifierBuilder;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;

/**
 *
 * @author PLRAD2SIU
 */
public class FXMLDocumentController extends dbConnection.DbConnection implements Initializable {

    @FXML
    private JFXTextField compName;
    @FXML
    private TextArea area;
    @FXML
    private JFXTextField searchTextF;
    @FXML
    private JFXTextField foldersTextField;
    @FXML
    private TextArea areaCopy;
    @FXML
    private JFXTextField copyTextField;
    @FXML
    private JFXButton copyBtn;
    @FXML
    private JFXButton createBtn;
    @FXML
    private JFXButton exitBtn;

    private String wypiszdane = "";
    @FXML
    private JFXButton doneBtn;
    @FXML
    private Tab pingHostTab;
    @FXML
    private Tab copyFileTab;

    public double x, y;
    @FXML
    private ImageView logo;
    @FXML
    private JFXButton at521;
    @FXML
    private JFXButton board2004;
    @FXML
    private JFXButton board7110;
    @FXML
    private JFXButton cc521;
    @FXML
    private JFXButton CC8100;
    @FXML
    private JFXButton ls2HP521;
    @FXML
    private JFXButton ls1HP521;
    @FXML
    private JFXButton lsHP8210;
    @FXML
    private JFXButton lsK5400;
    @FXML
    private JFXButton lw521;
    @FXML
    private JFXButton lwe3521;
    @FXML
    private JFXButton lwmag521;
    @FXML
    private JFXButton ae521dn;
    @FXML
    private JFXButton ae7110;
    @FXML
    private JFXButton bhp521DN;
    @FXML
    private JFXButton bhp8210;
    @FXML
    private JFXButton ep521bru;
    @FXML
    private JFXButton epMP3555;
    @FXML
    private JFXButton epMP9003;
    @FXML
    private JFXButton ep2335;
    @FXML
    private JFXButton hr521DN;
    @FXML
    private JFXButton hr8100;
    @FXML
    private JFXButton meMP90031ME;
    @FXML
    private JFXButton meMP4002;
    @FXML
    private JFXButton meMP9003plot;
    @FXML
    private JFXButton mePW750;
    @FXML
    private JFXButton meCanon6255;
    @FXML
    private JFXButton mp7110;
    @FXML
    private JFXButton mpCanon4235;
    @FXML
    private JFXButton mpMP4001;
    @FXML
    private JFXButton puCanon4045;
    @FXML
    private JFXButton pu8210;
    @FXML
    private JFXButton puEpson7015;
    @FXML
    private JFXButton pu521dn;
    @FXML
    private JFXButton pu8210blasz;
    @FXML
    private JFXButton mp8210pyr;
    @FXML
    private JFXButton hr521DNrecepcja;
    @FXML
    private JFXButton ce2335;
    @FXML
    private JFXButton ceMP2004;
    @FXML
    private JFXButton km958;
    @FXML
    private JFXButton ceMPC307;
    @FXML
    private JFXButton ce521winmod;
    @FXML
    private JFXButton ce8210gacia;
    @FXML
    private JFXButton qc225dw;
    @FXML
    private JFXButton addBtnEvents;
    @FXML
    private JFXDatePicker datePicker;
    @FXML
    private JFXTextField addEventTextField;
    @FXML
    private FontAwesomeIconView calculator;
    @FXML
    private FontAwesomeIconView cmd;
    @FXML
    private FontAwesomeIconView note;
    @FXML
    private TableColumn<String, EventsList> columnt_DATA;
    @FXML
    private TableColumn<String, EventsList> column_EVENT;
    @FXML
    private TableColumn<String, EventsList> column_END_DATE;
    @FXML
    private TableColumn<String, EventsList> column_OK;

    public ObservableList<EventsList> lista = FXCollections.observableArrayList();
    
    public ObservableList<PrintersList> listaDrukarek = FXCollections.observableArrayList();
    @FXML
    public TableView<PrintersList> tableView2;
    @FXML
    private TableColumn<Integer, PrintersList> column_ID;
    @FXML
    private TableColumn<String, PrintersList> column_department;
    @FXML
    private TableColumn<String, PrintersList> column_printers;
    @FXML
    private TableColumn<String, PrintersList> column_materials;
    @FXML
    private TableColumn<String, PrintersList> column_IP;
    @FXML
    private TableColumn<String, PrintersList> column_INFO;
    @FXML
    public TableView<EventsList> tableView;
    @FXML
    private JFXDatePicker enddatePicker;
    @FXML
    public TableColumn<Integer, EventsList> column_EXPIRES;
    @FXML
    private JFXButton checkBtn;
    @FXML
    private MenuItem getOkevent;
    @FXML
    private MenuItem RefreshContextMenu;
    @FXML
    private MenuItem editContextMenu;
    @FXML
    private MenuItem deleteContextMenu;

    public FilteredList<EventsList> filteredData = new FilteredList<>(lista, p -> true);
    
    public FilteredList<PrintersList> filtredPrinters = new FilteredList<>(listaDrukarek, p->true);

    
// ++++ Tablica powiadomień     
    private eu.hansolo.enzo.notification.Notification.Notifier notifier;
    private static final eu.hansolo.enzo.notification.Notification[] NOTIFICATIONS = {
        NotificationBuilder.create().title("Info !").message("Delete from database !").image(eu.hansolo.enzo.notification.Notification.INFO_ICON).build(),
        NotificationBuilder.create().title("Warning").message("Attention, please add event !").image(eu.hansolo.enzo.notification.Notification.WARNING_ICON).build(),
        NotificationBuilder.create().title("Success !").message("Great yours event its OK ! ").image(eu.hansolo.enzo.notification.Notification.SUCCESS_ICON).build(),
        NotificationBuilder.create().title("Alert ! ").message("Select path to create the direcotires ! ").image(eu.hansolo.enzo.notification.Notification.ERROR_ICON).build(),
        NotificationBuilder.create().title("Alert ! ").message("Please select path to copy files ! ").image(eu.hansolo.enzo.notification.Notification.ERROR_ICON).build(),
        NotificationBuilder.create().title("Alert ! ").message("Please enter host name ! ").image(eu.hansolo.enzo.notification.Notification.ERROR_ICON).build(),
        NotificationBuilder.create().title("Warning").message("Attention, please add date !").image(eu.hansolo.enzo.notification.Notification.WARNING_ICON).build(),
        NotificationBuilder.create().title("Success !").message("Great you add event ! ").image(eu.hansolo.enzo.notification.Notification.SUCCESS_ICON).build(),
        NotificationBuilder.create().title("Warning").message("Attention, please select item in table !").image(eu.hansolo.enzo.notification.Notification.WARNING_ICON).build(),
        NotificationBuilder.create().title("Success !").message("Great you add printer ! ").image(eu.hansolo.enzo.notification.Notification.SUCCESS_ICON).build(),
        NotificationBuilder.create().title("Info !").message("Only on windows !").image(eu.hansolo.enzo.notification.Notification.INFO_ICON).build(),
    };
    @FXML
    private Tab reminderTab;
    @FXML
    private MenuItem RefreshContextMenu1P;
    @FXML
    private MenuItem editContextMenu1P;
    @FXML
    private MenuItem deleteContextMenu1P;
    @FXML
    private JFXButton addBtnPrinters;
    @FXML
    private MenuItem AddPrintersContextMP1;
   

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
// ++++ SELECT NA BAZIE WYPISUJĄCY DANE Z TABELI PRINTERS        
        
        try {
            refreshDbPrinters();
        } catch (SQLException e) {
            System.err.println("Błąd!");
        }
        
// ++++ NAZWY "ip" i "model" ODWOLUJA SIE DO EVENTLIST WAZNA WIELKOSC LITER!!!!

        
        column_department.setCellValueFactory(new PropertyValueFactory<String, PrintersList>("dzial"));
        column_printers.setCellValueFactory(new PropertyValueFactory<String, PrintersList>("model"));
        column_materials.setCellValueFactory(new PropertyValueFactory<String, PrintersList>("rodzaj_tuszu"));
        column_IP.setCellValueFactory(new PropertyValueFactory<String, PrintersList>("ip"));
        column_INFO.setCellValueFactory(new PropertyValueFactory<String, PrintersList>("info"));
        tableView2.setItems(listaDrukarek);
        
        
        
        
        searchTextF.textProperty().addListener((observable, oldValue, newValue) -> {
            
            filtredPrinters.setPredicate((person) -> {
           
                if(newValue == null || newValue.isEmpty()) {
                
                return true;
                
                }
                String lowerCase = newValue.toLowerCase();
                
                 if (person.getDzial().toLowerCase().contains(lowerCase)) {
                            return true; // Filter matches event.
                        } else if (person.getModel().toLowerCase().contains(lowerCase)) {
                            return true; // Filter matches expires.
                        }else if (person.getRodzaj_tuszu().toLowerCase().contains(lowerCase)) {
                            return true; // Filter matches expires.
                        }else if (person.getIp().toLowerCase().contains(lowerCase)) {
                            return true; // Filter matches expires.
                        }else if (person.getInfo().toLowerCase().contains(lowerCase)) {
                            return true; // Filter matches expires.
                        }
                return false;
            
            
            });
                 
            filteredData.setPredicate(person -> {
                        // If filter text is empty, display all persons.
                        
                        if (newValue == null || newValue.isEmpty()) {
                            return true;
                        }
                        String lowerCaseFilter = newValue.toLowerCase();
                        
// ++++ TRZEBA PAMIETAC ZE FILTR DZIALA TYLKO JESLI W COLUMNIE W KAZDYM REKORDZIE JEST JAKIS ZNAK, WYSTARCZY ZE JEDEN REKORD JEST PUSTY W KOLUMNIE WYRZUCI BLAD 
// ++++ DLATEGO DO KOLUMNY OK DODALEM ZNAK 'WAIT' 
                       
                        if (person.getEvent().toLowerCase().contains(lowerCaseFilter)) {
                            return true; // Filter matches event.
                        } else if (person.getExpires().toLowerCase().contains(lowerCaseFilter)) {
                            return true; // Filter matches expires.
                        }else if (person.getEnddate().toLowerCase().contains(lowerCaseFilter)) {
                            return true; // Filter matches expires.
                        }else if (person.getData().toLowerCase().contains(lowerCaseFilter)) {
                            return true; // Filter matches expires.
                        }else if (person.getOk().toLowerCase().contains(lowerCaseFilter)) {
                            return true; // Filter matches expires.
                        }
                         
                        return false; // Does not match.
                    });
                });
                
// ++++ IKONY DO CONTEXT MENU WIELKOSC 16pX
        getOkevent.setGraphic(new ImageView("/img/check.png"));
        deleteContextMenu.setGraphic(new ImageView("/img/delete2.png"));
        editContextMenu.setGraphic(new ImageView("/img/edit2.png"));
        RefreshContextMenu.setGraphic(new ImageView("/img/refresh.png"));
        
// ++++ IKONY DO CONTEXT MENU PRINTERS WIELKOSC 16pX

        AddPrintersContextMP1.setGraphic(new ImageView("/img/check.png"));
        deleteContextMenu1P.setGraphic(new ImageView("/img/delete2.png"));
        editContextMenu1P.setGraphic(new ImageView("/img/edit2.png"));
        RefreshContextMenu1P.setGraphic(new ImageView("/img/refresh.png"));

// ++++ CHECK BUTTON ZMIENIA WARTOSC W TABELI OK na OK         
        checkBtn.setOnMouseClicked((MouseEvent event) -> {
            if (tableView.getSelectionModel().getSelectedItem() == null) {

                alert(8);

            } else {
                Integer sel = tableView.getSelectionModel().getSelectedItem().getId();

                try {
                    Connection conn = dbConnection.DbConnection.getConnection();

// ++++ SPRAWDZENIE UPDATE CZY POPRAWNIE WYPISUJE SIE Z BAZY DANYCH 
                    //String now = "UPDATE `simplemanager_db`.`addevents` SET OK = 'OK' WHERE ID = " + sel + ";";
                    //System.out.println(now);
                    conn.createStatement().executeUpdate("UPDATE `simplemanager_db`.`addevents` SET OK = 'OK' WHERE ID = " + sel + ";");
                    refreshDB();
                    alert(2);
                } catch (Exception e) {

                    System.err.println("Bład z updatem!!");
                }
            }
        });

        // ++++ AKTUALNA DATA W DATEPICKER 
        datePicker.setValue(LocalDate.now());

// ++++ DODAJE EVENT DO BAZY DANYCH I WYPISUJE W TABELI
        addBtnEvents.setOnMouseClicked((MouseEvent event) -> {
            if (addEventTextField.getText().equals("")) {

                alert(1);
            } else if (enddatePicker.getValue() == null) {
                alert(6);
            } else if (datePicker.getValue() == null) {
                alert(6);
            } else {
                try {
                    String kon = enddatePicker.getValue().toString();

                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    LocalDate koniec = LocalDate.parse(kon, formatter);
                    LocalDate dzis = LocalDate.now();
                    long ileminelo = ChronoUnit.DAYS.between(dzis, koniec);

                    Connection connection = dbConnection.DbConnection.getConnection();
                    Statement stm = connection.createStatement();
                    stm.executeUpdate("INSERT INTO `simplemanager_db`.`addevents` ( `DATE`, `EVENT` , `ENDDATE`, `EXPIRES`,`OK` ) VALUES ('" + datePicker.getValue() + "','" + addEventTextField.getText().toUpperCase() + "','" + enddatePicker.getValue() + "','" + ileminelo + "','WAIT');");

                    ResultSet rs = connection.createStatement().executeQuery("SELECT * FROM `simplemanager_db`.`addevents` ;");
                    lista.clear();
                    while (rs.next()) {

                        lista.add(new EventsList(rs.getString("DATE"), rs.getString("EVENT").toUpperCase(), rs.getString("ENDDATE"), rs.getString("EXPIRES"), rs.getString("OK"), rs.getInt("id")));

                    }
                    tableView.setItems(lista);
                    connection.close();
                    alert(7);
                } catch (SQLException ex) {
                    System.err.println("Problem z insertem !");
                }
            }
        });

// ++++ WYPISUJE WSZYSTKIE DANE Z TABELI addevents
        try {

            Connection conn = dbConnection.DbConnection.getConnection();
            ResultSet refresh = conn.createStatement().executeQuery("SELECT * FROM `simplemanager_db`.`addevents` ;");

            while (refresh.next()) {
                Integer id_dodaj = refresh.getInt("ID");
                String koncowa = refresh.getString("ENDDATE");
                LocalDate enddate = LocalDate.parse(koncowa);
                long expires_new = ChronoUnit.DAYS.between(LocalDate.now(), enddate);
                if (expires_new <= 0) {
                    conn.createStatement().executeUpdate("UPDATE `simplemanager_db`.`addevents` SET `EXPIRES` = 'EXPIRE' WHERE `id` = " + id_dodaj + ";");
                } else {
                    conn.createStatement().executeUpdate("UPDATE `simplemanager_db`.`addevents` SET `EXPIRES` = " + expires_new + " WHERE `id` = " + id_dodaj + ";");
                }
            }
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM `simplemanager_db`.`addevents` ;");
            while (rs.next()) {

                lista.add(new EventsList(rs.getString("DATE"), rs.getString("EVENT").toUpperCase(), rs.getString("ENDDATE"), rs.getString("EXPIRES"), rs.getString("OK"), rs.getInt("id")));

            }
            conn.close();
        } catch (SQLException ex) {
            System.err.println("Błąd SQL !");
        }
// ++++ NAZWY "data" i "event" ODWOLUJA SIE DO EVENTLIST WAZNA WIELKOSC LITER!!!!       
        columnt_DATA.setCellValueFactory(new PropertyValueFactory<String, EventsList>("data"));
        column_EVENT.setCellValueFactory(new PropertyValueFactory<String, EventsList>("event"));
        column_END_DATE.setCellValueFactory(new PropertyValueFactory<String, EventsList>("enddate"));
        column_EXPIRES.setCellValueFactory(new PropertyValueFactory<Integer, EventsList>("expires"));
        column_OK.setCellValueFactory(new PropertyValueFactory<String, EventsList>("ok"));
        tableView.setItems(lista);

        try {
            dbConnection.DbConnection.getConnection().close();
        } catch (SQLException ex) {
            System.err.println("Problem z połączeniem !");
        }

        note.setOnMouseClicked((MouseEvent event) -> {
            boolean bool_notepad = true;
            if(bool_notepad == true){
            try {
                Runtime.getRuntime().exec("cmd /c start notepad.exe");
            } catch (IOException ex) {
                System.err.println("Problem z notatnikiem !");
            }
            }else {
                alert(10);
            
            }
        });

        calculator.setOnMouseClicked((MouseEvent event) -> {
            boolean bool_cal = true; 
            if(bool_cal == true){
            try {
                Runtime.getRuntime().exec("cmd /c start calc");
            } catch (IOException ex) {
                System.err.println("Problem z kalkulatorem !");
            }
            }else {
                alert(10);
            }
        });
        cmd.setOnMouseClicked((MouseEvent event) -> {
            boolean bool_cmd = true;
            if(bool_cmd == true){
            try {
                Runtime.getRuntime().exec("cmd /c start cmd");
            } catch (IOException ex) {
                System.err.println("Problem z cmd !");
            }
            }else {
                alert(10);
            }
        });

// ++++ DRUKARKI WYWOLYWANE PRZEZ IEXPLORER PO IP         
        qc225dw.setOnMouseClicked((MouseEvent event) -> {

            try {
                Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe \"http://10.48.16.42\"");
            } catch (IOException ex) {
                System.err.println("Błąd połączenie QC DELL 225DW");
            }

        });

        ce2335.setOnMouseClicked((MouseEvent event) -> {

            try {
                Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe \"http://10.48.15.30\"");
            } catch (IOException ex) {
                System.err.println("Błąd połączenie CE DELL 2335");
            }

        });

        ceMP2004.setOnMouseClicked((MouseEvent event) -> {

            try {
                Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe \"http://10.48.15.42\"");
            } catch (IOException ex) {
                System.err.println("Błąd połączenie CE MP 2004 RICOH");
            }

        });

        km958.setOnMouseClicked((MouseEvent event) -> {

            try {
                Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe \"http://10.48.15.45\"");
            } catch (IOException ex) {
                System.err.println("Błąd połączenie CE Konica Minolta 958");
            }

        });

        ceMPC307.setOnMouseClicked((MouseEvent event) -> {

            try {
                Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe \"http://10.48.15.31\"");
            } catch (IOException ex) {
                System.err.println("Błąd połączenie CE RICOH MP307 Podgór. Monika");
            }

        });

        ce521winmod.setOnMouseClicked((MouseEvent event) -> {

            try {
                Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe \"http://10.48.15.44\"");
            } catch (IOException ex) {
                System.err.println("Błąd połączenie CE 521 Winmod");
            }

        });

        ce8210gacia.setOnMouseClicked((MouseEvent event) -> {

            try {
                Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe \"http://10.48.16.220\"");
            } catch (IOException ex) {
                System.err.println("Błąd połączenie CE Pawła Gąciar. 8210");
            }

        });

        hr521DNrecepcja.setOnMouseClicked((MouseEvent event) -> {

            try {
                Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe \"http://10.48.12.43\"");
            } catch (IOException ex) {
                System.err.println("Błąd połączenie HR recepcja 521");
            }

        });

        puEpson7015.setOnMouseClicked((MouseEvent event) -> {

            try {
                Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe \"http://10.48.16.221\"");
            } catch (IOException ex) {
                System.err.println("Błąd połączenie PU EPSON W7015");
            }

        });

        puCanon4045.setOnMouseClicked((MouseEvent event) -> {
            try {
                Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe \"http://10.48.16.21:8000\"");
            } catch (IOException ex) {
                System.err.println("Błąd połączenie PU CANON 4045");
            }

        });

        mp8210pyr.setOnMouseClicked((MouseEvent event) -> {
            try {
                Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe \"http://10.48.16.12\"");
            } catch (IOException ex) {
                System.err.println("Błąd połączenie MP Krzysztof Pyr. 8210");
            }

        });
        pu8210blasz.setOnMouseClicked((MouseEvent event) -> {
            try {
                Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe \"http://10.48.16.11\"");
            } catch (IOException ex) {
                System.err.println("Błąd połączenie PU Krzysztof Blasz. 8210");
            }

        });
        pu8210.setOnMouseClicked((MouseEvent event) -> {
            try {
                Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe \"http://10.48.16.22\"");
            } catch (IOException ex) {
                System.err.println("Błąd połączenie PU u Anity 8210");
            }

        });
        pu521dn.setOnMouseClicked((MouseEvent event) -> {
            try {
                Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe \"http://10.48.16.24\"");
            } catch (IOException ex) {
                System.err.println("Błąd połączenie PU u Oli 521DN");
            }

        });

        mpMP4001.setOnMouseClicked((MouseEvent event) -> {

            try {
                Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe \"http://10.48.16.228\"");
            } catch (IOException ex) {
                System.err.println("Błąd połączenie MP CANON 4235 poczta");
            }

        });

        mpCanon4235.setOnMouseClicked((MouseEvent event) -> {

            try {
                Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe \"http://10.48.16.234:8000\"");
            } catch (IOException ex) {
                System.err.println("Błąd połączenie MP CANON 4235 poczta");
            }

        });

        mp7110.setOnMouseClicked((MouseEvent event) -> {

            try {
                Runtime.getRuntime().exec("\"C:\\\\Program Files\\\\Internet Explorer\\\\iexplore.exe \\\"http://10.48.16.232\\\"\"");
            } catch (IOException e) {
                System.err.println("Błąd połączenia MP 7110");
            }

        });

        meMP4002.setOnMouseClicked((MouseEvent event) -> {
            try {
                Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe \"http://10.48.15.37\"");
            } catch (IOException ex) {
                System.err.println("Błąd połączenie ME MP CANON nad pocztą");
            }

        });

        meCanon6255.setOnMouseClicked((MouseEvent event) -> {
            try {
                Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe \"http://10.48.12.46\"");
            } catch (IOException ex) {
                System.err.println("Błąd połączenie ME MP CANON SAMOLOTY");
            }

        });

        meMP9003plot.setOnMouseClicked((MouseEvent event) -> {

            try {
                Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe \"http://10.48.10.237\"");
            } catch (IOException ex) {
                System.err.println("Błąd połączenie ME MP 9003  ploterownia");
            }

        });

        meMP90031ME.setOnMouseClicked((MouseEvent event) -> {

            try {
                Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe \"http://10.48.12.45\"");
            } catch (IOException ex) {
                System.err.println("Błąd połączenie ME MP 9003 I piętro");
            }

        });

        mePW750.setOnMouseClicked((MouseEvent event) -> {

            try {
                Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe \"http://10.48.10.42\"");
            } catch (IOException ex) {
                System.err.println("Błąd połączenie ME PLOT WAWVE 750");
            }

        });

        ep521bru.setOnMouseClicked((MouseEvent event) -> {
            try {
                Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe \"http://10.48.16.37\"");
            } catch (IOException ex) {
                System.err.println("Błąd połączenie EP 521 Bru.");
            }

        });

        epMP3555.setOnMouseClicked((MouseEvent event) -> {

            try {
                Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe \"http://10.48.16.23\"");
            } catch (IOException ex) {
                System.err.println("Błąd połączenie EP 3555");
            }

        });

        epMP9003.setOnMouseClicked((MouseEvent event) -> {

            try {
                Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe \"http://10.48.16.45\"");
            } catch (IOException ex) {
                System.err.println("Błąd połączenie EP MP9003");
            }

        });

        hr8100.setOnMouseClicked((MouseEvent event) -> {

            try {
                Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe \"http://10.48.10.54\"");
            } catch (IOException ex) {
                System.err.println("Błąd połączenie HR 8100");
            }

        });

        hr521DN.setOnMouseClicked((MouseEvent event) -> {

            try {
                Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe \"http://10.48.10.53\"");
            } catch (IOException ex) {
                System.err.println("Błąd połączenie HR 521DN");
            }
        });

        ep2335.setOnMouseClicked((MouseEvent event) -> {
            try {
                Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe \"http://10.48.16.43\"");
            } catch (IOException ex) {
                System.err.println("Błąd połączenie EP DELL 2335");
            }

        });

        bhp8210.setOnMouseClicked((MouseEvent event) -> {
            try {
                Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe \"http://10.48.16.28\"");
            } catch (IOException ex) {
                System.err.println("Błąd połączenie BHP hp 8210");
            }
        });

        bhp521DN.setOnMouseClicked((MouseEvent event) -> {
            try {
                Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe \"http://10.48.16.27\"");
            } catch (IOException ex) {
                System.err.println("Błąd połączenie BHP 521DN");
            }
        });

        ae7110.setOnMouseClicked((MouseEvent event) -> {
            try {
                Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe \"http://10.48.12.249\"");
            } catch (IOException ex) {
                System.err.println("Błąd połączenie AE 7110 biuro");
            }
        });

        ae521dn.setOnMouseClicked((MouseEvent event) -> {
            try {
                Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe \"http://10.48.15.46\"");
            } catch (IOException ex) {
                System.err.println("Błąd połączenie AE nad pocztą 521");
            }
        });

        lwmag521.setOnMouseClicked((MouseEvent event) -> {
            try {
                Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe \"http://10.48.16.26\"");
            } catch (IOException ex) {
                System.err.println("Błąd połączenie mag Flexi 521DN");
            }
        });

        lwe3521.setOnMouseClicked((MouseEvent event) -> {
            try {
                Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe \"http://10.48.16.41\"");
            } catch (IOException ex) {
                System.err.println("Błąd połączenie LW 521 łącznik E3");
            }
        });

        lw521.setOnMouseClicked((MouseEvent event) -> {
            try {
                Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe \"http://10.48.16.48\"");
            } catch (IOException ex) {
                System.err.println("Błąd połączenie LW 521 biuro");
            }
        });

        lsK5400.setOnMouseClicked((MouseEvent event) -> {
            try {
                Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe \"http://10.48.16.233\"");
            } catch (IOException ex) {
                System.err.println("Błąd połączenie LS K5400");
            }
        });

        lsHP8210.setOnMouseClicked((MouseEvent event) -> {
            try {
                Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe \"https://10.48.16.223/#hId-pgConsumables\"");
            } catch (IOException ex) {
                System.err.println("Błąd połączenie LS 8210");
            }
        });

        ls1HP521.setOnMouseClicked((Event event) -> {
            try {
                Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe \"http://10.48.16.30\"");
            } catch (IOException ex) {
                System.err.println("Błąd połączenie LS1 521");
            }
        });

        ls2HP521.setOnMouseClicked((MouseEvent event) -> {
            try {
                Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe \"http://10.48.16.38\"");
            } catch (IOException ex) {
                System.err.println("Błąd połączenie LS2 521");
            }
        });

        cc521.setOnMouseClicked((MouseEvent event) -> {
            try {
                Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe \"http://10.48.12.40\"");
            } catch (IOException ex) {
                System.err.println("Błąd połączenie z 521 CC");
            }
        });

        CC8100.setOnMouseClicked((MouseEvent event) -> {
            try {
                Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe \"http://10.48.12.48\"");
            } catch (IOException ex) {
                System.err.println("Błąd połączenie z 8100 CC");
            }
        });

        board2004.setOnMouseClicked((MouseEvent event) -> {
            try {
                Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe \"http://10.48.12.49\"");
            } catch (IOException ex) {
                System.err.println("Błąd połączenie z BOARD MP2004");
            }
        });

        board7110.setOnMouseClicked((MouseEvent event) -> {
            try {
                Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe \"http://10.48.10.51\"");
            } catch (IOException ex) {
                System.err.println("Błąd połączenie z BOARD 7110");
            }
        });

        at521.setOnMouseClicked((MouseEvent event) -> {
            try {
                Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe \"http://10.48.10.52\"");
            } catch (IOException ex) {
                System.err.println("Błąd połączenie z AT 521DN");
            }
        }); // KONIEC DODANYCH DRUKAREK

// ++++ LOGO APLIKACJI        
        logo.setImage(new Image("/img/simple.png"));

// ++++ FOCUS PRZY PINGOWANIU HOSTÓW AKTYWNY PRZY STARCIE APLIKACJI        
        focusTextField(compName);

// ++++ FOCUS PRZY PINOGWANIU HOSTOW         
        pingHostTab.setOnSelectionChanged((Event event) -> {
            focusTextField(compName);
            compName.setText("");
        });

// ++++ FOCUS NA KOPIOWANIU FOLDERÓW
        copyFileTab.setOnSelectionChanged((Event event) -> {
            focusTextField(foldersTextField);
            foldersTextField.setText("");
        });

// ++++ SZUKAJ PRZYCISK          
        searchTextF.setOnKeyReleased((KeyEvent event) -> {
             
                
                SortedList<EventsList> sortedData = new SortedList<>(filteredData);
                sortedData.comparatorProperty().bind(tableView.comparatorProperty());
                tableView.setItems(sortedData);
                
                SortedList<PrintersList> sortedPrinters = new SortedList<>(filtredPrinters);
                sortedPrinters.comparatorProperty().bind(tableView2.comparatorProperty());
                tableView2.setItems(sortedPrinters);
            
        });

// ++++ DONE PRZYCISK Z EXIT EVENT
        doneBtn.setOnMouseClicked((MouseEvent event) -> {
            exit();
        });

// ++++ KOPIOWANIE PLIKÓW        
        copyBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                try {

                    File zrodlo = new File("D://NEW-Template");
                    File cel = new File(copyTextField.getText());

                    copyFolder(zrodlo, cel);

                } catch (IOException ex) {
                    alert(4);
                    System.err.println("Błąd! kopiowania katalogów!");
                }

            }

            private void copyFolder(File zrodlo, File cel) throws IOException {

                if (zrodlo.isDirectory()) {
                    //Verify if destinationFolder is already present; If not then create it
                    if (!cel.exists()) {
                        cel.setReadable(true);
                        cel.setExecutable(true);
                        cel.setWritable(true);
                        
                        cel.mkdir();
                        System.out.println("Create :: " + cel);
                    } else if (cel.exists()) {
                        areaCopy.setText("Alert this files exsist ! Check the path file !");
                    }
                    //Get all files from source directory
                    String files[] = zrodlo.list();

                    //Iterate over all files and copy them to destinationFolder one by one
                    for (String file : files) {
                        File srcFile = new File(zrodlo, file);
                        File destFile = new File(cel, file);
                        //Recursive function call
                        copyFolder(srcFile, destFile);
                    }
                } else {

                    //Copy the file content from one place to another
                    String skopiowano = "Copy files : \n";
                    Files.copy(zrodlo.toPath(), cel.toPath());
                    // Stream list of text area
                    wypiszdane += cel.toString() + "\n";
                    
                    String gotowe ="Gotowe!";

                    System.out.println("Copy files :: " + cel);
                    areaCopy.setText(skopiowano + wypiszdane + gotowe);
                    

                }
            }
        });

// ++++ EXIT PRZYCISK WYJSCIE Z PROGRAMU        
        exitBtn.setOnMouseClicked((MouseEvent event) -> {
            exit();
        });

    } // ++++ END LINE OF INITIALIZE 

    @FXML
    private void HostNameKeyEvent(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            if (compName.getText().equals("")) {

                alert(5);
            } else {
                String ip = compName.getText();
                pingCommand("ping -a " + ip);
            }
        }

    }

    private void pingCommand(String command) {

        try {
            Process p = Runtime.getRuntime().exec(command);
            BufferedReader inputStream = new BufferedReader(
                    new InputStreamReader(p.getInputStream()));

            String s = "";
            String koniec = "\nDone!";
            String wynik = "";
            // reading output stream of the command

            while ((s = inputStream.readLine()) != null) {
                wynik += s;
                wynik += "\n";
                area.setText(wynik + koniec);
            }

        } catch (IOException e) {
            System.err.println("Błąd połączenia!");
        }
    }

// ++++ ZAMYKANIE APLIKACJI 
    public void exit() {

        Platform.exit();

    }

// ++++ FOCUS NA POLACH TEKSTOWYCH
    public void focusTextField(JFXTextField nazwa_textfield) {

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                nazwa_textfield.requestFocus();
            }
        });

    }

    // ++++ TWORZENIE FOLDERÓW PRZYCIESK 
    @FXML
    private void createBtnEvent(MouseEvent event) {

        if (foldersTextField.getText().equals("")) {

            alert(3);
        }
    }

    @FXML
    private void EexitBtnEvent(MouseEvent event) {
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

    @FXML
    private void close(MouseEvent event) {

        Platform.exit();
    }

    @FXML
    private void maxWindow(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setResizable(false);
        stage.setMaximized(true);
        stage.setFullScreen(true);
    }

    @FXML
    private void minWindow(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setFullScreenExitHint("");
        stage.setIconified(true);
    }

    @FXML
    private void doneContextMenuEvent(ActionEvent event) {
        Integer sel = tableView.getSelectionModel().getSelectedItem().getId();

        try {
            Connection conn = dbConnection.DbConnection.getConnection();

// ++++ SPRAWDZENIE UPDATE CZY POPRAWNIE WYPISUJE SIE Z BAZY DANYCH 
            //String now = "UPDATE `simplemanager_db`.`addevents` SET OK = 'OK' WHERE ID = " + sel + ";";
            //System.out.println(now);
            conn.createStatement().executeUpdate("UPDATE `simplemanager_db`.`addevents` SET OK = 'OK' WHERE ID = " + sel + ";");
            refreshDB();
            alert(2);
        } catch (Exception e) {

            System.err.println("Bład z updatem!!");
        }

    }

    
    
    @FXML
    private void refreshContextMenuEvent(ActionEvent event) {
        if (tableView.getSelectionModel().getSelectedItem() == null) {

                alert(8);

            } else {
        try {
            refreshDB();
        } catch (Exception e) {
            System.err.println("Problem z refreshDB w contextMenuEven !");
        }
    }
    }
    @FXML
    private void editContextMenuEvent(ActionEvent event) {
        if (tableView.getSelectionModel().getSelectedItem() == null) {

                alert(8);

            } else {
        
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/editWindow/editWindow.fxml"));
            Parent root = (Parent) fxmlLoader.load();
             EditWindowController editwindow = fxmlLoader.getController();
            //Pass whatever data you want. You can have multiple method calls here
            editwindow.betweenControllers(tableView.getSelectionModel().getSelectedItem());
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Edit Event");
            stage.getIcons().add(new Image("/img/simple.png"));
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.show();

        } catch (IOException ex) {
            System.err.println("Błąd z załadowaniem FXML'a editWindow.FXML !");
        }
    }
    }
    @FXML
    private void deleteContextMenuEvent(ActionEvent event) throws SQLException {
        if (tableView.getSelectionModel().getSelectedItem() == null) {

                alert(8);

            } else {
        Integer delrow = tableView.getSelectionModel().getSelectedItem().getId();

        lista.remove(delrow);

        Connection conn = dbConnection.DbConnection.getConnection();
        conn.createStatement().executeUpdate("DELETE FROM `simplemanager_db`.`addevents` WHERE ID = " + delrow + ";");

        refreshDB();
        alert(0);
    }
    }
      @FXML
    private void refreshContexeMEventPrinters(ActionEvent event) {
           if (tableView2.getSelectionModel().getSelectedItem() == null) {

                alert(8);

            } else {
        try {
            refreshDbPrinters();
        } catch (Exception e) {
            System.err.println("Problem z refreshDB w contextMenuEven !");
        }
    }
    }

    @FXML
    private void editContextMEventPrinters(ActionEvent event) {
         if (tableView2.getSelectionModel().getSelectedItem() == null) {

                alert(8);

            } else {
        
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/editPrinters/editPrinters.fxml"));
            Parent root = (Parent) fxmlLoader.load();
             EditPrintersController printersWindow = fxmlLoader.getController();
            //Pass whatever data you want. You can have multiple method calls here
            printersWindow.betweenFXMLandPrinters(tableView2.getSelectionModel().getSelectedItem());
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Edit Printer");
            stage.getIcons().add(new Image("/img/simple.png"));
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.show();

        } catch (IOException ex) {
            System.err.println("Błąd z załadowaniem FXML'a editWindow.FXML !");
        }
    }
          
    }

    @FXML
    private void deleteContextMEventPrinters(ActionEvent event) throws SQLException {
          if (tableView2.getSelectionModel().getSelectedItem() == null) {

                alert(8);

            } else {
        Integer delrow = tableView2.getSelectionModel().getSelectedItem().getIdprinters();

        listaDrukarek.remove(delrow);

        Connection conn = dbConnection.DbConnection.getConnection();
        conn.createStatement().executeUpdate("DELETE FROM `simplemanager_db`.`printers` WHERE IDPRINTERS = " + delrow + ";");

        refreshDbPrinters();
        conn.close();
        alert(0);
    }
    }
    public void refreshDB() throws SQLException {
        Connection conn = dbConnection.DbConnection.getConnection();
        lista.clear();
        ResultSet ref = conn.createStatement().executeQuery("SELECT * FROM `simplemanager_db`.`addevents`");
        while (ref.next()) {

            lista.add(new EventsList(ref.getString("DATE"), ref.getString("EVENT").toUpperCase(), ref.getString("ENDDATE"), ref.getString("EXPIRES"), ref.getString("OK"), ref.getInt("id")));
        }
        conn.close();
    }
    
    public void refreshDbPrinters() throws SQLException{
    
    Connection connection = dbConnection.DbConnection.getConnection();
    listaDrukarek.clear();
    ResultSet refresh = connection.createStatement().executeQuery("SELECT * FROM `simplemanager_db`.`printers`");
    
    while(refresh.next()){
    
        listaDrukarek.add(new PrintersList(refresh.getInt("IDPRINTERS"), refresh.getString("DZIAL"), refresh.getString("MODEL"), refresh.getString("RODZAJ_TUSZU"), refresh.getString("IP"), refresh.getString("INFO")));
    }
    connection.close();
    
    }
    

    public void alert(Integer liczba) {

        notifier = NotifierBuilder.create()
                .width(400)
                .height(100)
                .popupLocation(Pos.BOTTOM_RIGHT)
                .popupLifeTime(Duration.millis(5000))
                .styleSheet(getClass().getResource("style.css").toExternalForm())
                .build();
       
        notifier.notify(NOTIFICATIONS[liczba]);
        
    }

    @FXML
    private void createPrintersBtn(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/addPrinters/addPrinters.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Add Printer");
            stage.getIcons().add(new Image("/img/simple.png"));
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.show();

        } catch (IOException ex) {
            System.err.println("Błąd z załadowaniem FXML'a addPrinters.FXML !");
        }
    }

    @FXML
    private void AddContextMEventPrinters(ActionEvent event) {
          
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/addPrinters/addPrinters.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Add Printer");
            stage.getIcons().add(new Image("/img/simple.png"));
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.show();

        } catch (IOException ex) {
            System.err.println("Błąd z załadowaniem FXML'a addPrinters.FXML !");
        }
    }

  
}
