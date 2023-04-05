package hi.jaser.webstore;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class PhonesController {

    @FXML
    private void fxTilBakaHandler (ActionEvent e){
        ViewSwitcher.switchTo(View.PONTUN);
    }
}
