import java.util.Comparator;

public class HumanDobComparator implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return o1.getDob().compareTo(o2.getDob());
    }
}