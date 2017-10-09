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
public class Receipt {
    private final int receiptId;
    Display videoScreen = new VideoScreenDisplay();
    Printer consolePrint = new PrintConsoleLog();
    
    public Receipt(int id){
        receiptId = id;
    }
    
    public final void addNewProductToPurchase(){
        System.out.println("Receipt id=" + receiptId + " | Product Added to Purchase");
        
        updateDisplay();
    }
    
    public final void completeOrder(){
        System.out.println("Order Completed");
        
        consolePrint.printReceipt();
    }
    
    private final void updateDisplay(){
        videoScreen.updateDisplay();
    }
    
}
