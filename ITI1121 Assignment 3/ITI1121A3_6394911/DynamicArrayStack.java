/** An implementation of the interface Stack using the dynamic
 *  array technique.
 * 
 * @author Marcel Turcotte
 */

public class DynamicArrayStack<E> implements Stack<E> {

	private int defInc = 25; //Constant specifying the default increment of the stack
	private int increment; //Increment value
    /** A reference to an array that holds the elements of the stack.
     */

    private E[] elems;

    /** An instance variable that keeps track of the position of
     *  the next free cell. For an empty stack the value is 0.
     */

    private int top = 0;

    /** Creates an empty stack.
     */

    @SuppressWarnings( "unchecked" )

    public DynamicArrayStack( int increment ) {
	elems = (E[]) new Object[ increment ];
	this.increment = increment;
    }
    
    @SuppressWarnings("unchecked")
    
	public DynamicArrayStack(){ //Constructor without a parameter which initializes a stack with a size of defInc
    elems = (E[]) new Object[ defInc ];	
	this.increment = defInc;
    }

    /** Tests if this stack is empty.
     *
     * @return true if this stack contains no elements.
     */

    public boolean isEmpty() {
	return top == 0;
    }

    /** Returns the top element of this stack without removing it.
     *
     * @return the top element of the stack.
     */

    public E peek() {
	return elems[ top-1 ];
    }

    /** Returns and remove the top element of this stack.
     *
     * @return the top element of the stack.
     */

    public E pop() {
	
    int check = 0; //check if the top incrementx2 elements are null
    
    if(this.elems.length <=3){ //the size cannot be reduced
	    // save the top element
		E saved = elems[ --top ];
		// scrub the memory, then decrements top
		elems[ top ] = null; 
		return saved;
    }
    else{
		for(int i = this.elems.length - 1; i > this.elems.length - this.increment*2 - 1; i--){
				if(this.elems[i] != null){
					check ++;
				}
	    }
		
		if(check == 0){ //if none of the elements in the top increment*2 of the array weren't null then we decrease the size then pop
			E[] temp = (E[]) new Object[ this.elems.length - this.increment*2 ];
	
			for(int i = 0; i < this.elems.length - this.increment*2; i++){
				temp[i] = elems[i];
			}	
			this.elems = temp;
			
			E saved = elems[ --top ];
			// scrub the memory, then decrements top
			elems[ top ] = null; 
			return saved;
		}
		else{ //otherwise if any of the elements weren't null we just pop
		    // save the top element
			E saved = elems[ --top ];
			// scrub the memory, then decrements top
			elems[ top ] = null; 
			return saved;
		}
    }

    }

    /** Puts the element onto the top of this stack.
     *
     * @param elem the element that will be pushed onto the top of the stack.
     */

    public void push( E elem ) {

    if(elem == null){
    	throw new EmptyStackException("Null is not a valid element");
    }	
    else{	
		if(top+1 > this.elems.length){
			E[] temp = (E[]) new Object[ this.elems.length + increment ]; //creates a temporary array with a size increased by increment
		
			for(int i=0; i<this.elems.length; i++){
				temp[i] = this.elems[i]; //adds the elements from this array to the temp array
			}
			this.elems = temp; //sets this array equal to the temp array
			
			this.elems[ top++ ] = elem; //adds the element to the top of the increased size array then increments the top
		}
		else{
			this.elems[ top++ ] = elem;	// stores the element at position top, then increments top
		}
    }
    }

    /** Returns a string representation of this object.
     *
     * @return a string representation of this object.
     */

    public String toString() {

	StringBuffer b;
	b = new StringBuffer( "DynamicArrayStack: {" );

	for ( int i=top-1; i>=0; i-- ) {
	    if ( i!=top-1 ) {
		b.append( "," );
	    }
	    b.append( elems[ i ] );
	}

	b.append( "}" );

	return b.toString();
    }
    
}
