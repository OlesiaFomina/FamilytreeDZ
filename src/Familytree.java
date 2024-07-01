import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

class FamilyTree <T extends Named> implements Serializable, Iterable<T> {
    private List<T> members;

    public FamilyTree() {
        members = new ArrayList<>();
    }

    public void addMember(T member) {
        members.add(member);
    }

    public T findMemberByName(String name) {
        for (T  member : members) {
            if (member.getName().equals(name)) {
                return member;
            }
        }
        return null;
    }


    @Override
    public Iterator<T> iterator() {
        return new FamilyTreeIterator<>(this);
    }

    public List<T> getMembers() {
        return members;
    }
}



