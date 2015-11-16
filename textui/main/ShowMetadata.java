package edt.textui.main;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;


import edt.core.*;

// importado
import pt.utl.ist.po.ui.Menu;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;

import pt.utl.ist.po.ui.InputString;
import edt.core.*;
import java.util.*;


/**
 * Command for showing the metadata of the current document in the editor.
 */
public class ShowMetadata extends Command<Document> {

    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public ShowMetadata(Document ent) {
        super(MenuEntry.SHOW_METADATA, ent);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        /* FIXME: implement command */
        Display display = new Display();            
        Form f = new Form();
        InputString name = new InputString(f, "Press Enter to continue"); // changed to "Press enter to continue"
        display.add(entity().getTitle()); // adds string
        //display.add(entity().)
        display.add(entity().getSubsectionIndex());
        display.add(entity().getNumberUniqueIds());
        //display.display();
        f.parse();
    }
}
