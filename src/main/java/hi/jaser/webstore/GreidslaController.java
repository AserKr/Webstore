package hi.jaser.webstore;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import vinnsla.Veitingar;
import vinnsla.Vidskiptavinur;

public class GreidslaController {
    @FXML
     Label fxDelivery;
    @FXML
     Button fxTilbaka;
    @FXML
    ListView fxKarfa;
    @FXML
    Label totalprice;


    private PontunController pontunController;
    private Vidskiptavinur user;


    private StringProperty delivery = new SimpleStringProperty();

    private static final String nameofStore="Aser Trattoria";
    private static final String message="Your Order Has been confirmed!";
    private static final String message1="Aser Trattoria appreciates your support!";
    private static final String Okay ="Back";

    /**
     * creates the setup and bindings for the payment scene, binds the payment scene with variables from the main (PONTUN) scene
     */
    @FXML
    private void initialize() {

        user = new Vidskiptavinur(new SimpleStringProperty(null), new SimpleStringProperty(null));
        pontunController = (PontunController) ViewSwitcher.lookup(View.PONTUN);
        totalprice.textProperty().bind(pontunController.getFxHeildarverd().textProperty());
        setDelivery("Your order will be delivered after 15 minutes");
      user.nameProperty().addListener((observable, oldValue, newValue) -> {
            setDelivery("Your order will be delivered after 15 minutes to " + user.getName() + " at " + user.getAddress());
        });
        user.addressProperty().addListener((observable, oldValue, newValue) -> {
            setDelivery("Your order will be delivered after 15 minutes to " + user.getName() + " at " + user.getAddress());
        });
        user.nameProperty().bind(pontunController.getUser().nameProperty());
        user.addressProperty().bind(pontunController.getUser().addressProperty());
for (int i=0; i<pontunController.karfa.getsize();i++){
    fxKarfa.getItems().add(pontunController.karfa.getObs().get(i));
}
pontunController.karfa.getObs().addListener((ListChangeListener<? super Veitingar>) change -> {
        fxKarfa.getItems().add(pontunController.karfa.getObs().get(pontunController.karfa.getsize()-1));
});
};



    @FXML

    private void fxTilBakaHandler (ActionEvent e){
        ViewSwitcher.switchTo(View.PONTUN);
    }
    @FXML

    private void fxStadfestingHandler (ActionEvent e){
        pontunController.fxgreida.disableProperty().bind(pontunController.karfa.isemptyProperty());
        ButtonType bType = new ButtonType(Okay,
                ButtonBar.ButtonData.OK_DONE);
        Alert a = stofnaAlert(bType);
        a.showAndWait();
    }
    private Alert stofnaAlert(ButtonType bILagi) {
        // Væri hægt að segja Alert.AlertType.CONFIRMATION en þá stjórnum við ekki útliti hnappanna
        Alert a = new Alert(Alert.AlertType.NONE,  message, bILagi);
        a.setTitle(nameofStore);
        a.setHeaderText(message1);
        return a;

    }



    public StringProperty deliveryProperty() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery.set(delivery);
    }

}