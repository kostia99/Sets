package sets;

class Table<K extends Data, V extends Clonable> implements TableInterface<K,V> {

	
	List<Variable<K,V>> list;
	
	Table() {
		init();
	}
	
	public void init() {
		list = new List<Variable<K,V>>();
	}
	

	
	public void setValue(K k, V v) { 
		Variable<K,V> var = new Variable<K,V>(k, v);
		
		if (!list.find(var)) {
			list.insert(var);
		}
		else {
			list.retrieve().set = v;
		}
	}
	
	

	public V getValue(K k) throws VPException {
		Variable<K,V> var = new Variable<K,V>(k, null);
		
		if (list.find(var)) {
			return (V) list.retrieve().set;
		}
		else {
			throw new VPException("All keys must be assigned first. Table does not contain one of the kyes.");
		}
	}

	
	public Table<K,V> clone() {
		 Table<K,V> copy;

		    try {
		        copy = (Table<K,V>) super.clone();
		    } catch (CloneNotSupportedException e) {
		        throw new Error("Onmogelijk! instantie Knoop is niet Cloneable");
		    }

	        copy.list = list == null ? null : (List<Variable<K,V>>) list.clone();

		    return copy;
	}

}
