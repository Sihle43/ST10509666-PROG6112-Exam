/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.productsalesreport;

/**
 *
 * @author siphoesihle
 */
public class Product {

   
     public interface IProduct {
    int GetTotalProductSold();
    double GetAverageProductSold();
    String GetMostPopularProduct();
}
 
     public class Product implements IProduct {
     
     String[] productNames = {"Cozy Nights Monarch","Restonic Barbados","Sealy Phuket"};
     
     int[][] salesData = {{63,18,20},{15,10,12},{18,15,20}};
     
     @Override 
     public int GetTotalProductSold(){
         int total = 0;
         for (int i = 0; i< salesData.length; i++){
             for (int j = 0; j< salesData[i].length; j++){
                 total += salesData[i][j];
             }
         }
      return total;
     }
      
     @Override
     public double GetAverageProductSold(){
     int total = GetTotalProductSold();
     int totalEntries = salesData.length * salesData[0].length;
     return(double) total;
     
     } 
     
     @Override
     public  String GetMostPopularProduct(){
     int maxsales = -1;
     int productIndex = 0;
     for (int i = 0; i< salesData.length; i++){
         int currentProductTotal = 0;
             for (int j = 0; j< salesData[i].length; j++){
                 currentProductTotal = salesData[i][j];
 }
    if (currentProductTotal > maxsales){
        maxsales = currentProductTotal;
        productIndex = i;
 }
     }
 
    return productNames[productIndex]+ ("maxsales +");
 }
  public String[] getProductNames(){
      return productNames;
  }
  public int[][] getSales(){
      return salesData;
  }
}

}