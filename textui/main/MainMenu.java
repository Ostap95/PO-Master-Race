package edt.textui.main;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Menu;

import edt.textui.Editor;
/* FIXME: import core classes here */

/**
 * Represents the main menu of this application. This is the first menu
 * shown to the users.
 ***/

public class MainMenu extends Menu {

    public MainMenu(Editor editor) {
        super(MenuEntry.TITLE,
              new Command<?>[] { new NewDocument(editor),
                      new OpenDocument(editor),
                      new SaveDocument(editor),
                      new ShowMetadata(editor),
                      new AddAuthor(editor),
                      new ListTopSections(editor),
                      new ShowTextElement(editor),
                      new EditSection(editor),
                      });
    }
}
