/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategyproject;
import java.text.NumberFormat;

/**
 *
 * @author danielbyczynski
 */
public class CurrencyFormatter implements FormatService{
   
    @Override
    public String formatDouble(double value) {
        System.out.println("sup boiiiz");
        // NUMBERFORMATTER converts double value into formatted, rounded Currency String.
        NumberFormat NUMBERFORMATTER = NumberFormat.getCurrencyInstance();
        
        return NUMBERFORMATTER.format(value);
    }
    
}