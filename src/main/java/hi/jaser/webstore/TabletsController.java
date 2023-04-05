package hi.jaser.webstore;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class TabletsController {

    PontunController pontunController;
    @FXML
    ImageView fxTablet1;

    public void initialize() {
        pontunController = (PontunController) ViewSwitcher.lookup(View.PONTUN);
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
}