package fr.esiee.javafxtest;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML
    private TextField tf_inputName; // Champ de saisie pour le nom de l'utilisateur

    @FXML
    private Label l_welcomeText; // Label pour afficher le message

    @FXML
    protected void onHelloButtonClick() {
        // 1. Récupérer le texte saisi dans le champ TextField
        String inputName = tf_inputName.getText().trim();

        // 2. Vérifier si le nom est saisi
        if (inputName.isEmpty()) {
            // Si le champ est vide, afficher un message d'erreur en rouge
            l_welcomeText.setText("Erreur.. saisir votre nom");
            l_welcomeText.setStyle("-fx-text-fill: red;"); // Couleur par rougeez
        } else {
            // Si un nom est saisi, afficher un message de bienvenue
            l_welcomeText.setText("Bienvenue, " + inputName + " !");
            l_welcomeText.setStyle("-fx-text-fill: black;"); // Couleur par défaut
        }
    }
}
