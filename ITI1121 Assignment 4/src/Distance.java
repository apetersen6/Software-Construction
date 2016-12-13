/* ITI 1121/1521. Introduction to Computer Science II
 * Assignment/Devoir 4
 *
 * Marcel Turcotte
 */

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ListIterator;

public class Distance {

    public static final int TUPLE_SIZE = 5;
    private static String type = "AList";

    public static void setImpl( String type ) {

        if ( ! ( type.equals( "AList" ) || type.equals( "BinarySearchTree" ) ) ) {
            throw new IllegalArgumentException( type );
        }

        Distance.type = type;
    }

    private static Associative<String,Integer> getNewAssociative() {

        Associative<String,Integer> assoc;

        if ( type.equals( "AList" ) ) {

            assoc = new AList<String,Integer>();

        } else if ( type.equals( "BinarySearchTree" ) ) {

            assoc = new BinarySearchTree<String,Integer>();

        } else {

            throw new IllegalArgumentException( type );

        }
        
        return assoc;
    }

    // Returns an associative structure such that the keys are
    // k-tuples and the values are the number of occurrences.

    private static Associative<String,Integer> getCounts( String s ) {

        Associative<String,Integer> counts;
        counts = getNewAssociative();

        for ( int i=0; i < s.length() - TUPLE_SIZE + 1; i++ ) {
            counts.update( s.substring( i, i + TUPLE_SIZE ), new Plus( 1 ) );
        }

        return counts;
    }

    public static double compare( String aSeq, String bSeq ) {

        double distance = 0;
        int k = TUPLE_SIZE;
        
        Associative<String,Integer> a = getCounts(aSeq);
        Associative<String,Integer> b = getCounts(bSeq);
        
        LinkedList<String> aKeys = a.keys();
        LinkedList<Integer> aValues = a.values();
        LinkedList<String> bKeys = b.keys();
        LinkedList<Integer> bValues = b.values();
        
		Iterator<String> ak = aKeys.iterator();
		Iterator<Integer> av = aValues.iterator();
		Iterator<String> bk = bKeys.iterator();
		Iterator<Integer> bv = bValues.iterator();
		
		while(bk.hasNext() && ak.hasNext()){ //while both iterators still have elements
			
			if(bk.next().equals(ak.next())){ //if the tuples are equal calculate the distance
				distance = distance + Math.pow((av.next()/(double)(aSeq.length()-k+1) - bv.next()/(double)(bSeq.length()-k+1)), 2); //distance calculations
			}
			
			bk.previous(); //move cursor back so as to not miss any elements
			ak.previous();
				
			if(!bk.next().equals(ak.next())){ //if the tuples are unequal calculate the distance
				if(bk.hasNext()){
					ak.previous();
					distance = distance + Math.pow(0 - bv.next()/(double)(bSeq.length()-k+1), 2); //distance calculations	
				}else if(ak.hasNext()){
					bk.previous();
					distance = distance + Math.pow((av.next()/(double)(aSeq.length()-k+1) - 0), 2); //distance calculations
				}
			}
		}
		
		while(bk.hasNext() && bv.hasNext()){ //while only the second list iterator still contains elements

			distance = distance + Math.pow(0 - bv.next()/(double)(bSeq.length()-k+1), 2);

		}
		
		while(ak.hasNext() && av.hasNext()){ //while only the first list iterator still contains elements

			distance = distance + Math.pow((av.next()/(double)(aSeq.length()-k+1) - 0), 2); //distance calculations

		}
		
		return distance;
    }
}
