package fr.esiee.dao;

import fr.esiee.modele.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EasyTrainDAO {

    private Connection getConnexion() throws SQLException {
        String url = "jdbc:mysql://localhost:8889/EasyTrain";
        String user = "root";
        String password = "root";
        return DriverManager.getConnection(url, user, password);
    }

    // UTILISATEUR
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
        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setString(1, u.getLogin());
        stmt.setString(2, u.getMdp());
        stmt.setString(3, u.getNom());
        stmt.setString(4, u.getPrenom());
        stmt.setTimestamp(5, Timestamp.valueOf(u.getDateEmbauche()));
        stmt.setString(6, u.getRole().name());

        int result = stmt.executeUpdate();
        conn.close();
        return result > 0;
    }

    // ARRET
    public Arret getArretById(int id) throws SQLException {
        Connection conn = getConnexion();
        String sql = "SELECT * FROM Arret WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            Arret a = new Arret(rs.getInt("id"), rs.getString("nom"));
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
            liste.add(new Arret(rs.getInt("id"), rs.getString("nom")));
        }
        conn.close();
        return liste;
    }

    public boolean ajouterArret(Arret a) throws SQLException {
        Connection conn = getConnexion();
        String sql = "INSERT INTO Arret (nom) VALUES (?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, a.getNom());

        int result = stmt.executeUpdate();
        conn.close();
        return result > 0;
    }

    // TRAJET
    public Trajet getTrajetById(String code) throws SQLException {
        Connection conn = getConnexion();
        String sql = "SELECT t.*, ad.id as depart_id, ad.nom as depart_nom, aa.id as arrivee_id, aa.nom as arrivee_nom " +
                "FROM Trajet t " +
                "JOIN Arret ad ON t.arretDepart = ad.id " +
                "JOIN Arret aa ON t.arretArrivee = aa.id " +
                "WHERE t.code = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, code);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            Arret depart = new Arret(rs.getInt("depart_id"), rs.getString("depart_nom"));
            Arret arrivee = new Arret(rs.getInt("arrivee_id"), rs.getString("arrivee_nom"));

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
        String sql = "SELECT t.*, ad.id as depart_id, ad.nom as depart_nom, aa.id as arrivee_id, aa.nom as arrivee_nom " +
                "FROM Trajet t " +
                "JOIN Arret ad ON t.arretDepart = ad.id " +
                "JOIN Arret aa ON t.arretArrivee = aa.id";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            Arret depart = new Arret(rs.getInt("depart_id"), rs.getString("depart_nom"));
            Arret arrivee = new Arret(rs.getInt("arrivee_id"), rs.getString("arrivee_nom"));

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

public List<Role> getAllRoles() throws SQLException {
    List<Role> roles = new ArrayList<>();
    Connection conn = getConnexion();
    String sql = "SELECT * FROM Role"; // Adaptez le nom de la table des rôles si nécessaire
    Statement stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery(sql);

    while (rs.next()) {
        roles.add(new Role(rs.getInt("id"), rs.getString("nom"))); // Assurez-vous que les colonnes correspondent à votre table
    }
    conn.close();
    return roles;
}
}
