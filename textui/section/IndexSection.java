package edt.textui.section;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InputInteger;

import edt.core.*;
import java.util.HashMap;
import pt.utl.ist.po.ui.InvalidOperation;
/**
 * Command for indexing ia subsection (nomear secção 2.2.6) the current section .
 */
public class IndexSection extends Command<Document> {

    /**
    * Constructor.
    * @param ent the target entity.
    */
    public IndexSection(Document ent) {
        super(MenuEntry.NAME_SECTION, ent);
    }

    /**
    * Execute the command.
    */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
    Display display = new Display();
    Form f = new Form();
    InputInteger sectionId = new InputInteger(f, Message.requestSectionId());
    InputString uniqueId = new InputString(f, Message.requestUniqueId());
    f.parse();

    try {
        Section desiredSection = entity().getSection(Integer.parseInt(sectionId.toString()));
        HashMap<String, TextElement> elementMap = entity().getElementMap();
        if(elementMap.containsKey(uniqueId.toString())) {
          desiredSection.setKey(uniqueId.toString());
          display.add(Message.sectionNameChanged());
        } else {
          entity().indexElement(uniqueId.toString(), desiredSection);
        }

    } catch (InvalidOperation e) {
        display.add(Message.noSuchSection(Integer.parseInt(sectionId.toString())));
        display.display();
    }
    }
}
