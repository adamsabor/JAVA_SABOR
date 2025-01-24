module fr.esiee.easytrainfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens fr.esiee to javafx.fxml;
    opens fr.esiee.easytrainfx to javafx.fxml, javafx.graphics;
    exports fr.esiee;
    exports fr.esiee.dao;
    exports fr.esiee.modele;
    exports fr.esiee.easytrainfx;
}