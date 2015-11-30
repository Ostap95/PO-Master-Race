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
        Display display = new Display();
        try {
          for (Section sec : entity().getSubsections()) {
            display.add(sec.getHeadLine());
            display.display();
            display = new Display();
            list = new ListSections(sec);
            list.execute();
          }

        } catch (InvalidOperation e) {
          e.getMessage();
        }
    }
}
