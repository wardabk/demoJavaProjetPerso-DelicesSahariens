package com.wardacorp.delicesahariens.service;
import com.wardacorp.delicesahariens.domaine.Produit;
import java.util.List;
import java.util.ArrayList;

public class ServiceProduit {
    private List<Produit> produits;

    public ServiceProduit() {
        produits = new ArrayList<>();
        initialiserProduits();
    }


    private void initialiserProduits() {
        produits.add(new Produit(1, "Dattes Deglet Nour", "haute qualité","image1.jpg",15,1000));
        produits.add(new Produit(2, "Sucre de dattes", "pour régime alimentaire","image2.jpg",12,500));
        produits.add(new Produit(3, "Sirop de dattes", "gout spécial","image3.jpg",14,250));

    }


    public List<Produit> afficherListeProduits() {
        return produits;
    }

    public Produit rechercherProduit(String nom) {
        for (Produit p : produits) {
            if (p.getNom().equalsIgnoreCase(nom)) {
                return p;
            }
        }
        return null;
    }
}

