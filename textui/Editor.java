package edt.textui;


import edt.textui.main.MainMenu;
import edt.core.Document;
import pt.utl.ist.po.ui.Menu;
import static pt.utl.ist.po.ui.UserInteraction.IO;
import edt.core.Command;
import edt.parser.Parser;
import java.io.*;
import pt.utl.ist.po.ui.InvalidOperation;
/**
 * The main class of the edt application
 **/
public class Editor {

    /**
    * Current Document
    */
    private Document _currentDoc = new Document();

    /**
    * Editor constructor
    * @param doc : Document
    */
    public Editor(Document doc) {
      _currentDoc = doc;
    }

    /**
    * Return current document in use
    * @return return document
    */
    public Document getDocument() {
      return _currentDoc;
    }

    /**
    * Change current document
    * @param doc : Document
    */
    public void setDocument(Document doc) {
      _currentDoc = doc;
    }

    /**
    * Save current document
    */
    public void saveDocument() {
      Command cmd = new Command();
      cmd.saveDocument(_currentDoc);
    }

    /**
    * Load new document
    * @param filename : name of the document
    * @return return boolean value
    */
    public void loadDocument(String filename) throws InvalidOperation {
      Command cmd = new Command();
      try {
        _currentDoc= cmd.loadDocument(filename);
        //return true;
      } catch (ClassNotFoundException e) {
        e.getMessage();
        //return false;
        throw new InvalidOperation();
      } catch (IOException e) {
        e.getMessage();
        //return false;
        throw new InvalidOperation();
      }
    }

    public static void main(String[] args) {
        String fileName = System.getProperty("import");
        Document newdoc;
        if(fileName == null) {
            newdoc = new Document();
        }else{
          try {
            Parser parser = new Parser();
            newdoc = parser.parse(fileName);
          } catch (IOException e) {
            e.getMessage();
            newdoc = new Document();
          }
        }

        Editor editor = new Editor(newdoc);
		    MainMenu menu = new MainMenu(editor);
		    menu.open();
		    IO.close();
    }
}
