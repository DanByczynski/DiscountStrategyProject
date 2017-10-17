/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategyproject;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author danielbyczynski
 */
public class PrintConsoleLog implements Printer{

    @Override
    public void printHeader(int receiptId, String customerName) {
        printSolidLine();
        printSolidLine();
        printBlankLine();
        printBlankLine();
        printBlankLine();
        System.out.println("==                          KOHLS DEPARTMENT STORE                            ==");
        printBlankLine();
        System.out.println("==                          N95 W18000 Appleton Ave                           ==");
        System.out.println("==                         Menomonee Falls, WI 53051                          ==");
        System.out.println("==                             " + getCurrentDateString());
        printBlankLine();
        printBlankLine();
        printBlankLine();
        System.out.println("==   #" + receiptId + "  Customer: " + customerName);
        
        printBlankLine();
        printBlankLine();
    }
    
    @Override
    public final void printReceipt(String printableString) {
        System.out.println("== " + printableString);
    }

    @Override
    public void printFooter() {
        printBlankLine();
        printBlankLine();
        printBlankLine();
        System.out.println("==                       Thank you for shopping at Kohl's!                    ==");
        printBlankLine();
        printBlankLine();
        printBlankLine();
        printSolidLine();
        printSolidLine();
        printSpace();
        printSpace();
        printSpace();
    }
    
    public final void printBlankLine() {
        System.out.println("==                                                                            ==");
    }
    
    public final void printSolidLine() {
        System.out.println("================================================================================");
    }
    
    public final void printSpace() {
        System.out.println("");
    }
    
    private String getCurrentDateString(){
        return new SimpleDateFormat("MM/dd/yyyy hh:mma").format(Calendar.getInstance().getTime());
    }

}

