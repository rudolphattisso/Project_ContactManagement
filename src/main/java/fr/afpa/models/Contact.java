package fr.afpa.models;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.afpa.App;
import javafx.beans.property.SimpleStringProperty;

import java.io.Serializable;

public class Contact implements Serializable {

    private static Logger logger = LogManager.getLogger(App.class);

    private SimpleStringProperty nom;
    private String prenom;
    private String genre;
    private String dateDeNAissance;
    private String pseudo;
    private String adresse;
    private String telPerso;
    private String telPro;
    private String mail;
    private String codePostale;
    private String lienGit;

    public Contact(String nom, String prenom, String genre, String dateDeNAissance, String pseudo, String adresse,
            String telPerso, String telPro, String mail, String codePostale, String lienGit) {
        this.nom = new SimpleStringProperty(nom);
        this.prenom = prenom;
        this.genre = genre;
        this.dateDeNAissance = dateDeNAissance;
        this.pseudo = pseudo;
        this.adresse = adresse;
        this.telPerso = telPerso;
        this.telPro = telPro;
        this.mail = mail;
        this.codePostale = codePostale;
        this.lienGit = lienGit;
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
        return prenom;
    }

    public String getGenre() {
        return genre;
    }

    public String getDateDeNAissance() {
        return dateDeNAissance;
    }

    public String getPseudo() {
        return pseudo;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getTelPerso() {
        return telPerso;
    }

    public String getTelPro() {
        return telPro;
    }

    public String getMail() {
        return mail;
    }

    public String getCodePostale() {
        return codePostale;
    }

    public String getLienGit() {
        return lienGit;
    }

    // Setters
    public void setNom(String nom) {
        this.nom.setValue(nom); // changer la valeur du string property
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setDateDeNAissance(String dateDeNAissance) {
        this.dateDeNAissance = dateDeNAissance;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setTelPerso(String telPerso) {
        this.telPerso = telPerso;
    }

    public void setTelPro(String telPro) {
        this.telPro = telPro;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setCodePostale(String codePostale) {
        this.codePostale = codePostale;
    }

    public void setLienGit(String lienGit) {
        this.lienGit = lienGit;
    }

}
