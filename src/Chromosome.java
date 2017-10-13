import java.util.ArrayList;

public abstract class Chromosome<T> {

    ArrayList<T> genes;

    public abstract double fitness();

    public abstract void flip();

    public Chromosome<T> crossover(Chromosome<T> chromosome, int index)
    {
        return null;
    }
}