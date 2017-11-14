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
public class NoDiscount implements DiscountStrategy {

    ValidationService validate = new ValidationService();
    
    @Override
    public double getDiscountAmount(double productUnitCost, int quantity) {
        validate.checkNotNull(productUnitCost);
        validate.checkNotNull(quantity);
        return productUnitCost;
    }
    
    // ======== HashCode(), Equals(), and toString() ========

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.validate);
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
        final NoDiscount other = (NoDiscount) obj;
        if (!Objects.equals(this.validate, other.validate)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "NoDiscount{" + "validate=" + validate + '}';
    }
}
