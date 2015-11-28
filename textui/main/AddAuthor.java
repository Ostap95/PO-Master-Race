package edt.textui.main;

import pt.utl.ist.po.ui.Menu;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;

import edt.textui.Editor;
import java.util.*;
import edt.core.Document;
import edt.core.Author;

/**
 * Command for adding an author to the current document in the editor.
 */
public class AddAuthor extends Command<Editor> {

    /**
    * Constructor.
    * @param ent the target entity.
    */
    public AddAuthor(Editor editor) {
        super(MenuEntry.ADD_AUTHOR, editor);
    }

    /**
    * Execute the command.
    */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {

        Form f = new Form();
        InputString name = new InputString(f, Message.requestAuthorName());
        InputString email = new InputString(f, Message.requestEmail());
        f.parse();
        Author author = new Author(name.value(), email.value());
        SortedSet<Author> aut = entity().getDocument().getAuthors();
        if(aut.contains(author)) {
          Display display = new Display();
          display.add(Message.duplicateAuthor(name.value()));
          display.display();
        } else {
          entity().getDocument().addAuthor(author);
        }
    }
}
