/* ITI 1121/1521. Introduction to Computer Science II
 * Assignment/Devoir 4
 *
 * Marcel Turcotte
 */

import junit.framework.Assert;
import junit.framework.TestCase;

import java.io.IOException;

public class TestKeysAndValues extends TestCase {
  
    public static final int TUPLE_SIZE = 5;
  
    public static void testKeysValues() throws IOException {
    
        LinkedList<String> keys;
        LinkedList<Integer> values;
    
        String a = Utils.readFile( "a.txt" );
    
        Associative<String,Integer> counts;
        counts = new BinarySearchTree<String,Integer>();
    
        keys = counts.keys();
        Assert.assertEquals( "[]", keys.toString() );
    
        values = counts.values();
        Assert.assertEquals( "[]", values.toString() );
    
        for ( int i=0; i < a.length() - TUPLE_SIZE + 1; i++ ) {
            counts.update( a.substring( i, i + TUPLE_SIZE ), new Plus( 1 ) );
        }
    
        keys = counts.keys();
        Assert.assertEquals( "[ABABA,BABAB]", keys.toString() );
    
        values = counts.values();
        Assert.assertEquals( "[18,18]", values.toString() );
    
        String b = Utils.readFile( "b.txt" );
    
        counts = new BinarySearchTree<String,Integer>();
    
        for ( int i=0; i < b.length() - TUPLE_SIZE + 1; i++ ) {
            counts.update( b.substring( i, i + TUPLE_SIZE ), new Plus( 1 ) );
        }
    
        keys = counts.keys();
        Assert.assertEquals( "[ABABA,ABABC,ABCAB,BABAB,BABCA,BCABA,CABAB]", keys.toString() );
    
        values = counts.values();
        Assert.assertEquals( "[16,1,1,16,1,1,1]", values.toString() );
    
    }
  
}