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
public class ValidationService {
    public final void checkNotNull(Object object) throws IllegalArgumentException {
        if (object == null){
            throw new IllegalArgumentException("VALUE CANNOT BE NULL");
        }
    }
}
