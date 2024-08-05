package fr.afpa.tools;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import fr.afpa.models.Contact;

public class ContactBinarySerializer implements Serializer<Contact>, Deserializer<Contact> {

    public static void serialize(Contact contactToSerialize, String fileName) {
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            // sérialisation : écriture de l'objet dans le flux de sortie
            oos.writeObject(contactToSerialize);
            // on vide le tampon
            oos.flush();
            System.out.println(contactToSerialize + " a ete serialise");
            oos.close();
            fos.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static void deserialize(Contact contactToDeserialize, String fileName) {
        try (FileInputStream fileIn = new FileInputStream(fileName);
                ObjectInputStream in = new ObjectInputStream(fileIn)) {
            contactToDeserialize = (Contact) in.readObject();
            System.out.println("La désérialisation est terminée. Objet : " + contactToDeserialize);
        } catch (FileNotFoundException fnf) {
            System.err.println("Le fichier n'a pas été trouvé.");
        } catch (EOFException eof) {
            System.err.println("Fin de fichier atteinte.");
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Classe Personne introuvable.");
            c.printStackTrace();
        }

    }

    @Override
    public String load(String filePath) {

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
        Contact contact = new Contact("rud", "Ati", "M", "13/08/1990", "RANA", "Bordeaux", "0694644522", "",
                "rudati@gmail.com", "41800", "https://github.com/d9shboard");
        Contact.serialize(contact, "contactu");
    }

}
