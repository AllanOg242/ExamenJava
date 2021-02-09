package informatique.controller;

import informatique.model.User;
import informatique.model.UserSession;
import informatique.utils.Fabrique;
import informatique.utils.LoadView;
import informatique.utils.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class loginController implements Initializable {

    @FXML
    private TextField tfdLogin;

    @FXML
    private TextField tfdMdp;

    @FXML
    private Button btnConnecter;

    @FXML
    void connect(ActionEvent event) throws Exception {
        if(tfdLogin.getText().isEmpty() || tfdMdp.getText().isEmpty()){
            Utils.showMessage("Login", "Information","Veillez Remplir tous les champs !");
        }else {
            try {
                User user = Fabrique.getiUser().getUser(tfdLogin.getText(), tfdMdp.getText());

                if(user!=null){
                    UserSession.setInstace(user);
                    LoadView.showView("Acceuil","FormService.fxml",1);
                }else {
                    Utils.showMessage("Login", "Information","Login ou mot de passe incorrect !");
                    tfdLogin.setText("");
                    tfdMdp.setText("");
                }
            }catch (Exception ex){
                throw ex;
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
