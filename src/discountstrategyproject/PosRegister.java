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
    
    ValidationService validate = new ValidationService();
    // ======== Properties  ========
    Receipt[] receipts;
    Printer printObject;
    Display displayObject;
    ReceiptDataAccessStrategy dataStrategy;
    CurrencyFormatService doubleFormat;


    
    // ======== Constructor ========
    PosRegister(Printer printObject, Display displayObject, ReceiptDataAccessStrategy dataStrategy, CurrencyFormatService doubleFormat){
        setPrintObject(printObject);
        setDisplayObject(displayObject);
        setDataStrategy(dataStrategy);
        setDoubleFormat(doubleFormat);
        receipts = new Receipt[0];
    }
    
    // ======== Methods ========
    public final void beginNewOrder(int receiptId, String customerId){
        validate.checkNotNull(receiptId);
        validate.checkNotNull(customerId);
        
        addNewReceiptToReceiptArray(new Receipt(receiptId, displayObject, printObject, customerId, dataStrategy, doubleFormat));
    }
    
    
    public final void addNewProductToPurchase(int receiptId, String productId, int quantity){
        validate.checkNotNull(receiptId);
        validate.checkNotNull(productId);
        validate.checkNotNull(quantity);
        
        receipts[receiptId].addNewProductToPurchase(receiptId, productId, quantity);
    }
    
    private final void addNewReceiptToReceiptArray(final Receipt receipt){
        validate.checkNotNull(receipt);
        
        Receipt[] temporaryReceiptArray = new Receipt[receipts.length + 1];
        System.arraycopy(receipts, 0, temporaryReceiptArray, 0, receipts.length);
        temporaryReceiptArray[receipts.length] = receipt;
        receipts = temporaryReceiptArray;
    }
    
    public final void completeOrder(int receiptId){
        validate.checkNotNull(receiptId);
        receipts[receiptId].completeOrder(receiptId);
    }
    
    // ======== Getters and Setters ========
    
    public Printer getPrintObject() {
        return printObject;
    }

    public final void setPrintObject(Printer printObject) {
        validate.checkNotNull(printObject);
        this.printObject = printObject;
    }

    public Display getDisplayObject() {
        return displayObject;
    }

    public final void setDisplayObject(Display displayObject) {
        validate.checkNotNull(displayObject);
        this.displayObject = displayObject;
    }

    private ReceiptDataAccessStrategy getDataStrategy() {
        return dataStrategy;
    }

    private void setDataStrategy(ReceiptDataAccessStrategy dataStrategy) {
        validate.checkNotNull(dataStrategy);
        this.dataStrategy = dataStrategy;
    }
    
    public CurrencyFormatService getDoubleFormat() {
        return doubleFormat;
    }

    public void setDoubleFormat(CurrencyFormatService doubleFormat) {
        validate.checkNotNull(doubleFormat);
        this.doubleFormat = doubleFormat;
    }
}
