package sets;


/** ADT for the class IdentifierInterface.
*
* @author Kostia Dargis
* @author Koen Riepe
* @elements
*	alphanumeric characters of the type char
* @structure 
*	linear
* @domain
*	all rows of alphanumeric characters starting with a letter
* @constructor
*	Identifier();
*		PRE-condition 
*			-
*		POST-condition 
*			Row of characters is undefined
*	
**/


interface IdentifierInterface extends Data {
	
	
	/** Initializes Identifier object with one character.
	 * @throws VPException if char is not a letter
     * @precondition
     *	    -
     * @postcondition
     *	    Identifier contains only 'c'.
     **/
	void init(char c) throws VPException;
	
	
	/** Adds character to Identifier object
     * @throws VPException if char is not a letter or a digit
     * @precondition
     *	    -
     * @postcondition
     *	    character is added to the Identifier.
     *		
     **/
	void add(char c) throws VPException;
	
	
	/** Returns character of Identifier with index 'i'.
     * @precondition
     *	    i >= 0 and i < size();
     * @postcondition
     *	    character is returned.
     **/
	char get(int i);
	
	
	/** Returns a deep copy of the Identifier object
     * @precondition
     *	    -
     * @postcondition
     *	    Identifier is returned
     **/
	Identifier clone();
	
	
	/** Returns length of the row of characters
     * @precondition
     *	    -
     * @postcondition
     *	    length of row is returned.
     **/
	int size();
}
