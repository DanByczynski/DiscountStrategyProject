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
    
    public final void beginNewOrder(int receiptId){
        receipt[receiptId] = new Receipt(receiptId);
    }
    
    public final void addNewProductToPurchase(int receiptId){
        receipt[receiptId].addNewProductToPurchase(receiptId);
    }
    
    public final void completeOrder(int receiptId){
        receipt[receiptId].completeOrder(receiptId);
    }
}
