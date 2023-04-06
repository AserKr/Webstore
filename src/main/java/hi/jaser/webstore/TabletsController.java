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

    public void initialize() {
        pontunController = (PontunController) ViewSwitcher.lookup(View.PONTUN);
        fxDescription1.setText("The iPad Air lets you have fun anywhere. It's powerful with the A13 Bionic processor and supports the 1st generation Apple Pencil, which takes drawing to the next level.");
        fxDescription2.setText("Watch movies and shows on the Google Pixel Tablet with an 11 inch 2K screen and four JBL speakers with Dolby Atmos. The Pixel Tablet also has a large battery and good storage space.");
        fxDescription3.setText("iPad Pro is more productive than ever with the Apple M2 processor. Together with the Liquid Retina XDR display, iPad Pro displays excellent picture quality.");
        fxDescription4.setText("The Samsung Galaxy Tab is light, thin and handy. The tablet has great battery life, stereo speakers with Dolby Atmos sound, and an 8 MP rear camera.");
    }
    @FXML
    private void fxTilBakaHandler (ActionEvent e){
        ViewSwitcher.switchTo(View.PONTUN);
    }


    @FXML
    private void fxBuyTablet(ActionEvent e) {
        pontunController.karfa.getObs().add(pontunController.menu.getObs().get(4));
    }
    @FXML
    private void fxBuyTablet2(ActionEvent e) {
        pontunController.karfa.getObs().add(pontunController.menu.getObs().get(5));
    }

    @FXML
    private void fxBuyTablet3(ActionEvent e) {
        pontunController.karfa.getObs().add(pontunController.menu.getObs().get(6));
    }
    @FXML
    private void fxBuyTablet4(ActionEvent e) {
        pontunController.karfa.getObs().add(pontunController.menu.getObs().get(7));
    }

    @FXML
    private void fxgreidaHandler() {
        ViewSwitcher.switchTo(View.GREIDSLA);
    }
}