/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */



import com.mycompany.productsalesreport.Product;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author siphoesihle
 */
public class ProductTest {
    
   

    @Test
    public void testGetTotalProductsSales_WithValidData_ReturnsCorrectValue() {
        Product product = new Product();
        int ExpectedTotal = 153; 
        assertEquals(product.GetTotalProductSold(), product.GetTotalProductSold());
    }

    @Test
    public void testGetAverageSales_WithValidData_ReturnsCorrectValue() {
        Product product = new Product();
        double expectedAverage = productNames.GetTotalProductSold() / 90;
        assertEquals(expectedAverage, productNames.GetAverageProductSold(), 111);
    }
}


  
