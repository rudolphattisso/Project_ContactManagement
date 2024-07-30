package fr.afpa;

import java.util.ArrayList;

public interface Serializer<T> {

    public abstract void saveList(String filesPath, ArrayList<T> objectsToSave);
    public abstract void save(String filePath, T objet);
}