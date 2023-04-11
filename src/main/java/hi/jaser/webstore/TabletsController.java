package hi.jaser.webstore;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class TabletsController {

    PontunController pontunController;
    @FXML
    ImageView fxTablet1;

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
        fxDescription1.setText("The iPad Air lets you have fun anywhere. It's powerful with the A13 Bionic processor and supports the 1st generation Apple Pencil, which takes drawing to the next level.");
        fxDescription2.setText("Watch movies and shows on the Google Pixel Tablet with an 11 inch 2K screen and four JBL speakers with Dolby Atmos. The Pixel Tablet also has a large battery and good storage space.");
        fxDescription3.setText("iPad Pro is more productive than ever with the Apple M2 processor. Together with the Liquid Retina XDR display, iPad Pro displays excellent picture quality.");
        fxDescription4.setText("The Samsung Galaxy Tab is light, thin and handy. The tablet has great battery life, stereo speakers with Dolby Atmos sound, and an 8 MP rear camera.");
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
     * Adds tablet number 1 to the cart
     * @param e
     */
    @FXML
    private void fxBuyTablet(ActionEvent e) {
        pontunController.karfa.getObs().add(pontunController.menu.getObs().get(4));
    }

    /**
     * Adds tablet number 2 to the cart
     * @param e
     */
    @FXML
    private void fxBuyTablet2(ActionEvent e) {
        pontunController.karfa.getObs().add(pontunController.menu.getObs().get(5));
    }

    /**
     * Adds tablet number 3 to the cart
     * @param e
     */
    @FXML
    private void fxBuyTablet3(ActionEvent e) {
        pontunController.karfa.getObs().add(pontunController.menu.getObs().get(6));
    }

    /**
     * Adds tablet number 4 to the cart
     * @param e
     */
    @FXML
    private void fxBuyTablet4(ActionEvent e) {
        pontunController.karfa.getObs().add(pontunController.menu.getObs().get(7));
    }

    /**
     * Handler to open the cart page
     */
    @FXML
    private void fxCartHandler() {
        ViewSwitcher.switchTo(View.CART);
    }
}