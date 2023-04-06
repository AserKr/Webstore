package hi.jaser.webstore;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
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
    @FXML
    Button fxremove;


    private PontunController pontunController;
    private Vidskiptavinur user;
    private int whichItemkarfa = 0;
    @FXML
    ComboBox fxCurrencyBox;
    ObservableList<String> currencies = FXCollections.observableArrayList("USD", "ISK", "EUR");
    private StringProperty delivery = new SimpleStringProperty();



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
        fxCurrencyBox.setItems(currencies);

        for (int i = 0; i < pontunController.karfa.getsize(); i++) {
            fxKarfa.getItems().add(pontunController.karfa.getObs().get(i));
        }
        pontunController.karfa.getObs().addListener((ListChangeListener<? super Veitingar>) change -> {
            /*   fxKarfa.getItems().add(pontunController.karfa.getObs().get(pontunController.karfa.getsize()-1));*/
            fxKarfa.setItems(pontunController.karfa.getObs());
            System.out.println(fxKarfa.getItems().size());
            System.out.println(pontunController.karfa.getsize());
            ;
        });
        fxCurrencyBox.setValue(null);
 /*fxKarfa.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        fxKarfa.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            // Indexinn í listanum.
            whichItemkarfa = fxKarfa.getSelectionModel().getSelectedIndex();
        });*/
        fxCurrencyBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            pontunController.karfa.setCurrencyPrice(newValue.toString());
        });
    }

    ;


    @FXML

    private void fxTilBakaHandler(ActionEvent e) {
        ViewSwitcher.switchTo(View.PONTUN);
    }

    @FXML

    private void fxStadfestingHandler(ActionEvent e) {
        /*pontunController.fxgreida.disableProperty().bind(pontunController.karfa.isemptyProperty());
        ButtonType bType = new ButtonType(Okay,
                ButtonBar.ButtonData.OK_DONE);*/
        /*Alert a = stofnaAlert(bType);
        a.showAndWait();*/
        ViewSwitcher.switchTo(View.DELIVERYMETHOD);
    }




    @FXML

    private void fxremovefromcart(ActionEvent e) {
        if (fxKarfa.getSelectionModel().getSelectedItems().size() > 0) {
            int index = fxKarfa.getSelectionModel().getSelectedIndex();
            pontunController.karfa.deleteitem(index);
            fxKarfa.setItems(pontunController.karfa.getObs());

        }

    }


    public StringProperty deliveryProperty() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery.set(delivery);
    }

    public void currencyChange(ActionEvent actionEvent) {

pontunController.karfa.setCurrentCurrency(fxCurrencyBox.getSelectionModel().getSelectedItem().toString());
    }
    }
