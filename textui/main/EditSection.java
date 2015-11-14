package edt.textui.main;

import pt.utl.ist.po.ui.Menu;
import pt.utl.ist.po.ui.Command;

import edt.textui.section.EditMenu;

import edt.core.*;

/* FIXME: import core classes here */

/**
 * Command for editing the current document in the editor.
 */
public class EditSection extends Command<Document> {

    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public EditSection(Document doc) {
        super(MenuEntry.OPEN_DOCUMENT_EDITOR, doc);
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

