import java.util.ArrayList;
import java.util.Random;

public class BinaryChromosome extends Chromosome<Integer> {


    private Random random = new Random();
    private int length = 0;
    private static ArrayList<Integer> value = new ArrayList();
    private static ArrayList<Integer> weight = new ArrayList();
    private static double limit = 200;

    BinaryChromosome() {}

    BinaryChromosome(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public static double getLimit() {
        return limit;
    }

    public static void setLimit(double limit) {
        BinaryChromosome.limit = limit;
    }

    public static ArrayList<Integer> getValue() {
        return value;
    }

    public static void setValue(ArrayList<Integer> value) {
        BinaryChromosome.value = value;
    }

    public static ArrayList<Integer> getWeight() {
        return weight;
    }

    public static void setWeight(ArrayList<Integer> weight) {
        BinaryChromosome.weight = weight;
    }

    @Override
    public Chromosome init() {              // initializes the ArrayList of genes with random values

        genes = new ArrayList<Integer>();

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
