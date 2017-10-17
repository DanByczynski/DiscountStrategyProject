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
public class XForThePriceOfYDiscount implements DiscountStrategy {

    // ======== Properties ========
    private int numberRequiredForFreeProduct;
    private int numberOfFreeProducts;
    private int calculatedNumberOfFreeProducts;
    
    public XForThePriceOfYDiscount(int numberRequiredForFreeProduct, int numberOfFreeProducts) {
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
        int i = 0;
        for(int qty = quantity; qty >= numberRequiredForFreeProduct; qty -= numberRequiredForFreeProduct) {
            i++;
        }
        
        return i * numberOfFreeProducts;
    }
    
    private double calculateDiscountedTotal(double productUnitCost, int quantity){
        return productUnitCost * (quantity - calculatedNumberOfFreeProducts);
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
