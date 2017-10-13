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
    private Customer customer;

    private ReceiptDataAccessStrategy dataStrategy;
    private LineItem[] lineItems = new LineItem[1];
    private String productId;
    

    
    // ======== Constructor ========

    public Receipt(int receiptId, Display displayObject, Printer printerObject, String customerId, ReceiptDataAccessStrategy dataStrategy) {
        setReceiptId(receiptId);
        setDisplayObject(displayObject);
        setPrinterObject(printerObject);
        setCustomer(dataStrategy.findCustomerById(customerId));
        setDataStrategy(dataStrategy);
        System.out.println("Cusotmer: " + customer.getCustomerName());
    }
    
    
    // ======== Methods ========

    public final void addNewProductToPurchase(int receiptId, String productId, int quantity) {
        lineItems[receiptId] = new LineItem( 0, dataStrategy.findProductById(productId), quantity);
        lineItems[receiptId].printLineItem();
        
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
    
    public Customer getCustomer() {
        return customer;
    }

    public final void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    public ReceiptDataAccessStrategy getDataStrategy() {
        return dataStrategy;
    }

    public final void setDataStrategy(ReceiptDataAccessStrategy dataStrategy) {
        this.dataStrategy = dataStrategy;
    }
}
