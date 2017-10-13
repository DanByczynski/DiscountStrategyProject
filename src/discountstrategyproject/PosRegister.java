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
    Receipt[] receipts;

    Printer printObject;
    Display displayObject;
    ReceiptDataAccessStrategy dataStrategy;
    FormatService doubleFormat;


    
    // ======== Constructor ========
    PosRegister(Printer printObject, Display displayObject, ReceiptDataAccessStrategy dataStrategy, FormatService doubleFormat){
        setPrintObject(printObject);
        setDisplayObject(displayObject);
        setDataStrategy(dataStrategy);
        setDoubleFormat(doubleFormat);
        receipts = new Receipt[0];
    }
    
    // ======== Methods ========
    public final void beginNewOrder(int receiptId, String customerId){
        addNewReceiptToReceiptArray(new Receipt(receiptId, displayObject, printObject, customerId, dataStrategy, doubleFormat));
    }
    
    
    public final void addNewProductToPurchase(int receiptId, String productId, int quantity){
        receipts[receiptId].addNewProductToPurchase(receiptId, productId, quantity);
    }
    
    private final void addNewReceiptToReceiptArray(final Receipt receipt){
        Receipt[] temporaryReceiptArray = new Receipt[receipts.length + 1];
        System.arraycopy(receipts, 0, temporaryReceiptArray, 0, receipts.length);
        temporaryReceiptArray[receipts.length] = receipt;
        receipts = temporaryReceiptArray;
    }
    
    public final void completeOrder(int receiptId){
        receipts[receiptId].completeOrder(receiptId);
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
    
    public FormatService getDoubleFormat() {
        return doubleFormat;
    }

    public void setDoubleFormat(FormatService doubleFormat) {
        this.doubleFormat = doubleFormat;
    }
}
