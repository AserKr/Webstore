package hi.jaser.webstore;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;

public class DeliverymethodController {

    @FXML
    Button fxHomeDelivery;

    @FXML
    Button fxPickUp;

    private static final String nameofStore = "Jaser Electronics";
    private static final String message1 = "Your Order Has been confirmed!";
    private static final String message = "Your order will be ready for pick-up in 2-3 business days";
    private static final String Okay = "Back to home page";

    private PontunController pontunController;

    @FXML
    private void initialize() {
        pontunController = (PontunController) ViewSwitcher.lookup(View.PONTUN);
    }

    @FXML
    private void fxGoBackHandler(ActionEvent e){
        ViewSwitcher.switchTo(View.CART);
    }
    @FXML
    private void fxPickUpHandler(ActionEvent e) {
        int i= pontunController.karfa.getsize();
        pontunController.karfa.getProducts().remove(0, i);

        ButtonType bType = new ButtonType(Okay,
                ButtonBar.ButtonData.OK_DONE);
        Alert a = makeAlert(bType);
        a.showAndWait();
        ViewSwitcher.switchTo(View.PONTUN);
    }

    private Alert makeAlert(ButtonType bILagi) {
        // Væri hægt að segja Alert.AlertType.CONFIRMATION en þá stjórnum við ekki útliti hnappanna
        Alert a = new Alert(Alert.AlertType.NONE, message, bILagi);
        a.setTitle(nameofStore);
        a.setHeaderText(message1);
        return a;
    }

    public void fxHomeDeliveryHandler(ActionEvent actionEvent) {
        HomeDeliveryDialog d = new HomeDeliveryDialog();
        d.show();
    }
}
