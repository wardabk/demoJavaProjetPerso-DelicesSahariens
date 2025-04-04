import java.util.*;

public class Administrateur extends Utilisateur {

    public Administrateur(String nom, String prenom, String email, String telephone, String password) {
        super(nom, prenom, email, telephone, password);
    }

    // Ajouter un produit
    public void ajouterProduit(List<Produit> listeProduits, Produit produit) {
        listeProduits.add(produit);
        System.out.println("Produit ajouté : " + produit.getNom());
    }

    // Modifier un produit
    public void modifierProduit(List<Produit> listeProduits, int idProduit, String nouveauNom, double nouveauPrix) {
        for (Produit produit : listeProduits) {
            if (produit.getId() == idProduit) {
                produit.setNom(nouveauNom);
                produit.setPrix(nouveauPrix);
                System.out.println("Produit modifié : " + produit.getNom());
                return;
            }
        }
        System.out.println("Produit non trouvé.");
    }

    // Supprimer un produit
    public void supprimerProduit(List<Produit> listeProduits, int idProduit) {
        for (Produit produit : listeProduits) {
            if (produit.getId() == idProduit) {
                listeProduits.remove(produit);
                System.out.println("Produit supprimé : " + produit.getNom());
                return;
            }
        }
        System.out.println("Produit non trouvé.");
    }

    // Visualiser les statistiques (Exemple simple: Nombre de produits)
    public void visualiserStatistiques(List<Produit> listeProduits) {
        System.out.println("Nombre total de produits : " + listeProduits.size());
    }
}
