import com.wardacorp.delicesahariens.domaine.Produit;
import com.wardacorp.delicesahariens.service.LignePanier;
import com.wardacorp.delicesahariens.domaine.Panier;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.wardacorp.delicesahariens.service.TestJDBC;

public class Main {
    public static void main(String[] args) {

        Connection conn = TestJDBC.getConnection();
        if (conn != null) {
            System.out.println("Connexion réussie");
        } else {
            System.out.println("Échec de connexion");
        }

        Produit produit1 = new Produit(1, "Dattes Deglet Nour", "Description", "image.jpg", 15.0, 1000);
        LignePanier ligne1 = new LignePanier(produit1, 3);

        Panier panier = new Panier();

        panier.getLignes().add(ligne1);


        panier.calculerSomme();

        for (LignePanier lp : panier.getLignes()) {
            System.out.println("Produit: " + lp.getProduit().getNom()
                    + ", Quantité: " + lp.getQuantite()
                    + ", Prix unitaire: " + lp.getProduit().getPrix());
        }
        System.out.println("Montant total du panier : " + panier.getSomme() + " DT");


        try {
            String sql = "INSERT INTO produit (id_produit, nom, description, image_url, prix, stock) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, produit1.getIdProduit());
            stmt.setString(2, produit1.getNom());
            stmt.setString(3, produit1.getDescription());
            stmt.setString(4, produit1.getImage());
            stmt.setDouble(5, produit1.getPrix());
            stmt.setInt(6, produit1.getStock());

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Produit inséré avec succès !");
            }

            stmt.close();
            conn.close(); // bonne pratique : fermer la connexion
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
