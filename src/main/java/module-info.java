module org.gyula {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens org.gyula to javafx.fxml;
    exports org.gyula;
}