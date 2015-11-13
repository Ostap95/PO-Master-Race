package edt.textui.section;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputInteger;

import edt.core.*;
/* FIXME: import core classes here */

/**
 * Command for removing a paragraph of the current section.
 */
public class RemoveParagraph extends Command<Document> {

    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public RemoveParagraph(Document ent) {
        super(MenuEntry.REMOVE_PARAGRAPH, ent);
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
