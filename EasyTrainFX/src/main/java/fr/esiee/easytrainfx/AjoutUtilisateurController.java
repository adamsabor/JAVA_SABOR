package fr.esiee.easytrainfx;

import fr.esiee.dao.EasyTrainDAO;
import fr.esiee.modele.Role;
import fr.esiee.modele.Utilisateur;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.List;

public class AjoutUtilisateurController {

    @FXML
    private TextField nomField;

    @FXML
    private TextField prenomField;

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private ComboBox<Role> roleComboBox;

    @FXML
    private Label statusLabel;

    private final EasyTrainDAO easyTrainDAO = new EasyTrainDAO();

    @FXML
    public void initialize() {
        // Initialiser la ComboBox avec les rôles disponibles
        try {
            List<Role> roles = easyTrainDAO.getAllRoles(); // Méthode DAO pour récupérer les rôles
            roleComboBox.getItems().addAll(roles);
        } catch (Exception e) {
            statusLabel.setText("Erreur lors du chargement des rôles !");
            statusLabel.setStyle("-fx-text-fill: red;");
            e.printStackTrace();
        }
    }

    @FXML
    public void handleReset() {
        // Réinitialiser tous les champs
        nomField.clear();
        prenomField.clear();
        emailField.clear();
        passwordField.clear();
        roleComboBox.getSelectionModel().clearSelection();
        statusLabel.setText("");
    }

    @FXML
    public void handleAdd() {
        // Vérifier les champs
        String nom = nomField.getText();
        String prenom = prenomField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();
        Role role = roleComboBox.getValue();

        if (nom.isEmpty() || prenom.isEmpty() || email.isEmpty() || password.isEmpty() || role == null) {
            statusLabel.setText("Veuillez remplir tous les champs !");
            statusLabel.setStyle("-fx-text-fill: red;");
            return;
        }

        // Créer l'utilisateur
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setNom(nom);
        utilisateur.setPrenom(prenom);
        utilisateur.setEmail(email);
        utilisateur.setPassword(password);
        utilisateur.setRole(role);

        try {
            // Ajouter l'utilisateur via DAO
            boolean success = easyTrainDAO.ajouterUtilisateur(utilisateur);

            if (success) {
                statusLabel.setText("Utilisateur ajouté avec succès !");
                statusLabel.setStyle("-fx-text-fill: green;");
                handleReset(); // Réinitialiser les champs après l'ajout
            } else {
                statusLabel.setText("Erreur lors de l'ajout de l'utilisateur.");
                statusLabel.setStyle("-fx-text-fill: red;");
            }
        } catch (Exception e) {
            statusLabel.setText("Erreur lors de l'ajout : " + e.getMessage());
            statusLabel.setStyle("-fx-text-fill: red;");
            e.printStackTrace();
        }
    }
}
