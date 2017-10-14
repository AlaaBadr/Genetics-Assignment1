import java.util.ArrayList;
import java.util.Random;

public class BinaryChromosome extends Chromosome<Integer> {


    private Random random = new Random();
    private int length = 0;
    static ArrayList<Integer> value = new ArrayList();
    static ArrayList<Integer> weight = new ArrayList();
    static double limit = 200;


    BinaryChromosome(int length) {
        this.length = length;
    }


    @Override
    public Chromosome init() {              // initializes the ArrayList of genes with random values

        genes.clear();

        for (int counter = 0; counter < length; ++counter) {
            if (random.nextInt(10) < 5)
                genes.add(0);
            else
                genes.add(1);
        }

        Chromosome<Integer> chromosome = new BinaryChromosome(length);
        chromosome.genes = this.genes;


        return chromosome;
    }

    @Override
    public double fitness() {               // calculates the value of a solution
        double valueSum = 0, weightSum = 0;

        for (int counter = 0; counter < genes.size(); ++counter) {
            if (genes.get(counter) > 0) {
                valueSum += value.get(counter);
                weightSum += weight.get(counter);
            }

            if (weightSum > limit) return 0;

        }
        return valueSum;
    }

    @Override
    public void flip(int index) {           // flips the value 0/1 in a specific index
        if (genes.get(index) == 1)
            genes.set(index, 0);
        else
            genes.set(index, 1);
    }
}
