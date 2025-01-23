package fr.esiee.dao;

import fr.esiee.modele.Utilisateur;
import fr.esiee.modele.Role;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UtilisateurDAO {

    private final Connection connection;

    public UtilisateurDAO(Connection connection) {
        this.connection = connection;
    }

    // Méthode pour ajouter un utilisateur
    public void ajouterUtilisateur(Utilisateur utilisateur) throws SQLException {
        String query = "INSERT INTO Utilisateur (login, mdp, nom, prenom, dateEmbauche, role) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, utilisateur.getLogin());
            stmt.setString(2, utilisateur.getMdp());
            stmt.setString(3, utilisateur.getNom());
            stmt.setString(4, utilisateur.getPrenom());
            stmt.setTimestamp(5, Timestamp.valueOf(utilisateur.getDateEmbauche()));
            stmt.setString(6, utilisateur.getRole().name());
            stmt.executeUpdate();
            System.out.println("Utilisateur ajouté avec succès !");
        }
    }

    // Méthode pour récupérer un utilisateur par ID
    public Utilisateur lireUtilisateur(int id) throws SQLException {
        String query = "SELECT * FROM Utilisateur WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Utilisateur(
                        rs.getInt("id"),
                        rs.getString("login"),
                        rs.getString("mdp"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getTimestamp("dateEmbauche").toLocalDateTime(),
                        Role.valueOf(rs.getString("role"))
                );
            }
        }
        return null;
    }

    // Méthode pour récupérer tous les utilisateurs
    public List<Utilisateur> lireTousLesUtilisateurs() throws SQLException {
        List<Utilisateur> utilisateurs = new ArrayList<>();
        String query = "SELECT * FROM Utilisateur";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Utilisateur utilisateur = new Utilisateur(
                        rs.getInt("id"),
                        rs.getString("login"),
                        rs.getString("mdp"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getTimestamp("dateEmbauche").toLocalDateTime(),
                        Role.valueOf(rs.getString("role"))
                );
                utilisateurs.add(utilisateur);
            }
        }
        return utilisateurs;
    }

    // Méthode pour mettre à jour un utilisateur
    public void mettreAJourUtilisateur(Utilisateur utilisateur) throws SQLException {
        String query = "UPDATE Utilisateur SET login = ?, mdp = ?, nom = ?, prenom = ?, dateEmbauche = ?, role = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, utilisateur.getLogin());
            stmt.setString(2, utilisateur.getMdp());
            stmt.setString(3, utilisateur.getNom());
            stmt.setString(4, utilisateur.getPrenom());
            stmt.setTimestamp(5, Timestamp.valueOf(utilisateur.getDateEmbauche()));
            stmt.setString(6, utilisateur.getRole().name());
            stmt.setInt(7, utilisateur.getId());
            stmt.executeUpdate();
            System.out.println("Utilisateur mis à jour avec succès !");
        }
    }

    // Méthode pour supprimer un utilisateur par ID
    public void supprimerUtilisateur(int id) throws SQLException {
        String query = "DELETE FROM Utilisateur WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Utilisateur supprimé avec succès !");
        }
    }
}
