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
        
        // Instantiate new PosRegister to handle requests:
        PosRegister register = new PosRegister();
        
        register.addNewProductToPurchase();
        
        System.out.println("==========");
        
        register.completeOrder();
    }
    
}
