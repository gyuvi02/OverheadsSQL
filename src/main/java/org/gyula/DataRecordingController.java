package org.gyula;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class DataRecordingController {
    @FXML
    private Button quitButton;


    @FXML
    private void quit() {
        Stage ablak = (Stage) quitButton.getScene().getWindow();
        App.exit();
        ablak.close();
    }

    @FXML
    private void returnMain() throws IOException {
        App.setRoot("mainPage");
    }

}
