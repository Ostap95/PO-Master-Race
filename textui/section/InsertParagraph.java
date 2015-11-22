package edt.textui.section;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InputInteger;

import edt.core.*;
/* FIXME: import core classes here */

/**
 * Command for adding a paragraph to the current section.
 */
public class InsertParagraph extends Command<Document> {

    /**
     * Constructor.
     *
     * @param ent the target entity.
     */
    public InsertParagraph(Document ent) {
        super(MenuEntry.INSERT_PARAGRAPH, ent);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {

      Display display = new Display();
      Form f = new Form();
      InputInteger filename = new InputInteger(f, Message.requestParagraphId());
      InputString filename2 = new InputString(f, Message.requestParagraphContent());
      f.parse();

    }
}
