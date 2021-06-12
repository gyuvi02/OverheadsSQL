package org.gyula;

import java.io.IOException;
import javafx.fxml.FXML;

public class DataRecording {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}