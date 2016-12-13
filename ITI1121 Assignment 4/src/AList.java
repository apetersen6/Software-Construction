/* ITI 1121/1521. Introduction to Computer Science II
 * Assignment/Devoir 4
 *
 * Marcel Turcotte
 */

import java.util.NoSuchElementException;
import java.util.ConcurrentModificationException;

public class AList< K extends Comparable<K>, V > implements Associative<K,V> {
  
    //  ----------------------------------------------------------
    //  Implementing the doubly linked nodes (static nested class)
    //  ----------------------------------------------------------
  
    private static class Node<K,V> {
    
        private K key;
        private V value;
    
        private Node<K,V> previous;
        private Node<K,V> next;
    
        private Node( K key, V value, Node<K,V> previous, Node<K,V> next ) {
            this.key = key;
            this.value = value;
            this.previous = previous;
            this.next = next;
        }
    }
  
    // Instance variables
  
    private Node<K,V> head;
    private int size;
  
    /** Creates a new linked list.
     */
  
    public AList() {
    
        // Representation of the empty list using a dummy node
        head = new Node<K,V>( null, null, null, null );
        head.next = head.previous = head;
    
        size = 0;
    }
  
    /** Initializes the content of this list by copying all the
     *  elements of the collection into this list.
     */
  
    //  ----------------------------------------------------------
    //  LinkedList methods
    //  ----------------------------------------------------------
  
    /** 
     * Returns the number of elements currently stored in this OrderedStructure.
     *
     * @return the number of elements of this strucutre.
     */
  
    public int size() {
        return size;
    }
  
    /**
     * Returns true if this collection contains no elements.
     *
     * @return true if this collection contains no elements
     */
  
    public boolean isEmpty() {
        return size == 0;
    }
  
    /** Returns the value associated with this key, or null if the key is not found.
     *
     *  @param key key whose associated value is to be returned
     *  @return the value associated with this key, or null if the key is not found
     */
  
    public V get( K key ) {
    
        Node<K,V> p = head.next;
    
        V value = null;
    
        while ( p != head && p.key.compareTo( key ) <  0 ) {
            p = p.next;
        }
    
        if ( p != head && p.key.compareTo( key ) == 0 ) {
            value = p.value;
        }
    
        return value;
    }
  
    /** 
     * XXXXXXXXXX
     *
     * @return true since duplicated values are allowed.
     * @throws IllegalArgumentException if obj is null.
     */
  
    public V update( K key, Functor<V> fun ) {
    
        if ( key == null || fun == null ) {
            throw new IllegalArgumentException( "null" );
        }
    
        Node<K,V> before = head;
        Node<K,V> after;
    
        V old;
    
        while ( before.next != head && before.next.key.compareTo( key ) <  0 ) {
            before = before.next;
        }
    
        if ( before.next != head && before.next.key.compareTo( key ) ==  0 ) {
      
            old = before.next.value;
            before.next.value = fun.apply( old );
      
        } else {
      
            old = null;
            after = before.next;
            before.next = new Node<K,V>( key, fun.apply( null ), before, after );
            after.previous = before.next;
      
        }
    
        size++;
    
        return old;
    }
  
    public LinkedList<K> keys() {
    
        LinkedList<K> keys;
        keys = new LinkedList<K>();
    
        Node<K,V> p;
        p = head.next;
    
        while ( p != head ) {
      
            keys.addLast( p.key );
            p = p.next;
      
        }
    
        return keys;
    }
  
    public LinkedList<V> values() {
    
        LinkedList<V> values;
        values = new LinkedList<V>();
    
        Node<K,V> p;
        p = head.next;
    
        while ( p != head ) {
      
            values.addLast( p.value );
            p = p.next;
      
        }
    
        return values;
    }
  
    //  ----------------------------------------------------------
    //  Other instance methods
    //  ----------------------------------------------------------
  
    public String toString() {
        StringBuffer answer = new StringBuffer( "[" );
        Node<K,V> p = head.next;
        while ( p != head ) {
            if ( p != head.next ) {
        	answer.append( ", " );
            }
            answer.append( "(" + p.key + ", " + p.value + ")" );
            p = p.next;
        }
        answer.append( "]" );
        return answer.toString();
    }
  
}