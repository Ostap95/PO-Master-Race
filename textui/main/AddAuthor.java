package edt.textui.main;

import pt.utl.ist.po.ui.Menu;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import edt.core.*;
/* FIXME: import core classes here */

/**
 * Command for adding an author to the current document in the editor.
 */
public class AddAuthor extends Command<Document> {/* FIXE */

    /**
     * Constructor.
     *
     * @param ent the target entity.
     */
    public AddAuthor(Document ent) { /* FIXE */
        super(MenuEntry.ADD_AUTHOR, ent);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        /* FIXME: implement command */
        Form f = new Form();
        InputString name = new InputString(f, "Name: ");
        InputString email = new InputString(f, "Email: ");
        f.parse();
        Author author = new Author(name.toString(), email.toString());
        entity().addAuthor(author);
    }
}
