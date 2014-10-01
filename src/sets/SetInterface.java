package sets;

/** ADT for the class SetInterface.
*
* @author Kostia Dargis
* @author Koen Riepe
* @elements
*	elements of the type <T>
* @structure 
*	no structure
* @domain
*	all collections of the type <T>
* @constructor
*	Set();
*	    
*		PRE-condition 
*			-
*		POST-condition 
*			Set is empty
*
**/

interface SetInterface<T extends Data> extends Clonable {
	
	
	/** Initializes Set object as empty.
     * @precondition
     *	    -
     * @postcondition
     *	    Set is empty.
     **/
     void init();

	
    /** Adds object of the type <T> to the Set
     * @precondition
     *	    -
     * @postcondition
     *	    'T' is in the Set.
     **/
	 void add(T t);
	
	
	 /** Removes object of the type <T> from the Set
	 * Does nothing if the element does not exist in the Set
     * @precondition
     *	    -
     * @postcondition
     *	    't' is not in the Set.
     **/
	 void remove(T t);
	
	
	 /** Returns random element from the Set
	 * @throws VPException if set is empty
     * @precondition
     *	    -
     * @postcondition
     *	   a random T-object is returned, T-object in not in the Set.
     **/
	 T getElement() throws VPException;
	 
	 
	 /** Returns a new Set object with all elements from current and passed set
	 * @precondition
	 * 		-
	 * @postcondition
	 * 		A new set object is returned.
	 */
	 Set<T> union(Set<T> set);
	 
	 
	 /** Returns a new Set object which contains 'difference' between current and passed set
	 * @precondition
	 * 		-
	 * @postcondition
	 * 		A new set object is returned.
	 */
	 Set<T> difference(Set<T> set);
	 
	 
	 /** Returns a new Set object which contains 'intersection' between current and passed set
	 * @precondition
	 * 		-
	 * @postcondition
	 * 		A new set object is returned.
	 */
	 Set<T> intersection(Set<T> set);
	 
	
	 /** Returns a new Set object which contains 'symmetric difference' between current and passed set
	 * @precondition
	 * 		-
	 * @postcondition
	 * 		A new set object is returned.
	 */
	 Set<T> symDifference(Set<T> set);
	
	
	 /** Returns amount of elements in the Set
     * @precondition
     *	    -
     * @postcondition
     *	    int value is returned.
     **/
	 int size();

}
