package com.wardacorp.delicessahariens.service;

import java.util.ArrayList;
import java.util.List;
import com.wardacorp.delicessahariens.domain.*;

public class ServicePanier {

    public void ajouterProduitAuPanier(LignePanier lignePanier, Panier panier) {
        panier.getLignePanier().add(lignePanier);
    }

    public void retirerProduitDuPanier(LignePanier lignePanier, Panier panier) {
        panier.getLignePanier().remove(lignePanier);
    }

    public void modifierQuantiteProduit(LignePanier lignePanier, int nouvelleQuantite) {
        lignePanier.setQuantite(nouvelleQuantite);
    }

    public double getSomme(Panier panier) {
        double somme = 0;
        for (LignePanier lp : panier.getLignePanier()) {
            somme += lp.getProduit().getPrix() * lp.getQuantite();
        }
        return somme;
    }

    public boolean viderPanier(Panier panier) {
        panier.getLignePanier().clear();
        return panier.getLignePanier().isEmpty();
    }

    public List<LignePanier> getLignesPanier(Panier panier) {
        return new ArrayList<>(panier.getLignePanier());
    }
}
