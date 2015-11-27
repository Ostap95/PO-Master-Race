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
    * Execute the command.
    */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {

        try {
          Display display = new Display();
          display.add(((Section)entity().getDocument()).getHeadLine());
          for(Section section : entity().getDocument().getSubsections()) {
            display.add(section.getHeadLine());
          }
        display.display();
        } catch (InvalidOperation e) {
            System.out.println("error in top secs");
            e.getMessage();
        }
    }
}
