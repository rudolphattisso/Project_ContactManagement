package fr.afpa.tools;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import fr.afpa.models.Contact;

// Implementation de l'interface
public class ContactvCardSerializer implements Serializer<Contact> {

    public void serialize(Contact contact) {

    }

    // Paramètres : filesPath (chemin du fichier) et objectsToSave (liste d'objets
    // Contact à sauvegarder).
    // Implicitly target all declaration contexts by omitting a @Target annotation
    // @Retention(RetentionPolicy.SOURCE)
    // public @interface SuppressWarnings {
    // Cible implicitement tous les contextes de déclaration en omettant une
    // annotation @Target
    // @Retention(RetentionPolicy.SOURCE)
    // public @interface SuppressWarnings {
    /**
     * L'ensemble des avertissements qui doivent être supprimés par le compilateur
     * dans
     * l'élément annoté. Les noms en double sont autorisés. Les deuxième et
     * suivants occurrences d'un nom sont ignorées. La présence de
     * noms d'avertissements non reconnus n'est <i>pas</i> une erreur : les
     * compilateurs doivent
     * ignorer tous les noms d'avertissements qu'ils ne reconnaissent pas. Ils sont,
     * cependant,
     * libres d'émettre un avertissement si une annotation contient un nom
     * d'avertissement non reconnu.
     * 
     * @return l'ensemble des avertissements à supprimer
     */
    // FileOutputStream et ObjectOutputStream : Similaires à la méthode save.
    // out.writeObject(objectsToSave) : Sérialise la liste d'objets et l'écrit dans
    // le fichier.
    // Gestion des exceptions : Similaire à la méthode save.
    @Override
    public void saveList(String filesPath, @SuppressWarnings("exports") ArrayList<Contact> objectsToSave) {
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
    public void save(String filesPath, Contact contact) {
        /// 1 construire la chaîne de caractères correspondant au contenu vCard
        String vCardContent = "BEGIN:VCARD\nVERSION:4.0" + "\n";

        // Construction du nom
        vCardContent = vCardContent + "N:" + contact.getNom() + ";" + contact.getPrenom() + ";;" + contact.getGenre()
                + ";" + "\n";

        // Construction du "full name"
        vCardContent = vCardContent + "FN:" + contact.getPrenom() + " " + contact.getNom() + "\n";

        // Construction du "birtday"
        vCardContent = vCardContent + "BIRTHDAY:" + contact.getDateDeNAissance() + "\n";

        // Construction du "tel;type=persnum"
        vCardContent = vCardContent + "TEL;TYPE=persnum, voice;VALUE=uri" + contact.getTelPerso() + " "
                + contact.getCodePostale() + "\n";

        // Construction du "tel;type=pronum"
        vCardContent = vCardContent + "TEL;TYPE=worknum, voice; VALUE=uri" + contact.getTelPro() + "\n";

        // Construction du "adress"
        vCardContent = vCardContent + "ADR;TYPE=HOME; PREF=1; LABEL" + contact.getAdresse() + "\n";

        // Construction du "email"
        vCardContent = vCardContent + "EMAIL:" + contact.getMail() + "\n";

        // Construction "link git"
        vCardContent = vCardContent + "LINKGIT:" + contact.getLienGit() + "\n";

        // Construction "END VCARD"
        vCardContent = vCardContent + "END:VCARD";
        // 2 Ecriture de la vCard dans un fichier

        Path path = Paths.get(filesPath);

        // Try block to check for exceptions
        try {
            // Now calling Files.writeString() method
            // with path , content & standard charsets
            Files.writeString(path, vCardContent, StandardCharsets.UTF_8);
        }

        // Catch block to handle the exception
        catch (IOException ex) {
            // Print messqage exception occurred as
            // invalid. directory local path is passed
            System.out.print("Invalid Path");
        }

    }

}
// -----------------------------------------------------------------------------------

// import ezvcard.VCard;
// import ezvcard.VCardVersion;
// import ezvcard.property.StructuredName;
// import ezvcard.property.Telephone;
// import ezvcard.property.Email;
// import ezvcard.io.text.VCardWriter;

// import java.io.FileWriter;
// import java.io.IOException;

// public class ContactvCardSerializer{
// public static void main(String[] args) {
// // Créer une nouvelle vCard
// VCard vcard = new VCard();
// vcard.setFormattedName("John Doe");

// // Ajouter un nom structuré
// StructuredName n = new StructuredName();
// n.setFamily("Lasri");
// n.setGiven("Youssef");
// vcard.setStructuredName(n);

// // Ajouter un numéro de téléphone
// Telephone tel = new Telephone("+33 6 51 71 29 19");
// vcard.addTelephoneNumber(tel);

// // Ajouter une adresse e-mail
// Email email = new Email("Lamazir@gmail.com");
// vcard.addEmail(email);

// // Spécifier la version de vCard (par défaut, c'est 4.0)
// vcard.setVersion(VCardVersion.V4_0);

// // Sauvegarder la vCard dans un fichier
// try (FileWriter writer = new FileWriter("contact.vcf");
// VCardWriter vCardWriter = new VCardWriter(writer)) {
// vCardWriter.write(vcard);
// } catch (IOException e) {
// e.printStackTrace();
// }

// System.out.println("vCard créée avec succès!");
// }
// }