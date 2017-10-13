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
    public void printHeader(int receiptId, String customerName) {
        System.out.println("================================================================================");
        System.out.println("================================================================================");
        System.out.println("==                                                                            ==");
        System.out.println("==                                                                            ==");
        System.out.println("==                                                                            ==");
        System.out.println("==                          KOHLS DEPARTMENT STORE                            ==");
        System.out.println("==                                                                            ==");
        System.out.println("==                          N95 W18000 Appleton Ave                           ==");
        System.out.println("==                         Menomonee Falls, WI 53051                          ==");
        System.out.println("==                                                                            ==");
        System.out.println("==                             #" + receiptId + " | " + customerName);
        System.out.println("==                                                                            ==");
    }
    
    @Override
    public final void printReceipt(String printableString) {
        System.out.println("== " + printableString);
    }

    @Override
    public void printFooter() {
        System.out.println("================================================================================");
        System.out.println("================================================================================");
        System.out.println("");
        System.out.println("");
        System.out.println("");
    }

}
