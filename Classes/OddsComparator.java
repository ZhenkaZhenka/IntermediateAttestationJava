package Classes;

import java.util.Comparator;

public class OddsComparator implements Comparator<Toy> {

    @Override
    public int compare(Toy t1, Toy t2){
        return Integer.compare(t2.getOdds(), t1.odds);
    }

}
