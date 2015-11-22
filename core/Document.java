package edt.core;

import java.util.*;

/**
* Class Document represents general document, containing sections, subsections, authors and paragraphs.
*/
public class Document extends Section {

	/** File name*/
	public String _filename = "";

	/** List of authors */
	private ArrayList<Author> _authorList = new ArrayList<Author>();

	/** List of TextElements **/
	private HashMap<String, TextElement> _elementList = new HashMap<String, TextElement>();

	/**
	* Document Constructor
	*/
	public Document() {
		super("");
	}

	/** Document Constructor
	* @param filename: Files name
	*/
	public Document(String filename) {
		super("");
		_filename = filename;
	}

	/**
	* Adds new author to the document
	* @param name: authors name, email: authors email
	*/
	public void addAuthor(Author author) {
		int idx = 0;

		if (!_authorList.isEmpty()) {
				for (Author aut: _authorList) {
					if (aut.compareTo(author) > 0) {
						_authorList.add(idx, author);
						break;
					}
					idx ++;
				}

				if (idx == _authorList.size()) {
					_authorList.add(author);
				}

		} else {
			_authorList.add(author);
		}
	}

	/**
	* Return list of the document authors
	* @return ArrayList of authors
	*/
	public ArrayList<Author> getAuthors() {
		return _authorList;
	}

	/**
	* Return textelement by id
	* @return return text element
	*/
	public TextElement getTextElement(String id) {
		return _elementList.get(id);
	}

	/**
	* Add element to hasmap of text elements
	* @param id: text element id. ele: textelement
	*/
	public void indexElement(String id, TextElement ele) {
		 //ele.setKey(id);
		_elementList.put(id, ele);
	}

	/**
	* Return formmated title
	* @return return formmated title
	*/
	public String getHeadLine() {
		return "{" + getTitle() + "}\n";
	}

	/**
	* Remove TextElement from hash map
	* @param ele: text element to be removed
	*/
	public void removeFromIndex(TextElement ele) {
		String key = ele.getKey();
		_elementList.remove(key);
		ele.setKey("");
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

	/**
	* Used to get the number of uniq Ids
	*@return number of Unique Ids in file
	*/
	public int getNumberUniqueIds() {
		return _elementList.size();
	}

	/*
	* Return Element Map
	*/
	public HashMap<String, TextElement> getElementMap() {
		return _elementList;
	}
}
