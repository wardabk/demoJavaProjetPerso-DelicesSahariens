package com.wardacorp.delicessahariens.domain;

public class LignePanier {
    private int idLignePanier;
    private Produit produit;
    private double prixUnitaire;
    private int quantite;
    private double prixTotal;

    public LignePanier(int idLignePanier, Produit produit, double prixUnitaire, int quantite, double prixTotal) {
        this.idLignePanier = idLignePanier;
        this.produit = produit;
        this.prixUnitaire = prixUnitaire;
        this.quantite = quantite;
        this.prixTotal = prixTotal;
    }

    public int getIdLignePanier() {
        return idLignePanier;
    }

    public void setIdLignePanier(int idLignePanier) {
        this.idLignePanier = idLignePanier;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public double getPrixTotal() {
        return prixTotal;
    }

    public void setPrixTotal(double prixTotal) {
        this.prixTotal = prixTotal;
    }
}
