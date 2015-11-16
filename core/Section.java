package edt.core;

import java.util.ArrayList;
import java.io.*;
import pt.utl.ist.po.ui.InvalidOperation;

/**
* Class Section that represents a section of a document
*/
public class Section extends TextElement {
	
	/** Serial number for serialization */
	
	/* Section title */
	private String _title = "";
	// initialized for easier ListTopSections
	
	/** ArrayList of paragraphs of the section */
	private ArrayList<Paragraph> _paragraphs = new ArrayList<Paragraph>();
	
	/**  ArrayList of subsections of the section */
	private ArrayList<Section> _subsections = new ArrayList<Section>();
	
	/**
	* Section class constructor
	* @param id - unique key of the new section, title - title of the section
	*/
	
	/*public Section(String id, String title) {
		_title = title;
		setKey(id);
	}*/
	
	/**
	* Return HeadLine title
	* @return headline title
	*/
	public String getHeadLine() {
		// identificador ou titulo podem nao estar definidos
		return "[" + getKey() + "]" + "{" + _title + "}\n";
	}
	
	/**
	* Sets new title for the section 
	* @param title - title of the section
	*/
	public void setTitle(String title) {
		_title = title;
	}
	
	/**
	* Return section title
	* @return return section title
	*/
	public String getTitle() {
		return _title;
	}


	/**
	* to be used in metadata menu
	*@return number of Unique Ids in file
	*/
	public int getNumberUniqueIds() {

		int numberIds = 0; 
		for(Section section: _subsections ) {
				if(section.isIndexed())
					numberIds++;
		}
		for (Paragraph paragraph: _paragraphs) {
			if (paragraph.isIndexed())
				numberIds++;
		}
		return numberIds;
	}

	
	/**
	* Returns the size of the section (include all subsections)
	* @return returns the size of the section
	*/
	public int getSize() {
		int totalsize = _title.length(); 
		 
		 if (_paragraphs != null) {
			for (Paragraph y : _paragraphs) {    
				totalsize += y.getSize();
			}
		}

		if (_subsections != null) {	
			for (Section x : _subsections) {
				totalsize += x.getSize();
			}
		}

		return totalsize; 
	}
	
	/**
	* Return content of the section
	* @return returns content of the section 
	*/
	public String getContent() {
		StringBuilder result = new StringBuilder();
		result.append(this.getHeadLine());
		
		if (_paragraphs != null) {
			for (Paragraph par: _paragraphs) {
				result.append("[" + par.getKey() + "]" + par.getContent());
			}
		}
		
		if (_subsections != null) {
			for (Section sec : _subsections) {
				result.append(sec.getContent());
			}
		}
		
		return result.toString();
	}
	
	/**
	* Return list of all subsections of the current section
	* @return list of subsections
	*/

	public ArrayList<Section> getSubsections() throws InvalidOperation {
		/* USE EXCEPTION TO THROW ERROR IF SUBSECTIONS IS EMPTY */
		if (_subsections.isEmpty()){
			throw new InvalidOperation("No Subsections");
		} else {
			return _subsections;
		}
	}
	
	/**
	* Returns SubSection based on given index
	* @return return desired subsection of the section
	*/
	public Section getSection(int idx) throws InvalidOperation {
		/* USE EXCPETION TO THROW ERROR IF SUBSECTIONS IS EMPTY */
		try{	
			 if (_subsections.isEmpty()) {
				throw new InvalidOperation("No SubSection");
			} else { 
				return _subsections.get(idx);
			}
		} catch (IndexOutOfBoundsException e) {
			System.err.println("IndexOutOfBoundsException: " + e.getMessage());
			return null;
		} 
	}
	
	/**
	* Return number of elements in subsection array list
	* @return return number of subsections 
	*/ 

	// o que este metodo deve fazer?
	public String getSubsectionIndex() {
 		int size = _subsections.size();
		return Integer.toString(size);
	}
	
	/*
	//this method gets number of subsections
	public String getSubsectionIndex() {
 		int size = _subsections.size();
		return Integer.toString(size);
	}
	*/



	/**
	* Adds new subsections to the section
	*/
	public void addSection(int idx, Section sec) {
		try{
			_subsections.add(idx,sec);
		} catch (IndexOutOfBoundsException e) {
			System.err.println("IndexOutOfBoundsException: " + e.getMessage());
		} 
	}
	
	/**
	* Remove Subsection based on index
	* @return return boolean value based on the success of the remove
	*/
	public boolean removeSection(int idx, Document doc) {
		try{
			Section s = _subsections.get(idx);
		
			if (s.getKey() != null) {
				doc.removeFromIndex(s);
			}
			_subsections.remove(idx);
			return true;	

		} catch (NullPointerException e) {
			System.err.println("NullPointerException: " + e.getMessage());
			return false;
		}
	}
	
	/**
	* Add paragraph to the section
	*/
	public void addParagraph(int idx, Paragraph par) {
		try{
			_paragraphs.add(idx, par);
		} catch (IndexOutOfBoundsException e) {
			System.err.println("IndexOutOfBoundsException: " + e.getMessage());
		}
	}
	
	/**
	* Remove paragraph of the ssection
	* @return return boolean value based on the success of the remove
	*/
	public boolean removeParagraph(int idx, Document doc) throws InvalidOperation {
		/* USE EXCPETION TO THROW ERROR IF PARAGRAPHLIST IS EMPTY */
		try{
			
			if (_paragraphs.isEmpty()) {
				throw new InvalidOperation("No paragraph");
			} else {
				Paragraph p = _paragraphs.get(idx);
			
				if (p.getKey() != null) {
					doc.removeFromIndex(p);
				}
				_paragraphs.remove(idx);
				return true;
			}
		
		} catch (NullPointerException e) {
			System.err.println("NullPointerException: " + e.getMessage());
			return false;
		}
	}
	
	public Paragraph getParagraph(int idx) throws InvalidOperation {
		/* USE EXCPETION TO THROW ERROR IF PARAGRAPHLIST IS EMPTY */
		
		try{
			if (_paragraphs.isEmpty()) {
				throw new InvalidOperation("No paragraph");
			} else {
				return _paragraphs.get(idx);
			}
		} catch (IndexOutOfBoundsException e) {
			System.err.println("IndexOutOfBoundsException: " + e.getMessage());
			return null; 
		}
	}

	/**
     * procura seccoes de topo (com relacao direta 'a seccao atual)
     *
     * @param section (being used in doc)
     * @return string to be used in display
     */
    public String searchTopSections() {
        StringBuilder result = new StringBuilder();
        result.append(this.getTitle()).append("\n");
        try {
            for(Section section : this.getSubsections()){
                if(section.isIndexed())
                    // verifica se seccao esta indexada
                    result.append(this.getHeadLine()).append("\n");
                else{
                    result.append("[] ").append(this.getTitle()).append("\n");
                }
            }
        }catch(InvalidOperation e){
            System.err.println("InvalidOperation: " + e.getMessage());
            return ""; // return string
        }
        result.append("() {}");
        return result.toString();
    }	

	/*public static void main(String[] arg){
		
		Section sec = new Section();
		sec.setTitle("Test Title");
		Paragraph par = new Paragraph("Random Stuff");
		par.setKey("123");
		sec.addParagraph(0,par);
		Section sec2 = new Section();
		sec2.setTitle("SubSection Title");
		Paragraph par2 = new Paragraph("Subsection paragraph");
		sec2.addParagraph(0,par2);
		sec.addSection(0,sec2);
		
		System.out.println(sec.getContent());
		System.out.println(sec.getSize());
		
	}*/
}