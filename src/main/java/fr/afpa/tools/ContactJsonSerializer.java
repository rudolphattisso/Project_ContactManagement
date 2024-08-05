package fr.afpa.tools;

import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;

import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;

import fr.afpa.models.Contact;

public class ContactJsonSerializer implements Serializer<Contact> {

    // Sauvegarder une liste contacts dans un fichier JSON
    @Override
    public void saveList(String filesPath, ArrayList<Contact> contactsToSave) {
        // JSON String

        JsonArray contactsJsonArray = new JsonArray(contactsToSave);

        try (FileWriter fileWriter = new FileWriter("contacts.json")) {

            Jsoner.serialize(contactsJsonArray, fileWriter);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Sauvegarder un seul contact dans un fichier JSON
     */
    @Override
    public void save(String filePath, Contact contact) {


        try (FileWriter fileWriter = new FileWriter(filePath)) {

            Jsoner.serialize(contact, fileWriter);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
