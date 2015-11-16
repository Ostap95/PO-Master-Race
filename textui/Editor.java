package edt.textui;


import edt.textui.main.MainMenu;
import edt.core.Document;
import pt.utl.ist.po.ui.Menu;
import static pt.utl.ist.po.ui.UserInteraction.IO;
import edt.core.Command;
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

    public void loadDocument(String filename) {
        Command cmd = new Command();
        _currentDoc = cmd.loadDocument(filename);
    }


    public static void main(String[] args) {
        /* FIXME: Add code */
		Document newdoc = new Document();
    Editor editor = new Editor(newdoc);
		MainMenu menu = new MainMenu(editor);
		menu.open();
		IO.close();
    }
}
