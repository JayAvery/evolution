package land.jay.evolution;

import java.util.Iterator;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

public class CreaturePane extends Pane {
    
    private static final double PAD = 20;
    
    private Creature creature = new Creature();
    private Group parts = new Group();
    private double width;
    private double height;
    public boolean selected = false;
    public boolean empty = false;
    
    public CreaturePane(double width, double height) {
        
        this.width = width;
        this.height = height;
        this.getChildren().add(this.parts);
        this.setPrefHeight(height);
        this.setPrefWidth(width);
        this.setStyle("-fx-border-color: black;\n -fx-border-width: 1");
        this.addEventFilter(MouseEvent.MOUSE_CLICKED, (e) -> this.toggleSelect());
    }
    
    public void drawCreature() {
        
        double scale = Math.min((this.width / (Creature.MAX_WIDTH + PAD)), (this.height / (Creature.MAX_HEIGHT + PAD)));
        
        double bodyX = (this.width - this.creature.getBodyWidth(scale)) / 2;
        double bodyY = (this.height - this.creature.getBodyWidth(this.height / 230)) + 10;
        Rectangle body = new Rectangle(bodyX, bodyY, this.creature.getBodyWidth(scale), this.creature.getBodyHeight(scale));
        
        double legWidth = 15 * (this.creature.getBodyHeight(scale) / 40);
        double legHeight = this.creature.getBodyWidth(scale) - this.creature.getBodyHeight(scale);
        double frontlegX = bodyX;
        double backlegX = bodyX + this.creature.getBodyWidth(scale) - legWidth;
        double legY = bodyY + this.creature.getBodyHeight(scale);
        Rectangle frontleg = new Rectangle(frontlegX, legY, legWidth, legHeight);
        Rectangle backleg = new Rectangle(backlegX, legY, legWidth, legHeight);
        
        double headHeight = this.creature.getBodyHeight(scale) / 3;
        double headX = bodyX - this.creature.getNeckLength(scale) - this.creature.getHeadWidth(scale);
        double headY = bodyY - this.creature.getHeadRaise(scale);
        Polygon neck = new Polygon(
                bodyX, bodyY,
                bodyX, bodyY + this.creature.getBodyHeight(scale),
                headX + this.creature.getHeadWidth(scale), headY + headHeight,
                headX + this.creature.getHeadWidth(scale), headY
        );
        Rectangle head = new Rectangle(headX, headY, this.creature.getHeadWidth(scale), headHeight);
        
        Polygon tail = new Polygon(
                bodyX + this.creature.getBodyWidth(scale), bodyY,
                bodyX + this.creature.getBodyWidth(scale), bodyY + this.creature.getBodyHeight(scale),
                bodyX + this.creature.getBodyWidth(scale) + this.creature.getTailLength(scale), bodyY + this.creature.getBodyHeight(scale) - this.creature.getTailRaise(scale)
        );
        
        body.setFill(Color.AQUA);
        frontleg.setFill(Color.AQUA);
        backleg.setFill(Color.AQUA);
        neck.setFill(Color.AQUA);
        head.setFill(Color.AQUA);
        tail.setFill(Color.AQUA);
        
        this.parts.getChildren().addAll(body, frontleg, backleg, neck, head, tail);
    }
    
    public void release() {
        this.creature = null;
        this.parts.getChildren().clear();
        this.empty = true;
    }
    
    public void breed(CreaturePane first, CreaturePane second) {
        this.creature = new Creature(first.creature, second.creature);
        this.drawCreature();
        this.setStyle("-fx-border-color: lime;\n -fx-border-width: 10");
        this.empty = false;
    }
    
    public void toggleSelect() {
        if (this.selected || this.empty) {
            this.setStyle("-fx-border-color: black;\n -fx-border-width: 1");
            this.selected = false;
        } else {
            this.setStyle("-fx-border-color: blue;\n -fx-border-width: 10");
            this.selected = true;
        }
    }
    
    public void unSelect() {
        this.setStyle("-fx-border-color: black;\n -fx-border-width: 1");
        this.selected = false;
    }
}
