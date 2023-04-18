package hi.jaser.webstore;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;
import vinnsla.Customer;

import java.io.IOException;
import java.util.function.UnaryOperator;

public class HomeDeliveryDialog extends Dialog<Customer>{
    @FXML
    TextField fxName;
    @FXML
    TextField fxAddress;
    @FXML
    DatePicker fxDate;
    @FXML
    TextField fxCardNumber;
    @FXML
    TextField fxCardHolder;
    @FXML
    ButtonType fxILagi;
    @FXML
    TextField fxCVC;
    public Customer getUser() {
        return user;
    }
private BooleanProperty isEmptyCVC = new SimpleBooleanProperty(true);
    private BooleanProperty isEmptyCard = new SimpleBooleanProperty(true);

    private Customer user;
    private PontunController pontunController;
    private static final String nameofStore = "Jaser Electronics";
    private static final String message1 = "Your Order Has been confirmed for delivery!";
    private static final String message = "Your order will be delivered in 7-10 business days to ";
    private static final String Okay = "Back to home page";

    public HomeDeliveryDialog() {
        setDialogPane(readDialog());
       pontunController= (PontunController) ViewSwitcher.lookup(View.PONTUN);
       if (pontunController.getPassword().getPassword()!=null){
          fxDate.setValue(pontunController.getDateOfBirth().getValue());
           fxName.setText(pontunController.getUser().getName());
           fxAddress.setText(pontunController.getUser().getAddress());
       }
        iLagiRegla();
        UnaryOperator<TextFormatter.Change> filter = change -> {
            String newText = change.getControlNewText();
            if (newText.matches("\\d{0,3}")) {
                if (newText.length() == 3) {
                    isEmptyCVC.set(false);
                }
                else if (newText.length() < 3) {
                    isEmptyCVC.set(true);
                }
                return change;
            }
            return null;
        };
        TextFormatter<String> textFormatter = new TextFormatter<>(filter);
        fxCVC.setTextFormatter(textFormatter);


        UnaryOperator<TextFormatter.Change> filter2 = change -> {
            String newText = change.getControlNewText();
            if (newText.matches("\\d{0,16}")) {
                if (newText.length() == 16) {
                    isEmptyCard.set(false);
                }
                else if (newText.length() < 16) {
                    isEmptyCard.set(true);
                }
                return change;
            }
            return null;
        };
        TextFormatter<String> textFormatter2 = new TextFormatter<>(filter2);
        fxCardNumber.setTextFormatter(textFormatter2);

        setResultConverter(b -> {
            if (b.getButtonData() == ButtonBar.ButtonData.OK_DONE) {
                ButtonType bType = new ButtonType(Okay,
                        ButtonBar.ButtonData.OK_DONE);
        Alert a = stofnaAlert(bType);
        a.showAndWait();
                ViewSwitcher.switchTo(View.PONTUN);
                int i= pontunController.karfa.getsize();
                pontunController.karfa.getProducts().remove(0,i);
            }
            return null;
    });
        }

    /**
     * the rule to bind the Okay button in the dialog to the text fields
     */
    private void iLagiRegla() {
        // fletta upp í lagi hnappnum út frá hnappategund
        Node iLagi = getDialogPane().lookupButton(fxILagi);
        iLagi.disableProperty()
                .bind(fxAddress.textProperty().isEmpty()
                        .or(fxName.textProperty().isEmpty()).or(fxDate.valueProperty().isNull()).or(isEmptyCVC).or(isEmptyCard).or(fxCardHolder.textProperty().isEmpty()));
    }

    /**
     * reads the fxml file for the LOGIN dialog.
     */
    private DialogPane readDialog() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(View.HOMEDELIVERY.getFileName()));
        try {
            fxmlLoader.setController(this);
            return fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }




    private Alert stofnaAlert(ButtonType bILagi) {
        // Væri hægt að segja Alert.AlertType.CONFIRMATION en þá stjórnum við ekki útliti hnappanna
        Alert a = new Alert(Alert.AlertType.NONE, message + fxAddress.getText(), bILagi);
        a.setTitle(nameofStore);
        a.setHeaderText(message1);
        return a;

    }
}
