package fr.esiee.easytrainfx;

import fr.esiee.dao.EasyTrainDAO;
import fr.esiee.modele.Arret;
import fr.esiee.modele.TypeArret;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.sql.SQLException;

public class AjoutArretController {
    @FXML private TextField nomArret;
    @FXML private ComboBox<TypeArret> typeArret;
    @FXML private Label messageLabel;

    private EasyTrainDAO dao;

    @FXML
    public void initialize() {
        // Initialisation du DAO
        dao = new EasyTrainDAO();

        // Remplissage de la ComboBox avec les types d'arrêt
        typeArret.getItems().addAll(TypeArret.values());

        // Sélection par défaut
        typeArret.setValue(TypeArret.INTERMEDIAIRE);
    }

    @FXML
    protected void onAjouterClick() {
        // Récupération des valeurs
        String nom = nomArret.getText().trim();
        TypeArret type = typeArret.getValue();

        // Validation des champs
        if(nom.isEmpty()) {
            afficherErreur("Le nom de l'arrêt est obligatoire");
            return;
        }

        try {
            // Vérification si l'arrêt existe déjà
            if(dao.arretExiste(nom)) {
                afficherErreur("Un arrêt avec ce nom existe déjà");
                return;
            }

            // Création et ajout de l'arrêt
            Arret arret = new Arret(0, nom, type);
            if(dao.ajouterArret(arret)) {
                afficherSucces("Arrêt ajouté avec succès :\n" +
                        "ID : " + arret.getId() + "\n" +
                        "Nom : " + arret.getNom() + "\n" +
                        "Type : " + arret.getTypeArret());
                reinitialiserFormulaire();
            }
        } catch(SQLException e) {
            afficherErreur("Erreur lors de l'ajout : " + e.getMessage());
        }
    }

    @FXML
    protected void onReinitialiserClick() {
        reinitialiserFormulaire();
        messageLabel.setText("");
    }

    private void reinitialiserFormulaire() {
        nomArret.clear();
        typeArret.setValue(TypeArret.INTERMEDIAIRE);
    }

    private void afficherSucces(String message) {
        messageLabel.setStyle("-fx-text-fill: green");
        messageLabel.setText(message);
    }

    private void afficherErreur(String message) {
        messageLabel.setStyle("-fx-text-fill: red");
        messageLabel.setText(message);
    }
}