package edt.textui.main;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Menu;

/* FIXME: import core classes here */

/**
 * Represents the main menu of this application. This is the first menu
 * shown to the users.
 ***/

public class MainMenu extends Menu {

    public MainMenu(/* FIXME: decls of argument(s) for receiver(s) */) {
        super(MenuEntry.TITLE,
              new Command<?>[] { new NewDocument(/* FIXME: receiver(s) */),
                      new OpenDocument(/* FIXME: receiver(s) */),
                      new SaveDocument(/* FIXME: receiver(s) */),
                      new ShowMetadata(/* FIXME: receiver(s) */),
                      new AddAuthor(/* FIXME: receiver(s) */),
                      new ListTopSections(/* FIXME: receiver(s) */),
                      new ShowTextElement(/* FIXME: receiver(s) */),
                      new EditSection(/* FIXME: receiver(s) */),
                      });
    }
}
