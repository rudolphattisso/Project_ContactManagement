package fr.afpa.models;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsonable;

import fr.afpa.App;
import javafx.beans.property.SimpleStringProperty;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.Writer;

public class Contact implements Serializable, Jsonable {

    private static Logger logger = LogManager.getLogger(App.class);

    // SimpleStringProperty est utilisé pour mettre automiquement l'interface
    // graphique à jour(TableView) à chaque modification de la String
    private SimpleStringProperty nom;
    private SimpleStringProperty prenom;
    private SimpleStringProperty genre;
    private SimpleStringProperty dateDeNaissance;
    private SimpleStringProperty pseudo;
    private SimpleStringProperty adresse;
    private SimpleStringProperty telPerso;
    private SimpleStringProperty telPro;
    private SimpleStringProperty mail;
    private SimpleStringProperty codePostale;
    private SimpleStringProperty lienGit;

    public Contact(String nom, String prenom,
            String genre, String dateDeNaissance,
            String pseudo, String adresse,
            String telPerso, String telPro,
            String mail, String codePostale,
            String lienGit) {

        this.nom = new SimpleStringProperty(nom);
        this.prenom = new SimpleStringProperty(prenom);
        this.genre = new SimpleStringProperty(genre);
        this.dateDeNaissance = new SimpleStringProperty(dateDeNaissance);
        this.pseudo = new SimpleStringProperty(pseudo);
        this.adresse = new SimpleStringProperty(adresse);
        this.telPerso = new SimpleStringProperty(telPerso);
        this.telPro = new SimpleStringProperty(telPro);
        this.mail = new SimpleStringProperty(mail);
        this.codePostale = new SimpleStringProperty(codePostale);
        this.lienGit = new SimpleStringProperty(lienGit);
    }

    @Override
    public String toString() {
        return "Contact [nom=" + nom + ", prenom=" + prenom + ", genre=" + genre + ", dateDeNAissance="
                + dateDeNaissance + ", pseudo=" + pseudo + ", adresse=" + adresse + ", telPerso=" + telPerso
                + ", telPro=" + telPro + ", mail=" + mail + ", codePostale=" + codePostale + ", lienGit=" + lienGit
                + "]";
    }

    // getters
    public String getNom() {
        return nom.getValue();// pour obtenir un String; car l'attribut à été déclaré en SimpleString
                              // Property.
    }

    public SimpleStringProperty getNomProperty() {
        return nom;// pour obtenir SimpleString Property.
    }

    public String getPrenom() {
        return prenom.getValue();
    }

    public SimpleStringProperty getPrenomProperty() {
        return prenom;
    }

    public String getGenre() {
        return genre.getValue();
    }

    public SimpleStringProperty getGenreProperty() {
        return genre;
    }

    public String getDateDeNaissance() {
        return dateDeNaissance.getValue();
    }

    public SimpleStringProperty getDateDeNAissanceProperty() {
        return dateDeNaissance;
    }

    public String getPseudo() {
        return pseudo.getValue();
    }

    public SimpleStringProperty getPseudoProperty() {
        return pseudo;
    }

    public String getAdresse() {
        return adresse.getValue();
    }

    public SimpleStringProperty getAdresseProperty() {
        return adresse;
    }

    public String getTelPerso() {
        return telPerso.getValue();
    }

    public SimpleStringProperty getTelPersoProperty() {
        return telPerso;
    }

    public String getTelPro() {
        return telPro.getValue();
    }

    public SimpleStringProperty getTelProProperty() {
        return telPro;
    }

    public String getMail() {
        return mail.getValue();
    }

    public SimpleStringProperty getMailProperty() {
        return mail;
    }

    public String getCodePostale() {
        return codePostale.getValue();
    }

    public SimpleStringProperty getCodePostaleProperty() {
        return codePostale;
    }

    public String getLienGit() {
        return lienGit.getValue();
    }

    public SimpleStringProperty getLienGitProperty() {
        return lienGit;
    }

    // Setters
    public void setNom(String nom) {
        this.nom.setValue(nom); // changer la valeur du string property
    }

    public void setPrenom(SimpleStringProperty prenom) {
        this.prenom = prenom;
    }

    public void setGenre(SimpleStringProperty genre) {
        this.genre = genre;
    }

    public void setDateDeNaissance(SimpleStringProperty dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }

    public void setPseudo(SimpleStringProperty pseudo) {
        this.pseudo = pseudo;
    }

    public void setAdresse(SimpleStringProperty adresse) {
        this.adresse = adresse;
    }

    public void setTelPerso(SimpleStringProperty telPerso) {
        this.telPerso = telPerso;
    }

    public void setTelPro(SimpleStringProperty telPro) {
        this.telPro = telPro;
    }

    public void setMail(SimpleStringProperty mail) {
        this.mail = mail;
    }

    public void setCodePostale(SimpleStringProperty codePostale) {
        this.codePostale = codePostale;
    }

    public void setLienGit(SimpleStringProperty lienGit) {
        this.lienGit = lienGit;
    }

    public static void serialize(Contact contact, String string) {
        throw new UnsupportedOperationException("Unimplemented method 'serialize'");
    }

    @Override
    public String toJson() {
        throw new UnsupportedOperationException("Unimplemented method 'toJson'");
    }

    @Override
    public void toJson(Writer writable) throws IOException {

        JsonObject jsonObject = new JsonObject();
        jsonObject.put("nom", this.getNom());
        jsonObject.put("prénom", this.getPrenom());
        jsonObject.put("genre", this.getGenre());
        jsonObject.put("date de naissance", this.getDateDeNaissance());
        jsonObject.put("pseudo", this.getPseudo());
        jsonObject.put("adresse", this.getAdresse());
        jsonObject.put("telPerso", this.getTelPerso());
        jsonObject.put("mail", this.getMail());
        jsonObject.put("code Postale", this.getCodePostale());
        jsonObject.put("lienGit", this.getLienGit());

        jsonObject.toJson(writable);
    }

    private void writeObject(ObjectOutputStream oos) throws IOException {

        oos.writeObject(nom.getValue());
        oos.writeObject(prenom.getValue());
        oos.writeObject(genre.getValue());
        oos.writeObject(dateDeNaissance.getValue());
        oos.writeObject(pseudo.getValue());
        oos.writeObject(adresse.getValue());
        oos.writeObject(telPerso.getValue());
        oos.writeObject(telPro.getValue());
        oos.writeObject(mail.getValue());
        oos.writeObject(codePostale.getValue());
        oos.writeObject(lienGit.getValue());

    }

    private void readObject(ObjectInputStream in) throws IOException {

        try {

            nom = new SimpleStringProperty((String) in.readObject());
            prenom = new SimpleStringProperty((String) in.readObject());
            genre = new SimpleStringProperty((String) in.readObject());
            dateDeNaissance = new SimpleStringProperty((String) in.readObject());
            pseudo = new SimpleStringProperty((String) in.readObject());
            adresse = new SimpleStringProperty((String) in.readObject());
            telPerso = new SimpleStringProperty((String) in.readObject());
            telPro = new SimpleStringProperty((String) in.readObject());
            mail = new SimpleStringProperty((String) in.readObject());
            codePostale = new SimpleStringProperty((String) in.readObject());
            lienGit = new SimpleStringProperty((String) in.readObject());
            
        } catch (ClassNotFoundException e) {
            logger.debug(e.getMessage());
        } 
    }

}
