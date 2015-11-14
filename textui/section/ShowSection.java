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
public class ShowSection extends Command<Document> {

    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public ShowSection(Document ent) {
        super(MenuEntry.SHOW_CONTENT, ent);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        /* FIXME: implement command */
        
        Display display = new Display();
        display.add(entity().getContent());
        display.display();
        Form f = new Form();
        InputString name = new InputString(f, "Press any key to continue");
        f.parse();
        
     }
}
