package fr.esiee.dao;

import fr.esiee.modele.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EasyTrainDAO {
    // Méthode de connexion à la base de données avec les paramètres MAMP
    private Connection getConnexion() throws SQLException {
        String url = "jdbc:mysql://localhost:8889/EasyTrain";
        String user = "root";
        String password = "";
        return DriverManager.getConnection(url, user, password);
    }

    // Méthodes pour la gestion des Utilisateurs
    public Utilisateur getUtilisateurById(int id) throws SQLException {
        Connection conn = getConnexion();
        String sql = "SELECT * FROM Utilisateur WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            Utilisateur u = new Utilisateur(
                    rs.getInt("id"),
                    rs.getString("login"),
                    rs.getString("mdp"),
                    rs.getString("nom"),
                    rs.getString("prenom"),
                    rs.getTimestamp("dateEmbauche").toLocalDateTime(),
                    Role.valueOf(rs.getString("role"))
            );
            conn.close();
            return u;
        }
        conn.close();
        return null;
    }

    public List<Utilisateur> getAllUtilisateurs() throws SQLException {
        List<Utilisateur> liste = new ArrayList<>();
        Connection conn = getConnexion();
        String sql = "SELECT * FROM Utilisateur";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            liste.add(new Utilisateur(
                    rs.getInt("id"),
                    rs.getString("login"),
                    rs.getString("mdp"),
                    rs.getString("nom"),
                    rs.getString("prenom"),
                    rs.getTimestamp("dateEmbauche").toLocalDateTime(),
                    Role.valueOf(rs.getString("role"))
            ));
        }
        conn.close();
        return liste;
    }

    public boolean ajouterUtilisateur(Utilisateur u) throws SQLException {
        Connection conn = getConnexion();
        String sql = "INSERT INTO Utilisateur (login, mdp, nom, prenom, dateEmbauche, role) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        stmt.setString(1, u.getLogin());
        stmt.setString(2, u.getMdp());
        stmt.setString(3, u.getNom());
        stmt.setString(4, u.getPrenom());
        stmt.setTimestamp(5, Timestamp.valueOf(u.getDateEmbauche()));
        stmt.setString(6, u.getRole().name());

        int result = stmt.executeUpdate();
        if (result > 0) {
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                u.setId(rs.getInt(1));
            }
        }
        conn.close();
        return result > 0;
    }

    // Méthodes pour la gestion des Arrêts
    public boolean arretExiste(String nom) throws SQLException {
        Connection conn = getConnexion();
        String sql = "SELECT COUNT(*) FROM Arret WHERE nom = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, nom);

        ResultSet rs = stmt.executeQuery();
        boolean existe = rs.next() && rs.getInt(1) > 0;
        conn.close();
        return existe;
    }

    public Arret getArretById(int id) throws SQLException {
        Connection conn = getConnexion();
        String sql = "SELECT * FROM Arret WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            Arret a = new Arret(
                    rs.getInt("id"),
                    rs.getString("nom"),
                    TypeArret.valueOf(rs.getString("type_d_arret").toUpperCase())
            );
            conn.close();
            return a;
        }
        conn.close();
        return null;
    }

    public List<Arret> getAllArrets() throws SQLException {
        List<Arret> liste = new ArrayList<>();
        Connection conn = getConnexion();
        String sql = "SELECT * FROM Arret";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            liste.add(new Arret(
                    rs.getInt("id"),
                    rs.getString("nom"),
                    TypeArret.valueOf(rs.getString("type_d_arret").toUpperCase())
            ));
        }
        conn.close();
        return liste;
    }

    public boolean ajouterArret(Arret a) throws SQLException {
        Connection conn = getConnexion();
        String sql = "INSERT INTO Arret (nom, type_d_arret) VALUES (?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        stmt.setString(1, a.getNom());
        stmt.setString(2, a.getTypeArret().name().toLowerCase());

        int result = stmt.executeUpdate();
        if (result > 0) {
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                a.setId(rs.getInt(1));
            }
        }
        conn.close();
        return result > 0;
    }

    // Méthodes pour la gestion des Trajets
    public Trajet getTrajetById(String code) throws SQLException {
        Connection conn = getConnexion();
        String sql = "SELECT t.*, ad.*, aa.* FROM Trajet t " +
                "JOIN Arret ad ON t.arretDepart = ad.id " +
                "JOIN Arret aa ON t.arretArrivee = aa.id " +
                "WHERE t.code = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, code);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            Arret depart = new Arret(
                    rs.getInt("ad.id"),
                    rs.getString("ad.nom"),
                    TypeArret.valueOf(rs.getString("ad.type_d_arret").toUpperCase())
            );
            Arret arrivee = new Arret(
                    rs.getInt("aa.id"),
                    rs.getString("aa.nom"),
                    TypeArret.valueOf(rs.getString("aa.type_d_arret").toUpperCase())
            );

            Trajet t = new Trajet(
                    rs.getString("code"),
                    rs.getTimestamp("tempsDepart").toLocalDateTime(),
                    rs.getTimestamp("tempsArrivee").toLocalDateTime(),
                    depart,
                    arrivee
            );
            conn.close();
            return t;
        }
        conn.close();
        return null;
    }

    public List<Trajet> getAllTrajets() throws SQLException {
        List<Trajet> liste = new ArrayList<>();
        Connection conn = getConnexion();
        String sql = "SELECT t.*, ad.*, aa.* FROM Trajet t " +
                "JOIN Arret ad ON t.arretDepart = ad.id " +
                "JOIN Arret aa ON t.arretArrivee = aa.id";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            Arret depart = new Arret(
                    rs.getInt("ad.id"),
                    rs.getString("ad.nom"),
                    TypeArret.valueOf(rs.getString("ad.type_d_arret").toUpperCase())
            );
            Arret arrivee = new Arret(
                    rs.getInt("aa.id"),
                    rs.getString("aa.nom"),
                    TypeArret.valueOf(rs.getString("aa.type_d_arret").toUpperCase())
            );

            liste.add(new Trajet(
                    rs.getString("code"),
                    rs.getTimestamp("tempsDepart").toLocalDateTime(),
                    rs.getTimestamp("tempsArrivee").toLocalDateTime(),
                    depart,
                    arrivee
            ));
        }
        conn.close();
        return liste;
    }

    public boolean ajouterTrajet(Trajet t) throws SQLException {
        Connection conn = getConnexion();
        String sql = "INSERT INTO Trajet (code, tempsDepart, tempsArrivee, arretDepart, arretArrivee) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setString(1, t.getCode());
        stmt.setTimestamp(2, Timestamp.valueOf(t.getTempsDepart()));
        stmt.setTimestamp(3, Timestamp.valueOf(t.getTempsArrivee()));
        stmt.setInt(4, t.getArretDepart().getId());
        stmt.setInt(5, t.getArretArrivee().getId());

        int result = stmt.executeUpdate();
        conn.close();
        return result > 0;
    }
}