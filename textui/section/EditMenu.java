package edt.textui.section;

import pt.utl.ist.po.ui.Menu;
import pt.utl.ist.po.ui.Command;

import edt.textui.section.*;

import edt.core.*;

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
    public EditMenu(Document doc, Section sec) {
        super(MenuEntry.TITLE,
              new Command<?>[] { new ChangeTitle(sec),
                      new ListSections(sec),
                      new ShowSection(sec),
                      new SelectSection(doc, sec),
                      new InsertSection(sec),
                      new IndexSection(doc, sec),
                      new RemoveSection(doc, sec),
                      new InsertParagraph(doc),
                      new IndexParagraph(doc, sec),
                      new ChangeParagraph(sec),
                      new RemoveParagraph(doc, sec),
                      });
    }
}
