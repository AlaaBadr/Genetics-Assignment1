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

    public abstract void flip(int index);

    public ArrayList<Chromosome> crossover(Chromosome<T> chromosome, int index) {
        ArrayList<Chromosome> result = new ArrayList(2);
        for (Chromosome chromosome1 : result) {
            chromosome1.init();
        }

        for (int counter = 0; counter < index; ++counter) {
            result.get(0).genes.set(counter, genes.get(counter));
            result.get(1).genes.set(counter, chromosome.genes.get(counter));
        }

        for (int counter = index; counter < chromosome.genes.size(); ++counter) {
            result.get(0).genes.set(counter, chromosome.genes.get(counter));
            result.get(1).genes.set(counter, genes.get(counter));
        }


        return result;
    }
}