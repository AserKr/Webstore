package hi.jaser.webstore;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;
import vinnsla.Customer;

import java.io.IOException;

public class CustomerDialog extends Dialog<Customer> {
    @FXML
     TextField fxName;
    @FXML
     TextField fxAddress;
    @FXML
     DatePicker fxLoginBirth;
    @FXML
     ButtonType fxILagi;



    private Customer user;
    private PontunController pontunController;

    /**
     * creates the dialog for the sign in information in which the user can enter their name and address, and sets up needed bindings.
     */
    public CustomerDialog() {
        setDialogPane(readLoginDialog());
        iLagiRegla();
        pontunController = (PontunController) ViewSwitcher.lookup(View.PONTUN);
        user = new Customer(fxName.textProperty(), fxAddress.textProperty());
        setResultConverter(b -> {
            if (b.getButtonData() == ButtonBar.ButtonData.OK_DONE) {

                pontunController.getUser().nameProperty().bind(user.nameProperty());
                pontunController.getUser().addressProperty().bind(user.addressProperty());
                pontunController.getDateOfBirth().valueProperty().bind(fxLoginBirth.valueProperty());
                pontunController.fxInnskraning.setText("Click here to enter your password");
                PasswordDialog d = new PasswordDialog();
                d.show();

                return user;
            } else {
                return null;
            }
        });
        setTitle("Sign in Information");
    }

    /**
     * the rule to bind the Okay button in the dialog to the text fields
     */
    private void iLagiRegla() {
        Node iLagi = getDialogPane().lookupButton(fxILagi);
        iLagi.disableProperty()
                .bind(fxAddress.textProperty().isEmpty()
                        .or(fxName.textProperty().isEmpty()));
    }

    /**
     * reads the fxml file for the LOGIN dialog.
     */
    private DialogPane readLoginDialog() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(View.VIDSKIPTAVINUR.getFileName()));
        try {
            fxmlLoader.setController(this);
            return fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }



}
