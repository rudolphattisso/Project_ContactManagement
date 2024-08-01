package fr.afpa.controllers;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.afpa.App;
import fr.afpa.models.Contact;
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

    // actions
    @FXML
    public void jsonExport(ActionEvent event) {
        // Instancier ContactJsonSerializer
    }

    @FXML
    public void vCardExport(ActionEvent event) {
        // Instancier ContactVCardSerializer
    }

    @FXML
    public void creer(ActionEvent event) {
        // verifier au fil de la saisie sur les champs mail et lient git que le format
        // est correcte
        // avec les méthodes de verification mail et URL.
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

        contactsListView.add(new Contact("rud", "Ati", "M", "13/08/1990", "RANA", "Boreaux", "0694658452", "",
                "rudati@gmail.com", "41800", "https://github.com/dashboard"));
        // contactsListView.add(new Contact());
        // contactsListView.add(new Contact());
        tableViewContact.setItems(contactsListView);

        colGenre.setCellValueFactory(cellData -> cellData.getValue().getGenreProperty());
        colNom.setCellValueFactory(cellData -> cellData.getValue().getNomProperty());
        colPrenom.setCellValueFactory(cellData -> cellData.getValue().getPrenomProperty());
        colMail.setCellValueFactory(cellData -> cellData.getValue().getMailProperty());
        colTel.setCellValueFactory(cellData -> cellData.getValue().getTelPersoProperty());

    }

}
