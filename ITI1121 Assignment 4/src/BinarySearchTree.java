/* ITI 1121/1521. Introduction to Computer Science II
 * Assignment/Devoir 4
 *
 * Marcel Turcotte
 */

public class BinarySearchTree< K extends Comparable<K>, V > implements Associative<K,V> {
  
    // A static nested class used to store the elements of this tree
  
    private static class Node<K,V> {
    
        private K key;
        private V value;
    
        private Node<K,V> left;
        private Node<K,V> right;
    
        private Node( K key, V value ) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }
    }
  
    private Node<K,V> root = null;
    private int size = 0;
  
    public int size() {
        return size;
    }
  
    /** The method fun.apply() is used to associate a value with the
     *  specified key. If the associative structure previously
     *  contained the key, the associated value is passed to the
     *  method apply and the resulting value is used to replace the
     *  old value, otherwise a new association (key,value) is created,
     *  the method apply receives the value zero, the result is associated
     *  with the key.
     *
     * @param key key with which the specified value is to be associated
     * @param fun an implementation of the interface Functor
     * @return the previous value associated with this key, or null if the key was not found
     */
  
    public V update( K key, Functor<V> fun ) {
    
        // pre-condtion:
    
        if ( key == null || fun == null ) {
            throw new IllegalArgumentException( "null" );
        }
    
        // special case:
    
        if ( root == null ) {
            root = new Node<K,V>( key, fun.apply( null ) );
            size++;
            return null;
        }
    
        // general case:
    
        return update( key, fun, root );
    }
  
    // helper method

    private V update( K key, Functor<V> fun, Node<K,V> current ) {
    
        V old;
    
        int test = key.compareTo( current.key );
    
        if ( test == 0 ) { // already exists
            old = current.value;
            current.value = fun.apply( old );
        } else if ( test < 0 ) {
            if ( current.left == null ) {
        	old = null;
        	current.left = new Node<K,V>( key, fun.apply( old ) );
        	size++;
            } else {
        	old = update( key, fun, current.left );
            }
        } else {
            if ( current.right == null ) {
        	old = null;
        	current.right = new Node<K,V>( key, fun.apply( old ) );
        	size++;
            } else {
        	old = update( key, fun, current.right );
            }
        }
        return old;
    }
  
    /**
     * Looks up for key in this BinarySearchTree, returns associated value
     * if key was found and null otherwise.
     *
     * @param key value to look for
     * @return value the value associated with this key
     */
  
    public V get( K key ) {
    
        // pre-condtion:
    
        if ( key == null ) {
            throw new IllegalArgumentException( "null" );
        }
    
        return get( key, root );
    }
  
    private V get( K key, Node<K,V> current ) {
    
        V value;
    
        if ( current == null ) {
      
            value = null;
      
        } else {
      
            int test = key.compareTo( current.key );
      
            if ( test == 0 ) {
        
        	value = current.value;
        
            } else if ( test < 0 ) {
        
        	value = get( key, current.left );
        
            } else {
        
        	value = get( key, current.right );
        
            }
        }
        return value;
    }
  
    /** Returns the list of keys in order, according to the method compareTo of the key
     *  objects.
     *
     *  @return the list of keys in order
     */

    public LinkedList<K> keys() { //returns a list of all of the keys in order of the binary search tree
    	
    	LinkedList<K> list = new LinkedList();
    	
    	if(root != null){
    		list.addFirst(root.key);
    		
    		if(root.left != null){
    			list.addLast(root.left.key);
    		}
    		if(root.right != null){
    			list.addLast(root.right.key);
    		}
    	}
    	
       	return list;
    }

    /** Returns the list of value in the order specified by the method compareTo of the key
     *  objects.
     *
     *  @return the list of values
     */

    public LinkedList<V> values() { //returns a list of all of the values in order of the binary search tree
    	
    	LinkedList<V> list = new LinkedList();
    	
    	if(root != null){
    		list.addFirst(root.value);
    		
    		if(root.left != null){
    			list.addLast(root.left.value);
    		}
    		if(root.right != null){
    			list.addLast(root.right.value);
    		}
    	}
    	
       	return list;
    }

    /** Returns the path length of the node containg specified key.  Let
     * the <b>path length</b> of a node be the number of links
     * starting from the root that must be followed to reach that node.
     * The path length of the root is 0. Returns <b>-1</b> if
     * <b>obj</b> is not found in that tree.
     *
     * @param obj the key
     * @return the path length of the specified key
     */
  
    public int getPathLength( K obj ) { //calculates the path length to a certain node

        int length = 0;
        
        if(obj.compareTo(root.key) == 0){
        	//do nothing
        }
        else if(obj.compareTo(root.key) < 0){
        	length++;
        	if(root.left.key != obj){  //check to see if the current node is equal to the desired node
    				length++;		   // if not, increase path length
        	}
        	else{
        		length = -1;			//return -1 if the node isn't found
        	}
        }
        else if(obj.compareTo(root.key) > 0){
        	length++;
        	if(root.right.key != obj){ //check to see if the current node is equal to the desired node
    				length++;		   // if not, increase path length
        	}
        	else{
        		length = -1;			//return -1 if the node isn't found
        	}
        }
        return length;
    }

    /** Returns a String representation of the tree.
     *
     * @return a String representation of the tree.
     */

    public String toString() {
        return toString( root );
    }

    // helper
  
    private String toString( Node<K,V> current ) {
    
        if ( current == null ) {
            return "()";
        }
    
        return "(" + toString( current.left ) + "[" + current.key + "," + current.value + "]" + toString( current.right ) + ")";
    }
  
}