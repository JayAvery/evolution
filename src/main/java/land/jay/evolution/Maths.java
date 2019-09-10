package land.jay.evolution;

import java.util.Random;

public class Maths {
    
    private static final Random RAND = new Random();
    
    /** @return Random double between the two values. */
    public static double random(double lower, double upper) {
        
        return lower + ((upper - lower) * RAND.nextDouble());
    }
}
