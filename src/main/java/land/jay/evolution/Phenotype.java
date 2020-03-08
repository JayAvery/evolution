package land.jay.evolution;

import java.util.function.Function;

public class Phenotype {
    
    public final double height;
    public final double thickness;
    public final double hipDrop;
    public final double shoulderDrop;
    public final double abdomen;
    public final double backPad;
    public final double backHump;
    public final double neckHeight;
    public final double tailHeight;
    public final double torsoShear;
    public final double hipShear;
    public final double thighHeight;
    public final double ankleHeight;
    public final double kneeProjection;
    public final double ankleRecession;
    public final double thighThickness;
    public final double calfThickness;
    public final double ankleThickness;
    public final double footExtension;
    public final double footProjection;
    public final double footHeight;
    public final double toeHeight;
    public final double toeRecession;
    public final double hockOverhang;
    public final double heelHeight;
    public final double heelRecession;
    public final double heelLength;
    public final double bicepHeight;
    public final double elbowRecession;
    public final double bicepThickness;
    public final double wristThickness;
    public final double neckBase;
    public final double neckEnd;
    public final double neckLength;
    public final double neckFirst;
    public final double neckSecond;
    public final double neckMid;
    public final double neckAngle;
    public final double headHeight;
    public final double headLength;
    public final double crownLength;
    public final double foreheadLength;
    public final double foreheadDrop;
    public final double browDrop;
    public final double snoutHeight;
    public final double snoutRecession;
    public final double chinLength;
    public final double chinDrop;
    public final double jawProjection;
    public final double noseSize;
    public final double tailBase;
    public final double tailEnd;
    public final double tailLength;
    public final double tailFirst;
    public final double tailSecond;
    public final double tailMid;
    public final double tailAngle;

