package fr.afpa.controllers;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.afpa.App;
import fr.afpa.models.Contact;
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

    }

    @FXML
    public void vCardExport(ActionEvent event) {

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

}
