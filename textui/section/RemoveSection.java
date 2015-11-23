package edt.textui.section;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputInteger;

import edt.core.*;
/* FIXME: import core classes here */

/**
 * Command for removing a subsection of the current section.
 */
public class RemoveSection extends Command<Document> {

    /**
     * Constructor.
     *
     * @param ent the target entity.
     */
    public RemoveSection(Document ent) {
        super(MenuEntry.REMOVE_SECTION, ent);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        Display display = new Display();
        Form f = new Form();
        InputInteger idx = new InputInteger(f, Message.requestSectionId());
        f.parse();
        entity().removeSection(idx.value(), entity());
        display.display();
    }
}
