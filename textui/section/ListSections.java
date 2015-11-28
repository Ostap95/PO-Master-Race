package edt.textui.section;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.InvalidOperation;

import edt.core.Section;
import edt.core.Document;
import edt.core.Paragraph;
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
        /*try {
          ArrayList<Section> subsections = entity().getSubsections();
          for(Section sect : subsections) {
            Display display = new Display();
            display.add(sect.getHeadLine());
            display.display();
          }
        } catch (InvalidOperation e) {
          e.getMessage();
        }
    }*/
    try {
      List<Section> subsections = entity().getSubsections();
      ListSections list;
      Display display = new Display();
      display.add(entity().getHeadLine());
      display.display();
      for(Section sect : subsections) {
        if(sect != null) {
          list = new ListSections(sect);
          list.execute();
        }
      }
    } catch (InvalidOperation e) {
      e.getMessage();
    }
  }
}
