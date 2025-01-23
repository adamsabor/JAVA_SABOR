package fr.esiee;

import fr.esiee.modele.Arret;
import fr.esiee.modele.Trajet;
import fr.esiee.modele.Utilisateur;
import fr.esiee.modele.Role;

import java.sql.*;

public class TestJDBC {
<<<<<<< HEAD

    // Connexion AlwaysData (fictive)
    private static final String ALWAYS_DATA_URL = "jdbc:mysql://mysql-12345.alwaysdata.net/fake_database";
    private static final String ALWAYS_DATA_USER = "adamdev";
    private static final String ALWAYS_DATA_PASSWORD = "root";

    // Connexion locale
    private static final String LOCAL_URL = "jdbc:mariadb://localhost:8889/EasyTrain";
    private static final String LOCAL_USER = "root";
    private static final String LOCAL_PASSWORD = "root";

    private final Connection connection;

    public TestJDBC() {
        this.connection = initConnection();
    }

    // Essaie AlwaysData, puis bascule sur la base locale si besoin
    private Connection initConnection() {
        try {
            Connection conn = DriverManager.getConnection(ALWAYS_DATA_URL, ALWAYS_DATA_USER, ALWAYS_DATA_PASSWORD);
            System.out.println("Connexion à AlwaysData établie !");
            return conn;
=======
    public static void main(String[] args) {
        String urlLocal= "jdbc:mariadb://localhost:8889/EasyTrain";
        String userLocal = "root" ;
        String pwdLocal ="root";
        String urlDistant="localhost:3306/EasyTrain";
        String userDistant = "root" ;
        String pwdDistant ="";
       
         String urlAlwaysData = "jdbc:mysql://adamdev.alwaysdata.net:3306/adamdev_database";
         String userAlwaysData = "AdamDev";
        String pwdAlwaysData = "root";
/// creation d'une connexion a la bdd
        try {
            Connection connection = DriverManager.getConnection(
                    urlLocal ,userLocal,pwdLocal);
            System.out.println("OK");
>>>>>>> 3ec60e6cdd8a5c496872082c50d75349f7582412
        } catch (SQLException e) {
            System.out.println("Échec AlwaysData, tentative de connexion locale...");
            try {
                Connection conn = DriverManager.getConnection(LOCAL_URL, LOCAL_USER, LOCAL_PASSWORD);
                System.out.println("Connexion locale établie !");
                return conn;
            } catch (SQLException ex) {
                throw new RuntimeException("Échec de connexion : " + ex.getMessage());
            }
        }
    }

    // Ajoute un utilisateur
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

    // Récupère un utilisateur par ID
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

    // Met à jour un utilisateur
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

    // Supprime un utilisateur par ID
    public void supprimerUtilisateur(int id) throws SQLException {
        String query = "DELETE FROM Utilisateur WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Utilisateur supprimé avec succès !");
        }
    }

    // Ajoute un arrêt
    public void ajouterArret(Arret arret) throws SQLException {
        String query = "INSERT INTO Arret (nom) VALUES (?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, arret.getNom());
            stmt.executeUpdate();
            System.out.println("Arrêt ajouté avec succès !");
        }
    }

    // Ajoute un trajet
    public void ajouterTrajet(Trajet trajet) throws SQLException {
        String query = "INSERT INTO Trajet (code, tempsDepart, tempsArrivee, arretDepart, arretArrivee) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, trajet.getCode());
            stmt.setTimestamp(2, Timestamp.valueOf(trajet.getTempsDepart()));
            stmt.setTimestamp(3, Timestamp.valueOf(trajet.getTempsArrivee()));
            stmt.setInt(4, trajet.getArretDepart().getId());
            stmt.setInt(5, trajet.getArretArrivee().getId());
            stmt.executeUpdate();
            System.out.println("Trajet ajouté avec succès !");
        }
    }

    // Ferme la connexion
    public void fermerConnexion() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
            System.out.println("Connexion fermée !");
        }
    }
<<<<<<< HEAD
}
=======
    }
>>>>>>> 3ec60e6cdd8a5c496872082c50d75349f7582412
