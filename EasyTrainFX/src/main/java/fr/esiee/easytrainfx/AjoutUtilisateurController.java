package fr.esiee.easytrainfx;

import fr.esiee.dao.EasyTrainDAO;   // Changé de UtilisateurDAO à EasyTrainDAO
import fr.esiee.modele.Utilisateur;
import fr.esiee.modele.Role;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.time.LocalDateTime;
import java.sql.SQLException;

public class AjoutUtilisateurController {
    @FXML private TextField loginField;
    @FXML private PasswordField passwordField;
    @FXML private TextField nomField;
    @FXML private TextField prenomField;
    @FXML private ComboBox<Role> roleCombo;
    @FXML private Label messageLabel;

    private EasyTrainDAO dao = new EasyTrainDAO();  // Changé ici aussi

    @FXML
    public void initialize() {
        // Remplir la combo box avec les valeurs de l'enum Role
        roleCombo.getItems().addAll(Role.values());
    }

    @FXML
    protected void onAjouterClick() {
        try {
            Utilisateur user = new Utilisateur(
                    0,
                    loginField.getText(),
                    passwordField.getText(),
                    nomField.getText(),
                    prenomField.getText(),
                    LocalDateTime.now(),
                    roleCombo.getValue()
            );

            if(dao.ajouterUtilisateur(user)) {
                messageLabel.setText("Utilisateur ajouté avec succès !");
                viderChamps();
            }
        } catch (SQLException e) {
            messageLabel.setText("Erreur : " + e.getMessage());
        }
    }

    @FXML
    protected void onReinitialiserClick() {
        viderChamps();
        messageLabel.setText("");
    }

    private void viderChamps() {
        loginField.clear();
        passwordField.clear();
        nomField.clear();
        prenomField.clear();
        roleCombo.setValue(null);
    }
}