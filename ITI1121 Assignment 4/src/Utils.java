/* ITI 1121/1521. Introduction to Computer Science II
 * Assignment/Devoir 4
 *
 * Marcel Turcotte
 */

import java.io.*;

public class Utils {

    public static String readFile( String fileName ) throws IOException, FileNotFoundException {

        String line;
        StringBuffer buffer;
        BufferedReader input;
            
        input = new BufferedReader( new InputStreamReader( new FileInputStream( fileName ) ) );
        buffer = new StringBuffer();

        while ( ( line = input.readLine() ) != null ) {
            buffer.append( line );
        }
        input.close();

        return buffer.toString();
    }

}