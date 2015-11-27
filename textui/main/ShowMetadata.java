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
    * @param ent the target entity.
    */
     public ShowMetadata(Editor editor) {
         super(MenuEntry.SHOW_METADATA, editor);
     }


    /**
    * Prints authors data
    * @param authors List
    * @return return string with authors data
    */

    /*
    public String printAuthors(List<Author> authors) {
        StringBuilder result = new StringBuilder();
        for (Author author : authors) {
            result.append(Message.author(author.getName(), author.getEmail()) + "\n");
        }
        return result.toString();
    }
    */

    /**
    * Execute the command.
    */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        Display display = new Display();
        SortedSet<Author> authors;
        authors = entity().getDocument().getAuthors();
        display.add(Message.documentTitle(entity().getDocument().getTitle()) + "\n"); // adds string
        for (Author author : authors) {
          display.add(Message.author(author.getName(), author.getEmail()) + "\n");
        }
        display.add(Message.documentSections(entity().getDocument().getSubsectionIndex()) + "\n");
        display.add(Message.documentBytes(entity().getDocument().getSize()) + "\n");
        display.add(Message.documentIdentifiers(entity().getDocument().getNumberUniqueIds()) + "\n");
        display.display();
    }
}
