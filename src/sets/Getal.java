package sets;

class Getal implements GetalInterface {

	StringBuffer str;
	
	
	public void init() {
		str = new StringBuffer();
		str.append('0');
	}
	
	
	public void add(char e) throws VPException {
		if (str.charAt(0) == '0') {
			str.deleteCharAt(0);
		}
		parseChar(e);
		str.append(e);
	}
	
	
	void parseChar(char c) throws VPException {
		if(!Character.isDigit(c)) {
			throw new VPException("Getal contains non-numeric char: " + "'" + c + "'");
		}
	}

	
	public char get(int i) {
		return str.charAt(i);
	}

	
	public int size() {
		return str.length();
	}
	
	
	public Getal clone() {
		Getal copy;

	    try {
	        copy = (Getal) super.clone();
	    } catch (CloneNotSupportedException e) {
	        throw new Error("Onmogelijk! instantie Knoop is niet Cloneable");
	    }
		
		copy.str = new StringBuffer(str.toString());
		
		return copy;
	}


	public int compareTo(Object obj) {
		final int BEFORE = -1;
	    final int EQUAL = 0;
	    final int AFTER = 1;
	    
	    if (obj instanceof Getal) {
	    	Getal o = new Getal();
	    	o = (Getal)obj;
	    	
	    	if (str.length() == o.str.length()) {
	    	
			    for (int i = 0; i < str.length(); i++) {
			    	if (str.charAt(i) > o.str.charAt(i)) {
			    		return BEFORE;
			    	}
			    	if (str.charAt(i) < o.str.charAt(i)) {
			    		return AFTER;
			    	}
			    }
	    	}
	    	else if (str.length() > o.str.length()) {
	    		return AFTER;
	    	}
	    	else { 
	    		return BEFORE; 
	    	}
	    }
	    
		return EQUAL;
	}
	
}
