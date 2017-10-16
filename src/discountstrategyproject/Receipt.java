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
    private FormatService doubleFormat;
    
    private LineItem[] lineItems;
    private String productId;
    

    
    // ======== Constructor ========

    public Receipt(int receiptId, Display displayObject, Printer printerObject, String customerId, ReceiptDataAccessStrategy dataStrategy, FormatService doubleFormat) {
        setReceiptId(receiptId);
        setDisplayObject(displayObject);
        setPrinterObject(printerObject);
        setCustomer(dataStrategy.findCustomerById(customerId));
        setDataStrategy(dataStrategy);
        setDoubleFormat(doubleFormat);
        lineItems = new LineItem[0];
    }
    
    
    // ======== Methods ========

    public final void addNewProductToPurchase(int receiptId, String productId, int quantity) {
        addNewLineItemToArray(new LineItem(0, dataStrategy.findProductById(productId), quantity, doubleFormat));
        updateDisplay();
    }
    
    // ==== Add new lineItem to lineItems array by copying and re-initializing ====
    private final void addNewLineItemToArray(final LineItem lineItem) {
        LineItem[] temporaryLineItemArray = new LineItem[lineItems.length + 1];
        System.arraycopy(lineItems, 0, temporaryLineItemArray, 0, lineItems.length);
        temporaryLineItemArray[lineItems.length] = lineItem;
        lineItems = temporaryLineItemArray;
    }
    
    // Calculate total of lineItems in Receipt.
    private final String calculateLineItemTotal(){
        double unitPriceTotal = 0;
        double salePriceTotal = 0;
        int quantity;
        
        String newline = System.getProperty("line.separator");
        
        for (int i = 0; i < lineItems.length; i++){
            quantity = lineItems[i].getQuantity();
            unitPriceTotal += (lineItems[i].getProductUnitPrice() * quantity);
            salePriceTotal += lineItems[i].getProductSalePrice();
        }
        
        return "Unit Total: " + doubleFormat.formatDouble(unitPriceTotal) + newline + "== Sale Total: " + doubleFormat.formatDouble(salePriceTotal) + newline + "== You saved: " + doubleFormat.formatDouble(unitPriceTotal - salePriceTotal);
    }
    
    private final String calculateSalesTax(){
        return "";
    }
    
    // ==== Generate Final Receipt for Printing ====
    public final void completeOrder(int receiptId){
        
        // Tell printer object to print receipt header
        printerObject.printHeader(receiptId, customer.getCustomerName());
        
        // Iterate through lineItems and print them all in order.
        for (int i = 0; i < lineItems.length; i++){
            printerObject.printReceipt(lineItems[i].printLineItem());
        }
        
        // Print total for purchase.
        printerObject.printBlankLine();
        printerObject.printReceipt(calculateLineItemTotal());
        
        // Tell printer object to print footer.
        printerObject.printFooter();
    }
    
    
    
    // ==== Update display when new items are entered ====
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
    
    public FormatService getDoubleFormat() {
        return doubleFormat;
    }

    public final void setDoubleFormat(FormatService doubleFormat) {
        this.doubleFormat = doubleFormat;
    }
}
