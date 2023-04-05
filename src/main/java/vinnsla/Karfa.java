package vinnsla;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;

public class Karfa extends Matsedill{


    private IntegerProperty heildarverd;
    private BooleanProperty isemptyprop = new SimpleBooleanProperty();


    /**
     * a constructor for the cart, the cart has one extra element than matsedill which is the total price of the elements inside it
     * @param heildarverd the total price of the elements in the cart.
     */
    public Karfa(IntegerProperty heildarverd) {
        this.heildarverd = heildarverd;
    }

    public void setHeildarverd(int heildarverd) {
        this.heildarverd.set(heildarverd);
    }


    /**
     * a method to check the emptyproperty of the cart
     * @return returns a boolean property of whether the cart is empty or not;
     */
    public BooleanProperty isemptyProperty() {
         isemptyprop.set(this.getObs().isEmpty());
    return isemptyprop;
    }








}
