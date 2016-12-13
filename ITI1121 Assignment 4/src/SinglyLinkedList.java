/* ITI 1121/1521. Introduction to Computer Science II
 * Assignment/Devoir 4
 *
 * Marcel Turcotte
 */

import java.util.NoSuchElementException;

public class SinglyLinkedList<E> {

    private static class Node<E> {
        private E value;
        private Node<E> next;
        private Node( E value, Node<E> next ) {
            this.value = value;
            this.next  = next;
        }
    }

    // Instance variable
    private Node<E> first;

    //  ----------------------------------------------------------
    //  SinglyLinkedList methods
    //  ----------------------------------------------------------

    public void addFirst( E item ) {
        first = new Node<E>( item, first );
    }

    public boolean isEmpty() { 
        return first == null; 
    }

    public SinglyLinkedList<E> take( int n ) {
    	
    	if(n == 0){
    		return this;
    	}
    	else{
    		this.first.next = this.first.next.next;
    	}
    	
    	return this.take(n-1);
    }

    //  ----------------------------------------------------------
    //  Other instance methods
    //  ----------------------------------------------------------

    public String toString() {
        StringBuffer answer = new StringBuffer( "[" );
        Node p = first;
        while ( p != null ) {
            if ( p != first ) {
                answer.append( "," );
            }
            answer.append( p.value );
            p = p.next;
        }
        answer.append( "]" );
        return answer.toString();
    }

}