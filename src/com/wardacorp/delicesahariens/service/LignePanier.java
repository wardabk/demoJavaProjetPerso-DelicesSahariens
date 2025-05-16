package com.wardacorp.delicesahariens.service;
import com.wardacorp.delicesahariens.domaine.Produit;
public class LignePanier {
    private Produit produit;
    private int quantite;

    public LignePanier(Produit produit, int quantite) {
        this.produit = produit;
        this.quantite = quantite;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public double getsomme() {
        return produit.getPrix() * quantite;
    }
}



