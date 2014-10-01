package sets;

import java.io.PrintStream;
import java.util.Scanner;
import java.util.regex.Pattern;


class Main {
	
	
	Table<Identifier, Set<Getal>> table;
	
	Scanner in;
	
	PrintStream log;
	
	
	Main() {
		
		log = new PrintStream(System.out);
		
		in = new Scanner(System.in);
		
		table = new Table<Identifier, Set<Getal>>();
	}
	
	
	
	char nextChar(Scanner in) {
		return in.next().charAt(0);
	}
	
	
	boolean nextCharIs(Scanner in, char c) {
		return in.hasNext(Pattern.quote(c+""));
	}
	
	
	boolean nextCharIsLetter(Scanner in) {
		return in.hasNext("[a-zA-Z]");
	}
	
	boolean nextCharIsDigit(Scanner in) {
		return in.hasNext("[0-9]");
	}
	
	
	void character(Scanner in, char c) throws VPException {
		if (!in.hasNext()) {
			throw new VPException("Line ended unexpectedly.");
		}
	    if (!nextCharIs(in, c)) {
	    	throw new VPException("Syntax error, remove this: " + c + in.nextLine());
	    }
	}
	
	
	void readSpace(Scanner in) {
		while (nextCharIs(in, ' ')) {
			nextChar(in);
		}
	}
	
	
	void endOfLine (Scanner in) throws VPException {
	    if (in.hasNext()) {
	    	throw new VPException("Syntax error. Remove this: " + in.nextLine());
	    }
	}

	
	
	Identifier readIdentifier(Scanner in) throws VPException {
		Identifier tmp = new Identifier();
		tmp.init(nextChar(in));
		
		while(in.hasNext()) {
			if (!nextCharIsLetter(in)) { 
				break; 
			}
			
			tmp.add(nextChar(in));
		}
		
		return tmp;
	}
	
	
	Getal readGetal (Scanner in) throws VPException {
		Getal g = new Getal();
		g.init();
		
		while (in.hasNext()) {
			g.add(nextChar(in));
			
			if (!nextCharIsDigit(in)) {
				break;
			}
		}
		
		return g;
	}
	
	
	Set<Getal> readSet(Scanner in) throws VPException {
		Set<Getal> set = new Set<Getal>();
		
		character(in, '{');
		nextChar(in);
		
		while (in.hasNext()) {
			readSpace(in);
			
			if (nextCharIsDigit(in)) {
				set.add(readGetal(in));
				
				readSpace(in);
				
				if (nextCharIs(in, ',')) {
					nextChar(in);
				}
				else {
					break;
				}
			}
			else {
				break;
			}
		}
		
		readSpace(in);
		
		if (nextCharIs(in, '}')) {
			nextChar(in);
		} else {
			throw new VPException("Elements cannot be empty, must contain only digits and be closed with a comma except the last one.");
		}
		
		return set;
	}
	
	
	Set<Getal> complexFactor(Scanner in) throws VPException {
		Set<Getal> set = new Set<Getal>();
		
		character(in, '(');
		nextChar(in);
		
		set = expression(in);
		
		character(in, ')');
		nextChar(in);
		
		return set;
	}
	
	
	
	Set<Getal> expression(Scanner in) throws VPException {
		Set<Getal> set = new Set<Getal>();
		set = term(in);
		
		
		while (in.hasNext()) {
			readSpace(in);
			
			if (in.hasNext()) {
				if (nextCharIs(in, ')')) {
					return set;
				}
				
				char c = nextChar(in);
				
				switch (c) {
				
				case '+': set = set.union(term(in)); break;
				case '-': set = set.difference(term(in)); break;
				case '|': set = set.symDifference(term(in)); break;
				
				default: 
					character(in, c);
				}
			}
		}
		
		return set;
	}
	
	
	Set<Getal> term(Scanner in) throws VPException {
		Set<Getal> set = factor(in);
		readSpace(in);
		
		if (nextCharIs(in, '*')) {
			character(in, '*');
			nextChar(in);
			
			return set.intersection(term(in)); 
		}
	
		return set;	
	}

	
	Set<Getal> factor(Scanner in) throws VPException {
		readSpace(in);
		
		Set<Getal> tmp = new Set<Getal>();
		
		if (nextCharIsLetter(in)) {
			tmp = table.getValue(readIdentifier(in)).clone();
		}
		else if (nextCharIs(in, '{')) {
			tmp = readSet(in);
		}
		else if (nextCharIs(in, '(')) {
			tmp = complexFactor(in);
		}
		else {
			if (!in.hasNext()) {
				throw new VPException("Line ended unxpectedly.");
			} else {
				throw new VPException("Syntax error: " + in.nextLine());
			}
		}
		
		return tmp;
	}
	
	
	
	void printStatement(Scanner in) throws VPException {
		character(in, '?');
		nextChar(in);
		
		Set<Getal> set = expression(in);
		
		endOfLine(in);
		printSet(set);
	}
	
	
	void assignment(Scanner in) throws VPException {
		readSpace(in);
		Identifier id = readIdentifier(in);
		readSpace(in);
		
		if (!nextCharIs(in, '=')) {
			throw new VPException("Systax error. Use '=' to assign value.");
		}
		
		nextChar(in);
		
		Set<Getal> set = expression(in);
		
		readSpace(in);
		endOfLine(in);
		
		table.setValue(id, set);
	}

	
	
	void statement(Scanner in) throws VPException {
		in.useDelimiter("");
		readSpace(in);
		
		if (nextCharIs(in, '?')) {
			printStatement(in);
		} 
		else if (nextCharIsLetter(in)) {
			assignment(in);
		}
		else if (nextCharIs(in, '/')) {
			return;
		}
		else {
			throw new VPException("Line must begin with the operator '?', the operator '/' or name of a Set");
		}
		
	}
	
	
	void printSet(Set<Getal> set) throws VPException {
		while (set.size() > 0) {
			printGetal(set.getElement());
		}
		
		log.println();
	}
	
	
	void printGetal(Getal g) {
		log.print(" ");
		for (int i = 0; i < g.size(); i++) {
			log.print(g.get(i));
		}
		log.print(" ");
	}

	
	void start() {
		while(in.hasNextLine()) {
			
			try {
				String nextLine = in.nextLine();
				
				statement(new Scanner(nextLine));
			} 
			catch (VPException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}
	
	
	public static void main(String[] argv) {
		new Main().start();
	}

}
