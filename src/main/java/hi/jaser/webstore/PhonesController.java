package hi.jaser.webstore;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import vinnsla.Veitingar;

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


    public void initialize() {
        pontunController = (PontunController) ViewSwitcher.lookup(View.PONTUN);
    }
    @FXML
    private void fxTilBakaHandler (ActionEvent e){
        ViewSwitcher.switchTo(View.PONTUN);
    }

    @FXML
    private void fxBuyPhone(ActionEvent e) {
            pontunController.karfa.getObs().add(pontunController.menu.getObs().get(0));
    }
    @FXML
    private void fxBuyPhone2(ActionEvent e) {
        pontunController.karfa.getObs().add(pontunController.menu.getObs().get(1));
    }

    @FXML
    private void fxBuyPhone3(ActionEvent e) {
        pontunController.karfa.getObs().add(pontunController.menu.getObs().get(2));
    }
    @FXML
    private void fxBuyPhone4(ActionEvent e) {
        pontunController.karfa.getObs().add(pontunController.menu.getObs().get(3));
    }

    @FXML
    private void fxgreidaHandler() {
        ViewSwitcher.switchTo(View.GREIDSLA);
    }
}
