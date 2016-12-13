/* ITI 1121/1521. Introduction to Computer Science II
 * Assignment/Devoir 4
 *
 * Marcel Turcotte
 */

import junit.framework.Assert;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class TestTake extends TestCase {
  
    public static void testTake() {
       
        SinglyLinkedList<Integer> xs;
        xs = new SinglyLinkedList<Integer>();
    
        for ( int i=5; i>0; i-- ) {
            xs.addFirst( new Integer( i ) );
        }
    
        //Assert.assertEquals(  "[]", xs.take( 0 ).toString() );
        Assert.assertEquals( "[1,2,3,4,5]",  xs.toString() );
    
        //Assert.assertEquals( "[1]",  xs.take( 1 ).toString() );
        Assert.assertEquals( "[1,2,3,4,5]",  xs.toString() );
    
        Assert.assertEquals( "[1,2]",  xs.take( 2 ).toString() );
        Assert.assertEquals( "[1,2,3,4,5]",  xs.toString() );
    
        Assert.assertEquals( "[1,2,3]",  xs.take( 3 ).toString() );
        Assert.assertEquals( "[1,2,3,4,5]",  xs.toString() );
    
        Assert.assertEquals( "[1,2,3,4]",  xs.take( 4 ).toString() );
        Assert.assertEquals( "[1,2,3,4,5]",  xs.toString() );
    
        Assert.assertEquals( "[1,2,3,4,5]",  xs.take( 5 ).toString() );
        Assert.assertEquals( "[1,2,3,4,5]",  xs.toString() );
 
        try {
      
            xs.take( 6 );
            fail( "IllegalArgumentException expected" );
           
        } catch ( IllegalArgumentException e ) {
      
            Assert.assertEquals( "[1,2,3,4,5]",  xs.toString() );
      
        }

        try {
      
            xs.take( -5 );
            fail( "IllegalArgumentException expected" );
           
        } catch ( IllegalArgumentException e ) {
      
            Assert.assertEquals( "[1,2,3,4,5]",  xs.toString() );
      
        }
    
    }

}