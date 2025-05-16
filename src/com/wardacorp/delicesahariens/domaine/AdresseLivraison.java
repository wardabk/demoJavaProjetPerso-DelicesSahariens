package com.wardacorp.delicesahariens.domaine;

public class AdresseLivraison {
    private String rue;
    private String ville;
    private int codePostal;

    public AdresseLivraison(String rue, String ville, int codePostal) {
        this.rue = rue;
        this.ville = ville;
        this.codePostal = codePostal;
    }

    public String getRue() {
        return rue;
    }

    public String getVille() {
        return ville;
    }

    public int getCodePostal() {
        return codePostal;
    }

    public String getAdresseComplete(String rue, String ville, int codePostal){
        return "l'adresse correspondante est " + rue + " " + ville + " " + codePostal;
    }
}
