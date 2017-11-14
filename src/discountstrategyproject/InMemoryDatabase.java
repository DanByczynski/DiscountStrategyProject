/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategyproject;

import java.util.Arrays;

/**
 *
 * @author danielbyczynski
 */

// ======== In Memory implementation of ReceiptDataAccessStrategy Interface ========
public class InMemoryDatabase implements ReceiptDataAccessStrategy {
    
    // ======== Create array of Customer objects ========
    private final Customer[] customers = {
        new Customer("100", "John Smith"),
        new Customer("200", "Sally Jones"),
        new Customer("300", "Bob Clementi")
    };
    
    // ======== Create array of Product objects ========
    private final Product[] products = {
        new Product("A101", "MLB Brewer's Hat ", 19.95, new PercentOffDiscount(0.15)),
        new Product("B202", "Men's Dress Shirt", 35.50, new PercentOffDiscount(0.15)),
        new Product("C303", "Women's Socks    ", 9.50, new NoDiscount()),
        new Product("D404", "Men's Sandals    ", 15.95, new XForThePriceOfYDiscount(2, 1)),
        new Product("E505", "Candy Bar        ", 0.35, new XForThePriceOfYDiscount(5, 1)),
    };
    
    // ======== Method overrides for ReceiptDataAccessStrategy interface ========
    // ==== Find and Return customer object by custId ====
    @Override
    public final Customer findCustomerById(final String custId) {
        // validation is needed for method parameter
        if(custId == null || custId.length() == 0) {
            System.out.println("Sorry, FakeDatabase.findCustomer method has "
                    + "illegal argument");
            return null;  // end method prematurely after log to console
        }
        
        Customer customer = null;
        for(Customer c : customers) {
            if(!custId.equals(c.getCustomerId())) {
            } else {
                customer = c;
                break;
            }
        }
        
        return customer;
    }
    
    
    // ==== Find and Return customer object by prodId ====
    @Override
    public final Product findProductById(final String prodId) {
        // validation is needed for method parameter
        if(prodId == null || prodId.length() == 0) {
            System.out.println("Sorry, FakeDatabase.findProduct method has "
                    + "illegal argument");
            return null;  // end method prematurely after log to console
        }
        
        Product product = null;
        for(Product p : products) {
            if(prodId.equals(p.getProdId())) {
                product = p;
                break;
            }
        }
        
        return product;
    }
    
    // ======== HashCode(), Equals(), and toString() ========

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Arrays.deepHashCode(this.customers);
        hash = 89 * hash + Arrays.deepHashCode(this.products);
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
        final InMemoryDatabase other = (InMemoryDatabase) obj;
        if (!Arrays.deepEquals(this.customers, other.customers)) {
            return false;
        }
        if (!Arrays.deepEquals(this.products, other.products)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "InMemoryDatabase{" + "customers=" + customers + ", products=" + products + '}';
    }
}

