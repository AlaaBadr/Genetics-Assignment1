import java.util.ArrayList;

public abstract class GeneticAlgorithm {

    double minimum = 0.0,maximum,crossoverP = 0.4, mutationP = 0.1;

    ArrayList<Chromosome> population;

    public void init()
    {

    }

    public void selection()
    {

    }

    public void crossover()
    {

    }

    public void mutation()
    {

    }

    public abstract void replacement();

    public static void main(String[] args) {
        // write your code here
    }
}