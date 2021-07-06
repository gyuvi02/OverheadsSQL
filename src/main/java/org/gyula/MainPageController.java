package org.gyula;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class MainPageController {

    @FXML
    private Button quitButton;

    @FXML
    private Button addDataButton;


    @FXML
    private void quit() {
        Stage ablak = (Stage) quitButton.getScene().getWindow();
        App.exit();
        ablak.close();
    }

    @FXML
    private void addData() throws IOException {

        Stage dialog = new Stage();
        dialog.setTitle("Új óraállások megadása");
        Scene scene = new Scene(App.loadFXML("/org/gyula/dataRecording"));
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.setScene(scene);
        dialog.setResizable(false);
        dialog.show();
    }

}
