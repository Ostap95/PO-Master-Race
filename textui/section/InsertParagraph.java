package edt.textui.section;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InputInteger;

import edt.core.*;
import pt.utl.ist.po.ui.InvalidOperation;

/**
 * Command for adding a paragraph to the current section.
 */
public class InsertParagraph extends Command<Section> {

    /**
     * Constructor.
     *
     * @param ent the target entity.
     */
    public InsertParagraph(Section sec) {
        super(MenuEntry.INSERT_PARAGRAPH, sec);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {

      Display display = new Display();
      Form f = new Form();
      InputInteger pReferenceId = new InputInteger(f, Message.requestParagraphId());
      InputString paragraphContent = new InputString(f, Message.requestParagraphContent());
      f.parse();
      Paragraph newParagraph = new Paragraph(paragraphContent.toString());
      //if(entity().paragraphExist(Integer.parseInt(pReferenceId.toString()))){
          entity().addParagraph(Integer.parseInt(pReferenceId.toString()), newParagraph);
    //  } else {
      //    entity().addParagraph(-1, newParagraph);
    //  }
    }
}
