package edt.textui.section;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputInteger;

import edt.core.*;
import java.util.*;
import pt.utl.ist.po.ui.InvalidOperation;

/**
 * Command for removing a subsection of the current section.
 */
public class RemoveSection extends Command<Section> {

    /** Holds the Document that we are using */
    private Document _doc;

    /**
     * Constructor.
     *
     * @param ent the target entity.
     */
    public RemoveSection(Document doc, Section sec) {
        super(MenuEntry.REMOVE_SECTION, sec);
        _doc = doc;
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
      Form f = new Form();
      InputInteger idx = new InputInteger(f, Message.requestSectionId());
      f.parse();
      try {
      entity().removeSection(idx.value(), _doc);
    } catch (IndexOutOfBoundsException e) {
      e.getMessage();
    }
      /*try {
        List<Section> sec = entity().getSubsections();
        sec.remove(idx.value());
      } catch (InvalidOperation  e) {
        e.getMessage();
      }*/
    }
}
