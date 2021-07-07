package org.gyula;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class DataRecordingController {

    MonthlyData data;

    @FXML
    public Label address;

    @FXML
    private Button returnButton;

    @FXML
    private Button saveButton;

    @FXML
    private Label formerGas;

    @FXML
    private Label formerElectricity;

    @FXML
    private Label gasConsumption;

    @FXML
    private Label electricityConsumption;

    @FXML
    private TextField actualGas;


    public void adatTranszfer(String flat) {
        System.out.println(flat);
        try {
            data = DBStuff.getDataForInvoice(flat);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        address.setText(flat);
        formerGas.setText(String.valueOf(data.getGasLast()));
        formerElectricity.setText(String.valueOf(data.getElectricityLast()));

    }

    @FXML
    private void saveData() {

    }

    @FXML
    private void returnMain() {
        Stage ablak = (Stage) returnButton.getScene().getWindow();
        ablak.close();
    }

}
