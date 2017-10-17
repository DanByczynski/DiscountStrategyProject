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
public class BuyXGetYFreeDiscount implements DiscountStrategy {

    // ======== Properties ========
    private int numberRequiredForFreeProduct;
    private int numberOfFreeProducts;
    
    public BuyXGetYFreeDiscount(int numberRequiredForFreeProduct, int numberOfFreeProducts) {
        setNumberRequiredForFreeProduct(numberRequiredForFreeProduct);
        setNumberOfFreeProducts(numberOfFreeProducts);
    }

    // ======== Logic Methods ========
    @Override
    public final double getDiscountAmount(double productUnitCost, int quantity) {
        return calculatedDiscountAmount(productUnitCost, quantity);
    }

    private double calculatedDiscountAmount(double productUnitCost, int quantity) {
        double discountedTotal = productUnitCost;
        
        if (quantity >= numberRequiredForFreeProduct){
            discountedTotal = productUnitCost * (quantity - numberOfFreeProducts);
        }
        
        return discountedTotal / quantity;
    }
    
    // ======== Getters and Setters ========
    
    public final int getNumberRequiredForFreeProduct() {
        return numberRequiredForFreeProduct;
    }

    public final void setNumberRequiredForFreeProduct(int numberRequiredForFreeProduct) {
        this.numberRequiredForFreeProduct = numberRequiredForFreeProduct;
    }

    public final int getNumberOfFreeProducts() {
        return numberOfFreeProducts;
    }

    public final void setNumberOfFreeProducts(int numberOfFreeProducts) {
        this.numberOfFreeProducts = numberOfFreeProducts;
    }
    
}
