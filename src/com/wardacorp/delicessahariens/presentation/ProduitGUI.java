package com.wardacorp.delicessahariens.presentation;

import com.wardacorp.delicessahariens.dao.ServiceProduitDAO;
import com.wardacorp.delicessahariens.domain.Produit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ProduitGUI extends JFrame {
    private JTextField nomField, descriptionField, prixField, stockField, imageField;
    private JTextArea produitsArea;

    public ProduitGUI() {
        setTitle("Gestion des Produits - Délices Sahariens");
        setSize(600, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Formulaire
        JPanel formPanel = new JPanel(new GridLayout(6, 2, 10, 5));
        formPanel.setBorder(BorderFactory.createTitledBorder("Ajouter un produit"));

        nomField = new JTextField();
        descriptionField = new JTextField();
        prixField = new JTextField();
        stockField = new JTextField();
        imageField = new JTextField();

        formPanel.add(new JLabel("Nom :"));
        formPanel.add(nomField);
        formPanel.add(new JLabel("Description :"));
        formPanel.add(descriptionField);
        formPanel.add(new JLabel("Prix :"));
        formPanel.add(prixField);
        formPanel.add(new JLabel("Stock :"));
        formPanel.add(stockField);
        formPanel.add(new JLabel("Image (chemin relatif) :"));
        formPanel.add(imageField);

        JButton ajouterBtn = new JButton("Ajouter Produit");
        JButton afficherBtn = new JButton("Afficher Produits");
        formPanel.add(ajouterBtn);
        formPanel.add(afficherBtn);

        // Zone d'affichage
        produitsArea = new JTextArea();
        produitsArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(produitsArea);

        // Layout global
        setLayout(new BorderLayout());
        add(formPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Action : Ajouter produit
        ajouterBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Produit p = new Produit(
                            0,
                            nomField.getText(),
                            descriptionField.getText(),
                            Double.parseDouble(prixField.getText()),
                            imageField.getText(),
                            Float.parseFloat(stockField.getText())
                    );
                    ServiceProduitDAO.addProduit(p);
                    JOptionPane.showMessageDialog(null, "Produit ajouté !");
                    clearFields();
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Erreur : " + ex.getMessage());
                }
            }
        });

        // Action : Afficher produits
        afficherBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    List<Produit> produits = ServiceProduitDAO.getAllProduits();
                    produitsArea.setText(""); // reset
                    for (Produit p : produits) {
                        produitsArea.append(p.getIdProduit() + " - " + p.getNom() + " - " + p.getPrix() + " DT\n");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Erreur : " + ex.getMessage());
                }
            }
        });
    }

    private void clearFields() {
        nomField.setText("");
        descriptionField.setText("");
        prixField.setText("");
        stockField.setText("");
        imageField.setText("");
    }

}
