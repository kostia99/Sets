package sets;


/** ADT for the class GetalInterface.
*
* @author Kostia Dargis
* @author Koen Riepe
* @elements
*	digits of the type char
* @structure 
*	linear
* @domain
*	all digits
* @constructor
*	Getal();
*		PRE-condition 
*			-
*		POST-condition 
*			Row of elements is undefined
*	
**/

interface GetalInterface extends Data {
	
	/** Initializes Getal object with '0'.
     * @precondition
     *	    -
     * @postcondition
     *	    Getal contains 0.
     **/
	void init();
	
	
	/** Adds char to the Getal-object
	 * @throws VPException if char is not a digit
     * @precondition
     *	    'c' is a digit
     * @postcondition
     *	    char 'c' is added to Getal
     *		if Getal was '0' then the '0' was overwritten with 'c'
     *		else 'c' was appended to the end.
     **/
	void add(char c) throws VPException;

	
	/** Returns char with index 'i'.
     * @precondition
     *	    i >= 0 and i < size();
     * @postcondition
     *	    char with index 'i' is returned.
     **/
	char get(int i);
	
	
	/** Returns a deep copy of the Getal object
     * @precondition
     *	    -
     * @postcondition
     *	    copy of Getal is returned
     **/
	Getal clone();
	
	
	/** Compares current Getal with the passed in Getal
     * @precondition
     *	    -
     * @postcondition
     *	    returns -1 if current Getal is before passed in Getal
     *		returns 0 if they are equal
     *		returns 1 if current Getal is after passed in Getal
     **/
	int compareTo(Object obj); 
	
	
	/** Returns length of the Getal
     * @precondition
     *	    -
     * @postcondition
     *	    length of Getal is returned.
     **/
	int size();

}
