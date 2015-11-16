package edt.core;

import java.io.*;

/**
* Class Paragraph represents a paragraph of a section
*/
public class Paragraph extends TextElement {

	/** Text information of the paragraph */
	private String _text;

	/** Paragraph constructor
	* @param text: text for the paragraph
	*/
	public Paragraph(String text) {
		_text = text;
	}

	/**
	* Set new text for paragraph
	* @param text: new text for the paragraph
	*/
	public void setText(String text) {
		_text = text;
	}

	/*
	* Return content of the paragraph
	* @return return string content of the paragraph
	*/
	public String getContent(){
		return "{" +_text+ "}\n";
	}

	/*
	* Return paragraph size
	* @return return paragraph size
	*/
	public int getSize() {
		int length = _text.length();
		return length;
	}
}
