package sets;

class List<E extends Data> implements ListInterface<E> {
	
	
	Node<E> current, first, last;
	
	int amountNodes;
	
	
	List() {
		init();
	}
	
	
	public List<E> init() {
		current = null;
		first = current;
		last = current;
		
		amountNodes = 0;
		
		return this;
	}

	
	public boolean find(E d) {
		if (!setFirst()) {
			return false;
		}
			
		while(current.data.compareTo(d) != 0) {
			if (current.next == null) {
				return false;
			}
		
			if (current.data.compareTo(d) > 0) {
				current = current.next;
			}
			else {
				return false;
			}
		}
		
		return true;
	}
	

	public boolean getNext() {
		if (current.next == null) {
			return false;
		}
		
		current = current.next;
		
		return true;
	}

	
	public boolean getPrior() {
		if (current.prior == null) {
			return false;
		}

		current = current.prior;
		
		return true;
	}


	public boolean isEmpty() {
		return amountNodes == 0;
	}

	
	public List<E> remove() {
		if (isEmpty()) {
			return this;
		}
		else if (amountNodes == 1) {
			return init();
		}
		else if (current.prior == null) {
			first = current.next;
			current = first;
			current.prior = null;
			
		}
		else if (current.next == null) {
			last = current.prior;
			current = last;
			current.next = null;
			
		}
		else {
			current = current.next;
			current.prior.prior.next = current;
			current.prior = current.prior.prior;
		}
		
		amountNodes -= 1;
		
		return this;
	}

	
	public E retrieve() {
		return current.data;
	}

	
	public boolean setFirst() {
		if (isEmpty()) {
			return false;
		}
		
		current = first;		
		
		return true;
	}

	
	public boolean setLast() {
		if (isEmpty()) {
			return false;
		}
		
		current = last;
		
		return true;
	}

	
	
	public int size() {
		return amountNodes;
	}
	

	public List<E> insert(E d) {
		Node<E> tmp = new Node<E>(d);
		
		if (isEmpty()) {
			current = tmp.clone();
			first = current;
			last = current;
		}
		else if (first.data.compareTo(d) <= 0) {
			tmp.next = first;
			first.prior = tmp.clone();
			first = first.prior;
			current = first;
		}
		else if (last.data.compareTo(d) >= 0) {
			tmp.prior = last;
			last.next = tmp.clone();
			last = last.next;
			current = last;
		}
		else {

			if (find(d)) { }
			
			tmp.next = current;
			tmp.prior = current.prior;
			current.prior.next = tmp.clone();
			current.prior = current.prior.next;
		}
				
		amountNodes += 1;
		
		return this;
	}
	
	
	public List<E> clone() {
		 List<E> copy;

		    try {
		        copy = (List<E>) super.clone();
		    } catch (CloneNotSupportedException e) {
		        throw new Error("Onmogelijk! instantie Lijst is niet Cloneable");
		    }
		    
		    copy.init();
		    
		    if (setFirst()) {
		    	
		    	do {
		    		copy.insert((E)current.data.clone());
		    		
		    	} while (getNext());
		    }
		    else {
		    	return new List<E>();
		    }

		    return copy;
	    }
	
}


