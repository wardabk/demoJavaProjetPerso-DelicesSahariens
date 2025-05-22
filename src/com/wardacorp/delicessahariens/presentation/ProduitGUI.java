package com.wardacorp.delicessahariens.presentation;

import com.wardacorp.delicessahariens.dao.ServiceProduitDAO;
import com.wardacorp.delicessahariens.domain.Produit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class ProduitGUI extends JFrame {
    private ServiceProduitDAO produitDAO = new ServiceProduitDAO();
    private JTable table;
    private DefaultTableModel tableModel;

    public ProduitGUI() {
        setTitle("Gestion des Produits - Délices Sahariens");
        setSize(800, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Définition de la table
        String[] columnNames = {"id_produit", "Nom", "Description", "Prix", "Image_url", "Stock"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        // Button d'affichage
        JButton afficherBtn = new JButton("Afficher les Produits");
        afficherBtn.addActionListener((ActionEvent e) -> {
            try {
                List<Produit> produits = produitDAO.getAllProduits();
                tableModel.setRowCount(0); // Nettoie la table avant d'ajouter
                for (Produit p : produits) {
                    Object[] row = {
                            p.getIdProduit(),
                            p.getNom(),
                            p.getDescription(),
                            p.getPrix(),
                            p.getImage(),
                            p.getStock()
                    };
                    tableModel.addRow(row);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Erreur : " + ex.getMessage());
            }
        });

        // Layout
        setLayout(new BorderLayout());
        add(afficherBtn, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }
}
