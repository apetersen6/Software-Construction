/* ITI 1121/1521. Introduction to Computer Science II
 * Assignment/Devoir 4
 *
 * Marcel Turcotte
 */

import junit.framework.Assert;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class TestA4Q1 extends TestCase {
  
    public static void testEquals() {
    
        LinkedList<Integer> xs;
        xs = new LinkedList<Integer>();
    
        LinkedList<Integer> ys;
        ys = new LinkedList<Integer>();
    
        Assert.assertTrue( A4Q1.equals( null, null ) );
    
        Assert.assertFalse( A4Q1.equals( xs, null ) );
    
        Assert.assertFalse( A4Q1.equals( null, ys ) );
    
        Assert.assertTrue( A4Q1.equals( xs, ys ) );
    
        for ( int i=0; i<5; i++ ) {
            xs.addLast( new Integer( i ) );
            Assert.assertFalse( A4Q1.equals( xs, ys ) );
        }
    
        for ( int i=0; i<5; i++ ) {
            Assert.assertFalse( A4Q1.equals( xs, ys ) );
            ys.addLast( new Integer( i ) );
        }
    
        Assert.assertTrue( A4Q1.equals( xs, ys ) );
    
        xs.addLast( new Integer( 98 ) );
    
        Assert.assertFalse( A4Q1.equals( xs, ys ) );
    
        ys.addLast( new Integer( 99 ) );
    
        Assert.assertFalse( A4Q1.equals( xs, ys ) );
    
    }
  
}