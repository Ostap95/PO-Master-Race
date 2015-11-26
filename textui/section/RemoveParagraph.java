package edt.textui.section;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputInteger;

import edt.core.*;
import pt.utl.ist.po.ui.InvalidOperation;
/**
 * Command for removing a paragraph of the current section.
 */
public class RemoveParagraph extends Command<Section> {

    /** Holds the Document that we are using */
    private Document _doc;

    /**
     * Constructor.
     *
     * @param ent the target entity.
     */
    public RemoveParagraph(Document doc, Section sec) {
        super(MenuEntry.REMOVE_PARAGRAPH, sec);
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
      InputInteger idx = new InputInteger(f, Message.requestParagraphId());
      f.parse();
      try {
      entity().removeParagraph(idx.value(), _doc);
      //caso remova com sucesso n apresenta mensagem
      }catch(InvalidOperation e) {
        display.add(Message.noSuchParagraph(idx.value()));
      }
      display.display();
    }
}
