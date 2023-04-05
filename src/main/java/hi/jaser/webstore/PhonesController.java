package hi.jaser.webstore;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import vinnsla.Veitingar;

public class PhonesController {
PontunController pontunController;
    @FXML
    ImageView fxPhone1;


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
}
