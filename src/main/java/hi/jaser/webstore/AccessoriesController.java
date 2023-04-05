package hi.jaser.webstore;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class AccessoriesController {

    PontunController pontunController;
    @FXML
    ImageView fxAccessory1;

    public void initialize() {
        pontunController = (PontunController) ViewSwitcher.lookup(View.PONTUN);
    }
    @FXML
    private void fxTilBakaHandler (ActionEvent e){
        ViewSwitcher.switchTo(View.PONTUN);
    }

    @FXML
    private void fxBuyAccessory(ActionEvent e) {
        pontunController.karfa.getObs().add(pontunController.menu.getObs().get(12));
    }
    @FXML
    private void fxBuyAccessory2(ActionEvent e) {
        pontunController.karfa.getObs().add(pontunController.menu.getObs().get(13));
    }

    @FXML
    private void fxBuyAccessory3(ActionEvent e) {
        pontunController.karfa.getObs().add(pontunController.menu.getObs().get(14));
    }
    @FXML
    private void fxBuyAccessory4(ActionEvent e) {
        pontunController.karfa.getObs().add(pontunController.menu.getObs().get(15));
    }

}