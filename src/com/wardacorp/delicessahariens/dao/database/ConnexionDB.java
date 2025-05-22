package com.wardacorp.delicessahariens.dao.database;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import org.apache.log4j.Logger;

public class ConnexionDB {

    private static String DB_NAME = "";
    private static String URL_BASE = "";
    private static String USER = "";
    private static String PASSWORD = "";

    private static final Logger logger = Logger.getLogger(ConnexionDB.class);

    static {
        try {
            initializeDB();
        } catch (Exception e) {
            logger.fatal("Échec de l'initialisation de la base de données.", e);
        }
    }

    public static void initializeDB() {
        Properties props = new Properties();

        try (FileInputStream input = new FileInputStream("config/db.properties")) {
            props.load(input);

            DB_NAME = props.getProperty("db.name");
            URL_BASE = props.getProperty("db.url");
            USER = props.getProperty("db.user");
            PASSWORD = props.getProperty("db.password");

            //  créer la base si elle n'existe pas
            try (Connection connectionDB = DriverManager.getConnection(URL_BASE, USER, PASSWORD);
                 Statement stmt = connectionDB.createStatement()) {

                logger.info("Connexion au serveur MySQL réussie.");
                stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS " + DB_NAME);
                logger.info("Base de données '" + DB_NAME + "' créée ou déjà existante.");

            } catch (SQLException e) {
                logger.error("Erreur lors de la connexion ou création de la base.", e);
                return;
            }

            //  Créer les tables
            initializeTables();

        } catch (IOException e) {
            logger.error("Erreur lors de la lecture du fichier de configuration.", e);
        } catch (Exception e) {
            logger.error("Erreur inattendue.", e);
        }
    }

    public static Connection getConnection() throws SQLException {
        logger.debug("Connexion à la base de données : " + URL_BASE + DB_NAME);
        return DriverManager.getConnection(URL_BASE + DB_NAME, USER, PASSWORD);
    }

    public static void initializeTables() {
        try (Connection con = getConnection(); Statement stmt = con.createStatement()) {

            stmt.executeUpdate("""
                CREATE TABLE IF NOT EXISTS produit (
                    id_produit INT AUTO_INCREMENT PRIMARY KEY,
                    nom VARCHAR(100),
                    description TEXT,
                    image_url VARCHAR(255),
                    prix DECIMAL(10,2),
                    CONSTRAINT unique_nom_desc UNIQUE (nom, description)
                );
            """);

            // Tu peux ajouter ici les autres tables : client, utilisateur, commande, etc.

            logger.info("Tables créées avec succès.");

        } catch (SQLSyntaxErrorException e) {
            logger.error("Erreur de syntaxe SQL dans les requêtes CREATE TABLE.", e);
        } catch (SQLException e) {
            logger.error("Erreur SQL lors de la création des tables.", e);
        }
    }
}
