package sets;

class Variable<K extends Data, V extends Clonable> implements Data {

	K id;
	
	V set;
	
	
	Variable() {
		init();
	}
	
	
	Variable(K id, V set) {
		this.id = id;
		this.set = set;
	}
	
	
	public void init() {
		this.id = null;
		this.set = null;
	}
	
	
	
	
	public Variable<K,V> clone() {
		Variable<K,V> copy;
		
	    try {
	        copy = (Variable<K,V>) super.clone();
	    } catch (CloneNotSupportedException e) {
	        throw new Error("Onmogelijk! instantie Variabele is niet Cloneable");
	    }
	   
	    copy.id = id == null ? null : (K) id.clone();
	    copy.set = set == null ? null : (V) set.clone();
	    
	    return copy;
	}


	public V getValue(K k) {
		return this.set;
	}


	public void setValue(V v) {
		this.set = v;
	}


	public int compareTo(Object obj) {
		Variable<K,V> var = new Variable<K,V>();
		
		if (obj instanceof Variable<?,?>) {
			var = (Variable<K,V>)obj;
		}
		
		return this.id.compareTo(var.id);
	}

}
