package edt.textui.main;

import pt.utl.ist.po.ui.Menu;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputInteger;


import edt.textui.main.MainMenu;
import edt.core.Document;
import static pt.utl.ist.po.ui.UserInteraction.IO;

import edt.core.*;
import edt.textui.Editor;
/* FIXME: import core classes here */

/**
 * Command for creating a new document in the editor.
 */
public class NewDocument extends Command<Editor> {

    /**
     * Constructor.
     *
     * @param ent the target entity.
     */
    public NewDocument(Editor editor) {
        super(MenuEntry.NEW, editor);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        /* FIXME: implement command */
        Document newdoc = new Document();
    		entity().setDocument(newdoc);
    }
}
