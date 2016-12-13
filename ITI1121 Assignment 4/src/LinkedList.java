/* ITI 1121/1521. Introduction to Computer Science II
 * Assignment/Devoir 4
 *
 * Marcel Turcotte
 */

import java.util.NoSuchElementException;
import java.util.ConcurrentModificationException;

public class LinkedList<E> {
  
    //  ----------------------------------------------------------
    //  Implementing the doubly linked nodes (static nested class)
    //  ----------------------------------------------------------
  
    private static class Node<E> {
    
        private E value;
    
        private Node<E> previous;
        private Node<E> next;
    
        private Node( E value, Node<E> previous, Node<E> next ) {
            this.value = value;
            this.previous = previous;
            this.next = next;
        }
    }
  
    //  ----------------------------------------------------------
    //  Implementing the iterators (inner class)
    //  ----------------------------------------------------------
  
    private class LinkedListIterator implements Iterator<E> {
    
        private Node<E> current;
        private int expectedModCount;
    
        private LinkedListIterator() {
            expectedModCount = modCount;
            current = head;
        }
    
        public E next() {
      
            checkConcurrentModification();
      
            if ( current.next == head ) {
        	throw new NoSuchElementException();
            }
      
            current = current.next ; // move the cursor forward
      
            return current.value ;
        }
    
        public boolean hasNext() {
            return current.next != head;
        }
    
        public void add( E elem ) {

            checkConcurrentModification();
      
            if ( elem == null ) {
        	throw new IllegalArgumentException();
            }

            Node<E> after = current.next;

            current.next = new Node<E>( elem, current, after );
            after.previous = current.next;
            current = current.next;

            // Updating variables

            expectedModCount++;
            modCount++;
            size++;

        }

        public boolean hasPrevious() {
        	return current.previous != null;
        }
    
        public E previous() {
	    
       	 	checkConcurrentModification();
       	 	
             if (!hasPrevious()) {
            	 throw new NoSuchElementException();
             }
             
             current = current.previous ; // move the cursor backward
             
             return current.value ;
        }
    
        public void remove() {
        	
            checkConcurrentModification();
            
            if ( !hasPrevious() ) {
            	throw new IllegalStateException();
            }

            current.next = null;
            current = current.previous;

            // Updating variables

            expectedModCount++;
            modCount++;
            size--;
        	
        }
    
        private void checkConcurrentModification() {
            if ( expectedModCount != modCount ) {
        	throw new ConcurrentModificationException();
            }
        }
    }
  
    // Instance variables
  
    private Node<E> head;
    private int size;
    private int modCount;
  
    /** Creates a new linked list.
     */
  
    public LinkedList() {
    
        // Representation of the empty list using a dummy node
        head = new Node<E>( null, null, null );
        head.next = head.previous = head;
    
        modCount = 0;
        size = 0;
    }
  
    /** Initializes the content of this list by copying all the
     *  elements of the collection into this list.
     */
  
    //  ----------------------------------------------------------
    //  LinkedList methods
    //  ----------------------------------------------------------
  
    /**
     * Returns an iterator for this list.
     *
     * @return an iterator for this list
     */
  
    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }
  
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
  
    /** 
     * Adds an element at the end of the list.
     *
     * @return true since duplicated values are allowed.
     * @throws IllegalArgumentException if obj is null.
     */
  
    public boolean addLast( E obj ) {
    
        if ( obj == null ) {
            throw new IllegalArgumentException( "null" );
        }
    
        Node<E> before = head.previous;
        Node<E> after = head;
    
        before.next = new Node<E>( obj, before, after );
        after.previous = before.next;
    
        modCount++;
        size++;
    
        return true;
    }
  
    /** 
     * Adds an element at the start of the list.
     *
     * @return true since duplicated values are allowed.
     * @throws IllegalArgumentException if obj is null.
     */
  
    public boolean addFirst( E obj ) {
    
        if ( obj == null ) {
            throw new IllegalArgumentException( "null" );
        }
    
        Node<E> before = head;
        Node<E> after = head.next;
    
        before.next = new Node<E>( obj, before, after );
        after.previous = before.next;
    
        modCount++;
        size++;
    
        return true;
    }
  
    /** 
     * Returns the element at the specified position; the first
     * element has the index 0.
     *
     * @return the element at the specified position.
     * @throws IndexOutOfBoundsException if pos is out of range (pos < 0 || pos >= size()). 
     */
  
    public E get( int pos ) {
    
        if ( pos < 0 || pos > (size-1) ) {
            throw new IndexOutOfBoundsException( Integer.toString( pos ) );
        }
    
        Node<E> p = head.next;
    
        for ( int i=0; i<pos; i++ ) {
            p = p.next;
        }
    
        return p.value;
    }
  
    /**
     * Removes the leftmost occurrence of o from the list. Returns true if
     * the element was removed.
     *
     * @return true if an occurrence was found and removed.
     */
  
    public boolean remove( E o ) {
    
        if ( o == null ) {
            throw new IllegalArgumentException( "null" );
        }
    
        Node<E> current = head.next;
        boolean found = false;
    
        while ( ! found && current != head ) {
      
            if ( o.equals( current.value ) ) {
        
        	found = true;
        
        	Node<E> left = current.previous;
        	Node<E> right = current.next;
        
        	// removing the element from the list;
        
        	left.next = right;
        	right.previous = left;
        
        	// ``scrubbing the memory''
        
        	current.value = null;
        	current.previous = null;
        	current.next = null;
        
            } else {
        
        	current = current.next;
        
            }
      
        }
    
        modCount++;
        size--;
    
        return found;
    }
  
    //  ----------------------------------------------------------
    //  Other instance methods
    //  ----------------------------------------------------------
  
    public String toString() {
        StringBuffer answer = new StringBuffer( "[" );
        Node<E> p = head.next;
        while ( p != head ) {
            if ( p != head.next ) {
        	answer.append( "," );
            }
            answer.append( p.value );
            p = p.next;
        }
        answer.append( "]" );
        return answer.toString();
    }
  
}