package sets;


class Identifier implements IdentifierInterface {
	
	StringBuffer str;

	
	public void add(char c) throws VPException {
		parseChar(c);
		str.append(c);
	}
	
	
	public char get(int i) {
		return str.charAt(i);
	}

	
	public void init(char c) throws VPException {
		str = new StringBuffer();
		parseChar(c);
		str.append(c);
	}

	
	void parseChar(char c) throws VPException {
		if (str.length() == 0) {
			if(!Character.isLetter(c)) {
				throw new VPException("Identifier does not begin with a small letter!");
			}
		}
		else {
			if(!Character.isLetterOrDigit(c)) {
				throw new VPException("Identifier contains non-alphanumeric character: \'" + c + "\'");
			}
		}
	}
	
	
	public int size() {
		return str.length();
	}
	
	
	public Identifier clone() {
		Identifier copy;

	    try {
	        copy = (Identifier) super.clone();
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
	    
	    
	    if (obj instanceof Identifier) {
	    	Identifier o = new Identifier();
	    	o = (Identifier)obj;
	    	
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
