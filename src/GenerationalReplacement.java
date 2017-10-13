import java.util.ArrayList;

public class GenerationalReplacement extends ReplacementStrategy {

    @Override
    public ArrayList<Chromosome> replace(ArrayList<Chromosome> selected, ArrayList<Chromosome> offsprings) {
        return offsprings;
    }
}
