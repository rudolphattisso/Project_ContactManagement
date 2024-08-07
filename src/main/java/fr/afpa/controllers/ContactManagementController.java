package fr.afpa.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.afpa.App;
import fr.afpa.models.Contact;
import fr.afpa.tools.ContactvCardSerializer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ContactManagementController {

    private static Logger logger = LogManager.getLogger(App.class);

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
    private TextField nomfField;
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

    @FXML
    public void jsonExport(ActionEvent event) {

    }

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

    @FXML
    public void creer(ActionEvent event) {

    }

    @FXML
    public void modifier(ActionEvent event) {

    }

    @FXML
    public void supprimer(ActionEvent event) {

    }

    private ObservableList<Contact> contactsListView = FXCollections.observableArrayList();

    @FXML
    public void initialize() {

        Contact contact1 = new Contact("Las", "You", "M", "25/07/1987", "You", "2 passage des arceaux", "0651712919",
                "0632067946", "Lamazir@gmail.com", "33450", "https://github.com/LasriYoussef");
        contactsListView.add(contact1);
        tableViewContact.setItems(contactsListView);
        colGenre.setCellValueFactory(cellData -> cellData.getValue().getGenreProperty());
        colNom.setCellValueFactory(cellData -> cellData.getValue().getNomProperty());
        colPrenom.setCellValueFactory(cellData -> cellData.getValue().getPrenomProperty());
        colMail.setCellValueFactory(cellData -> cellData.getValue().getMailProperty());
        colTel.setCellValueFactory(cellData -> cellData.getValue().getTelPersoProperty());
        ContactvCardSerializer vCardSerializer = new ContactvCardSerializer();
        vCardSerializer.serialize(contact1);
    }

}
