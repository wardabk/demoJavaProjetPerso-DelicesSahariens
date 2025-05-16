package com.wardacorp.delicesahariens.domaine;

public class Client extends Utilisateur {

    private int idClient;
    private AdresseLivraison adresse;

    public Client(String nom, String prenom, String email, String telephone, String password, int idClient, AdresseLivraison adresse) {
        super(nom, prenom, email, telephone, password);
        this.idClient = idClient;
        this.adresse = adresse;
    }


}

