package sets;


class Set<T extends Data> implements SetInterface<T> {
	
	
	List<T> list;
	
	Set() {
		init();
	}
	
	
	public void init() {
		list = new List<T>();
	}
	
	
	public void add(T t) {
		if (!list.find(t)) {
			list.insert(t);
		}
	}
	
	
	public void remove(T t) {
		if (list.find(t)) {
			list.remove();
		}
	}
	
	
	private void addAll(Set<T> set) {
		if (set.list.setFirst()) {
			do {
				
				if (!list.find(set.list.retrieve())) {
					list.insert(set.list.retrieve());
				}
				
			} while (set.list.getNext());
		}
	}
	
	
	private void removeAll(Set<T> set) {
		if (set.list.setFirst()) {
			do {
				
				remove(set.list.retrieve());
				
			} while (set.list.getNext());
		}
	}
	
	
	public Set<T> union(Set<T> set) {
		addAll(set);
		return this;
	}
	
	
	public Set<T> difference(Set<T> set) {
		removeAll(set);
		return this;
	}
	
	
	public Set<T> intersection(Set<T> set) {
		Set<T> temp = new Set<T>();
		
		if (set.list.setFirst()) {
			do  {
				
				if (list.find(set.list.retrieve())) {
					temp.add(set.list.retrieve());
				}
				
			} while (set.list.getNext());	
		}
		
		return temp;
	}
	
	
	public Set<T> symDifference(Set<T> set) {
		Set<T> temp1 = this.clone().difference(set);
		Set<T> temp2 = set.difference(this.clone());
		
		return temp1.union(temp2);
		
	}
	
	
	public T getElement() throws VPException {
		if (list.isEmpty()) {
			throw new VPException("This set is empty. There is nothing to return.");
		}
		
		T t = list.retrieve();
		remove(t);
		
		return t;
	}
	
	
	public Set<T> clone() {
		Set<T> copy;

	    try {
	        copy = (Set<T>) super.clone();
	    } catch (CloneNotSupportedException e) {
	        throw new Error("Onmogelijk! instantie Verzameling is niet Cloneable");
	    }
	    
	    copy.init();

        copy.list = list == null ? null : (List<T>) list.clone();

	    return copy;
	}
	
	
	public int size() {
		return list.size();
	}	
}

