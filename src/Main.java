import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.*;





public class Main {
    public static void main(String[] args) throws IOException {
        String pathToFileTree = "src/family_tree.dat";


        Human father = new Human("Фомин Валерий Борисович", LocalDate.of(1976, 2, 14), null, Gender.MALE);
        Human mother = new Human("Тимошкова Юлия Александровна", LocalDate.of(1978, 6, 1), null, Gender.FEMALE);

        Human grandfatherFather = new Human("Фомин Борис Алексеевич", LocalDate.of(1953, 2, 17), null, Gender.MALE);
        Human grandmotherFather = new Human("Фомина Ольга Александровна", LocalDate.of(1955, 3, 30), null, Gender.FEMALE);

        Human grandfatherMother = new Human("Тимошков Александр Алексеевич", LocalDate.of(1955, 2, 20), null, Gender.MALE);
        Human grandmotherMother = new Human("Горланова Ольга Бориславовна", LocalDate.of(1957, 3, 10), LocalDate.of(1982, 1, 1), Gender.FEMALE);

        father.setFather(grandfatherFather);
        father.setMother(grandmotherFather);
        mother.setFather(grandfatherMother);
        mother.setMother(grandmotherMother);

        Human child1 = new Human("Фомина Олеся Валерьевна", LocalDate.of(2003, 5, 4), null, Gender.FEMALE);
        Human child2 = new Human("Фомина Анастасия Валерьевна", LocalDate.of(2008, 12, 6), null, Gender.FEMALE);
        Human child3 = new Human("Ануфриева Ника Дмитриевна", LocalDate.of(2015, 1, 26), null, Gender.FEMALE);
        Human child4 = new Human("Ануфриев Дарий Дмитриевич", LocalDate.of(2022, 9, 9), null, Gender.MALE);

        father.addChild(child1);
        father.addChild(child2);
        mother.addChild(child1);
        mother.addChild(child2);
        mother.addChild(child3);
        mother.addChild(child4);


        FamilyTree<Human> familyTree = new FamilyTree<>();
        familyTree.addMember(father);
        familyTree.addMember(mother);
        familyTree.addMember(grandfatherFather);
        familyTree.addMember(grandmotherFather);
        familyTree.addMember(grandfatherMother);
        familyTree.addMember(grandmotherMother);
        familyTree.addMember(child1);
        familyTree.addMember(child2);
        familyTree.addMember(child3);
        familyTree.addMember(child4);

        // Сохранение древа\
        FileHandler fileHandler = new FileHandler();
        fileHandler.saveTree(familyTree, "family_tree.dat");

        // Загрузка древа
        FamilyTree<Human> loadedTree = fileHandler.loadTree("family_tree.dat");

        // Поиск человека с помощью ввода пользователя
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите ФИО человека: ");
        String nameToFind = scanner.nextLine();

        Human foundPerson = loadedTree.findMemberByName(nameToFind);
        if (foundPerson != null) {
            System.out.println("Найден: " + foundPerson.getName());
            System.out.println("Дата рождения: " + foundPerson.getDob());
            if (foundPerson.getFather() != null) {
                System.out.println("Отец: " + foundPerson.getFather().getName());
            }
            if (foundPerson.getMother() != null) {
                System.out.println("Мать: " + foundPerson.getMother().getName());
            }
            if (!foundPerson.getChildren().isEmpty()) {
                System.out.println("Дети:");
                // Сортировка детей по имени
                List<Human> sortedChildren = new ArrayList<>(foundPerson.getChildren());
                sortedChildren.sort(new HumanComporatorByName());
                for (Human child : sortedChildren) {
                    System.out.println("- " + child.getName());
                }
                // Сортировка детей по дате рождения
                sortedChildren.sort(new HumanDobComparator());
                System.out.println("\n Дети, отсортированные по дате рождения:");
                for (Human child : sortedChildren) {
                    System.out.println("- " + child.getName() + " (" + child.getDob() + ")");
                }

                // Использование FamilyTreeIterator
                System.out.println("\n Использование FamilyTreeIterator:");
                for (Human member : loadedTree) {
                    System.out.println(member.getName());
                }
            } else {
                System.out.println("Человек не найден.");
            }
            scanner.close();
        }
    }
}
