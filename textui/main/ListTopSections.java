package edt.textui.main;

import java.util.SortedSet;

import pt.utl.ist.po.ui.Menu;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;

import pt.utl.ist.po.ui.InputString;
import edt.core.*;
import java.util.*;
import pt.utl.ist.po.ui.InvalidOperation;
import edt.textui.Editor;

/**
 * Command for showing the top sections of the current document in the editor.
 */
public class ListTopSections extends Command<Editor> {

    /**
    * Constructor.
    *
    * @param ent the target entity.
    */
    public ListTopSections(Editor editor) {
        super(MenuEntry.SHOW_INDEX, editor);
    }

    /**
    * Search top section in document
    * @param sec: section to be Used
    * @return return formatted string with top section information
    */
    public String searchTopSections(Section sec) {
        StringBuilder result = new StringBuilder();
        result.append( sec.getHeadLine());
        try {
            for(Section section : sec.getSubsections()) {
                  result.append(section.getHeadLine());
            }
        } catch(InvalidOperation e) {
            return result.toString();
        }
        return result.toString();
    }

    /**
    * Execute the command.
    */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {

        Display display = new Display();
        Form f = new Form();
        display.add(searchTopSections(entity().getDocument()));
        display.display();
        f.parse();

    }
}
