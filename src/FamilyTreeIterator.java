import java.util.Iterator;
import java.util.NoSuchElementException;

class FamilyTreeIterator implements Iterator<Human> {
    private FamilyTree familyTree;
    private int currentIndex = 0;

    public FamilyTreeIterator(FamilyTree familyTree) {
        this.familyTree = familyTree;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < familyTree.getMembers().size();
    }

    @Override
    public Human next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return familyTree.getMembers().get(currentIndex++);
    }
}