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
        Display videoScreen = new VideoScreenDisplay();
        Printer consolePrint = new PrintConsoleLog();
        ReceiptDataAccessStrategy dataStrategy = new InMemoryDatabase();
        
        // ======== Instantiate new PosRegister ========
        PosRegister register = new PosRegister(consolePrint, videoScreen, dataStrategy);
        
        // ======== Testing ========
        register.beginNewOrder(0, "100");
        register.addNewProductToPurchase(0);
        System.out.println("==========");
        register.completeOrder(0);
        
        System.out.println("========== Order # 2 ========");
        register.beginNewOrder(1, "200");
        register.addNewProductToPurchase(1);
        System.out.println("==========");
        register.completeOrder(1);
    }
    
}
