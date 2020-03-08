package land.jay.evolution;

import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Translate;

public class CreaturePane extends Pane {

    private Creature creature = new Creature();
    private Group parts = new Group();
    private double width;
    private double height;
    
    public CreaturePane(double width, double height) {
        this.width = width;
        this.height = height;
        this.getChildren().add(this.parts);
        this.setPrefHeight(height);
        this.setPrefWidth(width);
        this.setStyle("-fx-border-color: black;\n -fx-border-width: 1");
    }
    
    public void drawCreature() {
        
        Phenotype pheno = this.creature.phenotype;
        
        Polygon torso = new Polygon();
        
        double third = 1.0/3.0;
        double sixth = 1.0/6.0;
        
        double topShoulderY = - pheno.backPad - pheno.neckHeight;
        double topHipY = - pheno.backPad - pheno.tailHeight - pheno.torsoShear - pheno.hipShear;
        double slope = pheno.tailHeight - pheno.neckHeight;
        double firstThirdY = topShoulderY - (slope / 3.0) - pheno.backPad - pheno.backHump - (pheno.torsoShear * 0.1) - (pheno.hipShear * third);
        double secondThirdY = topShoulderY - (slope / 3.0) - pheno.backPad - pheno.backHump - (pheno.torsoShear * 0.4) - (pheno.hipShear * third);

        double hipDrop = pheno.hipDrop - pheno.torsoShear - pheno.hipShear;
        double firstThirdBelly = pheno.thickness - (pheno.torsoShear * 0.1) - (pheno.hipShear * third);
        double secondThirdBelly = pheno.abdomen - (pheno.torsoShear * 0.4) - (pheno.hipShear * third);
        
        torso.getPoints().addAll(0.0, 0.0);
        torso.getPoints().addAll(- sixth, pheno.shoulderDrop);
        torso.getPoints().addAll(0.0, pheno.shoulderDrop);
        torso.getPoints().addAll(0.0, pheno.thickness);
        torso.getPoints().addAll(third, firstThirdBelly);
        torso.getPoints().addAll(2 * third, secondThirdBelly);
        torso.getPoints().addAll(1.0, secondThirdBelly);
        torso.getPoints().addAll(1.0, hipDrop);
        torso.getPoints().addAll(1.0 + sixth, hipDrop);
        torso.getPoints().addAll(1.0, - pheno.torsoShear - pheno.hipShear);
        torso.getPoints().addAll(1.0, topHipY);
        torso.getPoints().addAll(2 * third, secondThirdY);
        torso.getPoints().addAll(third, firstThirdY);
        torso.getPoints().addAll(0.0, topShoulderY);


        Polygon neck = new Polygon();
        
        double neckAdd = (pheno.neckBase - pheno.neckEnd) / 4.0;
        
        double top1x = - (Math.cos(pheno.neckAngle) * pheno.neckFirst);
        double top1y = topShoulderY - (Math.sin(pheno.neckAngle) * pheno.neckFirst);
        double top2x = top1x - (Math.cos(2 * pheno.neckAngle) * pheno.neckSecond);
        double top2y = top1y - (Math.sin(2 * pheno.neckAngle) * pheno.neckSecond);
        double top3x = top2x - (Math.cos(3 * pheno.neckAngle) * pheno.neckMid);
        double top3y = top2y - (Math.sin(3 * pheno.neckAngle) * pheno.neckMid);
        double top4x = top3x - (Math.cos(2 * pheno.neckAngle) * pheno.neckSecond);
        double top4y = top3y - (Math.sin(2 * pheno.neckAngle) * pheno.neckSecond);
        double top5x = top4x - (Math.cos(pheno.neckAngle) * pheno.neckFirst);
        double top5y = top4y - (Math.sin(pheno.neckAngle) * pheno.neckFirst);
        double top6x = top5x - (Math.tan(pheno.neckAngle) * pheno.neckEnd);
        double top6y = top5y;
        double bottom1x = top6x;
        double bottom1y = top6y + pheno.neckEnd;
        double bottom2x = top4x - (Math.sin(2 * pheno.neckAngle) * (pheno.neckEnd + neckAdd));
        double bottom2y = top4y + (Math.cos(2 * pheno.neckAngle) * (pheno.neckEnd + neckAdd));
        double bottom3x = top3x - (Math.sin(3 * pheno.neckAngle) * (pheno.neckEnd + (2 * neckAdd)));
        double bottom3y = top3y + (Math.cos(3 * pheno.neckAngle) * (pheno.neckEnd + (2 * neckAdd)));
        double bottom4x = top2x - (Math.sin(2 * pheno.neckAngle) * (pheno.neckBase - neckAdd));
        double bottom4y = top2y + (Math.cos(2 * pheno.neckAngle) * (pheno.neckBase - neckAdd));
        double bottom5x = top1x - (Math.sin(pheno.neckAngle) * pheno.neckBase);
        double bottom5y = top1y + (Math.cos(pheno.neckAngle) * pheno.neckBase);
        
        
        neck.getPoints().addAll(0.0, topShoulderY);
        neck.getPoints().addAll(top1x, top1y);
        neck.getPoints().addAll(top2x, top2y);
        neck.getPoints().addAll(top3x, top3y);
        neck.getPoints().addAll(top4x, top4y);
        neck.getPoints().addAll(top5x, top5y);
        neck.getPoints().addAll(top6x, top6y);
        neck.getPoints().addAll(bottom1x, bottom1y);
        neck.getPoints().addAll(bottom2x, bottom2y);
        neck.getPoints().addAll(bottom3x, bottom3y);
        neck.getPoints().addAll(bottom4x, bottom4y);
        neck.getPoints().addAll(bottom5x, bottom5y);
        neck.getPoints().addAll(0.0, pheno.thickness);
        
        
        Polygon head = new Polygon();
        
        double crownX = top6x - pheno.crownLength;
        double crownY = top6y;
        double browX = crownX - pheno.foreheadLength;
        double browY = crownY + pheno.foreheadDrop;
        double eyeX = browX;
        double eyeY = browY + pheno.browDrop;
        double noseX = crownX - pheno.headLength;
        double noseY = crownY + pheno.headHeight - pheno.snoutHeight;
        double unRoundedNoseLength = eyeX - noseX;
        double unRoundedNoseHeight = noseY - eyeY;
        double snoutLength = Math.sqrt(Math.pow(unRoundedNoseLength, 2) + Math.pow(unRoundedNoseHeight, 2));
        double roundingProportion = (snoutLength - pheno.noseSize) /  snoutLength;
        double noseTopX = eyeX - (unRoundedNoseLength * roundingProportion);
        double noseTopY = eyeY + (unRoundedNoseHeight * roundingProportion);
        double chinPointX = noseX + pheno.snoutRecession;
        double chinPointY = crownY + pheno.headHeight + pheno.chinDrop;
        double unRoundedChinLength = pheno.snoutRecession;
        double unRoundedChinHeight = chinPointY - noseY;
        double noseBottomX = chinPointX - (unRoundedChinLength * roundingProportion);
        double noseBottomY = chinPointY - (unRoundedChinHeight * roundingProportion);
        double chinBackX = chinPointX + pheno.chinLength;
        double chinBackY = crownY + pheno.headHeight;
        double jawX = top6x - pheno.jawProjection;
        double jawY = crownY + pheno.headHeight;
        double backX = bottom1x;
        double backY = bottom1y;
        
        head.getPoints().addAll(top6x, top6y);
        head.getPoints().addAll(crownX, crownY);
        head.getPoints().addAll(browX, browY);
        head.getPoints().addAll(eyeX, eyeY);
        head.getPoints().addAll(noseTopX, noseTopY);
        head.getPoints().addAll(noseBottomX, noseBottomY);
        head.getPoints().addAll(chinPointX, chinPointY);
        head.getPoints().addAll(chinBackX, chinBackY);
        head.getPoints().addAll(jawX, jawY);
        head.getPoints().addAll(backX, backY);
        
        Polygon arm = new Polygon();
        
        double elbowX = - sixth + pheno.elbowRecession;
        double elbowY = pheno.shoulderDrop + pheno.bicepHeight;
        double bicepAngle = Math.tan(pheno.elbowRecession / pheno.bicepHeight);
        double backElbowX = elbowX + (pheno.bicepThickness * Math.cos(bicepAngle));
        double backElbowY = elbowY - (pheno.bicepThickness * Math.cos(bicepAngle));
        
        arm.getPoints().addAll(0.0, 0.0);
        arm.getPoints().addAll(- sixth, pheno.shoulderDrop);
        arm.getPoints().addAll(elbowX, elbowY);
        arm.getPoints().addAll(0.0, pheno.height);
        arm.getPoints().addAll(pheno.wristThickness, pheno.height);
        arm.getPoints().addAll(backElbowX, backElbowY);
 
        
        Polygon thigh = new Polygon();
        Polygon calf = new Polygon();
        Polygon ankle = new Polygon();
        
        double frontKneeX = 1.0 - pheno.kneeProjection;
        double frontKneeY = pheno.thighHeight + hipDrop;
        double frontAnkleX = 1.0 + pheno.ankleRecession;
        double frontAnkleY = pheno.height - pheno.ankleHeight;
        
        double thighAngle = Math.atan((pheno.kneeProjection + sixth) / (pheno.thighHeight));
        double backThighX = frontKneeX + pheno.thighThickness * Math.cos(thighAngle);
        double backThighY = frontKneeY + pheno.thighThickness * Math.sin(thighAngle);
        double midThighX = backThighX + (0.5 * (pheno.kneeProjection + sixth));
        double midThighY = backThighY - (0.5 * pheno.thighHeight);
        double backHipX = 1.0 + sixth + (0.5 * pheno.thighThickness * Math.cos(thighAngle));
        double backHipY = hipDrop + (0.5 * pheno.thighThickness * Math.sin(thighAngle));
        
        double calfAngle = Math.atan((frontAnkleX - frontKneeX) / (frontAnkleY - frontKneeY));
        double backCalfX = frontAnkleX + pheno.calfThickness * Math.cos(calfAngle);
        double backCalfY = frontAnkleY - pheno.calfThickness * Math.sin(calfAngle);
        double backKneeX = frontKneeX + pheno.calfThickness * Math.cos(calfAngle);
        double backKneeY = frontKneeY - pheno.calfThickness * Math.sin(calfAngle);
        
        double ankleAngle = pheno.ankleHeight == 0 ? 0 : Math.atan(pheno.ankleRecession / pheno.ankleHeight);
        double backAnkleX = frontAnkleX + (third * pheno.ankleRecession) + (pheno.ankleThickness * Math.cos(ankleAngle));
        double backAnkleY = frontAnkleY - (third * pheno.ankleHeight) + (pheno.ankleThickness * Math.sin(ankleAngle));
      
        thigh.getPoints().addAll(frontKneeX, frontKneeY);
        thigh.getPoints().addAll(backThighX, backThighY);
        thigh.getPoints().addAll(midThighX, midThighY);
        thigh.getPoints().addAll(backHipX, backHipY);
        thigh.getPoints().addAll(backHipX, topHipY);
        thigh.getPoints().addAll(1.0, topHipY);
        
        calf.getPoints().addAll(frontKneeX, frontKneeY);
        calf.getPoints().addAll(frontAnkleX, frontAnkleY);
        calf.getPoints().addAll(backCalfX, backCalfY);
        calf.getPoints().addAll(backKneeX, backKneeY);
        
        ankle.getPoints().addAll(1.0 + ((1 + third) * pheno.ankleRecession), pheno.height - ((1 + third) * pheno.ankleHeight));
        ankle.getPoints().addAll(1.0, pheno.height);
        ankle.getPoints().addAll(1.0 + pheno.ankleThickness, pheno.height);
        ankle.getPoints().addAll(backAnkleX, backAnkleY);
     
        Polygon foot = new Polygon();
        foot.getPoints().addAll(1.0, pheno.height);
        foot.getPoints().addAll(1.0 - pheno.footExtension, pheno.height);
        foot.getPoints().addAll(1.0 - pheno.footExtension - pheno.footProjection + pheno.toeRecession, pheno.height + (pheno.footHeight - pheno.toeHeight));
        foot.getPoints().addAll(1.0 - pheno.footExtension - pheno.footProjection, pheno.height + pheno.footHeight);
        foot.getPoints().addAll(1.0 + pheno.ankleThickness - pheno.hockOverhang - pheno.heelRecession + pheno.heelLength, pheno.height + pheno.footHeight);
        foot.getPoints().addAll(1.0 + pheno.ankleThickness - pheno.hockOverhang - pheno.heelRecession, pheno.height + (pheno.footHeight - pheno.heelHeight));
        foot.getPoints().addAll(1.0 + pheno.ankleThickness - pheno.hockOverhang, pheno.height);
        
        
        Polygon hand = new Polygon();
        hand.getPoints().addAll(0.0, pheno.height);
        hand.getPoints().addAll(0.0 - pheno.footProjection + pheno.toeRecession, pheno.height + (pheno.footHeight - pheno.toeHeight));
        hand.getPoints().addAll(0.0 - pheno.footProjection, pheno.height + pheno.footHeight);
        hand.getPoints().addAll(0.0 + pheno.wristThickness - pheno.hockOverhang - pheno.heelRecession + pheno.heelLength, pheno.height + pheno.footHeight);
        hand.getPoints().addAll(0.0 + pheno.wristThickness - pheno.hockOverhang - pheno.heelRecession, pheno.height + (pheno.footHeight - pheno.heelHeight));
        hand.getPoints().addAll(0.0 + pheno.wristThickness - pheno.hockOverhang, pheno.height);
        
        
        Polygon tail = new Polygon();
        
        double tailAdd = (pheno.tailBase - pheno.tailEnd) / 6.0;
        double ttop1x = backHipX + (Math.cos(pheno.tailAngle) * pheno.tailFirst);
        double ttop1y = topHipY + (Math.sin(pheno.tailAngle) * pheno.tailFirst);
        double ttop2x = ttop1x + (Math.cos(2 * pheno.tailAngle) * pheno.tailSecond);
        double ttop2y = ttop1y + (Math.sin(2 * pheno.tailAngle) * pheno.tailSecond);
        double ttop3x = ttop2x + (Math.cos(3 * pheno.tailAngle) * pheno.tailMid);
        double ttop3y = ttop2y + (Math.sin(3 * pheno.tailAngle) * pheno.tailMid);
        double ttop4x = ttop3x + (Math.cos(2 * pheno.tailAngle) * pheno.tailSecond);
        double ttop4y = ttop3y + (Math.sin(2 * pheno.tailAngle) * pheno.tailSecond);
        double ttop5x = ttop4x + (Math.cos(pheno.tailAngle) * pheno.tailFirst);
        double ttop5y = ttop4y + (Math.sin(pheno.tailAngle) * pheno.tailFirst);
        double ttop6x = ttop5x + pheno.tailFirst;
        double ttop6y = ttop5y;
        double tbottom1x = ttop6x;
        double tbottom1y = ttop6y + pheno.tailEnd;
        double tbottom2x = ttop5x - (Math.sin(pheno.tailAngle) * (pheno.tailEnd + tailAdd));
        double tbottom2y = ttop5y + (Math.cos(pheno.tailAngle) * (pheno.tailEnd + tailAdd));
        double tbottom3x = ttop4x - (Math.sin(2 * pheno.tailAngle) * (pheno.tailEnd + (2 * tailAdd)));
        double tbottom3y = ttop4y + (Math.cos(2 * pheno.tailAngle) * (pheno.tailEnd + (2 * tailAdd)));
        double tbottom4x = ttop3x - (Math.sin(3 * pheno.tailAngle) * (pheno.tailEnd + (3 * tailAdd)));
        double tbottom4y = ttop3y + (Math.cos(3 * pheno.tailAngle) * (pheno.tailEnd + (3 * tailAdd)));
        double tbottom5x = ttop2x - (Math.sin(2 * pheno.tailAngle) * (pheno.tailBase - (2 * tailAdd)));
        double tbottom5y = ttop2y + (Math.cos(2 * pheno.tailAngle) * (pheno.tailBase - (2 * tailAdd)));
        double tbottom6x = ttop1x - (Math.sin(pheno.tailAngle) * (pheno.tailBase - tailAdd));
        double tbottom6y = ttop1y + (Math.cos(pheno.tailAngle) * (pheno.tailBase - tailAdd));
        double tbottom7x = backHipX;
        double tbottom7y = topHipY + pheno.tailBase;
        
        
        
        tail.getPoints().addAll(ttop6x, ttop6y);
        tail.getPoints().addAll(ttop5x, ttop5y);
        tail.getPoints().addAll(ttop4x, ttop4y);
        tail.getPoints().addAll(ttop3x, ttop3y);
        tail.getPoints().addAll(ttop2x, ttop2y);
        tail.getPoints().addAll(ttop1x, ttop1y);
        tail.getPoints().addAll(backHipX, topHipY);
        tail.getPoints().addAll(1.0, topHipY);
        tail.getPoints().addAll(1.0, secondThirdBelly);
        tail.getPoints().addAll(tbottom7x, tbottom7y);
        tail.getPoints().addAll(tbottom6x, tbottom6y);
        tail.getPoints().addAll(tbottom5x, tbottom5y);
        tail.getPoints().addAll(tbottom4x, tbottom4y);
        tail.getPoints().addAll(tbottom3x, tbottom3y);
        tail.getPoints().addAll(tbottom2x, tbottom2y);
        tail.getPoints().addAll(tbottom1x, tbottom1y);
        
        
        Scale scale = new Scale();
        scale.setX(65);
        scale.setY(65);
        
        Translate translate = new Translate();
        translate.setX(150);
        translate.setY(70);
        
        torso.getTransforms().addAll(translate, scale);
        torso.setFill(Color.GREEN);
        neck.getTransforms().addAll(translate, scale);
        neck.setFill(Color.GREEN);
        arm.getTransforms().addAll(translate, scale);
        arm.setFill(Color.PURPLE);
        thigh.getTransforms().addAll(translate, scale);
        thigh.setFill(Color.BLUE);
        calf.getTransforms().addAll(translate, scale);
        calf.setFill(Color.PURPLE);
        ankle.getTransforms().addAll(translate, scale);
        ankle.setFill(Color.BLUE);
        foot.getTransforms().addAll(translate, scale);
        foot.setFill(Color.GREEN);
        hand.getTransforms().addAll(translate, scale);
        hand.setFill(Color.GREEN);
        tail.getTransforms().addAll(translate, scale);
        tail.setFill(Color.RED);
        head.getTransforms().addAll(translate, scale);
        head.setFill(Color.BLUE);
        this.parts.getChildren().addAll(neck, torso, arm, calf, thigh, ankle, foot, hand, tail, head);
        
    }
}
