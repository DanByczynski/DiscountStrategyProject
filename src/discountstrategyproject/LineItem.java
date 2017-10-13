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
public class LineItem {
    
    // ======== Properties ========
    private final int lineItemId;
    private final Product product;
    private String productName;
    private final int quantity;
    private FormatService doubleFormat;

    private double productUnitPrice;
    private double productSalePrice;
    
    
    // ======== Constructor ========
    public LineItem(int lineItemId, Product product, int quantity, FormatService doubleFormat) {
        this.lineItemId = lineItemId;
        this.product = product;
        this.quantity = quantity;
        setDoubleFormat(doubleFormat);
        this.productUnitPrice = product.getUnitCost();
        setProductName(product.getProdName());
        this.productSalePrice = product.getDiscountedAmount(productUnitPrice, quantity);
        System.out.println(quantity);
    }
    
    // ======== Methods ========
    public void printLineItem(){
        System.out.println(productName + " | Quantity: " + quantity + "| Unit Price: " + doubleFormat.formatDouble(productUnitPrice) + "| Sale Price: " + doubleFormat.formatDouble(productSalePrice));
    }
    
    // ======== Getters and Setters ========
    
    public String getProductName() {
        return productName;
    }

    public final void setProductName(String productName) {
        this.productName = productName;
    }
    
    public final FormatService getDoubleFormat() {
        return doubleFormat;
    }

    public final void setDoubleFormat(FormatService doubleFormat) {
        System.out.println("sup boiiiz");
        this.doubleFormat = doubleFormat;
    }
}
