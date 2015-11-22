package edt.textui.section;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;

import edt.core.*;

/**
 * Command for changing the title of the current section.
 */
public class ChangeTitle extends Command<Document> {

    /**
    * Constructor.
    * @param ent the target entity.
    */
    public ChangeTitle(Document ent) {
        super(MenuEntry.CHANGE_TITLE, ent);
    }

    /**
    * Execute the command.
    */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {

        Form f = new Form();

        InputString title = new InputString(f, "New title: ");
        f.parse();
        entity().setTitle(title.toString());
    }
}
