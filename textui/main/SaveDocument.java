package edt.textui.main;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InvalidOperation;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.InputString;
import java.io.IOException;

import edt.core.*;
import edt.textui.Editor;
/* FIXME: import core classes here */

/**
 * Command for saving the current document in the editor.
 */
public class SaveDocument extends Command<Editor> {

    /**
     * Constructor.
     *
     * @param ent the target entity.
     */
    public SaveDocument(Editor editor) {
        super(MenuEntry.SAVE, editor);
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
        if(entity().getDocument().getFilename() == ""){
          InputString filename = new InputString(f, Message.newSaveAs());
          f.parse();
          entity().getDocument().setFilename(filename.toString());
        }
        entity().saveDocument();
        display.display();

    }
}
