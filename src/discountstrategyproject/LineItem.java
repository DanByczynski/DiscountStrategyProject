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
    private int quantity;
    private CurrencyFormatService dollarFormat;
    private final double productUnitPrice;
    private final double productSalePrice;
    
    
    // ======== Constructor ========
    public LineItem(int lineItemId, Product product, int quantity, CurrencyFormatService dollarFormat) {
        this.lineItemId = lineItemId;
        this.product = product;
        this.quantity = quantity;
        setCurrencyFormat(dollarFormat);
        this.productUnitPrice = product.getUnitCost();
        setProductName(product.getProdName());
        this.productSalePrice = product.getDiscountedAmount(productUnitPrice, quantity);
    }
    
    // ======== Methods ========
    public String printLineItem(){
        return (productName + " | " + quantity + "     " + dollarFormat.formatDouble(productUnitPrice) +  "   " + dollarFormat.formatDouble(productSalePrice) + "   " + dollarFormat.formatDouble(productUnitPrice * quantity) + "   " + dollarFormat.formatDouble(productSalePrice * quantity));
    }
    
    // ======== Getters and Setters ========
    
    public final String getProductName() {
        return productName;
    }

    public final void setProductName(String productName) {
        this.productName = productName;
    }
    
    public final CurrencyFormatService getCurrencyFormat() {
        return dollarFormat;
    }

    public final void setCurrencyFormat(CurrencyFormatService dollarFormat) {
        this.dollarFormat = dollarFormat;
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
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
