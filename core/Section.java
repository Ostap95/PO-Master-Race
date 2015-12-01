package edt.core;

import java.util.*;
import java.io.*;
import pt.utl.ist.po.ui.InvalidOperation;
import edt.textui.section.*;

/**
* Class Section that represents a section of a document
*/
public class Section extends TextElement implements Visitable {

	/* Section title */
	private String _title = "";

	/** ArrayList of paragraphs of the section */
	private List<Paragraph> _paragraphs = new ArrayList<Paragraph>();

	/**  ArrayList of subsections of the section */
	private List<Section> _subsections = new ArrayList<Section>();

	/**
	* Section class constructor
	* @param id - unique key of the new section, title - title of the section
	*/
	public Section(String title) {
		_title = title;
	}

	/**
	* Return HeadLine title
	* @return headline title
	*/

	public String getHeadLine() {
		return "[" + getKey() + "]" + " {" + _title + "}\n";
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

	public String accept(Visitor v) {
		return v.visit(this);
	}

	/**
	* Return list of all subsections of the current section
	* @return list of subsections
	*/
	public List<Section> getSubsections() throws InvalidOperation {
		if (_subsections.isEmpty()) {
			throw new InvalidOperation("no subsections");
		} else {
			return _subsections;
		}
	}

	/**
	* Returns SubSection based on given index
	* @param idx: index in section list
	* @return return desired subsection of the section
	*/
	public Section getSection(int idx) throws InvalidOperation {
		try{
			 if (_subsections.isEmpty()) {
				throw new InvalidOperation();
			} else {
				return _subsections.get(idx);
			}
		} catch (IndexOutOfBoundsException e) {
			throw new InvalidOperation();
		}
	}

	/**
	* Return number of elements in subsection array list
	* @return return number of subsections
	*/
	public int getSubsectionIndex() {
 		int size = _subsections.size();
		return size;
	}

	/**
	* Adds new subsections to the section
	* @param idx: position in the list. sec: section to be added to the list
	*/

	public void addSection(int idx, Section sec) {
		try{
			if (idx == -1) {
				_subsections.add(sec);
			} else {
				_subsections.add(idx,sec);
			}
		} catch (IndexOutOfBoundsException e) {
			_subsections.add(sec);
		}
	}

	/**
	* Remove Subsection based on index
	* @param idx: position in the list. doc: current document
	* @return return boolean value based on the success of the remove
	*/

	public boolean removeSection(int idx, Document doc) throws InvalidOperation {

	   int n = 0;
	   Section sec = _subsections.get(idx);

	   try {

	    if (sec.isIndexed()) {
	     doc.removeFromIndex(sec);
	    }
	     for (Paragraph p : sec._paragraphs) {
	     if (p.isIndexed()) {
	       doc.removeFromIndex(p);
	     }
	      }

	     while (n <= sec.getSubsections().size()) {
	     if (!sec.removeSection(n,doc)) {
	      n++;
	     }
	      }

	     return _subsections.remove(sec);
	   } catch (InvalidOperation e) {
	     return _subsections.remove(sec);
	   } catch (IndexOutOfBoundsException e) {
	     throw new InvalidOperation();
	   }
	 }

	 public String getAllSubsections() {
		 StringBuilder result = new StringBuilder();
			 for (Section section : _subsections) {
				 result.append(section.getHeadLine());
				 result.append(section.getAllSubsections());
			 }
			 return result.toString();
	 }



	/**
	* Add paragraph to the section
	*
	* @param idx: position int the list. par: paragraph to be added
	*/
	public void addParagraph(int idx, Paragraph par) {
		try {
			if (idx == -1) {
				_paragraphs.add(par);
			} else {
				_paragraphs.add(idx, par);
			}
		} catch (IndexOutOfBoundsException e) {
				_paragraphs.add(par);
		}
	}

	/**
	* Remove paragraph of the ssection
	* @param idx: position in the list. doc: current document
	* @return return boolean value based on the success of the remove
	*/
	public boolean removeParagraph(int idx,Document doc) throws InvalidOperation {
		try {
			if (_paragraphs.isEmpty()) {
				throw new InvalidOperation();
			} else {
				Paragraph p = _paragraphs.get(idx);
				if (p.isIndexed()) {
					doc.removeFromIndex(p);
				}
				_paragraphs.remove(idx);
				return true;
			}

		} catch (IndexOutOfBoundsException e) {
			throw new InvalidOperation();
		}
	}

	/**
	* Return desired paragraph from the list
	* @param idx: position in the list
	* @return return desired paragraph
	*/
	public Paragraph getParagraph(int idx) throws InvalidOperation {
		try {
			if (_paragraphs.isEmpty()) {
				throw new InvalidOperation();
			} else {
				return _paragraphs.get(idx);
			}
		} catch (IndexOutOfBoundsException e) {
				throw new InvalidOperation();

		}
	}
}
