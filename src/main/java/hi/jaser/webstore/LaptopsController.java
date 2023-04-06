package hi.jaser.webstore;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class LaptopsController {

    PontunController pontunController;
    @FXML
    ImageView fxLaptop1;

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
        fxDescription1.setText("MacBook Pro is packed with power thanks to the powerful M2 processor designed for professionals. It comes with a Retina display with True Tone equalization, P3 spectrum support and high brightness.");
        fxDescription2.setText("The Samsung Galaxy Book gives you everything you need to stay productive on the go.");
        fxDescription3.setText("The MacBook Air is a high-speed machine in a light frame with the eight-core Apple M1 processor. The laptop has a Retina display with True Tone technology, P3 color gamut and high brightness.");
        fxDescription4.setText("The Galaxy Book Pro helps you with your daily tasks. It has an Intel Celeron processor and is equipped with 4 GB of RAM and 128 GB of eMMC storage space.");
    }

    @FXML
    private void fxTilBakaHandler (ActionEvent e){
        ViewSwitcher.switchTo(View.PONTUN);
    }

    @FXML
    private void fxBuyLaptop(ActionEvent e) {
        pontunController.karfa.getObs().add(pontunController.menu.getObs().get(8));
    }
    @FXML
    private void fxBuyLaptop2(ActionEvent e) {
        pontunController.karfa.getObs().add(pontunController.menu.getObs().get(9));
    }

    @FXML
    private void fxBuyLaptop3(ActionEvent e) {
        pontunController.karfa.getObs().add(pontunController.menu.getObs().get(10));
    }
    @FXML
    private void fxBuyLaptop4(ActionEvent e) {
        pontunController.karfa.getObs().add(pontunController.menu.getObs().get(11));
    }

    @FXML
    private void fxgreidaHandler() {
        ViewSwitcher.switchTo(View.GREIDSLA);
    }

}