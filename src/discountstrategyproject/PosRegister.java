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
public class PosRegister {
    
    Receipt receipt = new Receipt();
    
    public void PosRegister(){
        
    }
    
    public final void addNewProductToPurchase(){
        receipt.addNewProductToPurchase();
    }
    
    public final void completeOrder(){
        receipt.completeOrder();
    }
}
