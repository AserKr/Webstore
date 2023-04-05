package vinnsla;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Password {


    private StringProperty Password = new SimpleStringProperty();

    /**
     * a constructor for the user's password
     * @param password the user's password
     */
    public Password(StringProperty password) {
        Password = password;
    }

    /**
     *
     * @return returns the user's password.
     */
    public String getPassword() {
        return Password.get();
    }
    /**
     *
     * @return returns the StringProperty of user's password.
     */
    public StringProperty passwordProperty() {
        return Password;
    }


}
