package edt.core;

import java.util.ArrayList;

/**
* Class Document represents general document, containing sections, subsections, authors and paragraphs.
*/
public class Document extends Section {
	
	private static int listAuthorCounter = 0;
	
	/**
	* File name
	*/
	public String _filename;
	
	/**
	* List of authors
	*/
	private ArrayList<Author> _authors = new ArrayList<Author>();
	
	/**
	* Adds new author to the document
	* @param name: authors name, email: authors email
	*/
	public void addAuthor(String name, String email) {
		Author author = new Author(name, email);
		int idx = 0; 

		for (Author aut: _authors) {
			idx ++;
			
			if (aut.compareTo(author) < 0) {
				_authors.add((idx--),author);
				break;
			}

			if (idx == _authors.size()) {
				_authors.add(author);
			}
		}
	}
	
	/**
	* Return list of the document authors
	* @return ArrayList of authors
	*/
	public ArrayList<Author> getAuthors() {
		return _authors;
	}
	
	
	/*public TextElement getTextElement(String id) {
		
		
	}*/
	
	public void indexElement(String id, TextElement ele) {
		
	}
	
	public String getHeadLine() {
		return "{" + _filename + "}\n";
		
	}
	
	public void removeFromIndex(TextElement ele) {
		
	}
	
	
	/**
	* Returns document name
	* @return return file name
	*/
	public String getFilename() {
		return _filename;
	}
	
	/**
	* Set new name for the document
	*/
	public void setFilename(String filename) {
		_filename = filename;
	}
}
