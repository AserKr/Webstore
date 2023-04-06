package hi.jaser.webstore;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class DeliverymethodController {

    @FXML
    Button fxHomeDelivery;

    @FXML
    Button fxPickUp;

    @FXML
    private void fxTilBakaHandler (ActionEvent e){
        ViewSwitcher.switchTo(View.GREIDSLA);
    }


}
