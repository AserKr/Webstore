package hi.jaser.webstore;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class AccessoriesController {

    PontunController pontunController;
    @FXML
    ImageView fxAccessory1;

    @FXML
    Button fxKarfa;

    @FXML
    Label fxDescription1;
    @FXML
    Label fxDescription2;
    @FXML
    Label fxDescription3;
    @FXML
    Label fxDescription4;

    /**
     * Sets the text for the descriptions for the products
     */
    public void initialize() {
        pontunController = (PontunController) ViewSwitcher.lookup(View.PONTUN);
        fxDescription1.setText("Charge your phone when you need them with the 20W USB-C charging plug. It supports Fast Charging and is compatible with most smartphones.");
        fxDescription2.setText("This tablet pencil allows you to write and draw easily on touch screens.");
        fxDescription3.setText("With this 30 W USB-C charger, you can charge your MacBook Air, MacBook Pro, Samsung Galaxy Book and Galaxy Book Pro at the highest possible speed.");
        fxDescription4.setText("The AirPods Pro are packed with innovative features such as Active Acoustic Isolation and Personalized Spatial Audio. Together with the charging case, they provide up to 30 hours of high-quality sound.");
    }

    /**
     * Handler to go back to the main page
     * @param e
     */
    @FXML
    private void fxGoBackHandler(ActionEvent e){
        ViewSwitcher.switchTo(View.PONTUN);
    }

    /**
     * Adds accessory number 1 to the cart
     * @param e
     */
    @FXML
    private void fxBuyAccessory(ActionEvent e) {
        pontunController.karfa.getObs().add(pontunController.menu.getObs().get(12));
    }

    /**
     * Adds accessory number 2 to the cart
     * @param e
     */
    @FXML
    private void fxBuyAccessory2(ActionEvent e) {
        pontunController.karfa.getObs().add(pontunController.menu.getObs().get(13));
    }

    /**
     * Adds accessory number 3 to the cart
     * @param e
     */
    @FXML
    private void fxBuyAccessory3(ActionEvent e) {
        pontunController.karfa.getObs().add(pontunController.menu.getObs().get(14));
    }

    /**
     * Adds accessory number 4 to the cart
     * @param e
     */
    @FXML
    private void fxBuyAccessory4(ActionEvent e) {
        pontunController.karfa.getObs().add(pontunController.menu.getObs().get(15));
    }


    /**
     * Handler to open the cart page
     */
    @FXML
    private void fxCartHandler() {
        ViewSwitcher.switchTo(View.CART);
    }

}