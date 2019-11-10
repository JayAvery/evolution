package land.jay.evolution;

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
    private final BetaDistribution seed;
    
    private Gene(double min, double max) {
        this.min = min;
        this.max = max;
        double mid = Math.random();
        this.seed = new BetaDistribution(2 * mid, 2 * (1 - mid));
    }
    
    /** @return A random value weighted between the parents. */
    public double breed(double first, double second) {
        
        double low = this.normalise(Math.min(first, second));
        double high = this.normalise(Math.max(first, second));
        double mid = low + ((high - low) / 2);
        
        double precision = Math.pow(high - mid, -1.6);        
        BetaDistribution distribution = new BetaDistribution(precision *  mid, precision * (1 - mid));
        return this.unNormalise(distribution.sample());
    }
    
    /** @return A random value from the possible range according to initial seed. */
    public double random() {
        return this.unNormalise(this.seed.sample());
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
