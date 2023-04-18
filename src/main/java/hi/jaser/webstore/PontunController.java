package hi.jaser.webstore;


import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import vinnsla.*;

public class PontunController {

    @FXML
    Button fxgreida;
    @FXML
    Label fxTotalPrice;

    @FXML
    Button fxInnskraning;

    private int whichItem = 0;

    @FXML
    Label label1;

    @FXML
    Label label2;

    @FXML
    Label label3;

    @FXML
    Hyperlink hyperlink;

    @FXML
    ImageView fxLogo;

    public Karfa karfa;


    private DatePicker dateOfBirth;

    public ListView<Products> getMenuItems() {
        return menuItems;
    }
    ProductList menu;
    @FXML
    private ListView<Products> menuItems;
    private Customer user;
    private Password password;

    /**
     * sets up the main (PONTUN) scene and binds its components together, also sets up liseteners on some components.
     */
    @FXML
    private void initialize() {
        dateOfBirth=new DatePicker();
        user = new Customer(new SimpleStringProperty(null), new SimpleStringProperty(null));
        karfa = new Karfa(new SimpleIntegerProperty(0));
        menu = new ProductList();
        menu.setjaItems();

        label1.setText("Opening hours: \n \n Mondays-Thursdays: 8:00-16:00 \n Fridays: 8:00-15:00 \n Saturdays: 11:00-14:00 \n Sundays: CLOSED ");
        label2.setText("Contact us: \n \n Phone number: 555-1234 \n Email: info@jaser.com");
        label3.setText("Do you want to work with us?");
        password = new Password(new SimpleStringProperty(null));
        karfa.setTotalPrice(0);
        karfa.setCurrencyPrice("ISK");
        karfa.setCurrentCurrency("ISK");
        fxTotalPrice.setText("Total Price: 0");
        karfa.getObs().addListener((ListChangeListener<? super Products>) change -> {
            int heild = 0;
            for (int i = 0; i < karfa.getObs().size(); i++) {
                heild = heild + karfa.getPrice(i);
            }
            karfa.setTotalPrice(heild);
            karfa.setCurrencyPrice(karfa.getCurrentCurrency());
        });
        fxTotalPrice.textProperty().bind(karfa.currencyPriceProperty());
    }


    /**
     * Handler to open CustomerDialog or PasswordDialog
     * @param e
     */
    @FXML
    private void fxSignInHandler(ActionEvent e) {
        if (user.getName() == null) {
            CustomerDialog d = new CustomerDialog();
            d.show();
        } else {
            PasswordDialog d = new PasswordDialog();
            d.show();
        }
    }

    /**
     * Getter for the date of birth of the customer
     * @return the customer's date of birth
     */
    public DatePicker getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(DatePicker dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Handler that opens the JobApplicationDialog
     */
    @FXML
    private void fxJobHandler() {
        JobApplicationDialog d = new JobApplicationDialog();
        d.show();
    }

    /**
     * Handler that opens the phones page
     */
    @FXML
    private void fxPhonesHandler() {
        ViewSwitcher.switchTo(View.PHONES);
    }

    /**
     * Handler that opens the laptops page
     */
    @FXML
    private void fxLaptopsHandler() {
        ViewSwitcher.switchTo(View.LAPTOPS);
    }

    /**
     * Handler that opens the tablets page
     */
    @FXML
    private void fxTabletsHandler() {
        ViewSwitcher.switchTo(View.TABLETS);
    }

    /**
     * Handler that opens the accessories page
     */
    @FXML
    private void fxAccessoriesHandler() {
        ViewSwitcher.switchTo(View.ACCESSORIES);
    }

    /**
     * Handler to open the cart page
     */
    @FXML
    private void fxCartHandler() {
        ViewSwitcher.switchTo(View.CART);
    }

    /**
     * Getter for the total price of the cart
     * @return total price
     */
    public Label getFxTotalPrice() {
        return fxTotalPrice;
    }

    /**
     * Getter for the user's password
     * @return password
     */
    public Password getPassword() {
        return password;
    }

    /**
     * Getter for the user
     * @return user
     */
    public Customer getUser() {
        return user;
    }
}