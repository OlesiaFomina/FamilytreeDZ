import java.io.Serializable;

interface Writable <T extends Named>  {
    void saveTree(FamilyTree<T> familyTree, String pathToFileTree);
    FamilyTree<T> loadTree(String pathToFileTree);
}

