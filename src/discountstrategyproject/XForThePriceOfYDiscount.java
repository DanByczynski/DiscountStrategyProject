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
public class XForThePriceOfYDiscount implements DiscountStrategy {

    ValidationService validate = new ValidationService();
    
    // ======== Properties ========
    private int numberRequiredForFreeProduct;
    private int numberOfFreeProducts;
    private int calculatedNumberOfFreeProducts;
    
    public XForThePriceOfYDiscount(int numberRequiredForFreeProduct, int numberOfFreeProducts) {
        validate.checkNotNull(numberRequiredForFreeProduct);
        validate.checkNotNull(numberOfFreeProducts);
        
        setNumberRequiredForFreeProduct(numberRequiredForFreeProduct);
        setNumberOfFreeProducts(numberOfFreeProducts);
    }

    // ======== Logic Methods ========
    @Override
    public final double getDiscountAmount(double productUnitCost, int quantity) {
        validate.checkNotNull(productUnitCost);
        validate.checkNotNull(quantity);
        
        return calculatedDiscountAmount(productUnitCost, quantity);
    }

    private double calculatedDiscountAmount(double productUnitCost, int quantity) {
        validate.checkNotNull(productUnitCost);
        validate.checkNotNull(quantity);
        
        double discountedTotal = productUnitCost;
        
        // ==== Check if Customer purchased enough product to qualify for discount. ====
        if (quantity >= numberRequiredForFreeProduct){
            
            // ==== Calculate total number of free items ====
            calculatedNumberOfFreeProducts = calculateNumberOfFreeItems(quantity);
            
            // ==== Calculate the discounted total purchase price for the customer ====
            discountedTotal = calculateDiscountedTotal(productUnitCost, quantity);
            
        } else {
            // ==== No discount ====
            discountedTotal = productUnitCost * quantity;
        }
        
        // ==== return the discounted total divided by the quantity purchased ====
        return discountedTotal / quantity;
    }
    
    private int calculateNumberOfFreeItems(int quantity){
        validate.checkNotNull(quantity);
        
        int i = 0;
        for(int qty = quantity; qty >= numberRequiredForFreeProduct; qty -= numberRequiredForFreeProduct) {
            i++;
        }
        
        return i * numberOfFreeProducts;
    }
    
    private double calculateDiscountedTotal(double productUnitCost, int quantity){
        validate.checkNotNull(productUnitCost);
        validate.checkNotNull(quantity);
        
        return productUnitCost * (quantity - calculatedNumberOfFreeProducts);
    }
    
    // ======== Getters and Setters ========
    
    public final int getNumberRequiredForFreeProduct() {
        return numberRequiredForFreeProduct;
    }

    public final void setNumberRequiredForFreeProduct(int numberRequiredForFreeProduct) {
        validate.checkNotNull(numberRequiredForFreeProduct);
        
        this.numberRequiredForFreeProduct = numberRequiredForFreeProduct;
    }

    public final int getNumberOfFreeProducts() {
        return numberOfFreeProducts;
    }

    public final void setNumberOfFreeProducts(int numberOfFreeProducts) {
        validate.checkNotNull(numberOfFreeProducts);
        this.numberOfFreeProducts = numberOfFreeProducts;
    }
    
    // ======== HashCode(), Equals(), and toString() ========

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.validate);
        hash = 97 * hash + this.numberRequiredForFreeProduct;
        hash = 97 * hash + this.numberOfFreeProducts;
        hash = 97 * hash + this.calculatedNumberOfFreeProducts;
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
        final XForThePriceOfYDiscount other = (XForThePriceOfYDiscount) obj;
        if (this.numberRequiredForFreeProduct != other.numberRequiredForFreeProduct) {
            return false;
        }
        if (this.numberOfFreeProducts != other.numberOfFreeProducts) {
            return false;
        }
        if (this.calculatedNumberOfFreeProducts != other.calculatedNumberOfFreeProducts) {
            return false;
        }
        if (!Objects.equals(this.validate, other.validate)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "XForThePriceOfYDiscount{" + "validate=" + validate + ", numberRequiredForFreeProduct=" + numberRequiredForFreeProduct + ", numberOfFreeProducts=" + numberOfFreeProducts + ", calculatedNumberOfFreeProducts=" + calculatedNumberOfFreeProducts + '}';
    }
}
