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
    
}
