
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


class FamilyTree implements Serializable {
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
}