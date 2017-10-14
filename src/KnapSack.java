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
        chromosome = new BinaryChromosome(3);
        alg = new GeneticAlgorithm();
        alg.setPopulation(new ArrayList<Chromosome>());
        alg.setSelected(new ArrayList<Chromosome>());
        alg.setOffsprings(new ArrayList<Chromosome>());
        alg.setReplacer(new GenerationalReplacement());

        alg.setMaximum(3);
        ((BinaryChromosome)chromosome).setLimit(10.0);
        ArrayList<Integer> values = new ArrayList<>();
        values.add(4);
        values.add(6);
        values.add(3);
        ((BinaryChromosome)chromosome).setValue(values);
        ArrayList<Integer> weights = new ArrayList<>();
        weights.add(4);
        weights.add(7);
        weights.add(5);
        ((BinaryChromosome)chromosome).setWeight(weights);

        inputFile();
        alg.init(chromosome);
        alg.run();
        output();
    }
}
