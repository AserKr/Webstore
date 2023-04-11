package vinnsla;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Products {

    private StringProperty name = new SimpleStringProperty();



    private StringProperty price = new SimpleStringProperty();


    /**
     * a constructor for the products
     * @param name name of the product
     * @param price price of the product
     */
    public Products(StringProperty name, StringProperty price){
        this.name = name;
        this.price = price;
    }
    public String getPrice() {
        return price.get();
    }
    public void setPrice(String price) {
        this.price.set(price);
    }
    @Override
    public String toString() {
        return  name.getValue() + ", " + price.getValue();
    }
}
