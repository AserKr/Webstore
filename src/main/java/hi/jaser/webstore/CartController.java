package hi.jaser.webstore;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import vinnsla.Products;
import vinnsla.Customer;

public class CartController {

    @FXML
    Button fxGoBack;
    @FXML
    ListView fxKarfa;
    @FXML
    Label totalPrice;
    @FXML
    Button fxRemove;
    @FXML
    Button fxStadfesting;


    private PontunController pontunController;
    private Customer user;
    @FXML
    ComboBox fxCurrencyBox;
    ObservableList<String> currencies = FXCollections.observableArrayList("USD", "ISK", "EUR");
    private StringProperty delivery = new SimpleStringProperty();



    /**
     * Creates the setup and bindings for the payment scene, binds the payment scene with variables from the main (PONTUN) scene
     */
    @FXML
    private void initialize() {

        user = new Customer(new SimpleStringProperty(null), new SimpleStringProperty(null));
        pontunController = (PontunController) ViewSwitcher.lookup(View.PONTUN);
        totalPrice.textProperty().bind(pontunController.getFxTotalPrice().textProperty());
        setDelivery("Your order will be delivered after 15 minutes");
        user.nameProperty().addListener((observable, oldValue, newValue) -> {
            setDelivery("Your order will be delivered after 15 minutes to " + user.getName() + " at " + user.getAddress());
        });
        user.addressProperty().addListener((observable, oldValue, newValue) -> {
            setDelivery("Your order will be delivered after 15 minutes to " + user.getName() + " at " + user.getAddress());
        });
        user.nameProperty().bind(pontunController.getUser().nameProperty());
        user.addressProperty().bind(pontunController.getUser().addressProperty());
        fxCurrencyBox.setItems(currencies);
        if (pontunController.karfa.getsize() > 0) {
            fxStadfesting.setDisable(false);
        }
        else {
            fxStadfesting.setDisable(true);
        }

        pontunController.karfa.getObs().addListener((ListChangeListener<? super Products>) change -> {
            if (pontunController.karfa.getsize()==0){
                fxStadfesting.setDisable(true);
            }
            else {
                fxStadfesting.setDisable(false);
            }

        });

        for (int i = 0; i < pontunController.karfa.getsize(); i++) {
            fxKarfa.getItems().add(pontunController.karfa.getObs().get(i));
        }
        pontunController.karfa.getObs().addListener((ListChangeListener<? super Products>) change -> {
            fxKarfa.setItems(pontunController.karfa.getObs());
            ;
        });
        fxCurrencyBox.setValue(null);
        fxCurrencyBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            pontunController.karfa.setCurrencyPrice(newValue.toString());
        });
    }


    /**
     * Handler to go back to the main page
     * @param e
     */
    @FXML
    private void fxGoBackHandler(ActionEvent e) {
        ViewSwitcher.switchTo(View.PONTUN);
    }

    /**
     * Handler to confirm order. Takes the user to the "Choose delivery method" page
     * @param e
     */
    @FXML
    private void fxStadfestingHandler(ActionEvent e) {

        ViewSwitcher.switchTo(View.DELIVERYMETHOD);
    }


    /**
     * Handler to remove items from the cart
     * @param e
     */
    @FXML
    private void fxremovefromcart(ActionEvent e) {
        if (fxKarfa.getSelectionModel().getSelectedItems().size() > 0) {
            int index = fxKarfa.getSelectionModel().getSelectedIndex();
            pontunController.karfa.deleteitem(index);
            fxKarfa.setItems(pontunController.karfa.getObs());
        }
    }


    /**
     * Setter for the delivery method
     * @param delivery delivery method (pick-up or home delivery)
     */
    public void setDelivery(String delivery) {
        this.delivery.set(delivery);
    }

    /**
     * Handler that changes the currency of the total price of the cart to the currency that is chosen
     * @param actionEvent
     */
    public void currencyChange(ActionEvent actionEvent) {
        pontunController.karfa.setCurrentCurrency(fxCurrencyBox.getSelectionModel().getSelectedItem().toString());
    }
}
