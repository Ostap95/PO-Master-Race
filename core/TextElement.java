package edt.core;

import java.util.*;
import java.io.*;

/**
* Abstract class TextElement represents a generic text element with unique identification
*/
public abstract class TextElement implements Serializable {

	/** Text element identification */
	private String _key = "";

	/**
	* Return text element key
	* @return return text element key
	*/
	public String getKey() {
		return _key;
	}

	/**
	* Set text element key
	*/
	public void setKey(String key) {
		_key = key;
	}

	/**
	* See if text element has identification
	* @return return boolean value based on if text element has unique key
	*/
	protected boolean isIndexed(){
		return _key !=  null;
	}

	/**
	* Abstract method that subclasses need to implement
	* @return return content of desired text element
	*/
	public abstract String getContent();

	/**
	* Abstract method that subclasses need to implement
	* @return return size of desired text element
	*/
	public abstract int getSize();

}
