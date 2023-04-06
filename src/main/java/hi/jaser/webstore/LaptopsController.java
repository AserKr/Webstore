package hi.jaser.webstore;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class LaptopsController {

    PontunController pontunController;
    @FXML
    ImageView fxLaptop1;

    @FXML
    Button fxKarfa;

    public void initialize() {
        pontunController = (PontunController) ViewSwitcher.lookup(View.PONTUN);
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