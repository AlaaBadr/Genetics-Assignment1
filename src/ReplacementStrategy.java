import java.util.ArrayList;

public abstract class ReplacementStrategy {

    public abstract ArrayList<Chromosome> replace(ArrayList<Chromosome> selected, ArrayList<Chromosome> offsprings);
}