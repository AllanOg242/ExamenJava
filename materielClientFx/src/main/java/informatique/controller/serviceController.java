package informatique.controller;

import informatique.model.*;
import informatique.service.ITypeClient;
import informatique.utils.Fabrique;
import informatique.utils.Utils;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.xml.soap.Detail;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class serviceController implements Initializable {

    @FXML
    private TextField tfdNumero;

    @FXML
    private TextField tfdQuantite;

    @FXML
    private TextField tfdDateLiv;

    @FXML
    private TextField tfdLibelle;

    @FXML
    private TextField tfdPrix;

    @FXML
    private TableView<DetailCommande> tabCommande;

    @FXML
    private TableColumn<DetailCommande, String> colNumero;

    @FXML
    private TableColumn<DetailCommande, Date> colDateLiv;

    @FXML
    private TableColumn<DetailCommande, String> colQuantite;

    @FXML
    private TableColumn<DetailCommande, String> colLibelle;

    @FXML
    private TableColumn<DetailCommande, Double> colPrix;

    @FXML
    private Button btnEnregistrerDetCom;

    @FXML
    private Button btnModifierDetCom;

    @FXML
    private Button btnSupprimerDetCom;

    @FXML
    private TextField tfdNomUser;

    @FXML
    private TextField tfdPrenomUser;

    @FXML
    private TextField tfdPrenomClient;

    @FXML
    private TextField tfdTelephoneClient;

    @FXML
    private TextField tfdAdresseClient;

    @FXML
    private TextField tfdNomClient;

    @FXML
    private ComboBox<Profil> cbxProfilUser;

    @FXML
    private ComboBox<TypeClient> cbxTypeClient;

    @FXML
    private Button btnAjouterUser;

    @FXML
    private Button btnAjouterClient;

    @FXML
    private Button btnModifierUser;

    @FXML
    private Button btnSupprimerUser;

    @FXML
    private Button btnModifierClient;

    @FXML
    private Button btnSupprimerClient;

    @FXML
    private TableView<User> tabUtilisateur;

    @FXML
    private TableColumn<User, String> colNomUser;

    @FXML
    private TableColumn<User, String> colPrenomUser;

    @FXML
    private TableColumn<User, String> colProfilUser;

    @FXML
    private TableView<Client> tabClient;

    @FXML
    private TableColumn<Client, String> colNomClient;

    @FXML
    private TableColumn<Client, String> colPrenomClient;

    @FXML
    private TableColumn<Client, String> colAdresseClient;

    @FXML
    private TableColumn<Client, String> colTelephoneClient;

    @FXML
    private TableColumn<Client, String> colTypeClient;



    @FXML
    void deleteClient(ActionEvent event) {

    }

    @FXML
    void updateUser(ActionEvent event) {

    }



    @FXML
    void addClient(ActionEvent event) {
        String nom = tfdNomClient.getText().trim();
        String prenom = tfdPrenomUser.getText().trim();
        String telephone = tfdTelephoneClient.getText().trim();
        String adresse = tfdAdresseClient.getText().trim();
        if(nom.equals("") || prenom.equals("") || telephone.equals("") || adresse.equals("")){
            Utils.showMessage("Gestion Client","Veillez Remplir tout les champs !!!","!");
        }else {
            Client cl = new Client();
            cl.setNom(nom);
            cl.setPrenom(prenom);
            cl.setTelephone(telephone);
            cl.setAdresse(adresse);
            cl.setTypeClient(cbxTypeClient.getSelectionModel().getSelectedItem());

            try {
                Fabrique.getiClient().add(cl);
                showTableClient();
                viderChampsClient();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    private void viderChampsClient()
    {
        tfdNomClient.setText("");
        tfdPrenomClient.setText("");
        tfdAdresseClient.setText("");
        tfdTelephoneClient.setText("");
        cbxTypeClient.getSelectionModel().clearSelection();
    }

    private void showTableClient() {
        try {
            List<Client> listClient = Fabrique.getiClient().findAll();
            if (listClient != null) {
                colNomClient.setCellValueFactory(new PropertyValueFactory<>("nom"));
                colPrenomClient.setCellValueFactory(new PropertyValueFactory<>("prenom"));
                colAdresseClient.setCellValueFactory(new PropertyValueFactory<>("adresse"));
                colTelephoneClient.setCellValueFactory(new PropertyValueFactory<>("telephone"));
                colTypeClient.setCellValueFactory(new PropertyValueFactory<>("typeClient"));
                /*colProfilUser.setCellValueFactory(foo -> {
                    String profil = foo.getValue().getProfil().getPseudo();
                    ObservableValue<String> val = new SimpleObjectProperty<>(profil);
                    return val;
                });*/
                tabClient.getItems().clear();
                tabClient.setItems(FXCollections.observableArrayList(listClient));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void deleteUser(ActionEvent event) {
        if(Utils.confirmMessage("Gestion des User","Suppression User", "Etes-Vous Sur ???")){
            try {
                Fabrique.getiUser().delete(tabUtilisateur.getSelectionModel().getSelectedItem());
            }catch (Exception ex){

            }
            showTable();
        }
    }

    @FXML
    void updateClient(ActionEvent event) {

    }

    @FXML
    void addDetCom(ActionEvent event) {
        String numero = tfdNumero.getText().trim();
        String quantite = tfdQuantite.getText().trim();
        String libelle = tfdLibelle.getText().trim();
        Double prix = Double.parseDouble(tfdPrix.getText().trim());
        Date dateLivraison;
        try {
            dateLivraison = new SimpleDateFormat("dd-MM-yyyy").parse(tfdDateLiv.getText().trim());
        }catch (Exception e){
            dateLivraison = null;
        }
        System.out.println(dateLivraison);
        if(numero.equals("") || quantite.equals("") || libelle.equals("") || prix.equals("") || dateLivraison.equals("")){
            Utils.showMessage("Gestion Commande","Veillez Remplir tout les champs !!!","!");
        }else {
            Produit p =  new Produit();
            p.setLibelle(libelle);
            p.setPrix(prix);
            Commande c = new Commande();
            c.setNumeroCommande(numero);
            c.setQuantite(quantite);
            c.setDateLivraison(dateLivraison);
            List<DetailCommande> dts = new ArrayList<>();
            try {
                Commande com = Fabrique.getiCommande().add(c);
                DetailCommande dt = new DetailCommande();
                dt.setProduit(p);
                dt.setBon(com);
                dts.add(dt);
                c.setDetailCommandes(dts);
                for(DetailCommande d : dts){
                    Fabrique.getiDetailCommande().add(d);
                }
                tfdNumero.setText(Fabrique.getiCommande().createNumero());
                showTable();
                viderChamps();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @FXML
    void deleteDetCom(ActionEvent event) {
        if(Utils.confirmMessage("Gestion des Commandes","Suppression Commande", "Etes-Vous Sur ???")){
            try {
                Fabrique.getiDetailCommande().delete(tabCommande.getSelectionModel().getSelectedItem());
            }catch (Exception ex){

            }
            showTable();
        }
    }

    @FXML
    void updateDetCom(ActionEvent event) {

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        showTable();
        showTableUser();
        showTableClient();
        iProfil();
    }

    public void iProfil(){
        try{
            tfdNumero.setText(Fabrique.getiCommande().createNumero());
            List<Profil> listProfil= Fabrique.getiProfil().findAll();
            cbxProfilUser.setItems(FXCollections.observableArrayList(listProfil));
            List<TypeClient> listTypeClient= Fabrique.getiTypeClient().findAll();
            cbxTypeClient.setItems(FXCollections.observableArrayList(listTypeClient));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /*private void selectElement()
    {
        tabCommande.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            btnSupprimerDetCom.setDisable(false);
            btnEnregistrerDetCom.setDisable(true);
            if(newValue!=null){
                tfdNumero.setText(newValue.getNumeroCommande);
                tfdQuantite.setText(newValue.getQuantite);
                tfdDateLiv.setText(newValue.getDateLivraison);
                tfdPrix.setText(newValue.getPrix);
                tfdLibelle.setText(newValue.getLibelle);
            }
        });
    }*/

    private void showTable() {
        try {
            List<DetailCommande> listDetCommande = Fabrique.getiDetailCommande().findAll();
            if (listDetCommande != null) {
                colNumero.setCellValueFactory(foo -> {
                    String numeroCommande = foo.getValue().getBon().getNumeroCommande();
                    ObservableValue<String> val = new SimpleObjectProperty<>(numeroCommande);
                    return val;
                });
                colQuantite.setCellValueFactory(foo -> {
                    String quantite = foo.getValue().getBon().getQuantite();
                    ObservableValue<String> val = new SimpleObjectProperty<>(quantite);
                    return val;
                });
                colDateLiv.setCellValueFactory(foo -> {
                    Date dateLiv = foo.getValue().getBon().getDateLivraison();
                    ObservableValue<Date> val = new SimpleObjectProperty<>(dateLiv);
                    return val;
                });
                colLibelle.setCellValueFactory(foo -> {
                    String libelle = foo.getValue().getProduit().getLibelle();
                    ObservableValue<String> val = new SimpleObjectProperty<>(libelle);
                    return val;
                });
                colPrix.setCellValueFactory(foo -> {
                    Double prix = foo.getValue().getProduit().getPrix();
                    ObservableValue<Double> val = new SimpleObjectProperty<>(prix);
                    return val;
                });
                tabCommande.getItems().clear();
                tabCommande.setItems(FXCollections.observableArrayList(listDetCommande));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void viderChamps()
    {
        tfdDateLiv.setText("");
        tfdLibelle.setText("");
        tfdPrix.setText("");
        tfdQuantite.setText("");
        try{
            tfdNumero.setText(Fabrique.getiCommande().createNumero());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void addUser(ActionEvent event) {
        String nom = tfdNomUser.getText().trim();
        String prenom = tfdPrenomUser.getText().trim();
        if(nom.equals("") || prenom.equals("")){
            Utils.showMessage("Gestion User","Veillez Remplir tout les champs !!!","!");
        }else {
            User u = new User();
            u.setNom(nom);
            u.setPrenom(prenom);
            u.setProfil(cbxProfilUser.getSelectionModel().getSelectedItem());
            try {
                Fabrique.getiUser().add(u);
                showTableUser();
                viderChampsUser();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    private void viderChampsUser()
    {
        tfdNomUser.setText("");
        tfdPrenomUser.setText("");
        cbxProfilUser.getSelectionModel().clearSelection();
    }

    private void showTableUser() {
        try {
            List<User> listUser = Fabrique.getiUser().findAll();
            if (listUser != null) {
                colNomUser.setCellValueFactory(new PropertyValueFactory<>("nom"));
                colPrenomUser.setCellValueFactory(new PropertyValueFactory<>("prenom"));
                colProfilUser.setCellValueFactory(new PropertyValueFactory<>("profil"));
                /*colProfilUser.setCellValueFactory(foo -> {
                    String profil = foo.getValue().getProfil().getPseudo();
                    ObservableValue<String> val = new SimpleObjectProperty<>(profil);
                    return val;
                });*/
                tabUtilisateur.getItems().clear();
                tabUtilisateur.setItems(FXCollections.observableArrayList(listUser));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
