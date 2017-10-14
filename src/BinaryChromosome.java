import java.util.ArrayList;
import java.util.Random;

public class BinaryChromosome extends Chromosome<Integer> {


    static double limit = 200;
    private Random random = new Random();
    private int length = 0;
    ArrayList<Integer> value = new ArrayList<>(length);
    ArrayList<Integer> weight = new ArrayList<>(length);


    BinaryChromosome(int length) {
        this.length = length;
    }


    @Override
    public Chromosome init() {              // initializes the ArrayList of genes with random values


        for (int counter = 0; counter < length; ++counter) {
            if (random.nextInt(10) < 5)
                genes.add(0);
            else
                genes.add(1);
        }
        return this;
    }

    @Override
    public double fitness() {               // calculates the value of the solution
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
