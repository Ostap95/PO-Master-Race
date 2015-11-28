package edt.textui.main;

import java.util.SortedSet;

import pt.utl.ist.po.ui.Menu;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;

import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InvalidOperation;

import java.util.*;
import edt.textui.Editor;
import edt.core.Section;

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
          display.display();
          for(Section section : entity().getDocument().getSubsections()) {
            display = new Display();
            display.add(section.getHeadLine());
            display.display();
          }
        } catch (InvalidOperation e) {
            e.getMessage();
        }
    }
}
