package edt.textui.section;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import edt.core.*;
/* FIXME: import core classes here */

/**
 * Command for showing the content of current section.
 */
public class ShowSection extends Command<Section> {

    /**
     * Constructor.
     *
     * @param ent the target entity.
     */
    public ShowSection(Section sec) {
        super(MenuEntry.SHOW_CONTENT, sec);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {

        Display display = new Display();
        display.add(entity().getContent());
        display.display();

     }
}
