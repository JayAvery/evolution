package land.jay.evolution;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

public class Creature {
    
    public static final double MAX_HEIGHT = 230;
    public static final double MAX_WIDTH = 460;
    private static final double bodyWidth = 120;
    private static final double headWidth = 40;
    
    private final double baseLength;
    private final double bodyHeight;
    private final double neckExt;
    private final double tailExt;
    private final double headRaise;
    private final double tailRaise;
    
    private final double neckLength;
    private final double tailLength;

    // max width = 440
    // max height = 210
    public Creature() {
        
        this.baseLength = Gene.BASE_LENGTH.random();
        this.bodyHeight = Gene.BODY_HEIGHT.random();
        this.neckExt = Gene.NECK_EXT.random();
        this.tailExt = Gene.TAIL_EXT.random();
        this.tailRaise = Gene.TAIL_RAISE.random();
        this.headRaise = Gene.NECK_RAISE.random();
        
        this.neckLength = this.baseLength + this.neckExt;
        this.tailLength = this.baseLength + this.tailExt;
    }
    
    public Creature(Creature first, Creature second) {
        
        this.baseLength = Gene.BASE_LENGTH.breed(first.baseLength, second.baseLength);
        this.bodyHeight = Gene.BODY_HEIGHT.breed(first.bodyHeight, second.bodyHeight);
        this.neckExt = Gene.NECK_EXT.breed(first.neckExt, second.neckExt);
        this.tailExt = Gene.TAIL_EXT.breed(first.tailExt, second.tailExt);
        this.tailRaise = Gene.TAIL_RAISE.breed(first.tailRaise, second.tailRaise);
        this.headRaise = Gene.NECK_RAISE.breed(first.headRaise, second.headRaise);
        
        this.neckLength = this.baseLength + this.neckExt;
        this.tailLength = this.baseLength + this.tailExt;
    }
    
    public double getBodyHeight(double scale) {
        
        return this.bodyHeight * scale;
    }
    
    public double getNeckLength(double scale) {
        
        return this.neckLength * scale;
    }
    
    public double getHeadRaise(double scale) {
        
        return this.headRaise * scale;
    }
    
    public double getTailLength(double scale) {
        
        return this.tailLength * scale;
    }
    
    public double getTailRaise(double scale) {
        
        return this.tailRaise * scale;
    }
    
    public double getBodyWidth(double scale) {
        
        return bodyWidth * scale;
    }
    
    public double getHeadWidth(double scale) {
        
        return headWidth * scale;
    }
}
