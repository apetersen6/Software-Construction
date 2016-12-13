/* ITI 1121/1521. Introduction to Computer Science II
 * Assignment/Devoir 4
 *
 * Marcel Turcotte
 */

import junit.framework.Assert;
import junit.framework.TestCase;

import java.util.NoSuchElementException;
import java.util.ConcurrentModificationException;

public class TestIteratorPrevious extends TestCase {
  
    public static void testHasPrevious() {
    
        LinkedList<Integer> ll;
        ll = new LinkedList<Integer>();
 
        for ( int i=0; i<5; i++ ) {
            ll.addLast( new Integer( i ) );
        }
    
        Iterator<Integer> i;
        i = ll.iterator();
    
        Assert.assertFalse( i.hasPrevious() );
    
        while ( i.hasNext() ) {
            i.next();   
            Assert.assertTrue( i.hasPrevious() );
        }    
    
    }
  
    public static void testNoSuchElement() {
    
        LinkedList<Integer> ll;
        ll = new LinkedList<Integer>();
    
        Iterator<Integer> i;
        i = ll.iterator();
    
        try {
      
            i.previous();
            fail( "NoSuchElementException expected" );
      
        } catch ( NoSuchElementException e ) {
            ;
        }
    
    }
  
    public static void testLast2First() {
    
        LinkedList<Integer> ll;
        ll = new LinkedList<Integer>();
    
        Integer one, two, three;
    
        one = new Integer( 1 );
        two = new Integer( 2 );
        three = new Integer( 3 );
    
        ll.addLast( one );
        ll.addLast( two );
        ll.addLast( three );
    
        Iterator<Integer> i;
        i = ll.iterator();
    
        while ( i.hasNext() ) {
            Integer v = i.next();
        }
    
        Assert.assertTrue( i.hasPrevious() );
        Assert.assertEquals( three, i.previous() );
    
        Assert.assertTrue( i.hasPrevious() );
        Assert.assertEquals( two, i.previous() );
    
        Assert.assertTrue( i.hasPrevious() );
        Assert.assertEquals( one, i.previous() );
    
        Assert.assertFalse( i.hasPrevious() );
    }
  
    public static void testConcurrentModificationException() {
    
        LinkedList<Integer> ll;
        ll = new LinkedList<Integer>();
    
        ll.addLast( new Integer( 1 ) );

        Iterator<Integer> i;
        i = ll.iterator();
    
        i.next();

        ll.addLast( new Integer( 2 ) );
 
        try {
      
            i.previous();
            fail( "ConcurrentModificationException expected" );
      
        } catch ( ConcurrentModificationException e ) {
            ;
        }    
    }
  
}