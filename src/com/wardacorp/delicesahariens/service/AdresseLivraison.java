package com.wardacorp.delicesahariens.service;

public class AdresseLivraison {
    private String rue;
    private String ville;
    private int codePostal;

    public AdresseLivraison(String rue, String ville, int codePostal) {
        this.rue = rue;
        this.ville = ville;
        this.codePostal = codePostal;
    }

    public String getAdresseComplete(String rue, String ville, int codePostal){
        return "L'adresse est " + rue + ", " + codePostal + " " + ville;
    }
}
