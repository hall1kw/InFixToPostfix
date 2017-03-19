import java.util.*;
import java.io.*;

public class MainReadIn {
	// Make queues and stack available to all classes in package
	static Q<Character> qOne = new Q<Character>();
	static S<Character> sOne = new S<Character>();
	static Q<Character> qFinal = new Q<Character>();

	///////////////////////////////////////////////////////////////////////////////////
	/* @uther - Kenneth Hall for CPS 181 - Program Five 
	 * Purpose: Take an unknown number of infix equations and convert to postfix line by line
	 * Add-ons:
	 * 		Modulus functionality (same priority as '*' & '/'
	 * 		Parens functionality
	 * 		Exponentiation functionality
	 */
	public static <E> void main(String[] args) throws FileNotFoundException {
		File file = new File("input.txt");
		Scanner fisc = new Scanner(file);
		while (fisc.hasNextLine()) {
			String lineRead = fisc.nextLine();
			// Convert input string to CharArray and populate qOne with characters in order
			char[] chars = lineRead.toCharArray();
			for (int i = 0; i < lineRead.length(); i++) {
				qOne.add2Rear(chars[i]);
			}
			for (int i = 0; i < lineRead.length(); i++) {
				// Determine if front of qOne is an operator or an operand
				char charFromQueue = qOne.removeFront();
				if (MathUtil.OperandOrAtor(charFromQueue) == 0) {
					// If front of queue is operand append to qFinal
					qFinal.add2Rear(charFromQueue);
				} else if (MathUtil.OperandOrAtor(charFromQueue) == 1) {
					// Check for priorities 
					if (MathUtil.CheckForOperator() == 0) {
						// If no operator is in stack, push to stack
						sOne.push(chars[i]);
					} else if (MathUtil.CheckForOperator() == 1) {
						if (MathUtil.compareTo(charFromQueue) == 1) {
							// If operator in qOne takes higher priority, push onto stack
							sOne.push(charFromQueue);
						} else if ((MathUtil.compareTo(charFromQueue) == 0) || 
								(MathUtil.compareTo(charFromQueue) == -1)){
							// If operator in qOne is lower or equal priority to operator in stack
							// Pop operator from stack, append to qFinal, push qOne operator onto stack
							char temp = sOne.pop();
							qFinal.add2Rear(temp);
							sOne.push(chars[i]);
						} else if (MathUtil.compareTo(charFromQueue) == 2) {
							// The compareTo return of 2 indicates there is a carrot on the stack
							// Append carrot to qFinal and repeat the compareTo method
							qFinal.add2Rear(sOne.pop());
							if (MathUtil.compareTo(charFromQueue) == 1) {
								// If operator in qOne takes higher priority, push onto stack
								sOne.push(charFromQueue);
							} else if ((MathUtil.compareTo(charFromQueue) == 0) || 
									(MathUtil.compareTo(charFromQueue) == -1)){
								// If operator in qOne is lower or equal priority to operator in stack
								// Pop operator from stack, append to qFinal, push qOne operator onto stack
								char temp = sOne.pop();
								qFinal.add2Rear(temp);
								sOne.push(chars[i]);
							}
						}
					}
				} else if (MathUtil.OperandOrAtor(charFromQueue) == 2) {
					// If charFromQueue is left parens push it onto the stack
					sOne.push(charFromQueue);				
				} else if (MathUtil.OperandOrAtor(charFromQueue) == 3) {
					// If charFromQueue is right parens, dump the stack until
					// a left parens is found and pop that parens
					while (sOne.top() != '('){
						qFinal.add2Rear(sOne.pop());
					}
					sOne.pop();
				} 
			}
			// Dump stack to qFinal
			for (int i = 0; i <= sOne.size(); i++) {
				char temp = sOne.pop();
				qFinal.add2Rear(temp);
			}
			// Print final results and clear qFinal for next iteration
			System.out.println("In: " + lineRead);
			System.out.print("  Out: ");
			qFinal.printIt();
			qFinal.ClearQ();

		}
		fisc.close();
	}
}
