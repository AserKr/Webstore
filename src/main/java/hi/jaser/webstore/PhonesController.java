package hi.jaser.webstore;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class PhonesController {

    @FXML
    ImageView fxPhone1;

    public void initialize() {
        fxPhone1.getStyleClass().add("Phone-styles.css");
    }
    @FXML
    private void fxTilBakaHandler (ActionEvent e){
        ViewSwitcher.switchTo(View.PONTUN);
    }


}
