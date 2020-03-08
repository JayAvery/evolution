package land.jay.evolution;


public class Creature {

    private final Genotype genotype;
    public final Phenotype phenotype;
    
    /** New creature with random genotype. */
    public Creature() {
        this.genotype = new Genotype();
        this.phenotype = new Phenotype(this.genotype);
    }
    
    /** New creature with parent-defined genotype. */
    public Creature (Creature first, Creature second) {
        this.genotype = new Genotype(first.genotype, second.genotype);
        this.phenotype = new Phenotype(this.genotype);
    }
}
