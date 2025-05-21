import com.wardacorp.delicessahariens.dao.ServiceProduitDAO;
import com.wardacorp.delicessahariens.domain.Produit;
import com.wardacorp.delicessahariens.presentation.ProduitGUI;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.util.List;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        try {
            // Initialiser de Log4j
            PropertyConfigurator.configure("./config/log4j.properties");

            // Créer d'un produit
            Produit produit1 = new Produit(
                    1,
                    "Dattes Deglet Nour",
                    "Délicieuses dattes tunisiennes",
                    15,
                    "images/dagla.jpg",
                    100
            );
            Produit produit2 = new Produit(
                    2,
                    "Sirop de dattes",
                    "Sirop naturel extrait de dattes",
                    10,
                    "sirop de dattes.jpg",
                    50
            );

            Produit produit3 = new Produit(
                    3,
                    "Dattes farcies",
                    "Dattes farcies aux amandes et noix",
                    20,
                    "dattes farcie3.jpg",
                    75
            );

            // Ajouter un produit à la base de données
            ServiceProduitDAO.addProduit(produit1);
            ServiceProduitDAO.addProduit(produit2);
            ServiceProduitDAO.addProduit(produit3);
            logger.info("Produit ajouté avec succès !");

            // afficher la liste de produits
            List<Produit> produits = ServiceProduitDAO.getAllProduits();
            logger.info("Liste des produits en base :");
            for (Produit p : produits) {
                System.out.println(p.getIdProduit() + " - " + p.getNom() + " - " + p.getPrix() + " DT");
            }

        } catch (Exception e) {
            logger.error("Erreur lors de l'exécution du programme :", e);
            e.printStackTrace();
        }

        javax.swing.SwingUtilities.invokeLater(() -> {
            ProduitGUI gui = new ProduitGUI();
            gui.setVisible(true);
        });
    }
}
