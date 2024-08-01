package fr.afpa.tools;

import java.util.ArrayList;

import fr.afpa.models.Contact;

public class ContactBinarySerializer implements Serializer<Contact>, Deserializer<Contact>{

    @Override
    public String load(String filePath) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'load'");
    }

    @Override
    public ArrayList<Contact> loadList(String filePath) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'loadList'");
    }

    @Override
    public void saveList(String filesPath, ArrayList<Contact> objectsToSave) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveList'");
    }

    @Override
    public void save(String filePath, Contact objet) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    
}
