import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class FamilyTree {
    private List<Human> members;

    public FamilyTree() {
        members = new ArrayList<>();
    }

    public void addMember(Human member) {
        members.add(member);
    }

    public Human findMember(String name, LocalDate dob, String fatherName, String motherName) {
        for (Human member : members) {
            if (member.getName().equals(name) && member.getDob().equals(dob)
                    && ((member.getFather() != null && member.getFather().getName().equals(fatherName))
                    || (fatherName == null && member.getFather() == null))
                    && ((member.getMother() != null && member.getMother().getName().equals(motherName))
                    || (motherName == null && member.getMother() == null))) {
                return member;
            }
        }
        return null;
    }
}
