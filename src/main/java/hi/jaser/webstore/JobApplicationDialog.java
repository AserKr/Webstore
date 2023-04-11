package hi.jaser.webstore;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;
import vinnsla.Customer;
import java.io.IOException;

public class JobApplicationDialog extends Dialog<Customer> {

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
     * The user interface is read og the dialog gets a pane
     */
    public JobApplicationDialog() {
        setDialogPane(lesaJobApplicationDialog());
        iLagiRegla();
    }

    /**
     * The look of the dialog is made
     * @return object of DialogPane
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
     * Rule to bind the Okay button in the dialog to the text fields
     */
    private void iLagiRegla() {
        Node iLagi = getDialogPane().lookupButton(fxILagi);
        iLagi.disableProperty().bind(fxName.textProperty().isEmpty().or(fxAddress.textProperty().isEmpty()).or(fxCV.textProperty().isEmpty()));
    }
}