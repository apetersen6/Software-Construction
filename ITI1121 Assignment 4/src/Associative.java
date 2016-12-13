/* ITI 1121/1521. Introduction to Computer Science II
 * Assignment/Devoir 4
 *
 * Marcel Turcotte
 */

public interface Associative< K extends Comparable<K>, V > {

    /** Returns the value associated with this key, or null if the key is not found.
     *
     *  @param key key whose associated value is to be returned
     *  @return the value associated with this key, or null if the key is not found
     */

    public abstract V get( K key );

    /** The method fun.apply() is used to associate a value with the
     *  specified key. If the associative structure previously
     *  contained the key, the associated value is passed to the
     *  method apply and the resulting value is used to replace the
     *  old value, otherwise a new association (key,value) is created,
     *  the method apply receives the value zero, the result is associated
     *  with the key.
     *
     *  @param key key with which the specified value is to be associated
     *  @param fun an implementation of the interface <tt>Functor</tt>
     *  @return the previous value associated with this key, or null if the key was not found
     */

    public abstract V update( K key, Functor<V> fun );

    /** Returns the list of keys in order, according to the method compareTo of the key
     *  objects.
     *
     *  @return the list of keys in order
     */

    public abstract LinkedList<K> keys();

    /** Returns the list of value in the order specified by the method compareTo of the key
     *  objects.
     *
     *  @return the list of values
     */

    public abstract LinkedList<V> values();

}