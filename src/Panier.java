import java.util.List;
import java.util.ArrayList;

public class Panier {
    private List<Produit> produits;
    private double montantTotal;

    // Constructeur
    public Panier() {
        this.produits = new ArrayList<>();
        this.montantTotal = 0.0;
    }

    // Ajouter un produit au panier avec quantité
    public void ajouterProduit(Produit produit, int quantite) {
        produits.add(produit);
        montantTotal += produit.getPrix() * quantite; // Maj du montant total
    }

    // Getter pour obtenir la liste des produits
    public List<Produit> getProduits() {
        return produits;
    }

    // Afficher les produits dans le panier
    public void afficherPanier() {
        System.out.println("Produits dans le panier : ");
        for (Produit produit : produits) {
            System.out.println(produit.getNom() + " - " + produit.getPrix() + "DT");
        }
        System.out.println("Montant total: " + montantTotal + "DT");
    }

    // Vider le panier
    public void viderPanier() {
        produits.clear();
        montantTotal = 0.0;
    }

    // Getter pour le montant total
    public double getMontantTotal() {
        return montantTotal;
    }
}
