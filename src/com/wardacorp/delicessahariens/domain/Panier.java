package com.wardacorp.delicessahariens.domain;

import java.util.List;
import java.util.ArrayList;

public class Panier {
    private int idPanier;
    private List<LignePanier> lignePanier = new ArrayList<>();
    private double somme;

    public Panier(int idPanier, List<LignePanier> lignePanier, double somme) {
        this.idPanier = idPanier;
        this.lignePanier = lignePanier;
        this.somme = somme;
    }

    public int getIdPanier() {
        return idPanier;
    }

    public void setIdPanier(int idPanier) {
        this.idPanier = idPanier;
    }

    public List<LignePanier> getLignePanier() {
        return lignePanier;
    }

    public void setLignePanier(List<LignePanier> lignePanier) {
        this.lignePanier = lignePanier;
    }

    public double getSomme() {
        return somme;
    }

    public void setSomme(double somme) {
        this.somme = somme;
    }
}
