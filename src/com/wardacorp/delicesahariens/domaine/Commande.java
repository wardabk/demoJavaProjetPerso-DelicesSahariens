package com.wardacorp.delicesahariens.domaine;
import com.wardacorp.delicesahariens.service.LignePanier;
public class Commande {
    private Client client;
    private Panier panier;

    public Commande(Client client, Panier panier) {
        this.client = client;
        this.panier = panier;
    }

    // Afficher les détails de la commande
    public void afficherCommande() {
        System.out.println("Commande de " + client.getNom());
        System.out.println("Produits dans la commande : ");

        // On récupère les lignes du panier (liste de LignePanier)
        for (LignePanier ligne : panier.getLignes()) {
            Produit produit = ligne.getProduit();
            System.out.println(produit.getNom() + " - " + produit.getPrix() + "DT x " + ligne.getQuantite());
        }

        System.out.println("Montant total de la commande : " + panier.getSomme() + "DT");
    }
}
