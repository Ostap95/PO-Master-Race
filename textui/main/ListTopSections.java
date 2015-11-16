package edt.textui.main;

import java.util.SortedSet;

import pt.utl.ist.po.ui.Menu;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;

import pt.utl.ist.po.ui.InputString;
import edt.core.*;
import java.util.*;
import pt.utl.ist.po.ui.InvalidOperation;

/**
 * Command for showing the top sections of the current document in the editor.
 */
public class ListTopSections extends Command<Document> {

    /**
     * Constructor.
     *
     * @param ent the target entity.
     */
    public ListTopSections(Document ent) {
        super(MenuEntry.SHOW_INDEX, ent);
    }
    /*
    public String searchTopSections(ArrayList<Section> sec) {
        StringBuilder result = new StringBuilder();
        result.append(sec.getTitle());
	      for(Section section : sec){
              result.append(searchTopSections(section).toString());
        }
        return result.toString();
    }*/
    // alterado para


    
    // search TopSections em Section.java (existe metodo protected)
    /**
     * procura seccoes de topo (com relacao direta 'a seccao atual)
     *
     * @param section (being used in doc)
     * @return string to be used in display
     */
    /*
    public String searchTopSections(Section sec) {
        StringBuilder result = new StringBuilder();
        result.append(sec.getTitle()).append("\n");
        try {
            for(Section section : sec.getSubsections()){
                if(section.isIndexed())
                    // verifica se seccao esta indexada
                    result.append(sec.getHeadLine()).append("\n");
                else{
                    result.append("[] ").append(sec.getTitle()).append("\n");
                }
            }
        }catch(InvalidOperation e){
            System.err.println("InvalidOperation: " + e.getMessage());
            return ""; // ret
        }
        result.append("() {}");
        return result.toString();
    }
    */


    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        // entity is Document
        Display display = new Display();
        Form f = new Form();
        InputString name = new InputString(f, "Press Enter to continue");
        display.add(entity().searchTopSections());
        display.display();
        f.parse();

    }
}
