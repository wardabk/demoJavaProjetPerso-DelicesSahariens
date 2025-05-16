package com.wardacorp.delicesahariens.domaine;

public class Paiement {
    // 1. Propriétés
    private int id;
    private double montantPaye;
    private String modePaiement;
    private String statutPaiement;

    // 2. Constructeurs
    public Paiement() {
        this.statutPaiement = "En attente";
    }

    public Paiement(int id, double montantPaye, String modePaiement) {
        this.id = id;
        this.montantPaye = montantPaye;
        this.modePaiement = modePaiement;
        this.statutPaiement = "En attente";
    }

    // 3. Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getMontantPaye() {
        return montantPaye;
    }

    public void setMontantPaye(double montantPaye) {
        this.montantPaye = montantPaye;
    }

    public String getModePaiement() {
        return modePaiement;
    }

    public void setModePaiement(String modePaiement) {
        this.modePaiement = modePaiement;
    }

    public String getStatutPaiement() {
        return statutPaiement;
    }

    public void setStatutPaiement(String statutPaiement) {
        this.statutPaiement = statutPaiement;
    }

    // 4. Méthodes
    public void validerPaiement() {
        this.statutPaiement = "Validé";
        System.out.println("com.wardacorp.delicesahariens.domaine.Paiement validé.");
    }

    public void annulerPaiement() {
        this.statutPaiement = "Refusé";
        System.out.println("com.wardacorp.delicesahariens.domaine.Paiement annulé.");
    }

    // 5. toString
    @Override
    public String toString() {
        return "com.wardacorp.delicesahariens.domaine.Paiement{" +
                "id=" + id +
                ", montantPaye=" + montantPaye +
                ", modePaiement='" + modePaiement + '\'' +
                ", statutPaiement='" + statutPaiement + '\'' +
                '}';
    }
}