    public Phenotype(Genotype genotype) {
        this.height = scale(average(genotype.height), 0.5, 2.0);
        this.thickness = scale(average(genotype.thickness), 0.4, 0.7) * this.height;        
        this.hipDrop = scale(genotype.hipDrop, scale(genotype.hipCrouch, 0.1, 0.25), scale(genotype.hipCrouch, 0.25, 0.5)) * this.thickness;
        this.shoulderDrop = scale(genotype.shoulderDrop, 0.15, 0.3) * this.thickness;
        this.abdomen = scale(genotype.chunkyness, 0.5, 1.2) * this.thickness;
        this.backPad = scale(genotype.chunkyness, 0.1, 0.2) * this.thickness;
        this.backHump = scale(average(genotype.hipCrouch, genotype.hipCrouch, genotype.backHump), -0.15, 0.2) * this.thickness;
        this.neckHeight = scale(average(genotype.size, genotype.neckTailLength, genotype.headSize, genotype.neckLength), 0.0, 0.3) * this.thickness;
        this.tailHeight = scale(average(genotype.size, genotype.neckTailLength, genotype.tailLength), 0.0, 0.2) * this.thickness;
        this.torsoShear = scale(average(genotype.hipCrouch, 1 - genotype.thickness), scale(genotype.size, -0.7, 0), 0) * this.height;
        this.hipShear = scale(genotype.hipHeight, -0.2, 0.2) * this.height;
        this.thighHeight = scale(average(1 - genotype.height, 1 - genotype.ankleLength, genotype.thighLength), 0.2, 0.5) * (this.height + this.torsoShear);
        this.kneeProjection = scale(average(genotype.limbFlex, genotype.kneeProjection), scale(genotype.hipCrouch, 0.0, 0.35), scale(genotype.hipCrouch, 0.15, 0.5));
        this.ankleRecession = scale(average(genotype.limbFlex, genotype.limbFlex, genotype.ankleRecession), scale(genotype.size, 0.08, 0.0), scale(genotype.size, 0.15, 0.08));
        this.thighThickness = scale(average(genotype.thickness, genotype.chunkyness, 1 - genotype.thighLength), scale(genotype.size, 0.125, 0.15), scale(genotype.size, 0.2, 0.25));
        this.calfThickness = scale(average(genotype.thickness, genotype.chunkyness, 1 - genotype.ankleLength), 0.7, 0.9) * this.thighThickness;
        this.ankleThickness = scale(average(1  - genotype.height, genotype.thickness, genotype.chunkyness, 1 - genotype.ankleLength), 0.7, 0.9) * this.calfThickness;
        double extensionAnkle = scale(genotype.ankleLength, scale(genotype.hipCrouch, -0.5, 0.0), scale(genotype.hipCrouch, 0.0, 0.4)) * this.height;
        this.footExtension = extensionAnkle < 0 ? Math.abs(extensionAnkle) : 0;
        this.ankleHeight = extensionAnkle > 0 ? extensionAnkle : 0;
        this.footProjection = scale(average(genotype.footLength, 1 - genotype.hoofness), scale(genotype.size, 0.2, 0.1), scale(genotype.size, 0.33, 0.15)) + this.ankleThickness;
        this.footHeight = scale(genotype.pawness, scale(genotype.hoofness, 0.15, 0.5), scale(genotype.hoofness, 0.5, 0.65)) * (this.ankleThickness + this.footExtension + this.footProjection);
        this.toeHeight = scale(genotype.pawness, scale(genotype.hoofness, 0.25, 0.4), scale(genotype.hoofness, 0.85, 0.6)) * this.footHeight;
        this.toeRecession = scale(1 - genotype.pawness, scale(genotype.hoofness, 0.15, 0.3), scale(genotype.hoofness, 0.2, 0.4)) * this.footProjection;
        this.hockOverhang = scale(average(1 - genotype.size, 1 - genotype.chunkyness, genotype.ankleLength), 0, scale(genotype.hoofness, 0.0, 0.4)) * this.ankleThickness;
        this.heelHeight = scale(1 - genotype.pawness, scale(genotype.hoofness, 0.15, 0.3), scale(genotype.hoofness, 0.25, 0.4)) * this.footHeight;
        this.heelRecession = scale(average(1 - genotype.size, 1 - genotype.chunkyness, genotype.pawness), scale(genotype.hoofness, 0.15, 0.1), scale(genotype.hoofness, 0.3, 0.15)) * this.footProjection;
        this.heelLength = scale(average(genotype.ankleLength, 1 - genotype.pawness), scale(genotype.hoofness, -1.0, 0.5), scale(genotype.hoofness, 3.0, 1.5)) * this.heelRecession;
        this.bicepHeight = scale(average(1 - genotype.height, genotype.thighLength), 0.25, 0.5) * this.height;
        this.elbowRecession = scale(genotype.ankleLength, 0.08, 0.16);
        this.bicepThickness = scale(average(genotype.thickness, genotype.chunkyness, 1 - genotype.thighLength), scale(genotype.size, 0.08, 0.1), scale(genotype.size, 0.16, 0.2));
        this.wristThickness = scale(average(genotype.thickness, genotype.chunkyness, 1 - genotype.ankleLength), 0.7, 0.9) * this.bicepThickness;
        this.neckBase = scale(average(genotype.thickness, genotype.chunkyness), scale(genotype.neckTailLength, 0.6, 0.6), scale(genotype.neckTailLength, 0.8, 0.8)) * (this.thickness + this.backPad + this.neckHeight); // TODO: add scaling  
        this.neckEnd = scale(average(1 - genotype.size, 1 - genotype.height, genotype.headSize, 1 - genotype.neckTaper, genotype.neckLength), scale(genotype.neckTailLength, 0.7, 0.1), scale(genotype.size, 0.9, 0.2)) * this.neckBase;
        this.neckLength = scale(average(genotype.neckTailLength, genotype.neckTailLength, genotype.neckTailLength, 1 - genotype.headSize, genotype.neckLength), 0.25, scale(genotype.size, 2.0, 3.0));
        double neckStretch = scale(average(genotype.neckTailLength, genotype.neckLength, genotype.neckStretch, genotype.neckStretch), 1.0, 6.0);
        this.neckFirst = this.neckLength / (2.0 + neckStretch + (2.0 * Math.pow(neckStretch, 0.5)));
        this.neckSecond = this.neckFirst * Math.pow(neckStretch, 0.5);
        this.neckMid = this.neckFirst * neckStretch;
        this.neckAngle = Math.toRadians(scale(average(genotype.neckLength, genotype.neckCurve), -5, scale(genotype.neckTailLength, 15.0, 40.0)));
        this.headHeight = scale(genotype.headSize, 1.0, 1.5) * this.neckEnd;
        this.headLength = scale(average(1 - genotype.thickness, genotype.neckTailLength, genotype.headLength, genotype.headLength), 0.7, 2.0) * this.headHeight;
        this.crownLength = scale(average(1 - genotype.thickness, genotype.neckTailLength, genotype.crownLength, genotype.crownLength), 0.15, 0.6) * this.neckEnd;
        this.foreheadLength = scale(average(genotype.foreheadLength, genotype.browRaise), 0.25, 0.75) * (this.headLength - this.crownLength);
        this.foreheadDrop = scale(average(genotype.foreheadDrop, 1 - genotype.browRaise), 0.1, 0.5) * this.headHeight;
        this.browDrop = scale(genotype.browRaise, 0.0, 0.15) * this.headHeight;
        this.snoutHeight = scale(genotype.snoutHeight, 0.25, 0.75) * (this.headHeight - this.browDrop - this.foreheadDrop);
        this.snoutRecession = scale(genotype.snoutRecession, -0.15, 0.7) * this.snoutHeight;
        this.chinLength = scale(genotype.chinLength, 0.5, 1.0) * (this.headLength - this.foreheadLength - this.crownLength);
        this.chinDrop = scale(genotype.chinDrop, 0.0, 0.3) *(this.headHeight - this.browDrop - this.foreheadDrop);
        this.jawProjection = scale(genotype.jawProjection, 0.1, 0.7) * this.headLength;
        this.noseSize = scale(genotype.noseSize, 0.0, 0.7) * this.snoutHeight;        
        this.tailBase = scale(average(genotype.tailDepth, 1 - genotype.tailLength, 1 - genotype.tailLength, 1 - genotype.tailLength), scale(genotype.neckTailLength, 0.05, 0.7), 0.8) * (this.abdomen + this.backPad + this.tailHeight);
        this.tailEnd = scale(average(genotype.size, genotype.tailPoint), 0.01, 0.05) * this.thickness;
        this.tailLength = scale(genotype.tailLength, scale(genotype.size, 0.0, 1.0), scale(genotype.size, 5.0, 2.0)) * this.neckLength;
        double tailStretch = scale(average(genotype.neckTailLength, genotype.tailLength, genotype.tailLength, genotype.tailLength, genotype.tailStretch), 1.0, 6.0);
        this.tailFirst = this.tailLength / (2.0 + tailStretch + (2.0 * Math.pow(tailStretch, 0.5)));
        this.tailSecond = this.tailFirst * Math.pow(tailStretch, 0.5);
        this.tailMid = this.tailFirst * tailStretch;
        this.tailAngle = Math.toRadians(scale(average(genotype.neckTailLength, genotype.tailCurve), scale(genotype.tailLength, 0.0, -30.0), scale(genotype.tailLength, 0.0, -45.0)));
    }
    
    private static double average(double... values) {
        double count = values.length;
        double sum = 0.0;
        for (double value : values) {
            sum = sum + value;
        }
        return sum / count;
    }
    
    private static double scale (double normal, double min, double max) {
        return (normal * (max - min)) + min;
    }
}
