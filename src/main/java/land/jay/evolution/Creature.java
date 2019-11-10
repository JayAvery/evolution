package land.jay.evolution;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

/** A creature defined by gene values. */
public class Creature {
    
    // Maximum possible size
    public static final double MAX_HEIGHT = 210;
    public static final double MAX_WIDTH = 440;
    
    // Universal dimensions
    private static final double bodyWidth = 120;
    private static final double headWidth = 40;
    
    // Genetic dimensions
    private final double baseLength;
    private final double bodyHeight;
    private final double neckExt;
    private final double tailExt;
    private final double neckRaise;
    private final double tailRaise;
    
    // Dimensions from gene combinations
    private final double neckLength;
    private final double tailLength;

    /** Creates a creature with random stats according to gene distributions. */
    public Creature() {
        
        this.baseLength = Gene.BASE_LENGTH.random();
        this.bodyHeight = Gene.BODY_HEIGHT.random();
        this.neckExt = Gene.NECK_EXT.random();
        this.tailExt = Gene.TAIL_EXT.random();
        this.tailRaise = Gene.TAIL_RAISE.random();
        this.neckRaise = Gene.NECK_RAISE.random();
        
        this.neckLength = this.baseLength + this.neckExt;
        this.tailLength = this.baseLength + this.tailExt;
    }
    
    /** Creates a creature with stats distributed according to parent genes. */
    public Creature(Creature first, Creature second) {
        
        this.baseLength = Gene.BASE_LENGTH.breed(first.baseLength, second.baseLength);
        this.bodyHeight = Gene.BODY_HEIGHT.breed(first.bodyHeight, second.bodyHeight);
        this.neckExt = Gene.NECK_EXT.breed(first.neckExt, second.neckExt);
        this.tailExt = Gene.TAIL_EXT.breed(first.tailExt, second.tailExt);
        this.tailRaise = Gene.TAIL_RAISE.breed(first.tailRaise, second.tailRaise);
        this.neckRaise = Gene.NECK_RAISE.breed(first.neckRaise, second.neckRaise);
        
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
        
        return this.neckRaise * scale;
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
