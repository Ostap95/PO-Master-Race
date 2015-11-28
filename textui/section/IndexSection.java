package edt.textui.section;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InputInteger;

import edt.core.Document;
import edt.core.Section;
import edt.core.TextElement;
import java.util.HashMap;
import pt.utl.ist.po.ui.InvalidOperation;
/**
 * Command for indexing ia subsection (nomear secção 2.2.6) the current section .
 */
public class IndexSection extends Command<Section> {

    /** Holds the Document that we are using */
    private Document _doc;

    /**
    * Constructor.
    * @param ent the target entity.
    */
    public IndexSection(Document doc, Section ent) {
         super(MenuEntry.NAME_SECTION, ent);
         _doc = doc;
     }

    /**
    * Execute the command.
    */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
    /*Display display = new Display();
    Form f = new Form();
    InputInteger sectionId = new InputInteger(f, Message.requestSectionId());
    InputString uniqueId = new InputString(f, Message.requestUniqueId());
    f.parse();
    try {
        Section desiredSection = entity().getSection(sectionId.value());
        HashMap<String, TextElement> elementMap = _doc.getElementMap();
        if(elementMap.containsKey(uniqueId.toString())) {
          desiredSection.setKey(uniqueId.toString());
          display.add(Message.sectionNameChanged());
        } else {
          _doc.indexElement(uniqueId.toString(), desiredSection);
        }
    } catch (InvalidOperation e) {
        display.add(Message.noSuchSection(sectionId.value()));
        display.display();
    }
  }*/
    Display display = new Display();
    Form f = new Form();
    InputInteger sectionId = new InputInteger(f, Message.requestSectionId());
    InputString uniqueId = new InputString(f, Message.requestUniqueId());
    f.parse();
    try {
      Section desiredSection = entity().getSection(sectionId.value());
      TextElement keyTextEl = _doc.getTextElement(uniqueId.value());

      if(desiredSection.isIndexed() )
          display.add(Message.sectionNameChanged());

      if(keyTextEl != null) {
        _doc.removeFromIndex(keyTextEl);
        _doc.indexElement(uniqueId.value(), desiredSection);

      } else {
        _doc.indexElement(uniqueId.toString(), desiredSection);
      }

    } catch (InvalidOperation e) {
        display.add(Message.noSuchSection(sectionId.value()));

    }finally {
        display.display();
    }
  }

}
