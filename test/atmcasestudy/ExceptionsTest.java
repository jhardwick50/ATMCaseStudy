/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atmcasestudy;

import java.io.IOException;
import org.junit.Test;

/**
 *
 * @author Jason
 */
public class ExceptionsTest {
    
    @Test
    public void test_checkedException() {
        try {
            throwCheckedException(null);
        } catch (IOException e) {
            System.out.println("IOException happened");
        } catch (IllegalArgumentException e) {
            System.out.println("Needed to pass a string not null");
            throw e;
        } finally {
            System.out.println("I logged an exception and threw it");
        }
    }
    
    public void throwCheckedException(String s) throws IOException {
        if (s == null) {
            throw new IllegalArgumentException("String s can't be null");
        }
        throw new IOException();
    }
    
    @Test
    public void test_uncheckedException() {
        try {
            throwUncheckedException();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public void throwUncheckedException() {
        throw new RuntimeException();
    }
}
