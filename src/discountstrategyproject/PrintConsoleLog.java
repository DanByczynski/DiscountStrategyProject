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
public class PrintConsoleLog implements Printer{

    @Override
    public final void printReceipt() {
        System.out.println("Receipt Printed!");
    }
}
