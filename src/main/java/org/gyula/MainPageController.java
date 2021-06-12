package org.gyula;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class MainPageController {

    @FXML
    private Button quitButton;

    @FXML
    private Button addDataButton;


    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

    @FXML
    private void quit() {
        Stage ablak = (Stage) quitButton.getScene().getWindow();
        App.exit();
        ablak.close();
    }

    @FXML
    private void addData() throws IOException {
        App.setRoot("dataRecording");
    }

}
