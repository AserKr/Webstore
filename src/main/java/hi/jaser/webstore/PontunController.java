package hi.jaser.webstore;


import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import vinnsla.*;

public class PontunController {
    @FXML
    ListView fxKarfa;
    @FXML
    Button fxgreida;
    @FXML
    Label fxHeildarverd;
    @FXML
    Button fxTakaUrKorfu;
    @FXML
    Button fxSetjaKorfu;
    @FXML
    Button fxInnskraning;
    private int whichItem = 0;
    private int whichItemkarfa = 0;

    public Karfa karfa;
    @FXML
    private ListView<Veitingar> menuItems;
    private Vidskiptavinur user;
    private Password password;
    /**
     * sets up the main (PONTUN) scene and binds its components together, also sets up liseteners on some components.
     */
    @FXML
    private void initialize() {
        user = new Vidskiptavinur(new SimpleStringProperty(null), new SimpleStringProperty(null));
        karfa = new Karfa(new SimpleIntegerProperty(0));
       /* menu = new Matsedill();*/
        password = new Password(new SimpleStringProperty(null));
        fxHeildarverd.setText("Total Price: 0 kr.");
        karfa.getObs().addListener((ListChangeListener<? super Veitingar>) change -> {
            System.out.println("Breyting");
            int heild = 0;
            for (int i = 0; i < karfa.getObs().size(); i++) {
                heild = heild + karfa.getVerd(i);
            }
            karfa.setHeildarverd(heild);
            fxHeildarverd.setText("Total Price: " + String.valueOf(heild)+ " kr.");
        });
        /*menuItems.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        menuItems.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            // Indexinn í listanum.
            whichItem = menuItems.getSelectionModel().getSelectedIndex();
        });*/
        /*fxKarfa.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        fxKarfa.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            // Indexinn í listanum.
            whichItemkarfa = fxKarfa.getSelectionModel().getSelectedIndex();
        });
        fxgreida.disableProperty().bind(karfa.isemptyProperty());*/
    }


    @FXML
    private void fxsetjakorfuHandler(ActionEvent e) {
        if (whichItem != -1) {
            karfa.getObs().add(menuItems.getItems().get(whichItem));
            fxKarfa.setItems(karfa.getObs());

        }
        fxgreida.disableProperty().bind(karfa.isemptyProperty());

    }

    @FXML

    private void fxtakaurKorfuHandler(ActionEvent e) {
        if (whichItemkarfa != -1&&whichItemkarfa<karfa.getsize()) {
            karfa.deleteitem(whichItemkarfa);
            fxKarfa.setItems(karfa.getObs());

        }
        fxgreida.disableProperty().bind(karfa.isemptyProperty());
    }

    @FXML
    private void fxInnskraningHandler(ActionEvent e) {
        if (user.getName() == null) {
            VidskiptavinurDialog d = new VidskiptavinurDialog();
            d.show();
        } else {
            PasswordDialog d = new PasswordDialog();
            d.show();
        }


    }


    @FXML
    private void fxPhonesHandler() {
        ViewSwitcher.switchTo(View.PHONES);
    }

    @FXML
    private void fxLaptopsHandler() {
        ViewSwitcher.switchTo(View.LAPTOPS);
    }

    @FXML
    private void fxTabletsHandler() {
        ViewSwitcher.switchTo(View.TABLETS);
    }

    @FXML
    private void fxAccessoriesHandler() {
        ViewSwitcher.switchTo(View.ACCESSORIES);
    }

    @FXML
    private void fxgreidaHandler() {
        ViewSwitcher.switchTo(View.GREIDSLA);
    }

    public Label getFxHeildarverd() {
        return fxHeildarverd;
    }

    public Password getPassword() {
        return password;
    }

    public Vidskiptavinur getUser() {
        return user;
    }


}