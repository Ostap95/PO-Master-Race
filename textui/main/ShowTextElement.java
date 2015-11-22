package edt.textui.main;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;

import edt.core.*;
import edt.textui.Editor;

/**
 * Command for showing the text element with a given identifier of the current document in the editor.
 */
public class ShowTextElement extends Command<Editor> {

    /**
    * Constructor.
    * @param ent the target entity.
    */
    public ShowTextElement(Editor editor) {
        super(MenuEntry.SHOW_TEXT_ELEMENT, editor);
    }

    /**
    * Execute the command.
    */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        /* FIXME: implement command */
    }
}
