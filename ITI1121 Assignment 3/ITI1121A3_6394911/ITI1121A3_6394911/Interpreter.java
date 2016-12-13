import java.awt.*;

import javax.swing.JTextArea;

/**
 * Luka Virtual Machine (LVM) -- An interpreter for the Luka programming
 * language.
 * 
 * @author Nathalie Japkowicz and Marcel Turcotte
 */

public class Interpreter {

	public JTextArea viewer;
	public Sheet sheet;

	/**
	 * Class variable. Newline symbol on this machine.
	 */

	private static final String NL = System.getProperty("line.separator");

	/**
	 * Instance variable. The operands stack.
	 */

	private Stack<Token> operands;

	/**
	 * Instance variable. A reference to a lexical analyzer (Reader).
	 */

	private Reader r;

	/**
	 * Instance variable. Coordinate x of the graphics state.
	 */

	private int gsX;

	/**
	 * Instance variable. Coordinate y of the graphics state.
	 */

	private int gsY;

	/**
	 * Instance variable. Color of the pen.
	 */

	private Color gsColor;

	/**
	 * Initializes this newly created interpreter so that the operand stack is
	 * empty, the accumulator is set 0, the cursor is at (0,0), and the default
	 * color is blue.
	 */

	public Interpreter() {
		reset();
	}

	/**
	 * Auxiliary method that resets the graphics state of this interpreter.
	 */

	private void reset() {

		operands = new LinkedStack<Token>();

		gsX = 0;
		gsY = 0;
		gsColor = Color.BLUE;
	}

	/**
	 * Executes the input program and displays the result onto the Graphics
	 * object received as an argument.
	 * 
	 * @param program
	 *            contains the source to be executed.
	 * @param g
	 *            the graphics context.
	 * @param output
	 *            TODO
	 */

	public void execute(String program, Graphics g, JTextArea output,
			Sheet sheet) {

		this.viewer = output;
		this.sheet = sheet;

		reset();
		r = new Reader(program);

		g.setColor(gsColor);

		while (r.hasMoreTokens()) {

			Token t = r.nextToken();

			if (t.isNumber()) {

				operands.push(t);

			} else if (t.getSymbol().equals("add")) {

				execute_add();

			} else if (t.getSymbol().equals("sub")) {

				execute_sub();

			} else if (t.getSymbol().equals("mul")) {

				execute_mul();

			} else if (t.getSymbol().equals("div")) {

				execute_div();

			} else if (t.getSymbol().equals("exch")) {

				execute_exch();

			} else if (t.getSymbol().equals("pop")) {

				execute_pop();

			} else if (t.getSymbol().equals("moveto")) {

				execute_moveto();

			} else if (t.getSymbol().equals("lineto")) {

				execute_lineto(g);

			} else if (t.getSymbol().equals("arc")) {

				execute_arc(g);

			} else if (t.getSymbol().startsWith("/")) {

				operands.push(new Token(t.getSymbol().substring(1)));

			} else if (t.getSymbol().equals("quit")) {

				execute_quit();

			} else if (t.getSymbol().equals("mark")) {

				execute_mark();

			} else if (t.getSymbol().equals("cleartomark")) {

				execute_cleartomark();

			} else if (t.getSymbol().equals("counttomark")) {

				execute_counttomark();

			} else if (t.getSymbol().equals("pstack")) {

				execute_pstack();

			} else if (t.getSymbol().equals("clear")) {

				execute_clear();

			} else if (t.getSymbol().equals("dup")) {

				execute_dup();

			} else if (t.getSymbol().equals("count")) {

				execute_count();

			} else if (t.getSymbol().equals("sumtomark")) {

				execute_sumtomark();

			} else if (t.getSymbol().equals("roll")) {

				execute_roll(operands.pop().getNumber(), operands.pop().getNumber());

			} else if (t.getSymbol().equals("cell")) {

				execute_cell(operands.pop().getNumber(), operands.pop().getSymbol().toString());

			} else if (t.getSymbol().equals("pushrow")) {

				execute_pushrow(operands.pop().getNumber());

			} else if (t.getSymbol().equals("pushcol")) {

				execute_pushcol(operands.pop().getSymbol().toString());

			} else {
				throw new LukaSyntaxException(
						"That is not a reserved word from the Luka programming language"); // throws a LukaSyntaxException if the token matches one of the reserved words
			}
		}
	}

	private void execute_add() {
		Token op1 = operands.pop();
		Token op2 = operands.pop();
		Token res = new Token(op1.getNumber() + op2.getNumber());
		operands.push(res);
	}

	private void execute_sub() {
		Token op1 = operands.pop();
		Token op2 = operands.pop();
		Token res = new Token(op2.getNumber() - op1.getNumber());
		operands.push(res);
	}

	private void execute_mul() {
		Token op1 = operands.pop();
		Token op2 = operands.pop();
		Token res = new Token(op1.getNumber() * op2.getNumber());
		operands.push(res);
	}

	private void execute_div() {
		Token op1 = operands.pop();
		Token op2 = operands.pop();
		Token res = new Token(op2.getNumber() / op1.getNumber());
		operands.push(res);
	}

	private void execute_exch() {
		Token op1 = operands.pop();
		Token op2 = operands.pop();
		operands.push(op1);
		operands.push(op2);
	}

	private void execute_pop() {
		operands.pop();
	}

	private void execute_moveto() {
		Token y = operands.pop();
		Token x = operands.pop();
		gsX = x.getNumber();
		gsY = y.getNumber();
	}

	private void execute_lineto(Graphics g) {
		Token y = operands.pop();
		Token x = operands.pop();
		g.drawLine(gsX, gsY, x.getNumber(), y.getNumber());
		gsX = x.getNumber();
		gsY = y.getNumber();
	}

