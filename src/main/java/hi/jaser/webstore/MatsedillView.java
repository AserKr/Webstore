package hi.jaser.webstore;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import vinnsla.Matsedill;

import java.io.IOException;

public class MatsedillView extends ListView {

    public MatsedillView() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("matsedill-view.fxml"));
        fxmlLoader.setRoot(this);   // rótin á viðmótstrénu sett hér
        fxmlLoader.setController(this); // controllerinn settur hér en ekki í .fxml skránni
        try {
            fxmlLoader.load();          // viðmótstréð lesið inn (þ.e. .fxml skráin)
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        Matsedill local = new Matsedill();
        local.setjaGogn();
        setItems(local.getVeitingar());
    }


}

