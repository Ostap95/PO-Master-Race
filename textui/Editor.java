package edt.textui;


import edt.textui.main.MainMenu;
import edt.core.Document;
import pt.utl.ist.po.ui.Menu;
import static pt.utl.ist.po.ui.UserInteraction.IO;
/**
 * Themain class of the edt application.
 **/
public class Editor {

    public static void main(String[] args) {
        /* FIXME: Add code */
		Document doc = new Document();
		MainMenu menu = new MainMenu(doc);
		menu.open();
		IO.close();
    }
}
