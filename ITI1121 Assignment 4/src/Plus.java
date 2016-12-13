/* ITI 1121/1521. Introduction to Computer Science II
 * Assignment/Devoir 4
 *
 * Marcel Turcotte
 */

public class Plus implements Functor<Integer> {

    private int operand;

    public Plus( int operand ) {
        this.operand = operand;
    }

    public Integer apply( Integer other ) {

        if ( other == null ) { // default value, 0.0, identity

            return new Integer( operand );

        } else {

            return new Integer( other.intValue() + operand );

        }
    }
    
}