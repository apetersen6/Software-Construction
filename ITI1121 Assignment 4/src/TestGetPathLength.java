/* ITI 1121/1521. Introduction to Computer Science II
 * Assignment/Devoir 4
 *
 * Marcel Turcotte
 */

import junit.framework.Assert;
import junit.framework.TestCase;

import java.io.IOException;

public class TestGetPathLength extends TestCase {
  
    public static final int TUPLE_SIZE = 5;
  
    public static void testGetPathLength() throws IOException {
    
        BinarySearchTree<String,Integer> counts;
        counts = new BinarySearchTree<String,Integer>();
    
        String b = Utils.readFile( "b.txt" );
    
        for ( int i=0; i < b.length() - TUPLE_SIZE + 1; i++ ) {
            counts.update( b.substring( i, i + TUPLE_SIZE ), new Plus( 1 ) );
        }
    
        Assert.assertEquals( 0, counts.getPathLength( "ABABA" ) );
        Assert.assertEquals( 2, counts.getPathLength( "ABABC" ) );
        Assert.assertEquals( 3, counts.getPathLength( "ABCAB" ) );
        Assert.assertEquals( 1, counts.getPathLength( "BABAB" ) );
        Assert.assertEquals( 2, counts.getPathLength( "BABCA" ) );
        Assert.assertEquals( 3, counts.getPathLength( "BCABA" ) );
        Assert.assertEquals( 4, counts.getPathLength( "CABAB" ) );
    
        Assert.assertEquals( -1, counts.getPathLength( "XXXXX" ) );     
    
        try {
      
            counts.getPathLength( null );
            fail( "IllegalArgumentException expected" );
      
        } catch ( IllegalArgumentException e ) {
      
            ;
      
        }
    
    }
  
}