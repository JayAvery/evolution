package land.jay.evolution;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

public class Creature {
    
    private static final double bodyWidth = 120;
    private static final double headWidth = 40;
    
    private final double bodyHeight;
    private final double neckLength;
    private final double headRaise;
    private final double tailLength;
    private final double tailRaise;
    
    public Creature() {
        
        this.bodyHeight = Maths.random(40, 80);
        this.neckLength = Maths.random(30, 120);
        this.headRaise = Maths.random(-30, 90);
        this.tailLength = Maths.random(30, 160);
        this.tailRaise = Maths.random(-30, 30);
    }
    
    public void draw(Group node) {
        
        double nodeWidth = node.getParent().prefWidth(-1);
        double nodeHeight = node.getParent().prefHeight(-1);
        
        double bodyX = (nodeWidth - bodyWidth) / 2;
        double bodyY = (nodeHeight - bodyWidth) / 2;
        Rectangle body = new Rectangle(bodyX, bodyY, bodyWidth, this.bodyHeight);
        
        double legWidth = 15 * (this.bodyHeight / 40);
        double legHeight = bodyWidth - this.bodyHeight;
        double frontlegX = bodyX;
        double backlegX = bodyX + bodyWidth - legWidth;
        double legY = bodyY + this.bodyHeight;
        Rectangle frontleg = new Rectangle(frontlegX, legY, legWidth, legHeight);
        Rectangle backleg = new Rectangle(backlegX, legY, legWidth, legHeight);
        
        double headHeight = this.bodyHeight / 3;
        double headX = bodyX - this.neckLength - headWidth;
        double headY = bodyY - this.headRaise;
        Polygon neck = new Polygon(
                bodyX, bodyY,
                bodyX, bodyY + this.bodyHeight,
                headX + headWidth, headY + headHeight,
                headX + headWidth, headY
        );
        Rectangle head = new Rectangle(headX, headY, headWidth, headHeight);
        
        Polygon tail = new Polygon(
                bodyX + bodyWidth, bodyY,
                bodyX + bodyWidth, bodyY + this.bodyHeight,
                bodyX + bodyWidth + this.tailLength, bodyY + this.bodyHeight - this.tailRaise
        );
        
        body.setFill(Color.AQUA);
        frontleg.setFill(Color.AQUA);
        backleg.setFill(Color.AQUA);
        neck.setFill(Color.AQUA);
        head.setFill(Color.AQUA);
        tail.setFill(Color.AQUA);
        
        node.getChildren().addAll(body, frontleg, backleg, neck, head, tail);
    }
}
