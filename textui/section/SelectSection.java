package edt.textui.section;

import pt.utl.ist.po.ui.Menu;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputInteger;

import edt.textui.main.EditSection;

import edt.core.*;
/* FIXME: import core classes here */

/**
 * Command for selecting a subsection of the current section and edit it.
 */
public class SelectSection extends Command<Document> {

    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public SelectSection(Document ent) {
        super(MenuEntry.SELECT_SECTION, ent);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        /* FIXME: implement command */
    }
}
