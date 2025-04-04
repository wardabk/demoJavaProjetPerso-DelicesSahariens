public class Produit {
    // 1. Propriétés
    private int id;
    private String nom;
    private String description;
    private String image;
    private double prix;
    private int stock;

    // 2. Constructeur
    public Produit(int id, String nom, String description,
                   String image, double prix, int stock) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.image = image;
        this.prix = prix;
        this.stock = stock;
    }

    // 3. Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    // 4. toString
    @Override
    public String toString() {
        return "Produit [id=" + id + ", nom=" + nom + ", description=" + description +
                ", image=" + image + ", prix=" + prix + ", stock=" + stock + "]";
    }
}
