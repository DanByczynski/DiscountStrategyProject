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
    public abstract Customer findCustomerById(final String custId);
    public abstract Product findProductById(final String prodId);
}
