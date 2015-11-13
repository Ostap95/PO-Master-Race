package edt.document.core;

import java.io.*;
import java.util.*;

/**
* Class Author represent author/authors of a document
*/
public class Author implements Comparable<Author>{
	
	/**
	* Name of the author
	*/
	private String _name;
	
	/**
	* E-mail of the author
	*/
	private String _email;
	
	/**
	* Author constructor
	*/
	public Author(String name, String email) {
		_name = name;
		_email = email;
	}
	
	/**
	* Return authors E-mail
	* @return return e-mail of the author
	*/
	public String getEmail() {
		return _email;
	}
	
	/**
	* Return authors name
	* @return return authors name
	*/
	public String getName() {
		return _name;
	}
	
	/**
	* See if two objects are equal
	* @return return true if two author are equal
	*/
	public boolean equals(Object obj) {
		return obj instanceof Author && _name.equals(((Author)obj).getName()) && _email.equals(((Author)obj).getEmail());
	}
	
	/**
	* Overriding the compareTo method from Comparator interface
	* See if two authors are the same
	* @return return 1 if the authors are the same and 0 if not
	*/
	public int compareTo(Author author) {
		return (this._name).compareTo(author.getName());
	}
}