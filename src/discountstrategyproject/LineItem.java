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
public class LineItem {
    
    // ======== Properties ========
    private final int lineItemId;
    private final Product product;
    private String productName;
    private final int quantity;
    
    // ======== Constructor ========
    public LineItem(int lineItemId, Product product, int quantity) {
        this.lineItemId = lineItemId;
        this.product = product;
        this.quantity = quantity;
        setProductName(product.getProdName());
        System.out.println(quantity);
    }
    
    // ======== Methods ========
    public void printLineItem(){
        System.out.println(productName + " Quantity: " + quantity);
    }
    
    // ======== Getters and Setters ========
    
    public String getProductName() {
        return productName;
    }

    public final void setProductName(String productName) {
        this.productName = productName;
    }
}
