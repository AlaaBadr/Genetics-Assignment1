import java.util.ArrayList;

public class KnapSack {

    private static GeneticAlgorithm alg;
    private static Chromosome chromosome;

    private static void inputFile()
    {

    }

    private static void output()
    {
        for(int i=0; i<alg.getPopulation().size(); i++)
        {
            System.out.println(alg.getPopulation().get(i).genes);
        }
    }

    public static void main(String[] args) {
        chromosome = new BinaryChromosome();
        alg = new GeneticAlgorithm();
        alg.setPopulation(new ArrayList<BinaryChromosome>());
        alg.setSelected(new ArrayList<BinaryChromosome>());
        alg.setOffsprings(new ArrayList<BinaryChromosome>());
        alg.setReplacer(new GenerationalReplacement());
        inputFile();
        alg.init(chromosome);
        alg.run();
        output();
    }
}
