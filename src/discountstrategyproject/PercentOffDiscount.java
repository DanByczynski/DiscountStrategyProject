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
public final class PercentOffDiscount implements DiscountStrategy {
    
    // ======== Properties ========
    private double discountPercentInput = 0;

    // ======== Constructor ========

    public PercentOffDiscount(double discountPercentInput) {
        setDiscountPercentInput(discountPercentInput);
    }
    
    
    // ======== Interface Method Overrides ========
    @Override
    public double getDiscountAmount() {
        return 0;
    }
    
    // 
    
    // ======== Getters and Setters ========
    public void setDiscountPercentInput(double discountPercentInput) {
        this.discountPercentInput = discountPercentInput;
    }
    
    public double getDiscountPercentInput() {
        return discountPercentInput;
    }
    
}
