/* ITI 1121/1521. Introduction to Computer Science II
 * Assignment/Devoir 4
 *
 * Marcel Turcotte
 */

public interface Iterator<E> {

    /**
     * Returns true if the iteration has more elements. (In other
     * words, returns true if next would return an element rather than
     * throwing an exception.)
     *
     * @return true if the iterator has more elements.
     */

    public abstract boolean hasNext();

    /**
     * Returns true if previous would return an element rather than
     * throwing an exception.
     *
     * @return true if the iterator has more elements (backward direction).
     */

    public abstract boolean hasPrevious();

    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration.
     * @exception NoSuchElementException iteration has no more elements.
     */

    public abstract E next();

    /**
     * Returns the last element that was returned by <tt>next</tt>.
     *
     * @exception IllegalStateException if the iteration has no previous element.
     */

    public abstract E previous();

    /**
     * Inserts the element immediately before the next element that would be returned by <tt>next</tt>.
     * A subsequent call to next would be unaffected
     *
     * @param the element to insert
     * @exception IllegalArgumentException if <tt>elem</tt> is null.
     */

    public void add( E elem );

    /**
     * Removes from the list the last element that was returned by
     * <tt>next</tt>.  This call can only be made once per call to <tt>next</tt>.
     *
     * @exception IllegalStateException if <tt>next</tt> has not been called, or
     *            the number of element removes exceeds the number of time
     *            <tt>next</tt> was called.
     */

    public void remove();

}