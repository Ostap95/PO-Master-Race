package edt.textui.section;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;


import edt.core.Section;
import edt.core.Document;
import edt.core.Paragraph;
import pt.utl.ist.po.ui.InvalidOperation;
import java.util.*;

/**
 * Command for listing all subsections of the current section.
 */
public class ListSections extends Command<Section> {

    /**
     * Constructor.
     *
     * @param ent the target entity.
     */
    public ListSections(Section sec) {
        super(MenuEntry.LIST_SECTIONS, sec);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        ListSections list;
        try {
          Display display = new Display();
          display.add(entity().getHeadLine());
          display.display();
          for (Section sec : entity().getSubsections()) {
            list = new ListSections(sec);
            list.execute();
          }

        } catch (InvalidOperation e) {
          e.getMessage();
        }
    }
}
