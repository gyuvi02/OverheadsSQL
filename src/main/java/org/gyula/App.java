package org.gyula;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("mainPage"), 500, 250);
        stage.setTitle("Lakás kiválasztása");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void exit() {
        System.exit(0);
    }


    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) throws SQLException {
        System.out.println(DBStuff.getFlatList());
        System.out.println(DBStuff.getDataForInvoice("4032 Debrecen Bem tér 8.").getGasLastDate());
        System.out.println(DBStuff.getDataForInvoice("4032 Debrecen Bem tér 8.").getGasLast());
        System.out.println(DBStuff.getDataForInvoice("4032 Debrecen Bem tér 8.").getElectricityLastDate());
        System.out.println(DBStuff.getDataForInvoice("4032 Debrecen Bem tér 8.").getElectricityLast());

        launch();
    }

}