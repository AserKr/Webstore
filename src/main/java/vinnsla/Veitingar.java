package vinnsla;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Veitingar {

    private StringProperty nafn = new SimpleStringProperty();
    private StringProperty verd = new SimpleStringProperty();

    /**
     * a constructor for the menu items
     * @param nafn name of the food
     * @param verd price of the food
     */
    public Veitingar (StringProperty nafn, StringProperty verd){
        this.nafn=nafn;
        this.verd=verd;
    }
    public String getVerd() {
        return verd.get();
    }

    @Override
    public String toString() {
        return  nafn.getValue() + ", " + verd.getValue();
    }
}
