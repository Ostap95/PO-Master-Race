package edt.textui.section;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;

import edt.core.Section;

/**
 * Command for changing the title of the current section.
 */
public class ChangeTitle extends Command<Section> {

    /**
    * Constructor.
    * @param ent the target entity.
    */
    public ChangeTitle(Section sec) {
        super(MenuEntry.CHANGE_TITLE, sec);
    }

    /**
    * Execute the command.
    */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {

        Form f = new Form();
        InputString title = new InputString(f, Message.requestSectionTitle());
        f.parse();
        entity().setTitle(title.value());
    }
}
