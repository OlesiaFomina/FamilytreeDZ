import java.util.Iterator;
import java.util.NoSuchElementException;

class FamilyTreeIterator<T extends Named> implements Iterator<T> {
    private FamilyTree<T> familyTree;
    private int currentIndex = 0;

    public FamilyTreeIterator(FamilyTree<T> familyTree) {

        this.familyTree = familyTree;
    }

    @Override
    public boolean hasNext() {

        return currentIndex < familyTree.getMembers().size();
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return familyTree.getMembers().get(currentIndex++);
    }
}