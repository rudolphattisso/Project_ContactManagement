package fr.afpa.controllers;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import fr.afpa.models.Contact;
import fr.afpa.tools.Serializer;

// Implementation de l'interface
public class ContactvCardSerializer implements Serializer<Contact> {
    // Paramètres : filesPath (chemin du fichier) et objectsToSave (liste d'objets
    // Contact à sauvegarder).
    // FileOutputStream et ObjectOutputStream : Similaires à la méthode save.
    // out.writeObject(objectsToSave) : Sérialise la liste d'objets et l'écrit dans
    // le fichier.
    // Gestion des exceptions : Similaire à la méthode save.
    @Override
    public void saveList(String filesPath, ArrayList<Contact> objectsToSave) {
        try (FileOutputStream fileOut = new FileOutputStream(filesPath);
                ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(objectsToSave);
            System.out.println("List of contacts has been saved to " + filesPath);
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    /**
     * Elle sauvegarde un contact dans un fichier vCard
     */
    // @Override
    // public void save(String filesPath, Contact objet) {
    // // Creating an instance of file
    // Path path
    // = Paths.get(filesPath);

    // // Custom string as an input
    // String str = "Geeks for Geeks \nWelcome to computer science portal \nHello
    // Geek";

    // // Try block to check for exceptions
    // try {
    // // Now calling Files.writeString() method
    // // with path , content & standard charsets
    // Files.writeString(path, str, StandardCharsets.UTF_8);
    // }

    // // Catch block to handle the exception
    // catch (IOException ex) {
    // // Print messqage exception occurred as
    // // invalid. directory local path is passed
    // System.out.print("Invalid Path");
    // }
    // }

    // -----------------------------------------------------------------------------

    // Paramètres : filesPath (chemin du fichier) et object (objet Contact à
    // sauvegarder).
    // FileOutputStream : Crée un flux de sortie pour écrire des octets dans un
    // fichier spécifié par filesPath.
    // ObjectOutputStream : Enveloppe le FileOutputStream et permet la sérialisation
    // de l'objet.
    // out.writeObject(object) : Sérialise l'objet et l'écrit dans le fichier.
    // Gestion des exceptions : try-with-resources pour fermer automatiquement les
    // flux et catch pour capturer et imprimer les erreurs d'entrée/sortie.
    @Override
    public void save(String filesPath, Contact object) {
        try (FileOutputStream fileOut = new FileOutputStream(filesPath);
                ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(object);
            System.out.println("Contact has been saved to " + filesPath);
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

}
