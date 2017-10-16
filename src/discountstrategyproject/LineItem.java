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
    private CurrencyFormatService dollarFormat;
    private final double productUnitPrice;
    private final double productSalePrice;
    
    
    // ======== Constructor ========
    public LineItem(int lineItemId, Product product, int quantity, CurrencyFormatService doubleFormat) {
        this.lineItemId = lineItemId;
        this.product = product;
        this.quantity = quantity;
        setDoubleFormat(doubleFormat);
        this.productUnitPrice = product.getUnitCost();
        setProductName(product.getProdName());
        this.productSalePrice = product.getDiscountedAmount(productUnitPrice, quantity);
    }
    
    // ======== Methods ========
    public String printLineItem(){
        return (productName + " | Quantity: " + quantity + "| Unit Price: " + dollarFormat.formatDouble(productUnitPrice) + "| Sale Price: " + dollarFormat.formatDouble(productSalePrice));
    }
    
    // ======== Getters and Setters ========
    
    public final String getProductName() {
        return productName;
    }

    public final void setProductName(String productName) {
        this.productName = productName;
    }
    
    public final CurrencyFormatService getDoubleFormat() {
        return dollarFormat;
    }

    public final void setDoubleFormat(CurrencyFormatService doubleFormat) {
        this.dollarFormat = doubleFormat;
    }
    
    public final double getProductUnitPrice() {
        return productUnitPrice;
    }

    public final double getProductSalePrice() {
        return productSalePrice;
    }
    
    public final int getQuantity() {
        return quantity;
    }
}
