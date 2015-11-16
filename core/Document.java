package edt.core;

import java.util.*;

/**
* Class Document represents general document, containing sections, subsections, authors and paragraphs.
*/
public class Document extends Section {
	/** File name*/
	public String _filename;
	
	/** List of authors */
	private ArrayList<Author> _authorList = new ArrayList<Author>();
	
	/** List of TextElements **/
	private HashMap<String, TextElement> _elementlist = new HashMap<String, TextElement>();


	/**
	* Adds new author to the document
	* @param name: authors name, email: authors email
	*/
	public void addAuthor(String name, String email) {
		Author author = new Author(name, email);
		int idx = 0; 

		for (Author aut: _authorList) {
			idx ++;
			
			if (aut.compareTo(author) < 0) {
				_authorList.add((idx--),author);
				break;
			}

			if (idx == _authorList.size()) {
				_authorList.add(author);
			}
		}
	}
	/**
	* Return list of the document authors
	* @return ArrayList of authors
	*/	



	/**
	* Return list of the document authors
	* @return ArrayList of authors
	*/
	public ArrayList<Author> getAuthors() {
		return _authorList;
	}	
	
	public TextElement getTextElement(String id) {  
		return _elementlist.get(id);
	}
	
	public void indexElement(String id, TextElement ele) {
		ele.setKey(id); 
		_elementlist.put(id, ele);
	}
	
	public String getHeadLine() {
		return "{" + getTitle() + "}\n";	
	}
	
	public void removeFromIndex(TextElement ele) {
		String key = ele.getKey();
		_elementlist.remove(key);
		ele.setKey(null);
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
