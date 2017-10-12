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
interface ReceiptDataAccessStrategy {
    public abstract Customer findCustomer(final String custId);
    public abstract Product findProduct(final String prodId);
}
