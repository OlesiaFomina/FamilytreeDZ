import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class Human {
    private String name;
    private LocalDate dob;
    private LocalDate dod;
    private List<Human> children;
    private Human father;
    private Human mother;
    private Gender gender;

    public Human(String name, LocalDate dob, LocalDate dod, Gender gender) {
        this.name = name;
        this.dob = dob;
        this.dod = dod;
        this.gender = gender;
        this.children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }
    public LocalDate getDob() {
        return dob;
    }

    public void addChild(Human child) {
        children.add(child);
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public Human getFather() {
        return father;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getMother() {
        return mother;
    }
}

