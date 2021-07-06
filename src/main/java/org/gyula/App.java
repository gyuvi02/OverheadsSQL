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

    public static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) throws SQLException {
        MonthlyData lakas = DBStuff.getDataForInvoice("4032 Debrecen Komlóssy út 62.");
        double aktualisGaz = 3587.233;
        double elozoGaz = lakas.getGasLast();
        int kulonbseg = (int) Math.round((aktualisGaz - elozoGaz) * 100);
        System.out.println("Fogyasztás: " + (double) kulonbseg/100);
        System.out.println(lakas.getGasLastDate());
        System.out.println(aktualisGaz);
        System.out.println(lakas.getElectricityLastDate());
        System.out.println(lakas.getElectricityLast());

        launch();
    }

}