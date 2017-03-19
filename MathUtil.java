

public class MathUtil extends MainReadIn {

	public static <E extends Comparable<E>> int OperandOrAtor(E charInQues) {
		///////////////////////////////////////////////////////////////////////////////////
		/* Generic method used to determine if the character in question is an
		 * operator or an operand. If the generic object passed to the method is
		 * a +, -, *, or / the method returns an int of 1, otherwise it will
		 * return a 0
		 * 
		 * Edit: Current version of this method also detects left and right parens,
		 * returning 2 for a left parens and carrot, and 3 for right parens
		 */

		int retval = -999;
		if ((charInQues.equals('+')) || (charInQues.equals('-')) || (charInQues.equals('*'))
				|| (charInQues.equals('/'))) {
			retval = 1;
		} else if ((charInQues.equals('(')) || (charInQues.equals('^'))){
			retval = 2;
		} else if (charInQues.equals(')')) {
			retval = 3;
		} else {
			retval = 0;
		}

		return retval;
	}

	public static int CheckForOperator() {
		///////////////////////////////////////////////////////////////////////////////////
		/* Check stack for existing operator
		 * If found the method returns an int of 1, otherwise 0 
		 */
		
		int retval = 0;
		for (char c : "*/-+%".toCharArray()) {
		    if (sOne.Contains(c)) {
		        retval = 1;
		        break;
		    }
		}
		
		
		
//		if ((sOne.Contains('*')) || (sOne.Contains('/')) || (sOne.Contains('-')) || (sOne.Contains('+')) || (sOne.Contains('%'))){
//			retval = 1;
//		} else {
//			retval = 0;
//		}
		return retval;
	}

	public static <E extends Comparable<E>> int compareTo(E operInQues) {
		///////////////////////////////////////////////////////////////////////////////////
		/* *This method takes in a generic object (which will always be an operator) 
		 * *The object taken in is the operator found in the front of the queue 
		 * *Priority level is assigned to the object taken in and to the object at 
		 * the top of the stack
		 * *Priority/equality over onInQue and opInStk is determined
		 * *Return values are as follows
		 * 		opInStk has priority over opInQue returns -1
		 * 		opInQue has priority over opInStk returns 1
		 * 		opInQue has equal priority to opInStk return 0
		 * 
		 *  * Edit: To add exponentiation functionality a fourth option was needed
		 *  	If the top of the stack has a carrot the method returns 2
		 *  	Modulus functionality was also added with equal priority to '*' & '/'
		 */
		int retval = -999;
		int opInStk = -999;
		int opInQue = -999;
		char opInStk_char = sOne.top();
		if (opInStk_char == '^') {
			return 2;
		}
		if (operInQues.equals('+') || (operInQues.equals('-'))) {
			opInQue = 1;
		} else if (operInQues.equals('*') || (operInQues.equals('/')) || (operInQues.equals('%'))) {
			opInQue = 2;
		}
		if ((opInStk_char == '+') || (opInStk_char == '-')) {
			opInStk = 1;
		} else if ((opInStk_char == '*') || (opInStk_char == '/') || (opInStk_char == '%')) {
			opInStk = 2;
		}
		if (opInQue > opInStk) {
			retval = 1;
		} else if (opInQue < opInStk) {
			retval = -1;
		} else if (opInQue == opInStk) {
			retval = 0;
		} else {
			System.out.println("Something tragic happened");
			System.exit(0);
		}
		return retval;
	}

}