package com.wardacorp.delicessahariens.dao;

import com.wardacorp.delicessahariens.domain.Produit;
import com.wardacorp.delicessahariens.dao.database.ConnexionDB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ServiceProduitDAO {

    public boolean produitExiste(String nom, String description) {
        String query = "SELECT COUNT(*) FROM produit WHERE nom = ? AND description = ?";
        try (Connection con = ConnexionDB.getConnection();
             PreparedStatement stmt = con.prepareStatement(query)) {

            stmt.setString(1, nom);
            stmt.setString(2, description);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void addProduit(Produit produit){

        if (produitExiste(produit.getNom(), produit.getDescription())) {
            System.out.println("Ce produit existe déjà !");
            return;
        }
        String sql = "INSERT INTO produit (nom, description, prix, image_url, stock) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = ConnexionDB.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, produit.getNom());
            stmt.setString(2, produit.getDescription());
            stmt.setDouble(3, produit.getPrix());
            stmt.setString(4, produit.getImage());
            stmt.setFloat(5, produit.getStock());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        public List<Produit> getAllProduits() throws Exception {
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
