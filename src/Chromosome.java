import java.util.ArrayList;

public abstract class Chromosome<T> {

    ArrayList<T> genes;

    public abstract double fitness();

    public abstract void flip();

    public abstract Chromosome<T> crossover(int index);
}