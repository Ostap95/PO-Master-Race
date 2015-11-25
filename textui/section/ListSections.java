package edt.textui.section;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;

import edt.core.Section;
import edt.core.Document;
import edt.core.Paragraph;
import pt.utl.ist.po.ui.InvalidOperation;
import java.util.ArrayList;
/* FIXME: import core classes here */

/**
 * Command for listing all subsections of the current section.
 */
public class ListSections extends Command<Section> {

    /**
     * Constructor.
     *
     * @param ent the target entity.
     */
<<<<<<< HEAD

    public ListSections(Document ent) {
        super(MenuEntry.LIST_SECTIONS, ent);
=======
    public ListSections(Section sec) {
        super(MenuEntry.LIST_SECTIONS, sec);
>>>>>>> e47e0fc1ab30af17ed9dced9631eaf33baa56dc8
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
<<<<<<< HEAD
      Display display = new Display();
      display.add(entity().searchAllSections());
      display.display();
=======
        try {
          ArrayList<Section> subsections = entity().getSubsections();
          for(Section sect : subsections) {
            Display display = new Display();
            display.add(sect.getHeadLine());
            display.display();
          }
        } catch (InvalidOperation e) {
          e.getMessage();
        }
>>>>>>> e47e0fc1ab30af17ed9dced9631eaf33baa56dc8
    }
}
