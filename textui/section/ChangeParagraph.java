package edt.textui.section;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputInteger;
import pt.utl.ist.po.ui.InputString;

import edt.core.*;
import pt.utl.ist.po.ui.InvalidOperation;

/**
 * Command for changing the content of a paragraph of the current section.
 */
public class ChangeParagraph extends Command<Section> {

    /**
     * Constructor.
     *
     * @param ent the target entity.
     */
    public ChangeParagraph(Section sec) {
        super(MenuEntry.EDIT_PARAGRAPH, sec);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
      Display display = new Display();
      Form f = new Form();
      InputInteger parId = new InputInteger(f, Message.requestParagraphId());
      InputString content = new InputString(f, Message.requestParagraphContent());
      f.parse();
      try {
        Paragraph par = entity().getParagraph(parId.value());
        par.setText(content.value());
      } catch (InvalidOperation e) {
        display.add(Message.noSuchParagraph(parId.value()));
      }
   }
}
