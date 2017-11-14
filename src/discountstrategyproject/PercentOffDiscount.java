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
public final class PercentOffDiscount implements DiscountStrategy {
    
    ValidationService validate = new ValidationService();
    
    // ======== Properties ========
    private double discountPercentInput = 0;

    // ======== Constructor ========

    public PercentOffDiscount(double discountPercentInput) {
        setDiscountPercentInput(discountPercentInput);
    }
    
    
    // ======== Interface Method Overrides ========
    @Override
    public double getDiscountAmount(double productUnitCost, int quantity) {
        validate.checkNotNull(productUnitCost);
        validate.checkNotNull(quantity);
        
        return calculatedDiscountAmount(productUnitCost, quantity);
    }
    
    private double calculatedDiscountAmount(double productUnitCost, int quantity){
        validate.checkNotNull(productUnitCost);
        validate.checkNotNull(quantity);
        
        return ((productUnitCost * quantity) - (productUnitCost * quantity * discountPercentInput));
    }
    
    // ======== Getters and Setters ========
    public void setDiscountPercentInput(double discountPercentInput) {
        validate.checkNotNull(discountPercentInput);
        validate.checkValidDiscount(discountPercentInput);
        this.discountPercentInput = discountPercentInput;
    }
    
    public double getDiscountPercentInput() {
        return discountPercentInput;
    }
    
    // ======== HashCode(), Equals(), and toString() ========

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.validate);
        hash = 11 * hash + (int) (Double.doubleToLongBits(this.discountPercentInput) ^ (Double.doubleToLongBits(this.discountPercentInput) >>> 32));
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
        final PercentOffDiscount other = (PercentOffDiscount) obj;
        if (Double.doubleToLongBits(this.discountPercentInput) != Double.doubleToLongBits(other.discountPercentInput)) {
            return false;
        }
        if (!Objects.equals(this.validate, other.validate)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PercentOffDiscount{" + "validate=" + validate + ", discountPercentInput=" + discountPercentInput + '}';
    }
}
