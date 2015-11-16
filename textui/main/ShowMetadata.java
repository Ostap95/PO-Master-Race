package edt.textui.main;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;


import edt.core.*;

// importado
import java.util.SortedSet;
import pt.utl.ist.po.ui.Menu;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import edt.core.*;
import java.util.*;
import edt.textui.Editor;

/**
 * Command for showing the metadata of the current document in the editor.
 */
public class ShowMetadata extends Command<Editor> {

    /**
     * Constructor.
     *
     * @param ent the target entity.
     */


    public String printAuthors(List<Author> authors) {
        StringBuilder result = new StringBuilder();
        for (Author author : authors) {
            result.append("Autor: ").append(author.getName()).append("/").append(author.getEmail()).append("\n");
        }
        return result.toString();
    }


    public ShowMetadata(Editor editor) {
        super(MenuEntry.SHOW_METADATA, editor);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        Display display = new Display();
        Form f = new Form();
        ArrayList<Author> authors;
        authors = entity().getDocument().getAuthors();
        Collections.sort(authors);
        display.add("Título: " + entity().getDocument().getTitle() + "\n"); // adds string
        display.add(printAuthors(authors));
        display.add("Dimensão do documento (bytes): " + entity().getDocument().getSize() + "\n");
        display.add("Identificadores únicos: " + entity().getDocument().getNumberUniqueIds() + "\n");
        display.display();
        InputString name = new InputString(f, "Press Enter to continue"); // changed to "Press enter to continue"
        f.parse();
    }
}
