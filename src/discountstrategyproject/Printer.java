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
public interface Printer {
    public abstract void printHeader(final int receiptId, final String customerName);
    public abstract void printReceipt(final String printableString);
    public abstract void printFooter();
    public abstract void printBlankLine();
}
