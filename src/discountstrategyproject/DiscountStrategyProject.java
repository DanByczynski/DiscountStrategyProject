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
        
        register.beginNewOrder(0);
        
        register.addNewProductToPurchase(0);
        
        System.out.println("==========");
        
        register.completeOrder(0);
        
        System.out.println("========== Order # 2 ========");
        register.beginNewOrder(1);
        
        register.addNewProductToPurchase(1);
        
        System.out.println("==========");
        
        register.completeOrder(1);
    }
    
}
