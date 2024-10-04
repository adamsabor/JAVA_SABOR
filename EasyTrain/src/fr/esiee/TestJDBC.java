package fr.esiee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJDBC {
    public static void main(String[] args) {
        String urlLocal= "jdbc:mariadb://localhost:8889/EasyTrain";
        String userLocal = "root" ;
        String pwdLocal ="root";
        String urlDistant="localhost:3306/EasyTrain";
        String userDistant = "root" ;
        String pwdDistant ="";
/// creation d'une connexion a la bdd
        try {
            Connection connection = DriverManager.getConnection(
                    urlLocal ,userLocal,pwdLocal);
            System.out.println("OKÒ");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    }