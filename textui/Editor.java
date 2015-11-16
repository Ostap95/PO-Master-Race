package edt.textui;


import edt.textui.main.MainMenu;
import edt.core.Document;
import pt.utl.ist.po.ui.Menu;
import static pt.utl.ist.po.ui.UserInteraction.IO;
import edt.core.Command;
import edt.parser.Parser;
import java.io.*;
/**
 * Themain class of the edt application.
 **/
public class Editor {

    private Document _currentDoc = new Document();

    public Editor(Document doc) {
      _currentDoc = doc;
    }

    public Document getDocument() {
      return _currentDoc;
    }

    public void setDocument(Document doc) {
      _currentDoc = doc;
    }

    public void saveDocument() {
      Command cmd = new Command();
      cmd.saveDocument(_currentDoc);
    }

    public boolean loadDocument(String filename) {
        Command cmd = new Command();

        try {
        _currentDoc= cmd.loadDocument(filename);
        return true;
        
      } catch (ClassNotFoundException e) {
        e.getMessage();
        return false;
      }catch (IOException e) {
        e.getMessage();
        return false;
      }

    }


    public static void main(String[] args) {
        /* FIXME: Add code */
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
