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


/**
 * Command for showing the metadata of the current document in the editor.
 */
public class ShowMetadata extends Command<Document> {

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


    public ShowMetadata(Document ent) {
        super(MenuEntry.SHOW_METADATA, ent);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        Display display = new Display();            
        Form f = new Form();
        InputString name = new InputString(f, "Press Enter to continue"); // changed to "Press enter to continue"
        ArrayList<Author> authors;
        authors = entity().getAuthors();
        Collections.sort(authors);
        display.add("Título: " + entity().getTitle() + "\n"); // adds string
        display.add(printAuthors(authors) + "\n");
        display.add("Dimensão do documento (bytes): " + entity().getSubsectionIndex() + "\n");
        display.add("Identificadores únicos: " + entity().getNumberUniqueIds() + "\n");
        display.display();
        f.parse();
    }
}
