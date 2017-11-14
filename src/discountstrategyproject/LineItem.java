/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategyproject;

import java.util.Objects;

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
    
    // ======== HashCode(), Equals(), and toString() ========

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.validate);
        hash = 43 * hash + this.lineItemId;
        hash = 43 * hash + Objects.hashCode(this.product);
        hash = 43 * hash + Objects.hashCode(this.productName);
        hash = 43 * hash + this.quantity;
        hash = 43 * hash + Objects.hashCode(this.dollarFormat);
        hash = 43 * hash + (int) (Double.doubleToLongBits(this.productUnitPrice) ^ (Double.doubleToLongBits(this.productUnitPrice) >>> 32));
        hash = 43 * hash + (int) (Double.doubleToLongBits(this.productSalePrice) ^ (Double.doubleToLongBits(this.productSalePrice) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LineItem other = (LineItem) obj;
        if (this.lineItemId != other.lineItemId) {
            return false;
        }
        if (this.quantity != other.quantity) {
            return false;
        }
        if (Double.doubleToLongBits(this.productUnitPrice) != Double.doubleToLongBits(other.productUnitPrice)) {
            return false;
        }
        if (Double.doubleToLongBits(this.productSalePrice) != Double.doubleToLongBits(other.productSalePrice)) {
            return false;
        }
        if (!Objects.equals(this.productName, other.productName)) {
            return false;
        }
        if (!Objects.equals(this.validate, other.validate)) {
            return false;
        }
        if (!Objects.equals(this.product, other.product)) {
            return false;
        }
        if (!Objects.equals(this.dollarFormat, other.dollarFormat)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "LineItem{" + "validate=" + validate + ", lineItemId=" + lineItemId + ", product=" + product + ", productName=" + productName + ", quantity=" + quantity + ", dollarFormat=" + dollarFormat + ", productUnitPrice=" + productUnitPrice + ", productSalePrice=" + productSalePrice + '}';
    }
}
