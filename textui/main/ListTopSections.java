package edt.textui.main;

import java.util.SortedSet;

import pt.utl.ist.po.ui.Menu;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;

import pt.utl.ist.po.ui.InputString;
import edt.core.*;
import java.util.*;
/* FIXME: import core classes here */

/**
 * Command for showing the top sections of the current document in the editor.
 */
public class ListTopSections extends Command<Document> {

    /**
     * Constructor.
     *
     * @param ent the target entity.
     */
    public ListTopSections(Document ent) {
        super(MenuEntry.SHOW_INDEX, ent);
    }


    public String searchTopSections(ArrayList<Section> sec) {
        StringBuilder result = new StringBuilder();
        result.append(sec.getHeadLine());
	      for(Section section : sec){
          result.append(searchTopSections(section));
        }
        return result.toString();
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        /* FIXME: implement command */
        ArrayList<Section> sections = entity().getSubsections();
        Display display = new Display();
        display.add(searchTopSections(sections));
        display.display();
        Form f = new Form();
        InputString name = new InputString(f, "Press any key to continue");
        f.parse();



    }
}
