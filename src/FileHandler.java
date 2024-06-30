

import java.io.*;

public class FileHandler implements Writable {
    @Override
    public void saveTree(FamilyTree familyTree, String pathToFileTree) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(pathToFileTree))) {
            objectOutputStream.writeObject(familyTree);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public FamilyTree loadTree(String pathToFileTree) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(pathToFileTree))) {
            return (FamilyTree) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
