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
    
    // ======== Property Declarations ========
    private final String prodId;
    private final String prodName;
    private final double unitCost;
    private final DiscountStrategy discount;
    
    // ======== Constructor ========
    public Product(String prodId, String prodName, double unitCost, DiscountStrategy discount) {
        this.prodId = prodId;
        this.prodName = prodName;
        this.unitCost = unitCost;
        this.discount = discount;
    }
    
    // ======== Property Value Getters ========
    public String getProdId() {
        return prodId;
    }

    public String getProdName() {
        return prodName;
    }

    public double getUnitCost() {
        return unitCost;
    }
    
    public DiscountStrategy getDiscount() {
        return discount;
    }
}
