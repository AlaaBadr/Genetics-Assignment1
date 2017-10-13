import java.util.ArrayList;

public abstract class Chromosome<T> {

    ArrayList<T> genes;

    public ArrayList<T> getGenes() {
        return genes;
    }

    public void setGenes(ArrayList<T> genes) {
        this.genes = genes;
    }

    public abstract Chromosome<T> init();

    public abstract double fitness();

    public abstract void flip();

    public ArrayList<Chromosome> crossover(Chromosome<T> chromosome, int index)
    {
        return null;
    }
}