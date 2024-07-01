

import java.io.*;

public class FileHandler <T extends Named> implements Writable <T> {
    @Override
    public void saveTree(FamilyTree <T> familyTree, String pathToFileTree) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(pathToFileTree))) {
            objectOutputStream.writeObject(familyTree);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public FamilyTree <T> loadTree(String pathToFileTree) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(pathToFileTree))) {
            return (FamilyTree<T>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
