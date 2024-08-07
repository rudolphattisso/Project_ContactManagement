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
import fr.afpa.tools.ContactvCardSerializer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;


public class ContactManagementController {

    private static Logger logger = LogManager.getLogger(App.class);
    // faire le lien entre les fichiers le controlleur et la vue ContactManagaement
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
    private ComboBox<String> genreComboBox;
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

    // ObservableList<String> comboBoxList = FXCollections.observableArrayList();

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

    /**
     * Méthode qui se déclenche sur un clic sur le bouton "Export JSon"
     * 
     * @param event Objet de la classe "ActionEvent" qui stocke les informations sur
     *              l'évènement en question
     */

    @FXML
    public void vCardExport(ActionEvent event) {
        ContactvCardSerializer vCardSerializer = new ContactvCardSerializer();

        Contact selectedContact = tableViewContact.getSelectionModel().getSelectedItem();
        if (selectedContact == null) {
            System.out.println("Aucun contact sélectionné");
            return;
        } else {
            vCardSerializer.save(
                    selectedContact.getGenre() + selectedContact.getNom() + selectedContact.getPrenom() + ".vcf",
                    selectedContact);
        }

    }

    private ObservableList<Contact> contactsListView = FXCollections.observableArrayList(); // Observable liste pour
                                                                                            // stocker les contacts

    /**
     * méthode qui se lance dès le lancement du logiciel.
     */
    @FXML
    public void initialize() {

        // Chargement des différents possibles dans la comboBox
        genreComboBox.getItems().addAll("Homme", "Femme", "Non binaire");

        ContactBinarySerializer binaryDeserializer = new ContactBinarySerializer();
        
        ArrayList<Contact> deserializedContacts = binaryDeserializer.loadList("contact.ser");
       // condition dans le cas ou la désirialisaton est impossible car le fichier de binaire n'existe pas au premier demarrage de l'application
       //la condition implique que rien ne doit être fait si le tableau est vide et effectuer l'action si dessous si c'estle contraire.

        if(deserializedContacts!=null){
            contactsListView.addAll(deserializedContacts);
        }
        

        tableViewContact.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        // création du lien entre l'élement graphique TableView et le
        // tableau(ObservableList).
        tableViewContact.setItems(contactsListView);

        // aujout
        colGenre.setCellValueFactory(cellData -> cellData.getValue().getGenreProperty());
        colNom.setCellValueFactory(cellData -> cellData.getValue().getNomProperty());
        colPrenom.setCellValueFactory(cellData -> cellData.getValue().getPrenomProperty());
        colMail.setCellValueFactory(cellData -> cellData.getValue().getMailProperty());
        colTel.setCellValueFactory(cellData -> cellData.getValue().getTelPersoProperty());
    }

    /**
     * Méthode permettant rajouter un contact à la liste de contacts;
     * elle verifie aussi le format de contenu du champ du mail et de l'url.
     * elle utilise aussi la serialisation binaire afin d'enreigistrer la liste
     * de contacts;
     * 
     * @param event : Objet de la classe "ActionEvent" qui stocke les informations
     *              sur
     *              l'évènement en question
     */
    @FXML
    public void creer(ActionEvent event) {
        // déclaration des variables dans lesquelles seront stockées le contenu de
        // champs
        // mail et url avant vérification.
        String mailValide = null;
        String urlValide = null;
        String genreSelection = null;

        // processus de verification des champs qui utiliseront les classes qui
        // contiennent*
        // les méthodes de vérificatoin
        Boolean checkMail = VerificationMail.isValidEmail(mailField.getText());
        Boolean checkUrl = VerificationUrl.isValidURL(lienGitField.getText());
        
        // cas ou les contenus des champs sont valides.
        if (checkMail == true && checkUrl == true && genreSelection != "Choix du genre") {
            mailValide = mailField.getText();
            urlValide = lienGitField.getText();
            genreSelection = genreComboBox.getSelectionModel().getSelectedItem();

            // création du contact;
            Contact contact = new Contact(nomField.getText(), prenomField.getText(), genreSelection,
                    dateDeNaissanceField.getText(), pseudoField.getText(), adresseField.getText(),
                    numPersoField.getText(),
                    numProField.getText(), mailValide, adresseField.getText(), urlValide);
            contactsListView.add(contact);

            // serialisation binaire des contacts:
            ContactBinarySerializer serializer = new ContactBinarySerializer();
            serializer.saveList("contact.ser", new ArrayList<Contact>(contactsListView));
            // suppression du style CSS qui s'active en cas d'erreur appliqué au champs lors
            // d'une saisie précédente
            mailField.getStyleClass().remove("error-field");
            lienGitField.getStyleClass().remove("error-field");
            // retirer supprimer les infos des champs après ajout du contact
            nomField.setText("");
            prenomField.setText("");
            genreComboBox.getSelectionModel().clearSelection();
            dateDeNaissanceField.setText("");
            pseudoField.setText("");
            adresseField.setText("");
            numPersoField.setText("");
            numProField.setText("");
            mailField.setText("");
            lienGitField.setText("");
            // cas du formats d'url et mail faux
            tableViewContact.getSelectionModel().clearSelection();
            tableViewContact.getSelectionModel().selectLast();
        } else {
            if (checkMail == false) {
                mailField.getStyleClass().add("error-field");
            }
            if (checkUrl == false) {
                lienGitField.getStyleClass().add("error-field");
            }
            if (genreSelection != "Choix du genre") {
                genreComboBox.getStyleClass().add("error-field");
            }
        }

        logger.info("click créer");
    }

    /**
     * Méthode permettant modifier un contact selectionné dans la liste,
     * 
     * @param event : : Objet de la classe "ActionEvent" qui stocke les informations
     *              sur
     *              l'évènement en question
     */
    @FXML
    public void modifier(ActionEvent event) {
        // selection du contact dans la liste et stockage dans une variable
        Contact selectedContact = tableViewContact.getSelectionModel().getSelectedItem();
        // suppression du contact:
        tableViewContact.getItems().remove(selectedContact);
        // envoi des valeur du contacts dans les champs:
        nomField.setText(selectedContact.getNom());
        prenomField.setText(selectedContact.getPrenom());
        genreComboBox.getSelectionModel().select(selectedContact.getGenre());
        dateDeNaissanceField.setText(selectedContact.getDateDeNaissance());
        pseudoField.setText(selectedContact.getPseudo());
        adresseField.setText(selectedContact.getAdresse());
        numPersoField.setText(selectedContact.getTelPerso());
        numProField.setText(selectedContact.getTelPro());
        mailField.setText(selectedContact.getMail());
        lienGitField.setText(selectedContact.getLienGit());

    }

    /**
     * Méthode permettant de supprimer un contact dans la liste. elle utilise aussi
     * la serialisation binaire afin d'enreigistrer la liste de contacts;
     * 
     * @param event : : Objet de la classe "ActionEvent" qui stocke les informations
     *              sur
     *              l'évènement en question
     */
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

                // serialisation binaire des contacts:
                ContactBinarySerializer serializer = new ContactBinarySerializer();
                serializer.saveList("contact.ser", new ArrayList<Contact>(contactsListView));
            }
        }
    }
}
