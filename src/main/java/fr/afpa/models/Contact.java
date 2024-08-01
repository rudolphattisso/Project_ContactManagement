package fr.afpa.models;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.afpa.App;
import javafx.beans.property.SimpleStringProperty;

import java.io.Serializable;

public class Contact implements Serializable {

    private static Logger logger = LogManager.getLogger(App.class);

    private SimpleStringProperty nom;
    private SimpleStringProperty prenom;
    private SimpleStringProperty genre;
    private SimpleStringProperty dateDeNAissance;
    private SimpleStringProperty pseudo;
    private SimpleStringProperty adresse;
    private SimpleStringProperty telPerso;
    private SimpleStringProperty telPro;
    private SimpleStringProperty mail;
    private SimpleStringProperty codePostale;
    private SimpleStringProperty lienGit;

    public Contact(String nom, String prenom, String genre, String dateDeNAissance, String pseudo, String adresse,
            String telPerso, String telPro, String mail, String codePostale, String lienGit) {
        this.nom = new SimpleStringProperty(nom);
        this.prenom = new SimpleStringProperty(prenom);
        this.genre = new SimpleStringProperty (genre);
        this.dateDeNAissance = new SimpleStringProperty(dateDeNAissance) ;
        this.pseudo = new SimpleStringProperty (pseudo);
        this.adresse = new SimpleStringProperty (adresse) ;
        this.telPerso = new SimpleStringProperty (telPerso) ;
        this.telPro = new SimpleStringProperty (telPro) ;
        this.mail = new SimpleStringProperty (mail) ;
        this.codePostale = new SimpleStringProperty (codePostale) ;
        this.lienGit = new SimpleStringProperty (lienGit) ;
    }

    @Override
    public String toString() {
        return "Contact [nom=" + nom + ", prenom=" + prenom + ", genre=" + genre + ", dateDeNAissance="
                + dateDeNAissance + ", pseudo=" + pseudo + ", adresse=" + adresse + ", telPerso=" + telPerso
                + ", telPro=" + telPro + ", mail=" + mail + ", codePostale=" + codePostale + ", lienGit=" + lienGit
                + "]";
    }

    // getters
    public String getNom() {
        return nom.getValue();// pour obtenir un String; car l'attribut à été déclaré en SimpleString Property.
    }
    public SimpleStringProperty getNomProperty() {
        return nom;// pour obtenir  SimpleString Property.
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

    public String getDateDeNAissance() {
        return dateDeNAissance.getValue();
    }
    
    public SimpleStringProperty getDateDeNAissanceProperty() {
        return dateDeNAissance;
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

    public void setDateDeNAissance(SimpleStringProperty dateDeNAissance) {
        this.dateDeNAissance = dateDeNAissance;
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

}
