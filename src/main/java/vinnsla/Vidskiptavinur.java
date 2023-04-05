package vinnsla;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Vidskiptavinur {




    private StringProperty Name = new SimpleStringProperty();
    private StringProperty Address= new SimpleStringProperty();

    /**
     * a constructor for the user.
     * @param name name of the user
     * @param address address of the user
     */
    public Vidskiptavinur(StringProperty name, StringProperty address) {
        Name = name;
        Address = address;
    }


    /**
     *
     * @return returns the user's name
     */
    public String getName() {
        return Name.get();
    }
    /**
     *
     * @return returns the StringProperty of the user's name
     */
    public StringProperty nameProperty() {
        return Name;
    }
    /**
     *
     * @return returns the user's address
     */

    public String getAddress() {
        return Address.get();
    }
    /**
     *
     * @return returns the StringProperty of the user's address
     */
    public StringProperty addressProperty() {
        return Address;
    }

}
