import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Random;

public class GeneticAlgorithm {

    private int minimum = 0, maximum, chromosomeLength, maxGenerations;
    private double crossoverP = 0.4, mutationP = 0.1;
    private ArrayList<Chromosome> population, selected, offsprings;
    private ReplacementStrategy replacer;

    public GeneticAlgorithm()
    {

    }

    public GeneticAlgorithm(int minimum, int maximum, double crossoverP, double mutationP, ArrayList<Chromosome> population, ArrayList<Chromosome> offsprings, ReplacementStrategy replacer) {
        this.minimum = minimum;
        this.maximum = maximum;
        this.crossoverP = crossoverP;
        this.mutationP = mutationP;
        this.population = population;
        this.offsprings = offsprings;
        this.replacer = replacer;
    }

    public int getChromosomeLength() {
        return chromosomeLength;
    }

    public void setChromosomeLength(int chromosomeLength) {
        this.chromosomeLength = chromosomeLength;
    }

    public int getMaxGenerations() {
        return maxGenerations;
    }

    public void setMaxGenerations(int maxGenerations) {
        this.maxGenerations = maxGenerations;
    }

    public int getMinimum() {
        return minimum;
    }

    public void setMinimum(int minimum) {
        this.minimum = minimum;
    }

    public int getMaximum() {
        return maximum;
    }

    public void setMaximum(int maximum) {
        this.maximum = maximum;
    }

    public double getCrossoverP() {
        return crossoverP;
    }

    public void setCrossoverP(double crossoverP) {
        this.crossoverP = crossoverP;
    }

    public double getMutationP() {
        return mutationP;
    }

    public void setMutationP(double mutationP) {
        this.mutationP = mutationP;
    }

    public ArrayList<Chromosome> getPopulation() {
        return population;
    }

    public void setPopulation(ArrayList<Chromosome> population) {
        this.population = population;
    }

    public ArrayList<Chromosome> getSelected() {
        return selected;
    }

    public void setSelected(ArrayList<Chromosome> selected) {
        this.selected = selected;
    }

    public ArrayList<Chromosome> getOffsprings() {
        return offsprings;
    }

    public void setOffsprings(ArrayList<Chromosome> offsprings) {
        this.offsprings = offsprings;
    }

    public ReplacementStrategy getReplacer() {
        return replacer;
    }

    public void setReplacer(ReplacementStrategy replacer) {
        this.replacer = replacer;
    }

    public void init(Chromosome temp)
    {
        for(int i=0; i<maximum; i++)
        {
            temp = temp.init();
            population.add(temp);
        }
        chromosomeLength = population.get(0).genes.size();
    }

    private void selection()
    {
        TreeMap<Double,Chromosome> cumulativetree= new TreeMap<>();
        double range = 0;

        for (Chromosome c : population) {
            if(c.fitness() != 0)
            {
                cumulativetree.put(range, c);
            }
            range += c.fitness();
        }

        Random rand = new Random();
        for(int i=0; i<population.size(); i++)
        {
            double n = rand.nextInt((int)range);
            selected.add(cumulativetree.get(cumulativetree.floorKey(n)));
        }
    }

    private void crossover()
    {
        Random rand = new Random();
        ArrayList<Chromosome> children;
        for(int i=0; i<selected.size(); i+=2)
        {
            if(Math.random() <= crossoverP)
            {
                int index = rand.nextInt(chromosomeLength-1) + 1;
                children = selected.get(i).crossover(selected.get(i+1), index);
                offsprings.add(children.get(0));
                offsprings.add(children.get(1));
            }
            else
            {
                offsprings.add(selected.get(i));
                offsprings.add(selected.get(i+1));
            }
        }
    }

    private void mutation()
    {
        for (Chromosome offspring : offsprings) {
            for (int j = 0; j < chromosomeLength; j++) {
                if (Math.random() <= mutationP)
                    offspring.flip(j);
            }
        }
    }

    private void replacement()
    {
        population = replacer.replace(population, offsprings);
    }

    public void run()
    {
        for(int i=0; i<maxGenerations; i++)
        {
            selection();
            crossover();
            mutation();
            replacement();
        }
    }
}