package edt.textui.main;

import pt.utl.ist.po.ui.Menu;
import pt.utl.ist.po.ui.Command;

import edt.textui.section.EditMenu;

import edt.core.*;
import edt.textui.Editor;

/* FIXME: import core classes here */

/**
 * Command for editing the current document in the editor.
 */
public class EditSection extends Command<Editor> {

    /**
     * Constructor.
     *
     * @param ent the target entity.
     */
    public EditSection(Editor editor) {
        super(MenuEntry.OPEN_DOCUMENT_EDITOR, editor);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        /* FIXME: implement command */
        EditMenu edit = new EditMenu(entity().getDocument());
        edit.entry(1).invisible();
        edit.open();
    }
}
