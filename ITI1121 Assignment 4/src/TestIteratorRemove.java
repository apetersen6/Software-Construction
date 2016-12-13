/* ITI 1121/1521. Introduction to Computer Science II
 * Assignment/Devoir 4
 *
 * Marcel Turcotte
 */

import junit.framework.Assert;
import junit.framework.TestCase;

import java.util.NoSuchElementException;
import java.util.ConcurrentModificationException;

public class TestIteratorRemove extends TestCase {
  
    public static void testRemove() {
    
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
    
        i.next();
        i.remove();
    
        i = ll.iterator();
    
        Assert.assertTrue( i.hasNext() );
        Assert.assertEquals( two, i.next() );
    
        Assert.assertTrue( i.hasNext() );
        Assert.assertEquals( three, i.next() );
    
        ll = new LinkedList<Integer>();
    
        ll.addLast( one );
        ll.addLast( two );
        ll.addLast( three );
    
        i = ll.iterator();
    
        i.next();
        i.next();
        i.remove();
    
        i = ll.iterator();
    
        Assert.assertTrue( i.hasNext() );
        Assert.assertEquals( one, i.next() );
    
        Assert.assertTrue( i.hasNext() );
        Assert.assertEquals( three, i.next() );
    
        ll = new LinkedList<Integer>();
    
        ll.addLast( one );
        ll.addLast( two );
        ll.addLast( three );
    
        i = ll.iterator();
    
        i.next();
        i.next();
        i.next();
        i.remove();
    
        i = ll.iterator();
    
        Assert.assertTrue( i.hasNext() );
        Assert.assertEquals( one, i.next() );
    
        Assert.assertTrue( i.hasNext() );
        Assert.assertEquals( two, i.next() );
    
        ll = new LinkedList<Integer>();
    
        ll.addLast( one );
        ll.addLast( two );
        ll.addLast( three );
    
        i = ll.iterator();
    
        while ( i.hasNext() ) {
            i.next();
        }
    
        Assert.assertTrue( i.hasPrevious() );
        i.remove();
    
        Assert.assertTrue( i.hasPrevious() );
        i.remove();
    
        Assert.assertTrue( i.hasPrevious() );
        i.remove();
    
        Assert.assertFalse( i.hasPrevious() );
    
    }
    public static void testIllegalStateException() {
    
        LinkedList<Integer> ll;
        Iterator<Integer> i;
        
        ll = new LinkedList<Integer>();
        i = ll.iterator();
    
        try {
      
            i.remove();
            fail( "IllegalStateException expected" );
      
        } catch ( IllegalStateException e ) {
            ;
        }
    
        ll = new LinkedList<Integer>();
        ll.addLast( new Integer( 1 ) );

        i = ll.iterator();
    
        i.next();
        i.remove();
    
        try {
      
            i.remove();
            fail( "IllegalStateException expected" );
      
        } catch ( IllegalStateException e ) {
            ;
        }    
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
      
            i.remove();
            fail( "ConcurrentModificationException expected" );
      
        } catch ( ConcurrentModificationException e ) {
            ;
        }    
    }
  
}