import java.time.LocalDate;
import java.util.Scanner;

class FamilyTreePresenter {
    private FamilyTree<Human> familyTree;

    public FamilyTreePresenter(FamilyTree<Human> familyTree) {
        this.familyTree = familyTree;
    }

    // Добавление члена семьи
    public void addMember() {
        Scanner scanner = new Scanner(System.in);

        // Ввод данных о новом человеке
        System.out.print("Введите имя: ");
        String name = scanner.nextLine();
        System.out.print("Введите дату рождения (ГГГГ-ММ-ДД): ");
        LocalDate dob = LocalDate.parse(scanner.nextLine());
        System.out.print("Введите пол (MALE/FEMALE): ");
        Gender gender = Gender.valueOf(scanner.nextLine().toUpperCase());

        // Создание нового объекта Human
        Human newMember = new Human(name, dob, null, gender);

        // Добавление нового члена в древо
        familyTree.addMember(newMember);

        System.out.println("Новый член семьи добавлен.");
    }

    // Поиск человека
    public void findMember() {
        Scanner scanner = new Scanner(System.in);

        // Запрос имени для поиска
        System.out.print("Введите ФИО человека: ");
        String nameToFind = scanner.nextLine();

        // Поиск человека в древе
        Human foundPerson = familyTree.findMemberByName(nameToFind);

        // Вывод информации о найденном человеке
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
                for (Human child : foundPerson.getChildren()) {
                    System.out.println("- " + child.getName());
                }
            }
        } else {
            System.out.println("Человек не найден.");
        }
    }

    // Обновление данных о человеке
    public void updateMember() {
        Scanner scanner = new Scanner(System.in);

        // Запрос имени для поиска человека
        System.out.print("Введите ФИО человека: ");
        String nameToFind = scanner.nextLine();

        // Поиск человека в древе
        Human memberToUpdate = familyTree.findMemberByName(nameToFind);

        if (memberToUpdate != null) {
            // Запрос новых данных
            System.out.print("Введите новое имя (оставьте пустым, если не хотите изменять): ");
            String newName = scanner.nextLine();
            if (!newName.isEmpty()) {
                memberToUpdate.setName(newName);
            }
            System.out.print("Введите новую дату рождения (ГГГГ-ММ-ДД) (оставьте пустым, если не хотите изменять): ");
            String newDobStr = scanner.nextLine();
            if (!newDobStr.isEmpty()) {
                memberToUpdate.setDob(LocalDate.parse(newDobStr));
            }

            System.out.println("Данные о человеке обновлены.");
        } else {
            System.out.println("Человек не найден.");
        }
    }
}