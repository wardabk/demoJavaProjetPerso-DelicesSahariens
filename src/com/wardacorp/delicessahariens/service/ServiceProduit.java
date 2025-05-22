package com.wardacorp.delicessahariens.service;

import com.wardacorp.delicessahariens.domain.Produit;
import com.wardacorp.delicessahariens.dao.ServiceProduitDAO;

import java.util.List;

public class ServiceProduit {
    private ServiceProduitDAO produitDAO = new ServiceProduitDAO();

    public void ajouterProduit(Produit p) {
        produitDAO.addProduit(p);
    }

    public List<Produit> afficherListeProduits() throws Exception {
        return produitDAO.getAllProduits();
    }
}

