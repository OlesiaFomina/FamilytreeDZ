import java.io.Serializable;

import java.util.ArrayList;

import java.util.List;

import java.util.Iterator;

class FamilyTree implements Serializable, Iterable<Human> {
    private List<Human> members;

    public FamilyTree() {
        members = new ArrayList<>();
    }

    public void addMember(Human member) {
        members.add(member);
    }

    public Human findMemberByName(String name) {
        for (Human member : members) {
            if (member.getName().equals(name)) {
                return member;
            }
        }
        return null;
    }

    public void sortByName() {
        members.sort(new HumanComporatorByName());
    }

    public void sortByDob() {
        members.sort(new HumanDobComparator());
    }

    @Override
    public Iterator<Human> iterator() {
        return new FamilyTreeIterator(this);
    }

    public List<Human> getMembers() {
        return members;
    }
}



