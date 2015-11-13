package edt.textui.section;

import pt.utl.ist.po.ui.Menu;
import pt.utl.ist.po.ui.Command;

import edt.textui.section.*;

/* FIXME: import core classes here */

/**
 * Represents the edit menu of this application. This menu
 * shows the option to edit the selected section.
 ***/

public class EditMenu extends Menu {
    /**
     * Builds an EditMenu object. It has all available options for editing
     * a section.
     *
     * @param doc
     * @param section
     **/
    public EditMenu(/* FIXME: decls of argument(s) for receiver(s) */) {
        super(MenuEntry.TITLE,
              new Command<?>[] { new ChangeTitle(/* FIXME: receiver(s) */),
                      new ListSections(/* FIXME: receiver(s) */),
                      new ShowSection(/* FIXME: receiver(s) */),
                      new SelectSection(/* FIXME: receiver(s) */),
                      new InsertSection(/* FIXME: receiver(s) */),
                      new IndexSection(/* FIXME: receiver(s) */),
                      new RemoveSection(/* FIXME: receiver(s) */),
                      new InsertParagraph(/* FIXME: receiver(s) */),
                      new IndexParagraph(/* FIXME: receiver(s) */),
                      new ChangeParagraph(/* FIXME: receiver(s) */),
                      new RemoveParagraph(/* FIXME: receiver(s) */),
                      });
    }
}
