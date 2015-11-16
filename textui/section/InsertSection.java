package edt.textui.section;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputInteger;
import pt.utl.ist.po.ui.InputString;

import edt.core.*;
/* FIXME: import core classes here */

/**
 * Command for adding a subsection to current section.
 */
public class InsertSection extends Command<Document> {

    /**
     * Constructor.
     *
     * @param ent the target entity.
     */
    public InsertSection(Document ent) {
        super(MenuEntry.INSERT_SECTION, ent);
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
