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
public class Product {
    
    ValidationService validate = new ValidationService();

    // ======== Property Declarations ========
    
    private String prodId;
    private String prodName;
    private double unitCost;
    private DiscountStrategy discount;
    
    // ======== Constructor ========
    public Product(String prodId, String prodName, double unitCost, DiscountStrategy discount) {
        setProdId(prodId);
        setProdName(prodName);
        setUnitCost(unitCost);
        setDiscount(discount);
    }
    
    // ======== Property Value Getters ========
    public final String getProdId() {
        return prodId;
    }

    public final String getProdName() {
        return prodName;
    }

    public final double getUnitCost() {
        return unitCost;
    }

    public final double getDiscountedAmount(double productUnitPrice, int quantity) {
        return discount.getDiscountAmount(productUnitPrice, quantity);
    }
    
    public final void setProdId(String prodId) {
        validate.checkNotNull(prodId);
        this.prodId = prodId;
    }

    public final void setProdName(String prodName) {
        validate.checkNotNull(prodName);
        this.prodName = prodName;
    }

    public final void setUnitCost(double unitCost) {
        validate.checkNotNull(unitCost);
        this.unitCost = unitCost;
    }
    
    public final void setDiscount(DiscountStrategy discount) {
        validate.checkNotNull(discount);
        this.discount = discount;
    }
    
    // ======== HashCode(), Equals(), and toString() ========

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + Objects.hashCode(this.validate);
        hash = 43 * hash + Objects.hashCode(this.prodId);
        hash = 43 * hash + Objects.hashCode(this.prodName);
        hash = 43 * hash + (int) (Double.doubleToLongBits(this.unitCost) ^ (Double.doubleToLongBits(this.unitCost) >>> 32));
        hash = 43 * hash + Objects.hashCode(this.discount);
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
        final Product other = (Product) obj;
        if (Double.doubleToLongBits(this.unitCost) != Double.doubleToLongBits(other.unitCost)) {
            return false;
        }
        if (!Objects.equals(this.prodId, other.prodId)) {
            return false;
        }
        if (!Objects.equals(this.prodName, other.prodName)) {
            return false;
        }
        if (!Objects.equals(this.validate, other.validate)) {
            return false;
        }
        if (!Objects.equals(this.discount, other.discount)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Product{" + "validate=" + validate + ", prodId=" + prodId + ", prodName=" + prodName + ", unitCost=" + unitCost + ", discount=" + discount + '}';
    }
}
