package hi.jaser.webstore;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import vinnsla.Password;

import java.io.IOException;

public class PasswordDialog extends Dialog<Password> {
    @FXML
    PasswordField fxPass;
    @FXML
    ToggleButton fxToggleVisual;
    private Password password;
    private PontunController pontunController;

    /**
     * sets up the password dialog in which a user can enter their password.
     */
    public PasswordDialog() {


        setDialogPane(readPassDialog());
        pontunController = (PontunController) ViewSwitcher.lookup(View.PONTUN);
        password=new Password(fxPass.textProperty());
        setResultConverter(b -> {
            if (b.getButtonData() == ButtonBar.ButtonData.OK_DONE) {
                pontunController.getPassword().passwordProperty().bind(password.passwordProperty());
                if (!password.getPassword().equals("")){
                    pontunController.fxInnskraning.disableProperty().set(true);
                    pontunController.fxInnskraning.setText("Welcome " + pontunController.getUser().getName());}

                return password;
            } else {
                return null;
            }

        });
        setTitle("Password");


        fxToggleVisual.addEventHandler(ActionEvent.ACTION, (ActionEvent e) -> {
            if (fxToggleVisual.isSelected()) {
                fxPass.setPromptText(fxPass.getText());
                fxPass.setStyle("-fx-prompt-text-fill: black; -fx-font-weight: bold;");
                fxPass.setText("");
                fxPass.setDisable(true);

            } else {
                fxPass.setText(fxPass.getPromptText());
                fxPass.setPromptText("");
                fxPass.setDisable(false);
            }

        });
    }

    /**
     * reads the fxml file for the password dialog.
     */
    private DialogPane readPassDialog() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Password-view.fxml"));
        try {
            fxmlLoader.setController(this);
            return fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

}
