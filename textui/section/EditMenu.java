package edt.textui.section;

import pt.utl.ist.po.ui.Menu;
import pt.utl.ist.po.ui.Command;

import edt.textui.section.*;

import edt.core.*;
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
    public EditMenu(Document doc) {
        super(MenuEntry.TITLE,
              new Command<?>[] { new ChangeTitle(doc),
                      new ListSections(doc),
                      new ShowSection(doc),
                      new SelectSection(doc),
                      new InsertSection(doc),
                      new IndexSection(doc),
                      new RemoveSection(doc),
                      new InsertParagraph(doc),
                      new IndexParagraph(doc),
                      new ChangeParagraph(doc),
                      new RemoveParagraph(doc),
                      });
    }
}
