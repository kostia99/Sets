package sets;

/** ADT for the class TableInterface.
*
* @author Kostia Dargis
* @author Koen Riepe
* @elements
*	Variables of type <K, V>
* @structure 
*	linear
* @domain
*	all collections of type <K,V>
* @constructor
*	Variable();
*		PRE-condition 
*			-
*		POST-condition 
*			Empty Variable is created
*
**/

interface TableInterface<K extends Data,V extends Clonable> extends Clonable {
	

	/** Initializes an empty Table
	 * @precondition
	 * 		-
	 * @postcondition
	 * 		Table is now empty
	 * 
	 */
	void init();
	

	
	/** Returns the value of variable
	 * @throws VPException if table does not contain the variable
	 * @precondition
	 * 		Table is not empty.
	 * @postcondition
	 * 		value of variable is returned.
	 * 
	 */
	V getValue(K k) throws VPException;
	
	
	/** Changes the 'v' of the variable with key 'k'
	 * 	if the key does not exist then adds a new Variable to the Table.
	 * @precondition
	 * 		-
	 * @postcondition
	 * 		Variable with the key 'k' is in the Table and contains value 'v'.
	 */
	void setValue(K k, V v);
	
	
	/** Returns a copy of Table
	 * @precondition
	 * 		-
	 * @postcondition
	 * 		A deep copy of Table is returned
	 */
	Table<K,V> clone();
	
}
