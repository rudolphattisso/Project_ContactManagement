package fr.afpa.tools;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import fr.afpa.models.Contact;

public class ContactJsonSerializer implements Serializer<Contact>{

    @Override
    public void saveList(String filesPath, ArrayList<Contact> objectsToSave) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveList'");
    }

    @Override
    public void save(String filePath, Contact objet) {
        // TODO Auto-generated method stub
//         try {
//             FileOutputStream fos = new FileOutputStream(fileName);
//             ObjectOutputStream oos = new ObjectOutputStream(fos);
//             // sérialisation : écriture de l'objet dans le flux de sortie
//             oos.writeObject(contactToSerialize);
//             // on vide le tampon
//             oos.flush();
//             System.out.println(contactToSerialize + " a ete serialise");
//             oos.close();
//             fos.close();
//         } catch (IOException ioe) {
//             ioe.printStackTrace();
//         }
//         throw new UnsupportedOperationException("Unimplemented method 'save'");
    
      
}

}
