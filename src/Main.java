import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Création d'un visiteur
        Visiteur visiteur = new Visiteur("Ahmed", "Brahim", "ahmed@email.com", "123456789", "password123");

        // Recherche de produits par le visiteur
        List<Produit> produitsTrouves = visiteur.rechercherProduit("datte");
        System.out.println("* Produits trouvés : ");
        for (Produit produit : produitsTrouves) {
            System.out.println(produit.getNom() + " - " + produit.getPrix() + "DT");
        }

        // Création d'un client
        Client client = new Client("Ali", "Ben Salah", "ali@email.com", "12345678", "password123");

        System.out.println("* Informations du client: ");
        System.out.println(client.toString());

        // Ajout de produits au panier
        client.ajouterAuPanier(produitsTrouves.get(0), 2);
        System.out.println("\n* Panier du client :");
        client.getPanier().afficherPanier();

        // Passage de commande
        client.passerCommande();


    }
}
