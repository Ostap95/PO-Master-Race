package edt.core;

/**
* Class Documento represents general document, containing sections, subsections, authors and paragraphs.
*/
public class Document extends Section {
	
	/**
	* File name
	*/
	public String _filename;
	
	/**
	* Adds new author to the document
	*/
	public void addAuthor(String name, String email) {
		Author author = new Author(name, email);
	}
	
	/*
	public Author getAuthors() {
		
	}*/
	
	/*public TextElement getTextElement(String id) {
		
		
	}*/
	
	public void indexElement(String id, TextElement ele) {
		
	}
	
	/*public String getHeadLine() {
		
		
	}*/
	
	public void removeFromIndex(TextElement ele) {
		
	}
	
	public void loadDocument() {
		
	}
	
	public void saveDocument() {
		
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
