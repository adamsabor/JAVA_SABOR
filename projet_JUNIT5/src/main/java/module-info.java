module fr.ecole.projet_junit5 {
    requires javafx.controls;
    requires javafx.fxml;


    opens fr.ecole.projet_junit5 to javafx.fxml;
    exports fr.ecole.projet_junit5;
}