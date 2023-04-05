package hi.jaser.webstore;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import vinnsla.Veitingar;

public class PhonesController {

    @FXML
    ImageView fxPhone1;

    @FXML
    private ListView<Veitingar> menuItems;

    public void initialize() {
    }
    @FXML
    private void fxTilBakaHandler (ActionEvent e){
        ViewSwitcher.switchTo(View.PONTUN);
    }

    @FXML
    private void fxBuyPhone(ActionEvent e) {
            karfa.getObs().add(menuItems.getItems().get(1));
            fxKarfa.setItems(karfa.getObs());


        fxgreida.disableProperty().bind(karfa.isemptyProperty());

    }

}
