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


            for (Produit produit : panier.getProduits()) {
                System.out.println(produit.getNom() + " - " + produit.getPrix() + "DT");
            }
            System.out.println("Montant total de la commande : " + panier.getMontantTotal() + "DT");
        }

}
