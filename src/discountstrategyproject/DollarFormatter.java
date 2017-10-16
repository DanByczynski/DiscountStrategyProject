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
public class DollarFormatter implements CurrencyFormatService{
    @Override
    public String formatDouble(double value) {
        
        // NUMBERFORMATTER converts double value into formatted, rounded Currency String.
        NumberFormat NUMBERFORMATTER = NumberFormat.getCurrencyInstance();
        
        return NUMBERFORMATTER.format(value);
    }
    
}
