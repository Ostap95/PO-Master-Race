package edt.textui.section;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputInteger;

import pt.utl.ist.po.ui.InvalidOperation;
import edt.core.Section;
import edt.core.Paragraph;
import edt.core.Document;


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
        Form f = new Form();
        InputInteger parId = new InputInteger(f, Message.requestParagraphId());
        f.parse();
        try {
          entity().removeParagraph(parId.value(), _doc);
        } catch (InvalidOperation e) {
          Display display = new Display();
          display.add(Message.noSuchParagraph(parId.value()));
          display.display();
        }
    }
}
