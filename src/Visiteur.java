import java.util.*;

public class Visiteur extends Utilisateur {

    // 2. Constructeur
    public Visiteur(String nom, String prenom, String email,
                    String telephone, String password) {
        super(nom, prenom, email, telephone, password);
    }

    // 4. Méthode : Recherche de produits par nom
    public List<Produit> rechercherProduit(String nom) {
        List<Produit> produitsTrouves = new ArrayList<>();
        if (nom != null && nom.equalsIgnoreCase("datte")) {
            produitsTrouves.add(new Produit(1, "Dattes Deglet Nour", "Dattes haute qualité", "image.jpg", 15, 100));
        }
        return produitsTrouves;
    }

    // 5. Méthode toString
    @Override
    public String toString() {
        return "Visiteur : " + super.toString();
    }
}
