package fr.afpa.tools;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Paths;
import java.util.ArrayList;

import fr.afpa.models.Contact;

public class ContactBinarySerializer implements Serializer<Contact>, Deserializer<Contact> {

    @Override
    public void saveList(String filePath, ArrayList<Contact> contactlistViewToSerialize) {
        try {

            FileOutputStream fos = new FileOutputStream(filePath);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            // sérialisation : écriture de l'objet dans le flux de sortie
            oos.writeObject(contactlistViewToSerialize);
            // on vide le tampon
            oos.flush();
            System.out.println(contactlistViewToSerialize + " a ete serialise");
            oos.close();
            fos.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }

    @Override
    public void save(String filePath, Contact contactToSerialize) {
        try {
            FileOutputStream fos = new FileOutputStream(filePath);
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

    @Override
    public ArrayList<Contact> loadList(String filePath) {
        ArrayList<Contact> deserializeList = null;
        try (FileInputStream fileIn = new FileInputStream(filePath);
                ObjectInputStream in = new ObjectInputStream(fileIn)) {
            deserializeList = (ArrayList<Contact>) in.readObject();
            System.out.println("La désérialisation est terminée. Objet : " + deserializeList);
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
        return deserializeList;
    }

    @Override
    public Contact load(String filePath) {
        Contact deserializeContact = null;
        try (FileInputStream fileIn = new FileInputStream(filePath);
                ObjectInputStream in = new ObjectInputStream(fileIn)) {
            deserializeContact = (Contact) in.readObject();
            System.out.println("La désérialisation est terminée. Objet : " + deserializeContact);
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
        return deserializeContact;
    }

}

