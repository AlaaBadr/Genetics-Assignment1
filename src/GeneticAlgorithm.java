import java.lang.reflect.Array;
import java.util.ArrayList;

public class GeneticAlgorithm {

    double minimum = 0.0, maximum, crossoverP = 0.4, mutationP = 0.1;
    ArrayList<Chromosome> population;
    ArrayList<Chromosome> offsprings;
    ReplacementStrategy replacer;

    public GeneticAlgorithm(double minimum, double maximum, double crossoverP, double mutationP, ArrayList<Chromosome> population, ArrayList<Chromosome> offsprings, ReplacementStrategy replacer) {
        this.minimum = minimum;
        this.maximum = maximum;
        this.crossoverP = crossoverP;
        this.mutationP = mutationP;
        this.population = population;
        this.offsprings = offsprings;
        this.replacer = replacer;
    }

    public double getMinimum() {
        return minimum;
    }

    public void setMinimum(double minimum) {
        this.minimum = minimum;
    }

    public double getMaximum() {
        return maximum;
    }

    public void setMaximum(double maximum) {
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

    public void replacement()
    {
        population = replacer.replace(population, offsprings);
    }

    public static void main(String[] args) {
        // write your code here
    }
}