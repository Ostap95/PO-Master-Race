package edt.textui.main;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;


import pt.utl.ist.po.ui.Menu;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;

import edt.core.Section;
import edt.core.Author;
import java.util.SortedSet;
import java.util.ArrayList;
import java.util.List;
import edt.textui.Editor;

import pt.utl.ist.po.ui.InvalidOperation;
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
    public String printAuthors(List<Author> authors) {
        StringBuilder result = new StringBuilder();
        for (Author author : authors) {
            result.append(Message.author(author.getName(), author.getEmail()) + "\n");
        }
        return result.toString();
    }

    /**
    * Execute the command.
    */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        Display display = new Display();
        ArrayList<Author> authors;
        authors = entity().getDocument().getAuthors();
        display.add(Message.documentTitle(entity().getDocument().getTitle()) + "\n"); // adds string
        display.add(printAuthors(authors));
        display.add(Message.documentSections(entity().getDocument().getSubsectionIndex()) + "\n");
        display.add(Message.documentBytes(entity().getDocument().getSize()) + "\n");
        display.add(Message.documentIdentifiers(entity().getDocument().getNumberUniqueIds()) + "\n");
        display.display();

    }
}
