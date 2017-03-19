import java.util.ArrayList;

public class Q<E> {
	// Create ArrayList object for use in Queue
	ArrayList<E> arrQoNE = new ArrayList<E>();

	public void add2Rear(E chr) {
		// Adds Character to rear
		arrQoNE.add(chr);
	}
	
	public int size() {
		int retval = arrQoNE.size();
		return retval;
	}

	public E removeFront() {
		// Remove from the front and return the Character that was removed
		E retval;
		retval = arrQoNE.get(0);
		arrQoNE.remove(0);
		return retval;
	}

	public void ClearQ() {
		// Clears the queue to start over again
		arrQoNE.clear();
	}

	public E front() {
		// Returns front item without removing it
		E retval = arrQoNE.get(0);
		return retval;
	}

	public boolean isQMT() {
		// Returns boolean if Queue is empty
		boolean retval = arrQoNE.isEmpty();
		return retval;
	}

	public boolean isQFull() {
		// Using ArrayList, this is always false
		return false;
	}
	
	public void printIt(){
		// Provide prettier means of printing
		int size = arrQoNE.size();
		for (int i = 0; i < size; i++){
			System.out.print(arrQoNE.get(0));
			arrQoNE.remove(0);
		}
		System.out.println();
	}

	public String toString() {
		// Provide means of printing
		String retval = arrQoNE.toString();
		return retval;
	}

}
