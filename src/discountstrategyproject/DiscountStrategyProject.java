/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategyproject;
/**
 *
 * @author danielbyczynski
 */
public class DiscountStrategyProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // ======== Configuration ========
        // Configures output classes
        Display videoScreen = new VideoScreenDisplay();
        Printer consolePrint = new PrintConsoleLog();
        
        // Configures data storage classes
        ReceiptDataAccessStrategy dataStrategy = new InMemoryDatabase();
        
        // Configure FormatService for double to currency format
        FormatService formatDouble = new CurrencyFormatter();
        
        
        // ======== Instantiate new PosRegister ========
        PosRegister register = new PosRegister(consolePrint, videoScreen, dataStrategy, formatDouble);
        
        // ======== Testing ========
        register.beginNewOrder(0, "100");
        register.addNewProductToPurchase(0, "A101", 1);
        register.addNewProductToPurchase(0, "C222", 4);
        register.addNewProductToPurchase(0, "B205", 4);
        register.completeOrder(0);
        
        System.out.println("========== Order # 2 ========");
        register.beginNewOrder(1, "200");
        register.addNewProductToPurchase(1, "A101", 5);
        register.addNewProductToPurchase(1, "C222", 4);
        register.completeOrder(1);
        
        System.out.println("========== Order # 3 ========");
        register.beginNewOrder(2, "300");
        register.addNewProductToPurchase(2, "A101", 5);
        register.addNewProductToPurchase(2, "C222", 4);
        register.completeOrder(2);
        
    }
    
}
