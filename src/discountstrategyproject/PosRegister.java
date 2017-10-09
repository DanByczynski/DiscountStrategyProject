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
    
    Receipt[] receipt = new Receipt[3];
    
    public void PosRegister(){
        
    }
    
    public final void beginNewOrder(){
        receipt[0] = new Receipt(0);
    }
    
    public final void addNewProductToPurchase(){
        this.receipt[0].addNewProductToPurchase();
    }
    
    public final void completeOrder(){
        this.receipt[0].completeOrder();
    }
}
