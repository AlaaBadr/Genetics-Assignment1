import java.util.ArrayList;

public abstract class Chromosome<T> implements Cloneable{

    ArrayList<T> genes;
    protected int length;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

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
        ArrayList<Chromosome> result = new ArrayList<>();
        result.add((Chromosome) chromosome.clone());
        result.add((Chromosome) chromosome.clone());

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
    public Object clone()
    {
        try {
            Chromosome cloned = (Chromosome)super.clone();
            cloned.genes = new ArrayList<>(genes);
            return cloned;

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return  null;
    }

    @Override
    public String toString() {
        return "Chromosome{" +
                "genes=" + genes +
                '}';
    }
}