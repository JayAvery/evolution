package land.jay.evolution;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.layout.GridPane;

/** Grid holding all creatures. */
public class CreatureGrid extends GridPane {

    private final CreaturePane[][] panes;
    
    public CreatureGrid(int rows, int columns, double width, double height) {
        this.panes = new CreaturePane[rows][columns];
        double cellWidth = width / rows;
        double cellHeight = height / columns;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                CreaturePane pane = new CreaturePane(cellWidth, cellHeight);
                this.panes[row][col] = pane;
                this.add(pane, col, row);
                pane.drawCreature();
            }
        }
    }
    
    /** @return Array of all currently selected panes. */
    public CreaturePane[] getSelected() {
        List<CreaturePane> selected = new ArrayList<CreaturePane>();
        for (CreaturePane[] row : this.panes) {
            for (CreaturePane pane : row) {
                if (pane.selected) {
                    selected.add(pane);
                }
            }
        }
        return selected.toArray(new CreaturePane[selected.size()]);
    }
    
    /** @return Array of all currently empty panes. */
    public CreaturePane[] getEmpty() {
        List<CreaturePane> empty = new ArrayList<CreaturePane>();
        for (CreaturePane[] row : this.panes) {
            for (CreaturePane pane : row) {
                if (pane.empty) {
                    empty.add(pane);
                }
            }
        }
        return empty.toArray(new CreaturePane[empty.size()]);
    }
    
    /** Deselects all panes. */
    public void clearSelection() {
        for (CreaturePane[] row : this.panes) {
            for (CreaturePane pane : row) {
                pane.deselect();
            }
        }
    }
}