	private void execute_arc(Graphics g) {
		Token a2 = operands.pop();
		Token a1 = operands.pop();
		Token r = operands.pop();
		g.drawArc(gsX, gsY, r.getNumber(), r.getNumber(), a1.getNumber(),
				a2.getNumber());
	}

	private void execute_mark() {
		operands.push(new Token("mark"));
	}

	private void execute_cleartomark() {
		boolean done = false;
		while (!done) {
			Token current = operands.pop();
			if (current.isSymbol() && current.getSymbol().equals("mark")) {
				done = true;
			}
		}
	}

	private void execute_counttomark() {
		Stack<Token> tempStack = new LinkedStack<Token>();
		boolean done = false;
		int count = 0;
		while (!done) {
			Token current = operands.pop();
			if (current.isSymbol() && current.getSymbol().equals("mark")) {
				done = true;
			} else {
				count++;
			}
			tempStack.push(current);
		}
		while (!tempStack.isEmpty()) {
			operands.push(tempStack.pop());
		}
		operands.push(new Token(count));
	}

	private void execute_pstack() { //displays the values of the operands stack in the viewer
		Stack<Token> tempStack = new LinkedStack<Token>();
		String temp = "[";
		boolean done = false;

		if (operands.isEmpty()) {
			// do nothing
		} else {
			while (!done) {

				tempStack.push(operands.pop());

				if (operands.isEmpty()) {
					done = true;
				}
			}

			while (!tempStack.isEmpty()) {
				Token current = tempStack.pop();
				if(current.isNumber()){
					temp = temp + current.getNumber() + " ";
					operands.push(current);
				}else if(current.isSymbol()){
					operands.push(current);					
				}
			}
		}
		viewer.append(temp + "\n");
	}

	private void execute_clear() { //clears the operands stack
		while (!operands.isEmpty()) {
			operands.pop();
		}
	}

	private void execute_dup() { //duplicates the top token of the operands stack
		Token dup = operands.pop();

		operands.push(dup);
		operands.push(dup);
	}

	private void execute_count() {
		Stack<Token> tempStack = new LinkedStack<Token>();
		boolean done = false;
		int count = 0;
		while (!done) {
			Token current = operands.pop();
			if (operands.isEmpty()) {
				count++;
				done = true;
			} else {
				count++; //counts the number of operands
			}
			tempStack.push(current);
		}
		while (!tempStack.isEmpty()) {
			operands.push(tempStack.pop());
		}
		operands.push(new Token(count)); //pushes the count to the top of the operands stack
	}

	private void execute_sumtomark() {
		Stack<Token> tempStack = new LinkedStack<Token>();
		boolean done = false;
		int sum = 0;
		while (!done) {
			Token current = operands.pop();
			if (current.isSymbol() && current.getSymbol().equals("mark")) {
				done = true;
			} else {
				sum = sum + current.getNumber(); //sums all the tokens in the operands stack up to the mark
			}
			tempStack.push(current);
		}
		while (!tempStack.isEmpty()) {
			operands.push(tempStack.pop());
		}
		operands.push(new Token(sum)); //pushes the sum to the top of the stack
	}

	private void execute_roll(int n, int j) {
		Stack<Token> tempStack = new LinkedStack<Token>();	
		Stack<Token> topN = new LinkedStack<Token>();	

		for(int i=0; i<n; i++){
			topN.push(operands.pop()); //pushes the top n values into a temporary stack
		}
		
		while(!operands.isEmpty()){
			tempStack.push(operands.pop()); //pushes the rest of the values into a different temporary stack
		}
		
		for(int i=0; i<j-n; i++){
			operands.push(tempStack.pop()); //pushes values from the 2nd temporary stack back into the operands stack depending on n, j
		}
		
		while(!topN.isEmpty()){
			operands.push(topN.pop()); //pushes the top n values back into the operands stack
		}
		
		while(!tempStack.isEmpty()){
			operands.push(tempStack.pop()); //pushes the rest of the values back into the operands stack completing the roll
		}
	}

	private void execute_cell(int r, String c) {
		char x = c.charAt(0);
		int col = x - 65; //based on the ASCII table where A is 65 and so on...
		
		if(sheet.getValueAt(r, col) != ""){ //should check to see if the cell contains anything other than a number, if so ignore it
			Token temp = new Token(Integer.parseInt(sheet.getValueAt(r, col).toString())); //Convert cell object to string, then parseInt
			operands.push(temp);
		}
		else{
			//do nothing
		}
	}

	private void execute_pushrow(int r) {
		for(int i=sheet.getColumnCount()-1; i>-1; i--){
			if(sheet.getValueAt(r, i) != ""){ //should check to see if the cell contains anything other than a number, if so ignore it
				Token temp = new Token(Integer.parseInt(sheet.getValueAt(r, i).toString())); //Convert cell object to string, then parseInt
				operands.push(temp);
			}
			else{
				//do nothing
			}
		}
	}

	private void execute_pushcol(String c) {
		char x = c.charAt(0);
		int col = x - 65; //based on the ASCII table where A is 65 and so on...
		
		for(int i=sheet.getRowCount()-1; i>-1; i--){
			if(sheet.getValueAt(i, col) != ""){ //should check to see if the cell contains anything other than a number, if so ignore it
				Token temp = new Token(Integer.parseInt(sheet.getValueAt(i, col).toString())); //Convert cell object to string, then parseInt
				operands.push(temp);
			}
			else{
				//do nothing
			}
		}
	}	

	private void execute_quit() {
		System.out.println("Bye!");
		System.exit(0);
	}

}
