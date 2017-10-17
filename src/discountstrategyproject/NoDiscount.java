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
public class NoDiscount implements DiscountStrategy {

    ValidationService validate = new ValidationService();
    
    @Override
    public double getDiscountAmount(double productUnitCost, int quantity) {
        validate.checkNotNull(productUnitCost);
        validate.checkNotNull(quantity);
        return productUnitCost;
    }
    
}
