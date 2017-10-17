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
    
    ValidationService validate = new ValidationService();

    // ======== Properties ========
    
    private int lineItemId;
    private Product product;
    private String productName;
    private int quantity;
    private CurrencyFormatService dollarFormat;
    private double productUnitPrice;
    private double productSalePrice;
    
    
    // ======== Constructor ========
    public LineItem(int lineItemId, Product product, int quantity, CurrencyFormatService dollarFormat) {
        
        setLineItemId(lineItemId);
        setProduct(product);
        setQuantity(quantity);
        setDollarFormat(dollarFormat);
        setProductName(product.getProdName());
        setProductUnitPrice();
        setProductSalePrice();
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
        validate.checkNotNull(productName);
        this.productName = productName;
    }
    
    public final CurrencyFormatService getCurrencyFormat() {
        return dollarFormat;
    }

    public final void setCurrencyFormat(CurrencyFormatService dollarFormat) {
        validate.checkNotNull(dollarFormat);
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
    
    public final void setQuantity(int quantity) {
        validate.checkNotNull(quantity);
        this.quantity = quantity;
    }
    
    
    public final int getLineItemId() {
        return lineItemId;
    }

    public final void setLineItemId(int lineItemId) {
        validate.checkNotNull(lineItemId);
        this.lineItemId = lineItemId;    }

    public final Product getProduct() {
        return product;
    }

    public final void setProduct(Product product) {
        validate.checkNotNull(product);
        this.product = product;
    }

    public final CurrencyFormatService getDollarFormat() {
        return dollarFormat;
    }
    
    public final void setDollarFormat(CurrencyFormatService dollarFormat) {
        validate.checkNotNull(dollarFormat);
        this.dollarFormat = dollarFormat;
    }
    
    public final void setProductUnitPrice() {
        this.productUnitPrice = product.getUnitCost();
    }

    public final void setProductSalePrice() {
        this.productSalePrice = product.getDiscountedAmount(productUnitPrice, quantity);
    }
}
