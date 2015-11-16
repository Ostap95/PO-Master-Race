package edt.textui.main;

import java.io.IOException;

import pt.utl.ist.po.ui.Menu;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InvalidOperation;

import edt.core.*;
import edt.textui.Editor;
/* FIXME: import core classes here */

/**
 * Command for opening an existing document in the editor.
 */
public class OpenDocument extends Command<Editor> {

    /**
     * Constructor.
     *
     * @param ent the target entity.
     */
    public OpenDocument(Editor editor) {
        super(MenuEntry.OPEN, editor);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() throws InvalidOperation {
        /* FIXME: implement command */
    }
}
