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
    
    // ======== Properties  ========
    Receipt[] receipt = new Receipt[3];

    Printer printObject;
    Display displayObject;
    ReceiptDataAccessStrategy dataStrategy;

    
    // ======== Constructor ========
    PosRegister(Printer printObject, Display displayObject, ReceiptDataAccessStrategy dataStrategy){
        setPrintObject(printObject);
        setDisplayObject(displayObject);
        setDataStrategy(dataStrategy);
    }
    
    // ======== Methods ========
    public final void beginNewOrder(int receiptId){
        receipt[receiptId] = new Receipt(receiptId, displayObject, printObject, dataStrategy);
    }
    
    public final void addNewProductToPurchase(int receiptId){
        receipt[receiptId].addNewProductToPurchase(receiptId);
    }
    
    public final void completeOrder(int receiptId){
        receipt[receiptId].completeOrder(receiptId);
    }
    
    // ======== Getters and Setters ========
    
    public Printer getPrintObject() {
        return printObject;
    }

    public final void setPrintObject(Printer printObject) {
        this.printObject = printObject;
    }

    public Display getDisplayObject() {
        return displayObject;
    }

    public final void setDisplayObject(Display displayObject) {
        this.displayObject = displayObject;
    }

    private ReceiptDataAccessStrategy getDataStrategy() {
        return dataStrategy;
    }

    private void setDataStrategy(ReceiptDataAccessStrategy dataStrategy) {
        this.dataStrategy = dataStrategy;
    }
}
