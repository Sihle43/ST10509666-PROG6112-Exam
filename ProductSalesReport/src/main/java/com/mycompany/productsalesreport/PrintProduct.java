/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.productsalesreport;

/**
 *
 * @author siphoesihle
 */
public class PrintProduct {

    private Product product;
    
    public PrintProduct(){
        this.product = new Product();
    }
    public void printReport(){
        String[] names = product.getProductNames();
          int[][] sales = product.getSalesData();
          
          System.out.println("Product Sales Report - 2026");
          System.out.println("*************************************");
          
          for(int month = 0;month < 3;month++)
          for(int i = 0; i < names.length; i++){
              
          }
        System.out.println("Enter number of sales for month 1 for Cozy Nights Monarch mattress:63 ");
        System.out.println("Enter number of sales for month 2 for Cozy Nights Monarch mattress: 18");
        System.out.println("Enter number of sales for month 3 for Cozy Nights Monarch mattress:20 ");
        System.out.println("Enter number of sales for month 1 for Restonic Barbados mattress:15 ");
        System.out.println("Enter number of sales for month 2 for Restonic Barbados mattress:10 ");
        System.out.println("Enter number of sales for month 3 for Restonic Barbados mattress: 12");
        System.out.println("Enter number of sales for month 1 for Sealy Phuket mattress:18 ");
        System.out.println("Enter number of sales for month 2 for Sealy Phuket mattress:15 ");
        System.out.println("Enter number of sales for month 3 for Sealy Phuket mattress: 20");
        System.out.println();
        System.out.println("Product Sales Report - 2026");
        System.out.println("*************************************");
        System.out.println("Total Product Sales:" + product.GetTotalProductsSold());
        System.out.println("Average Product Sales:",product.GetAverageProductSold());
        System.out.println("Most POpular Product:" + product.GetMostPopularProduct());
    }
    
} 

