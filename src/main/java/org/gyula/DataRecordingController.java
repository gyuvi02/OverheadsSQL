package org.gyula;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class DataRecordingController {

    @FXML
    public Label address;

    @FXML
    private Button returnButton;

    @FXML
    private Button saveButton;

    @FXML
    private void saveData() {

    }

    @FXML
    private void returnMain() {
        Stage ablak = (Stage) returnButton.getScene().getWindow();
        ablak.close();
    }

}
