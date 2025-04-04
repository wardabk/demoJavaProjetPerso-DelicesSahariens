public class Client extends Utilisateur {
    private Panier panier;

    public Client(String nom, String prenom, String email, String telephone, String password) {
        super(nom, prenom, email, telephone, password);
        this.panier = new Panier();
    }

    public void ajouterAuPanier(Produit produit, int quantite) {
        panier.ajouterProduit(produit, quantite);
    }

    public void passerCommande() {
        Commande commande = new Commande(this, panier);
        commande.afficherCommande();
        panier.viderPanier();
    }

    public Panier getPanier() {
        return panier;
    }

    @Override
    public String toString() {
        return "Nom : " + getNom() + " " + getPrenom() + "\n" +
                "Email: " + getEmail() + "\n" +
                "Téléphone: " + getTelephone();
    }
}

