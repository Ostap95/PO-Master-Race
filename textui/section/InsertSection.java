package edt.textui.section;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.InputInteger;
import pt.utl.ist.po.ui.InputString;

import edt.core.Section;

/**
 * Command for adding a subsection to current section.
 */
public class InsertSection extends Command<Section> {

    /**
    * Constructor.
    * @param ent the target entity.
    */
    public InsertSection(Section sec) {
        super(MenuEntry.INSERT_SECTION, sec);
    }

    /**
    * Execute the command.
    */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
      Display display = new Display();
      Form f = new Form();
      InputInteger sReferenceId = new InputInteger(f, Message.requestSectionId());
      InputString sectionTitle = new InputString(f, Message.requestSectionTitle());
      f.parse();
      Section newSection = new Section(sectionTitle.value());
      entity().addSection(sReferenceId.value(), newSection);
    }
}
