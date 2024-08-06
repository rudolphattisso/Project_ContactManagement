package fr.afpa.controllers;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.afpa.App;
import fr.afpa.models.Contact;
import fr.afpa.tools.ContactBinarySerializer;
import fr.afpa.tools.ContactJsonSerializer;
import fr.afpa.tools.VerificationMail;
import fr.afpa.tools.VerificationUrl;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ContactManagementController {

    private static Logger logger = LogManager.getLogger(App.class);

    // tableView

    @FXML
    private TableView<Contact> tableViewContact;
    @FXML
    private TableColumn<Contact, String> colPrenom;

    @FXML
    private TableColumn<Contact, String> colNom;
    @FXML
    private TableColumn<Contact, String> colGenre;
    @FXML
    private TableColumn<Contact, String> colMail;
    @FXML
    private TableColumn<Contact, String> colTel;
    // boutons
    @FXML
    private Button boutonJson;
    @FXML
    private Button boutonVCard;
    @FXML
    private Button boutonSupprimer;
    @FXML
    private Button boutonModifier;
    @FXML
    private Button boutonCreer;
    // textFields
    @FXML
    private TextField nomField;
    @FXML
    private TextField prenomField;
    @FXML
    private TextField genreField;
    @FXML
    private TextField dateDeNaissanceField;
    @FXML
    private TextField pseudoField;
    @FXML
    private TextField adresseField;
    @FXML
    private TextField numPersoField;
    @FXML
    private TextField numProField;
    @FXML
    private TextField mailField;
    @FXML
    private TextField lienGitField;

    /**
     * Méthode qui se déclenche sur un clic sur le bouton "Export JSon"
     * 
     * @param event Objet de la classe "ActionEvent" qui stocke les informations sur
     *              l'évènement en question
     */
    @FXML
    public void jsonExport(ActionEvent event) {

        // Intanciation d'un serializer
        ContactJsonSerializer serializer = new ContactJsonSerializer();

        // récupération du ou des contacts sélectionné
        ObservableList<Contact> selectedContacts = tableViewContact.getSelectionModel().getSelectedItems();
        if (selectedContacts.size() == 1) {

            Contact selectedContact = selectedContacts.getFirst();
            // appel à la méthode de sauvegarde (sérialisation)
            serializer.save("contact-" + selectedContact.getNom() + "-" + selectedContact.getPrenom() + ".json",
                    selectedContact);
        } else {
            serializer.saveList("contacts.json", new ArrayList<Contact>(selectedContacts));
        }

    }

    @FXML
    public void vCardExport(ActionEvent event) {

        // récupération du contact sélectionné
        Contact selectedContact = tableViewContact.getSelectionModel().getSelectedItem();

        // Intanciation d'un serializer
        ContactJsonSerializer serializer = new ContactJsonSerializer();
        // appel à la méthode de sauvegarde (sérialisation)
        serializer.save("contact-" + selectedContact.getNom() + "-" + selectedContact.getPrenom() + ".json",
                selectedContact);
    }

    private ObservableList<Contact> contactsListView = FXCollections.observableArrayList(); // Observable liste pour
                                                                                            // stocker les contacts

    @FXML
    public void initialize() {

        ContactBinarySerializer binaryDeserializer = new ContactBinarySerializer();

        ArrayList<Contact> deserializedContacts = binaryDeserializer.loadList("contact.ser");

        contactsListView.addAll(deserializedContacts);

        tableViewContact.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        // // instanciation contacts
        // Contact contactRud = new Contact("rud", "Ati", "M", "13/08/1990", "RANA",
        // "Bordeaux", "0694644522", "",
        // "rudati@gmail.com", "41800", "https://github.com/d9shboard");

        // Contact contactYreud = new Contact("yreud", "pAorti", "M", "16/07/1991",
        // "Pr2A", "Bordeaux", "0694584523", "",
        // "rudati@gmail.com", "21800", "https://github.com/déshboard");
        // Contact contactRireud = new Contact("rireud", "cecAti", "M", "14/08/1990",
        // "RA.é.NA", "Bordeaux", "0694658452",
        // "",
        // "rudati@gmail.com", "31800", "https://github.com/d0shboard");

        // contactsListView.add(contactRud);
        // contactsListView.add(contactYreud);
        // contactsListView.add(contactRireud);

        // lien entre liste existante et le tableau
        tableViewContact.setItems(contactsListView);

        // aujout
        colGenre.setCellValueFactory(cellData -> cellData.getValue().getGenreProperty());
        colNom.setCellValueFactory(cellData -> cellData.getValue().getNomProperty());
        colPrenom.setCellValueFactory(cellData -> cellData.getValue().getPrenomProperty());
        colMail.setCellValueFactory(cellData -> cellData.getValue().getMailProperty());
        colTel.setCellValueFactory(cellData -> cellData.getValue().getTelPersoProperty());

    }

    @FXML
    public void creer(ActionEvent event) {
        // verifier au fil de la saisie sur les champs mail et lient git que le format
        // est correcte
        // avec les méthodes de verification mail et URL.
        String mailValide = null;
        String urlValide = null;
        Boolean checkMail = VerificationMail.isValidEmail(mailField.getText());
        Boolean checkUrl = VerificationUrl.isValidURL(lienGitField.getText());
        if (checkMail == true && checkUrl == true) {
            mailValide = mailField.getText();
            urlValide = lienGitField.getText();

            Contact contact = new Contact(nomField.getText(), prenomField.getText(), genreField.getText(),
                    dateDeNaissanceField.getText(), pseudoField.getText(), adresseField.getText(),
                    numPersoField.getText(),
                    numProField.getText(), mailValide, adresseField.getText(), urlValide);
            contactsListView.add(contact);

            // serialisation binaire des contacts:
            ContactBinarySerializer serializer = new ContactBinarySerializer();
            serializer.saveList("contact.ser", new ArrayList<Contact>(contactsListView));

            mailField.getStyleClass().remove("error-field");
            lienGitField.getStyleClass().remove("error-field");
            // retirer supprimer les infos des champs après ajout du contact
            nomField.setText("");
            prenomField.setText("");
            genreField.setText("");
            dateDeNaissanceField.setText("");
            pseudoField.setText("");
            adresseField.setText("");
            numPersoField.setText("");
            numProField.setText("");
            mailField.setText("");
            lienGitField.setText("");

        } else {
            if (checkMail == false) {
                mailField.getStyleClass().add("error-field");
            }
            if (checkUrl == false) {
                lienGitField.getStyleClass().add("error-field");
            }
        }

        logger.info("click créer");
    }

    @FXML
    public void modifier(ActionEvent event) {
        //selection du contact dans la liste et stockage dans la variable
        Contact selectedContact=tableViewContact.getSelectionModel().getSelectedItem();
        //suppression du contact:
        tableViewContact.getItems().remove(selectedContact);
        //envoi des valeur du contacts dans les champs:
        nomField.setText(selectedContact.getNom());
        prenomField.setText(selectedContact.getPrenom());
        genreField.setText(selectedContact.getGenre());
        dateDeNaissanceField.setText(selectedContact.getDateDeNaissance());
        pseudoField.setText(selectedContact.getPseudo());
        adresseField.setText(selectedContact.getAdresse());
        numPersoField.setText(selectedContact.getTelPerso());
        numProField.setText(selectedContact.getTelPro());
        mailField.setText(selectedContact.getMail());
        lienGitField.setText(selectedContact.getLienGit());

    }

    @FXML
    public void supprimer(ActionEvent event) {

        Contact selectedItem = tableViewContact.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            // Boîte de dialogue de confirmation
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation de suppression");
            alert.setHeaderText("Êtes-vous sûr de vouloir supprimer cet élément ?");
            alert.setContentText("Cette action est irréversible.");

            if (alert.showAndWait().get() == ButtonType.OK) {
                tableViewContact.getItems().remove(selectedItem);
                            //serialisation binaire des contacts:
            ContactBinarySerializer serializer =  new ContactBinarySerializer();
            serializer.saveList("contact.ser", new ArrayList<Contact>(contactsListView) );
            }
        }
    }
}
