package edt.textui.section;

import pt.utl.ist.po.ui.Menu;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputInteger;
import pt.utl.ist.po.ui.InvalidOperation;

import edt.core.Document;
import edt.core.Section;
import edt.textui.main.EditSection;

/**
 * Command for selecting a subsection of the current section and edit it.
 */
public class SelectSection extends Command<Section> {

    /** Holds the Document that we are using */
    private Document _doc;

    /**
     * Constructor.
     *
     * @param ent the target entity.
     */
    public SelectSection(Document doc, Section sec) {
        super(MenuEntry.SELECT_SECTION, sec);
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
      InputInteger id = new InputInteger(f, Message.requestSectionId());
      f.parse();

      try {
        EditMenu edit = new EditMenu(_doc, entity().getSection(id.value()));
        display.add(Message.newActiveSection(id.value()));
        display.display();
        edit.open();

      } catch (InvalidOperation e) {
        display.add(Message.noSuchSection(id.value()));
        display.display();
      }
    }
}
