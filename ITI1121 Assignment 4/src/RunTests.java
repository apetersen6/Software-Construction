/* ITI 1121/1521. Introduction to Computer Science II
 * Assignment/Devoir 4
 *
 * Marcel Turcotte
 */

import junit.framework.Test;
import junit.framework.TestSuite;

/** Runs all the tests using a textual runner.  This is the
 *  alternative to running all the tests within your favorite
 *  development environment (DrJava, Eclipse...).  This may require
 *  downloading JUnit from <a href="www.junit.org">www.junit.org</a>.
 *
 * <pre>
 * > javac -cp junit-4.4.jar:. RunTests.java
 * > java -cp junit-4.4.jar:. RunTests
 * ************************************************************
 * *                                                          *
 * *                                                          *
 * *                                                          *
 * *                                                          *
 * ************************************************************
 * 
 * ..............
 * Time: 0.031
 * 
 * OK (14 tests)
 *  * </pre>
 */

public class RunTests {
  
    // Creates and returns a TestSuite object.

    private static Test suite() {

        TestSuite suite = new TestSuite();
  
        suite.addTestSuite( TestA4Q1.class );
        suite.addTestSuite( TestIteratorPrevious.class );
        suite.addTestSuite( TestIteratorRemove.class );
        suite.addTestSuite( TestTake.class );
        suite.addTestSuite( TestKeysAndValues.class );
        suite.addTestSuite( TestGetPathLength.class );
        suite.addTestSuite( TestDistance.class );

        return suite;
    }

    /**
     * Runs the test suite using the textual runner.
     */
    
    public static void main( String[] args ) {

        StudentInfo.display();

        junit.textui.TestRunner.run( suite() );
    }
}