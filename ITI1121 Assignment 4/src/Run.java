/* ITI 1121/1521. Introduction to Computer Science II
 * Assignment/Devoir 4
 *
 * Marcel Turcotte
 */

import java.io.FileNotFoundException;
import java.io.IOException;

public class Run {

    public static void main( String[] args ) {

        StudentInfo.display();

        if ( args.length != 3 || ! ( args[ 2 ].equals( "AList" ) || args[ 2 ].equals( "BinarySearchTree" ) ) ) {

            System.err.println( "Usage: java Compare file1 file2 AList|BinarySearchTree" );
            System.exit( 1 ); // failure

        }

        String a, b;
        double distance;

        try {

            a = Utils.readFile( args[ 0 ] );
            b = Utils.readFile( args[ 1 ] );

            Distance.setImpl( args[ 2 ] );

            System.out.println( distance = Distance.compare( a, b ) );

        } catch ( FileNotFoundException e ) {

            System.err.println( "Caught FileNotFoundException: " + e.getMessage() );

        } catch ( IOException e ) {

            System.err.println( "Caught IOException: " + e.getMessage() );

        }
    }

}