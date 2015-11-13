package edt.textui.main;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Menu;

import edt.core.*;
/* FIXME: import core classes here */

/**
 * Represents the main menu of this application. This is the first menu
 * shown to the users.
 ***/

public class MainMenu extends Menu {

    public MainMenu(Document doc) {
        super(MenuEntry.TITLE,
              new Command<?>[] { new NewDocument(doc),
                      new OpenDocument(doc),
                      new SaveDocument(doc),
                      new ShowMetadata(doc),
                      new AddAuthor(doc),
                      new ListTopSections(doc),
                      new ShowTextElement(doc),
                      new EditSection(doc),
                      });
    }
}
