/* ITI 1121/1521. Introduction to Computer Science II
 * Assignment/Devoir 4
 *
 * Marcel Turcotte
 */

import java.io.IOException;

import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * A JUnit test case class.
 */

public class TestDistance extends TestCase {
  
    public void testCompare() throws IOException {
         
        String a = Utils.readFile( "a.txt" );
        String b = Utils.readFile( "b.txt" );
        String c = Utils.readFile( "c.txt" );
        String d = Utils.readFile( "d.txt" );
     
        // Distance.setImpl( "BinarySearchTree" );
     
        Assert.assertEquals( 0.0, Distance.compare( a, a ), 1.0E-5 );
     
        Assert.assertEquals( 0.01278305332359386, Distance.compare( a, b ), 1.0E-5 );     
        Assert.assertEquals( 0.01278305332359386, Distance.compare( b, a ), 1.0E-5 );

        Assert.assertEquals( 0.07414170927684442, Distance.compare( a, c ), 1.0E-5 );     
        Assert.assertEquals( 0.07414170927684442, Distance.compare( c, a ), 1.0E-5 );

        Assert.assertEquals( 0.01150558842866535, Distance.compare( a, d ), 1.0E-5 );     
        Assert.assertEquals( 0.01150558842866535, Distance.compare( d, a ), 1.0E-5 );

        Assert.assertEquals( 0.0, Distance.compare( b, b ), 1.0E-5 );

        Assert.assertEquals( 0.029218407596785977, Distance.compare( b, c ), 1.0E-5 );     
        //Assert.assertEquals( 0.029218407596785977, Distance.compare( c, b ), 1.0E-5 );
     
        Assert.assertEquals( 3.361749723496064E-5, Distance.compare( b, d ), 1.0E-5 );     
        Assert.assertEquals( 3.361749723496064E-5, Distance.compare( d, b ), 1.0E-5 );

        Assert.assertEquals( Distance.compare( c, c ), 0.0 );
    
        //Assert.assertEquals( 0.030900242958455008, Distance.compare( c, d ), 1.0E-5 );     
        Assert.assertEquals( 0.030900242958455008, Distance.compare( d, c ), 1.0E-5 );
     
        Assert.assertEquals( 0.0, Distance.compare( d, d ), 1.0E-5 );
          
    }
  
}