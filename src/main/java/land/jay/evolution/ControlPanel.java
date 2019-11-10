package land.jay.evolution;

import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

/** Pane with control buttons and information for the player. */
public class ControlPanel extends GridPane {
    
    /** Pane for current message to player. */
    private DialogPane messagePane = new DialogPane();
    
    public ControlPanel(double width, double height) {
        this.setPrefHeight(height);
        Button release = new Button("Release");
        release.addEventFilter(MouseEvent.MOUSE_CLICKED, (e) -> Evolution.release());
        Button breed = new Button("Breed");
        breed.addEventFilter(MouseEvent.MOUSE_CLICKED, (e) -> Evolution.breed());
        this.add(release, 0, 0);
        this.add(this.messagePane, 1, 0);
        this.add(breed, 2, 0);
    }
    
    /** Updates the current message to player. */
    public void message(String message) {
        this.messagePane.setContentText(message);
    }
}
