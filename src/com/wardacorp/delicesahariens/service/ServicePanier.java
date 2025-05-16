package com.wardacorp.delicesahariens.service;

import com.wardacorp.delicesahariens.domaine.Panier;
import com.wardacorp.delicesahariens.service.LignePanier;

public class ServicePanier {

    // Calculer la somme totale du panier
    public double getSomme(Panier panier) {
        double total = 0;
        for (LignePanier ligne : panier.getLignes()) {
            total += ligne.getProduit().getPrix() * ligne.getQuantite();
        }
        return total;
    }

    // ajout d’une ligne au panier
    public void ajouterLignePanier(LignePanier ligne, Panier panier) {
        panier.ajouterLigne(ligne);
    }
}
