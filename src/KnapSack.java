import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class KnapSack {

    private static GeneticAlgorithm alg;
    private static Chromosome chromosome;

    private static void inputFile(Scanner input)
    {
        ArrayList<Integer> values = new ArrayList<>();
        ArrayList<Integer> weights = new ArrayList<>();

        chromosome.setLength(input.nextInt());
        ((BinaryChromosome)chromosome).setLimit(input.nextInt());

        for(int i=0; i<chromosome.getLength(); i++)
        {
            weights.add(input.nextInt());
            values.add(input.nextInt());
        }

        ((BinaryChromosome)chromosome).setWeight(weights);
        ((BinaryChromosome)chromosome).setValue(values);
    }

    private static void output()
    {
        //Collections.sort(alg.getPopulation(), Comparator.comparingDouble(Chromosome::fitness));
        double maxValue = 0;
        Chromosome best = null;
        for(Chromosome c: alg.getPopulation() )
        {
            if(c.fitness()>maxValue)
            {
                maxValue = c.fitness();
                best = c;
            }
        }
        System.out.println(best.fitness());
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("input_exp.txt"));
        int test_cases = input.nextInt();

        for(int i=0; i<test_cases; i++)
        {
            chromosome = new BinaryChromosome();
            alg = new GeneticAlgorithm();
            alg.setPopulation(new ArrayList<Chromosome>());
            alg.setSelected(new ArrayList<Chromosome>());
            alg.setOffsprings(new ArrayList<Chromosome>());
            alg.setReplacer(new GenerationalReplacement());

            inputFile(input);
            alg.init(chromosome);
            alg.run();
            System.out.print("Case "+(i+1)+": ");
            output();
        }
        input.close();
    }
}
