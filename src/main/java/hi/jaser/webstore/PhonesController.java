package hi.jaser.webstore;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class PhonesController {
    PontunController pontunController;
    @FXML
    ImageView fxPhone1;
    @FXML
    ImageView fxPhone2;
    @FXML
    ImageView fxPhone3;
    @FXML
    ImageView fxPhone4;

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
        fxDescription1.setText("The iPhone 14 Pro Max has an incredible 6.7 inch OLED touch screen with a variable 120 Hz refresh rate and IP68 water resistance.");
        fxDescription2.setText("The Samsung Galaxy S22 has a flat and beautiful 120 Hz display, an eight-core Exynos 2200 processor and a long-lasting battery. Take advantage of the three cameras to take amazing photos.");
        fxDescription3.setText("The Google Pixel 6 offers good performance. An excellent 6.59 inch 120 Hz IPS touch screen, 64 MP camera captures every detail, a 5000 mAh battery and 33W fast charging.");
        fxDescription4.setText("The Sony Xperia IV features a large 6.52 inch HD+ a-Si TFT display with a 90 Hz refresh rate, a powerful 50 MP camera, an octa-core processor and a 5050 mAh battery that supports 20W fast charging.");
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
     * Adds phone number 1 to the cart
     * @param e
     */
    @FXML
    private void fxBuyPhone(ActionEvent e) {
            pontunController.karfa.getObs().add(pontunController.menu.getObs().get(0));
    }
    /**
     * Adds phone number 2 to the cart
     * @param e
     */
    @FXML
    private void fxBuyPhone2(ActionEvent e) {
        pontunController.karfa.getObs().add(pontunController.menu.getObs().get(1));
    }

    /**
     * Adds phone number 3 to the cart
     * @param e
     */
    @FXML
    private void fxBuyPhone3(ActionEvent e) {
        pontunController.karfa.getObs().add(pontunController.menu.getObs().get(2));
    }
    /**
     * Adds phone number 4 to the cart
     * @param e
     */
    @FXML
    private void fxBuyPhone4(ActionEvent e) {
        pontunController.karfa.getObs().add(pontunController.menu.getObs().get(3));
    }

    /**
     * Handler to open the cart page
     */
    @FXML
    private void fxCartHandler() {
        ViewSwitcher.switchTo(View.CART);
    }
}
