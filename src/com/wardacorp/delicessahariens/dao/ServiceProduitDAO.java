package com.wardacorp.delicessahariens.dao;

import com.wardacorp.delicessahariens.domain.Produit;
import com.wardacorp.delicessahariens.dao.database.ConnexionDB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ServiceProduitDAO {
    public static void addProduit(Produit p) throws Exception {
        String sql = "INSERT INTO produit (nom, description, prix, image_url, stock) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = ConnexionDB.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, p.getNom());
            stmt.setString(2, p.getDescription());
            stmt.setDouble(3, p.getPrix());
            stmt.setString(4, p.getImage());
            stmt.setFloat(5, p.getStock());
            stmt.executeUpdate();

        }
    }
        public static List<Produit> getAllProduits() throws Exception {
            List<Produit> produits = new ArrayList<>();
            String sql = "SELECT * FROM produit";

            try (Connection con = ConnexionDB.getConnection();
                 PreparedStatement stmt = con.prepareStatement(sql);
                 ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    Produit p = new Produit(
                            rs.getInt("id_produit"),
                            rs.getString("nom"),
                            rs.getString("description"),
                            rs.getDouble("prix"),
                            rs.getString("image_url"),
                            rs.getFloat("stock")
                    );
                    produits.add(p);
                }
            }
            return produits;
        }
}
