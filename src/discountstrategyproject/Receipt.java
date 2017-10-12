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
    
    // ======== Properties ========
    private int receiptId;
    private Display displayObject;
    private Printer printerObject;
    private ReceiptDataAccessStrategy dataStrategy;

    
    // ======== Constructor ========

    public Receipt(int receiptId, Display displayObject, Printer printerObject, ReceiptDataAccessStrategy dataStrategy) {
        setReceiptId(receiptId);
        setDisplayObject(displayObject);
        setPrinterObject(printerObject);
        setDataStrategy(dataStrategy);
    }
    
    
    // ======== Methods ========
    public final void addNewProductToPurchase(int receiptId){
        System.out.println("Receipt id=" + receiptId + " | Product Added to Purchase");
        
        updateDisplay();
    }
    
    public final void completeOrder(int receiptId){
        System.out.println("Receipt id=" + receiptId + " | Order Completed");
        
        printerObject.printReceipt();
    }
    
    private void updateDisplay(){
        displayObject.updateDisplay();
    }

    // ======== Getters and Setters ========
    public final int getReceiptId() {
        return receiptId;
    }

    public final void setReceiptId(int receiptId) {
        this.receiptId = receiptId;
    }

    public final Display getDisplayObject() {
        return displayObject;
    }

    public final void setDisplayObject(Display displayObject) {
        this.displayObject = displayObject;
    }

    public final Printer getPrinterObject() {
        return printerObject;
    }

    public final void setPrinterObject(Printer printerObject) {
        this.printerObject = printerObject;
    }
    
    public ReceiptDataAccessStrategy getDataStrategy() {
        return dataStrategy;
    }

    public final void setDataStrategy(ReceiptDataAccessStrategy dataStrategy) {
        this.dataStrategy = dataStrategy;
    }
}
