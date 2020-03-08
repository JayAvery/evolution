package land.jay.evolution;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.layout.GridPane;

/** Grid holding all creatures. */
public class CreatureGrid extends GridPane {

  //  private final OldCreaturePane[][] panes;
    private final CreaturePane[][] panes;
    
    public CreatureGrid(int rows, int columns, double width, double height) {
    //    this.panes = new OldCreaturePane[rows][columns];
        this.panes = new CreaturePane[rows][columns];
        double cellWidth = width / rows;
        double cellHeight = height / columns;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
             //   OldCreaturePane pane = new OldCreaturePane(cellWidth, cellHeight);
                CreaturePane pane = new CreaturePane(cellWidth, cellHeight);
                this.panes[row][col] = pane;
                this.add(pane, col, row);
                pane.drawCreature();
            }
        }
    }
    
    /** @return Array of all currently selected panes. */
    public CreaturePane[] getSelected() {
     /*   List<OldCreaturePane> selected = new ArrayList<OldCreaturePane>();
        for (OldCreaturePane[] row : this.panes) {
            for (OldCreaturePane pane : row) {
                if (pane.selected) {
                    selected.add(pane);
                }
            }
        }
        return selected.toArray(new OldCreaturePane[selected.size()]);
   */ return null;
    }
    
    /** @return Array of all currently empty panes. */
    public CreaturePane[] getEmpty() {
     /*   List<OldCreaturePane> empty = new ArrayList<OldCreaturePane>();
        for (OldCreaturePane[] row : this.panes) {
            for (OldCreaturePane pane : row) {
                if (pane.empty) {
                    empty.add(pane);
                }
            }
        }
        return empty.toArray(new OldCreaturePane[empty.size()]);
  */ return null;
    }
    
    /** Deselects all panes. */
    public void clearSelection() {
     //   for (OldCreaturePane[] row : this.panes) {
     //       for (OldCreaturePane pane : row) {
     //           pane.deselect();
     //       }
     //   }
    }
}
