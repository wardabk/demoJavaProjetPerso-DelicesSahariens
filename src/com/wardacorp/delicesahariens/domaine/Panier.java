package com.wardacorp.delicesahariens.domaine;

import com.wardacorp.delicesahariens.service.LignePanier;
import java.util.*;

public class Panier {
    private int idPanier;
    private List<LignePanier> lignes;
    private double somme;


    public Panier() {
        this.lignes = new ArrayList<>();
        this.somme = 0;
    }

    public int getIdPanier() {
        return idPanier;
    }

    public void setIdPanier(int idPanier) {
        this.idPanier = idPanier;
    }

    public List<LignePanier> getLignes() {
        return lignes;
    }

    public void setLignes(List<LignePanier> lignes) {
        this.lignes = lignes;
        calculerSomme();
    }

    public double getSomme() {
        return somme;
    }

    public void setSomme(double somme) {
        this.somme = somme;
    }

    public void calculerSomme() {
        double total = 0;
        for (LignePanier ligne : lignes) {
            total += ligne.getProduit().getPrix() * ligne.getQuantite();
        }
        this.somme = total;
    }

    public void ajouterLigne(LignePanier ligne) {
        this.lignes.add(ligne);
        calculerSomme();
    }

    public void afficherPanier() {
        for (LignePanier ligne : lignes) {
            System.out.println(
                    "Produit: " + ligne.getProduit().getNom() +
                            ", Quantité: " + ligne.getQuantite() +
                            ", Prix unitaire: " + ligne.getProduit().getPrix()
            );
        }
    }
}

