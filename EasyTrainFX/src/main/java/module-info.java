module fr.esiee.easytrainfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens fr.esiee to javafx.fxml;
    exports fr.esiee;
    exports fr.esiee.easytrainfx;
    opens fr.esiee.easytrainfx to javafx.fxml;
}