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
public class Customer {

    // ======== Properties ========
    private String customerId;
    private String customerName;
    ValidationService validate = new ValidationService();
    
    // ======== Constructor ========
    public Customer(String customerId, String customerName) {
        setCustomerId(customerId);
        setCustomerName(customerName);
    }
    
    // ======== Getters and Setters ========
    public final String getCustomerId() {
        return customerId;
    }

    private final void setCustomerId(String customerId) {
        validate.checkNotNull(customerId);
        this.customerId = customerId;
    }

    public final String getCustomerName() {
        return customerName;
    }
    
    private final void setCustomerName(String customerName) {
        validate.checkNotNull(customerName);
        this.customerName = customerName;
    }
    
}
