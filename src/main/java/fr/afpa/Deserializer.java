package fr.afpa;

import java.util.ArrayList;

// 
public interface Deserializer<T> {
    
   
public abstract  void load(String filePath);

public abstract ArrayList<T> loadList(String filePath);


}
