package edt.textui.section;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputInteger;

import pt.utl.ist.po.ui.InvalidOperation;
import edt.core.*;

/**
 * Command for removing a subsection of the current section.
 */
public class RemoveSection extends Command<Section> {

    /** Holds the Document that we are using */
    private Document _doc;

    /**
     * Constructor.
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
        Display display = new Display();
        Form f = new Form();
        try{
          InputInteger idx = new InputInteger(f, Message.requestSectionId());
          f.parse();
          entity().getSection(idx.value()).removeSection(idx.value(), _doc);
          display.display();
        }catch(InvalidOperation e) {
          e.getMessage();
        }
    }
}
