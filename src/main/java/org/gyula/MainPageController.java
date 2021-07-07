package org.gyula;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class MainPageController implements Initializable {

    @FXML
    private Button quitButton;

    @FXML
    private Button addDataButton;

    @FXML
    private MenuButton pickFlat;

    @FXML
    private ComboBox<String> pickAddress;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            setData();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @FXML
    private void quit() {
        Stage ablak = (Stage) quitButton.getScene().getWindow();
        App.exit();
        ablak.close();
    }
    public void setData() throws SQLException {
        pickAddress.getItems().clear();

        pickAddress.getItems().addAll(DBStuff.getFlatList());

    }

    @FXML
    private void addData() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("dataRecording.fxml"));
        Parent parent = loader.load();
        Scene scene = new Scene(parent);
        DataRecordingController controller = loader.getController();
        controller.adatTranszfer(pickAddress.getValue());
        Stage dialog = new Stage();
        dialog.setTitle("Új óraállások megadása");
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.setScene(scene);
        dialog.setResizable(false);
        dialog.show();
    }

}
