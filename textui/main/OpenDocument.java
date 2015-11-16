package edt.textui.main;

import java.io.IOException;

import pt.utl.ist.po.ui.Menu;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InvalidOperation;

import java.io.*;
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
        Display display = new Display();
        Form f = new Form();
        InputString filename = new InputString(f, Message.openFile());
        f.parse();
        if(!(entity().loadDocument(filename.toString()))) {
        
          display.add(Message.fileNotFound());
          display.display();
        }
    }
}
