/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.productsalesreport;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author siphoesihle
 */
public class ProductApp extends JFrame {
  
    public JTextField txtCustomerName;
    public JComboBox<String> cmbProduct;
    public JTextField txtPrice;

    public ProductApp() {
        setTitle("Product App");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel lblCustomer = new JLabel("Customer Name:");
        lblCustomer.setBounds(30, 30, 120, 25);
        add(lblCustomer);

        txtCustomerName = new JTextField();
        txtCustomerName.setBounds(160, 30, 180, 25);
        add(txtCustomerName);

        JLabel lblProduct = new JLabel("Select Product:");
        lblProduct.setBounds(30, 70, 120, 25);
        add(lblProduct);

        String[] products = { "Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket" };
        cmbProduct = new JComboBox<>(products);
        cmbProduct.setBounds(160, 70, 77, 25);
        cmbProduct.setSelectedIndex(0);
        add(lblProduct);
        add(cmbProduct);

        JLabel lblPrice = new JLabel("Enter Price:");
        lblPrice.setBounds(30, 114, 120, 25);
        add(lblPrice);

        txtPrice = new JTextField();
        txtPrice.setBounds(110, 150, 180, 25);
        add(txtPrice);

        JButton btnProcess = new JButton("PROCESS");
        btnProcess.setBounds(160, 160, 160, 40);
        add(btnProcess);

        
        JMenuBar menuBar = new JMenuBar();
        
        JMenu menuFile = new JMenu("File");
        JMenuItem itemExit = new JMenuItem("Exit");
        menuFile.add(itemExit);
        
        JMenu menuTools = new JMenu("Tools");
        JMenuItem itemProcess = new JMenuItem("Process");
        JMenuItem itemClear = new JMenuItem("Clear");
        menuTools.add(itemProcess);
        menuTools.add(itemClear);

        menuBar.add(menuFile);
        menuBar.add(menuTools);
        setJMenuBar(menuBar);

        btnProcess.addActionListener(e -> processOrder());
        itemProcess.addActionListener(e -> processOrder());
        itemClear.addActionListener(e -> clearForm());
        itemExit.addActionListener(e -> System.exit(0));
    }

    private void processOrder() {
        try {
            String customerName = txtCustomerName.getText();
            String productName = (String) cmbProduct.getSelectedItem();
            double price = Double.parseDouble(txtPrice.getText());

            ProductCalculations calc = new ProductCalculations(price);
            double vat = calc.GetVat();
            double commission = calc.GetCommission();
            double total = calc.GetTotal();

           
            String message = String.format("Customer Name: %s\nProduct: %s\nVAT: R %.1f\nCOMMISSION: R %.1f\nTOTAL: R %.1f",
                    customerName, productName, vat, commission, total);
            
            JOptionPane.showMessageDialog(this, message, "Message", JOptionPane.INFORMATION_MESSAGE);

            
            try (PrintWriter writer = new PrintWriter(new FileWriter("data.txt", true))) {
                writer.println("DATA LOG");
                writer.println("**************************************************");
                writer.println("Customer Name: " + customerName);
                writer.println("Product: " + productName);
                writer.println(String.format("VAT: R %.1f", vat));
                writer.println(String.format("COMMISSION: R %.1f", commission));
                writer.println(String.format("TOTAL: R %.1f", total));
                writer.println("**************************************************");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error saving file.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid numeric price.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearForm() {
        txtCustomerName.setText("");
        txtPrice.setText("");
        cmbProduct.setSelectedIndex(0); 
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new ProductApp().setVisible(true));
    }
}

