package hi.jaser.webstore;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;
import vinnsla.Vidskiptavinur;
import java.io.IOException;
import java.util.Optional;

public class JobApplicationDialog extends Dialog<Vidskiptavinur> {

    @FXML
    private TextField fxName;
    @FXML
    private TextField fxAddress;
    @FXML
    private TextField fxCV;
    @FXML
    private ButtonType fxILagi;
    @FXML
    private ButtonType fxHaettaVid;



    /**
     * Notendaviðmótið lesið inn og dialogurinn fær pane
     */
    public JobApplicationDialog() {
        setDialogPane(lesaJobApplicationDialog());
        iLagiRegla();
    }

    /**
     * Útlit dialogsins búið til
     * @return hlutur af DialogPane
     */
    private DialogPane lesaJobApplicationDialog () {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("job-view.fxml"));
        try {
            fxmlLoader.setController(this);
            return fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    /**
     * Regla búin til um hvenær í lagi hnappurinn á að vera virkur/óvirkur
     */
    private void iLagiRegla() {
        Node iLagi = getDialogPane().lookupButton(fxILagi);
        iLagi.disableProperty().bind(fxName.textProperty().isEmpty().or(fxAddress.textProperty().isEmpty()).or(fxCV.textProperty().isEmpty()));
    }

}