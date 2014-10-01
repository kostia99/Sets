package sets;

class Node<E extends Data> implements Cloneable {

    E data;
    
    Node<E> prior,
             next;
    

    public Node (E d) {
    	
	    this(d, null, null);
    }


	public Node (E d, Node p, Node n) {
	    data = d == null ? null : (E) d.clone();
	    prior = p;
	    next = n;
    }


	public Node<E> clone() {
	    Node<E> copy;

	    try {
	        copy = (Node<E>) super.clone();
	    } catch (CloneNotSupportedException e) {
	        throw new Error("Onmogelijk! instantie Knoop is niet Cloneable");
	    }

        copy.data = data == null ? null : (E) data.clone();

	    return copy;
    }

}