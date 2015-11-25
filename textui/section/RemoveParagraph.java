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
public class RemoveParagraph extends Command<Document> {

    /**
     * Constructor.
     *
     * @param ent the target entity.
     */
    public RemoveParagraph(Document ent) {
        super(MenuEntry.REMOVE_PARAGRAPH, ent);
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
      entity().removeParagraph(idx.value(), entity());
      //caso remova com sucesso n apresenta mensagem
      }catch(InvalidOperation e) {
        display.add(Message.noSuchParagraph(idx.value()));
      }
      display.display();
    }
}
