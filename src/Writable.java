interface Writable {
    void saveTree(FamilyTree familyTree, String pathToFileTree);
    FamilyTree loadTree(String pathToFileTree);
}

