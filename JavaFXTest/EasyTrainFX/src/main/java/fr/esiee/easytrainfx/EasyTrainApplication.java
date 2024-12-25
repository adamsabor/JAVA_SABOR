package fr.esiee.easytrainfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class EasyTrainApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        // Charger la vue FXML
        FXMLLoader fxmlLoader = new FXMLLoader(EasyTrainApplication.class.getResource("ajoutUtilisateur-view.fxml"));

        // Définir la scène avec une taille adaptée
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);

        // Paramétrer la fenêtre
        stage.setTitle("EasyTrain - Ajout d'un Utilisateur");
        stage.setScene(scene);
        stage.setResizable(false); // Empêcher le redimensionnement de la fenêtre
        stage.show();
    }

    public static void main(String[] args) {
        // Lancer l'application
        launch();
    }
}
