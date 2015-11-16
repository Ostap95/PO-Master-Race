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
import edt.textui.Editor;
/**
 * Command for showing the top sections of the current document in the editor.
 */
public class ListTopSections extends Command<Editor> {

    /**
     * Constructor.
     *
     * @param ent the target entity.
     */
    public ListTopSections(Editor editor) {
        super(MenuEntry.SHOW_INDEX, editor);
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

    public String searchTopSections(Section sec) {
        StringBuilder result = new StringBuilder();
        result.append( sec.getHeadLine());
        try {
            for(Section section : sec.getSubsections()){
                  result.append(section.getHeadLine());
            }
        }catch(InvalidOperation e){

            return result.toString(); // ret
        }
        return result.toString();
    }



    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        // entity is Document
        Display display = new Display();
        Form f = new Form();
        display.add(searchTopSections(entity().getDocument()));
        display.display();
        //InputString name = new InputString(f, "Press Enter to continue");
        f.parse();

    }
}
