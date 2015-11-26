package edt.textui.section;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputInteger;
import pt.utl.ist.po.ui.InputString;

import edt.core.*;
import pt.utl.ist.po.ui.InvalidOperation;
import java.util.*;

/**
 * Command for indexing a paragraph (nomear um parágrafo 2.2.9) of the current section.
 */
public class IndexParagraph extends Command<Section> {

    /** Holds the Document that we are using */
    private Document _doc;

    /**
     * Constructor.
     *
     * @param ent the target entity.
     */
    public IndexParagraph(Document doc, Section sec) {
        super(MenuEntry.NAME_PARAGRAPH, sec);
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
      InputInteger paragraphId = new InputInteger(f, Message.requestParagraphId());
      InputString uniqueId = new InputString(f, Message.requestUniqueId());
      f.parse();
      try {
          Paragraph desiredParagraph = entity().getParagraph(paragraphId.value());
          Map<String, TextElement> elementMap = _doc.getElementMap();
          if(elementMap.containsKey(uniqueId.toString())) {
            desiredParagraph.setKey(uniqueId.toString());
            display.add(Message.paragraphNameChanged());
          } else {
            _doc.indexElement(uniqueId.toString(), desiredParagraph);
          }
      } catch (InvalidOperation e) {
          display.add(Message.noSuchParagraph(paragraphId.value()));
          display.display();
      }
    }
}
