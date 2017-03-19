import java.util.ArrayList;

public class S<E> {
	// Create ArrayList object for use in Stack
	ArrayList<E> arrs = new ArrayList<E>();

	public void push(E chr) {
		// Adds Character to top of Stack
		arrs.add(0, chr);

	}

	public boolean Contains(char key) {
		// Checks stack for key
		boolean retval = arrs.contains(key);
		return retval;

	}

	public int size() {
		// Returns size of stack (for final dump processing)
		int retval = arrs.size();
		return retval;
	}

	public E pop() {
		// Remove from top of Stack
		E retval = null;
		if (arrs.isEmpty()) {
			System.out.println(" The Character stack is empty");
		} else {
			retval = arrs.get(0);
			arrs.remove(0);
		}
		return retval;
	}

	public E top() {
		// Returns Character on top of stack without removing
		E retval = null;
		if (arrs.isEmpty()) {
			System.out.println("The stack is empty");

		} else {
			retval = arrs.get(0);
		}
		return retval;
	}

	public boolean isStkMT() {
		// Returns boolean of Stack empty
		boolean retval = arrs.isEmpty();
		return retval;
	}

}
