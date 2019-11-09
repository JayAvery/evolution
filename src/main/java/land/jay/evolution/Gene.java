package land.jay.evolution;

import java.util.Random;
import org.apache.commons.math3.distribution.BetaDistribution;

public enum Gene {
    
    BASE_LENGTH(0, 50),
    NECK_EXT(30, 70),
    TAIL_EXT(30, 100),
    BODY_HEIGHT(40, 80),
    NECK_RAISE(-30, 90),
    TAIL_RAISE(-30, 30);
    
    public static final double BODY_LENGTH = 120;
    public static final double HEAD_LENGTH = 40;
        
    private final double min;
    private final double max;
    
    private Gene(double min, double max) {
        this.min = min;
        this.max = max;
    }
    
    /** @return A random value weighted between the parents. */
    public double breed(double first, double second) {
        
        double low = this.normalise(Math.min(first, second));
        double high = this.normalise(Math.max(first, second));
        double mid = low + ((high - low) / 2);
        
        double precision = Math.pow(high - mid, -1.6);
        double alpha = precision * mid;
        double beta = precision * (1 - mid);
        
        BetaDistribution distribution = new BetaDistribution(alpha, beta);
        return this.unNormalise(distribution.sample());
    }
    
    /** @return A random value from the possible range. */
    public double random() {
        return this.min + (Math.random()*(this.max - this.min));
    }
    
    /** @return A double from 0-1 representing this value. */
    private double normalise(double value) {
        return (value - this.min) / (this.max - this.min);
    }
    
    /** @return The actual value represented by this double. */
    private double unNormalise(double normal) {
        return ((normal) * (this.max - this.min)) + this.min; 
    }
}
