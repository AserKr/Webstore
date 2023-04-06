package hi.jaser.webstore;


import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import vinnsla.*;

import java.util.Date;

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

    @FXML
    Label label1;

    @FXML
    Label label2;

    @FXML
    Label label3;

    @FXML
    Hyperlink hyperlink;

    @FXML
    ImageView fxLogo;

    public Karfa karfa;




    private DatePicker dateOfBirth;

    public ListView<Veitingar> getMenuItems() {
        return menuItems;
    }
Matsedill menu;
    @FXML
    private ListView<Veitingar> menuItems;
    private Vidskiptavinur user;
    private Password password;
    /**
     * sets up the main (PONTUN) scene and binds its components together, also sets up liseteners on some components.
     */
    @FXML
    private void initialize() {
        dateOfBirth=new DatePicker();
        user = new Vidskiptavinur(new SimpleStringProperty(null), new SimpleStringProperty(null));
        karfa = new Karfa(new SimpleIntegerProperty(0));
        menu = new Matsedill();
        menu.setjaGogn();

        label1.setText("Opening hours: \n \n Mondays-Thursdays: 8:00-16:00 \n Fridays: 8:00-15:00 \n Saturdays: 11:00-14:00 \n Sundays: CLOSED ");
        label2.setText("Contact us: \n \n Phone number: 555-1234 \n Email: info@jaser.com");
        label3.setText("Do you want to work with us?");
        password = new Password(new SimpleStringProperty(null));
        karfa.setHeildarverd(0);
        karfa.setCurrencyPrice("ISK");
        karfa.setCurrentCurrency("ISK");
        fxHeildarverd.setText("Total Price: 0");
        karfa.getObs().addListener((ListChangeListener<? super Veitingar>) change -> {
            System.out.println("Breyting");
            int heild = 0;
            for (int i = 0; i < karfa.getObs().size(); i++) {
                heild = heild + karfa.getVerd(i);
            }
            karfa.setHeildarverd(heild);
            karfa.setCurrencyPrice(karfa.getCurrentCurrency());
            System.out.println(fxHeildarverd);
            System.out.println(heild);;

        });
   fxHeildarverd.textProperty().bind(karfa.currencyPriceProperty());
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
    public DatePicker getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(DatePicker dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    @FXML
    private void fxJobHandler() {
            JobApplicationDialog d = new JobApplicationDialog();
            d.show();
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