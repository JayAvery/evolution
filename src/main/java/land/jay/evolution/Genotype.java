package land.jay.evolution;

import org.apache.commons.math3.distribution.BetaDistribution;

public class Genotype {

    // Genes
    final double size;
    final double height;
    final double thickness;
    final double chunkyness;
    
    final double headSize;
    final double headLength;
    final double crownLength;
    final double foreheadLength;
    final double foreheadDrop;
    final double browRaise;
    final double snoutHeight;
    final double snoutRecession;
    final double chinLength;
    final double chinDrop;
    final double jawProjection;
    final double noseSize;
    
    final double ankleLength;
    final double thighLength;
    final double limbFlex;
    final double kneeProjection;
    final double ankleRecession;
    
    final double hipHeight;
    final double hipCrouch;
    final double hipDrop;
    //final double torsoShear;
    //final double pelvisDrop;
    final double shoulderDrop;
    final double backHump;
    final double neckTailLength;
    //final double footLength;
    final double neckTaper;
    final double neckLength;
    final double neckStretch;
    final double neckCurve;
    final double tailDepth;
    final double tailLength;
    final double tailStretch;
    final double tailCurve;
    final double tailPoint;
    final double footLength;
    final double hoofness;
    final double pawness;
    
    /** Randomise all genes. */
    public Genotype() {
        this.size = Math.random();
        this.height = Math.random();
        this.thickness = Math.random();
        this.chunkyness = Math.random();
        this.headSize = Math.random();
        this.headLength = Math.random();
        this.crownLength = Math.random();
        this.foreheadLength = Math.random();
        this.foreheadDrop = Math.random();
        this.browRaise = Math.random();
        this.snoutHeight = Math.random();
        this.snoutRecession = Math.random();
        this.chinLength = Math.random();
        this.chinDrop = Math.random();
        this.jawProjection = Math.random();
        this.noseSize = Math.random();
        this.ankleLength = Math.random();
        this.thighLength = Math.random();
        this.limbFlex = Math.random();
        this.kneeProjection = Math.random();
        this.ankleRecession = Math.random();
        this.hipHeight = Math.random();
        this.hipCrouch = Math.random();
        this.hipDrop = Math.random();
        this.shoulderDrop = Math.random();
        this.backHump = Math.random();
        this.neckTailLength = Math.random();
        this.neckTaper = Math.random();
        this.neckLength = Math.random();
        this.neckStretch = Math.random();
        this.neckCurve = Math.random();
        this.tailDepth = Math.random();
        this.tailLength = Math.random();
        this.tailStretch = Math.random();
        this.tailCurve = Math.random();
        this.tailPoint = Math.random();
        this.footLength = Math.random();
        this.hoofness = Math.random();
        this.pawness = Math.random();
    }
    
    /** Breed genes from two parents. */
    public Genotype(Genotype first, Genotype second) {
        this.size = breed(first.size, second.size);
        this.height = breed(first.height, second.height);
        this.thickness = breed(first.thickness, second.thickness);
        this.chunkyness = breed(first.chunkyness, second.chunkyness);
        this.headSize = breed(first.headSize, second.headSize);
        this.headLength = breed(first.headLength, second.headLength);
        this.crownLength = breed(first.crownLength, second.crownLength);
        this.foreheadLength = breed(first.foreheadLength, second.foreheadLength);
        this.foreheadDrop = breed(first.foreheadDrop, second.foreheadDrop);
        this.browRaise = breed(first.browRaise, second.browRaise);
        this.snoutHeight = breed(first.snoutHeight, second.snoutHeight);
        this.snoutRecession = breed(first.snoutRecession, second.snoutRecession);
        this.chinLength = breed(first.chinLength, second.chinLength);
        this.chinDrop = breed(first.chinDrop, second.chinDrop);
        this.jawProjection = breed(first.jawProjection, second.jawProjection);
        this.noseSize = breed(first.noseSize, second.noseSize);
        this.ankleLength = breed(first.ankleLength, second.ankleLength);
        this.thighLength = breed(first.thighLength, second.thighLength);
        this.limbFlex = breed(first.limbFlex, second.limbFlex);
        this.kneeProjection = breed(first.kneeProjection, second.kneeProjection);
        this.ankleRecession = breed(first.ankleRecession, second.ankleRecession);
        this.hipHeight = breed(first.hipHeight, second.hipHeight);
        this.hipCrouch = breed(first.hipCrouch, second.hipCrouch);
        this.hipDrop = breed(first.hipDrop, second.hipDrop);
        this.shoulderDrop = breed(first.shoulderDrop, second.shoulderDrop);
        this.backHump = breed(first.backHump, second.backHump);
        this.neckTailLength = breed(first.neckTailLength, second.neckTailLength);
        this.neckTaper = breed(first.neckTaper, second.neckTaper);
        this.neckLength = breed(first.neckLength, second.neckLength);
        this.neckStretch = breed(first.neckStretch, second.neckStretch);
        this.neckCurve = breed(first.neckCurve, second.neckCurve);
        this.tailDepth = breed(first.tailDepth, second.tailDepth);
        this.tailLength = breed(first.tailLength, second.tailLength);
        this.tailStretch = breed(first.tailStretch, second.tailStretch);
        this.tailCurve = breed(first.tailCurve, second.tailCurve);
        this.tailPoint = breed(first.tailPoint, second.tailPoint);
        this.footLength = breed(first.footLength, second.footLength);
        this.hoofness = breed(first.hoofness, second.hoofness);
        this.pawness = breed(first.pawness, second.pawness);
    }
    
    /** Breed this gene according to Beta distribution defined by two parent genes. */
    private static double breed(double first, double second) {
        double low = Math.min(first, second);
        double high = Math.max(first, second);
        double mid = low + ((high - low) / 2);
        double precision = Math.max(Math.pow((high - mid), -1.6), 1); // Never allow precision to be less than 1!
        BetaDistribution dist = new BetaDistribution(precision * mid, precision * (1 - mid));
        return dist.sample();
    }
}
