package edt.textui.section;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputInteger;

/* FIXME: import core classes here */

/**
 * Command for removing a subsection of the current section.
 */
public class RemoveSection extends Command</* FIXME: core class */> {

    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public RemoveSection(/* FIXME: decls of argument(s) for receiver(s) */) {
        super(MenuEntry.REMOVE_SECTION, ent);
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
