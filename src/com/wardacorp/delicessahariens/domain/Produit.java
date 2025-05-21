package com.wardacorp.delicessahariens.domain;

public class Produit {
    private int idProduit;
    private String nom;
    private String description;
    private double prix;
    private String image;
    private float stock;

    public Produit(int idProduit, String nom, String description, double prix, String image, float stock) {
        this.idProduit = idProduit;
        this.nom = nom;
        this.description = description;
        this.prix = prix;
        this.image = image;
        this.stock = stock;
    }

    public int getIdProduit() {
        return idProduit;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public double getPrix() {
        return prix;
    }

    public String getImage() {
        return image;
    }

    public float getStock() {
        return stock;
    }
}

