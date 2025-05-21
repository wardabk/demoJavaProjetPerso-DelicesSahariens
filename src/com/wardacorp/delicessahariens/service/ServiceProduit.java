package com.wardacorp.delicessahariens.service;

import com.wardacorp.delicessahariens.domain.Produit;
import com.wardacorp.delicessahariens.dao.ServiceProduitDAO;

import java.util.List;

public class ServiceProduit {
    public static void ajouterProduit(Produit p) throws Exception {
        ServiceProduitDAO.addProduit(p);
    }

    public static List<Produit> afficherListeProduits() throws Exception {
        return ServiceProduitDAO.getAllProduits();
    }
}

