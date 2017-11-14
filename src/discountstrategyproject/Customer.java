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
    
    // ======== HashCode(), Equals(), and toString() ========
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + Objects.hashCode(this.customerId);
        hash = 13 * hash + Objects.hashCode(this.customerName);
        hash = 13 * hash + Objects.hashCode(this.validate);
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
        final Customer other = (Customer) obj;
        if (!Objects.equals(this.customerId, other.customerId)) {
            return false;
        }
        if (!Objects.equals(this.customerName, other.customerName)) {
            return false;
        }
        if (!Objects.equals(this.validate, other.validate)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Customer{" + "customerId=" + customerId + ", customerName=" + customerName + ", validate=" + validate + '}';
    }
}
