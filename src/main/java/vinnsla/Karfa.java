package vinnsla;

import javafx.beans.property.*;

public class Karfa extends Matsedill {


    private StringProperty currencyPrice = new SimpleStringProperty();


    private String currentCurrency;

    private IntegerProperty heildarverd;
    private BooleanProperty isEmptyProp = new SimpleBooleanProperty();


    /**
     * a constructor for the cart, the cart has one extra element than matsedill which is the total price of the elements inside it
     *
     * @param heildarverd the total price of the elements in the cart.
     */
    public Karfa(IntegerProperty heildarverd) {
        this.heildarverd = heildarverd;
    }


    public int getHeildarverd() {
        return heildarverd.get();
    }

    public IntegerProperty heildarverdProperty() {
        return heildarverd;
    }

    public void setHeildarverd(int heildarverd) {
        this.heildarverd.set(heildarverd);
    }


    /**
     * a method to check the emptyproperty of the cart
     *
     * @return returns a boolean property of whether the cart is empty or not;
     */
    public BooleanProperty isemptyProperty() {
        isEmptyProp.set(this.getObs().isEmpty());
        return isEmptyProp;
    }


    public String getCurrencyPrice() {
        return currencyPrice.get();
    }

    public StringProperty currencyPriceProperty() {
        return currencyPrice;
    }

    public void setCurrencyPrice(String currency) {
        int total = 0;
        switch (currency) {
            case "EUR":
                total = getHeildarverd() / 140;
                break;
            case "USD":
                total = getHeildarverd() / 135;
                break;
            case "ISK":
                total = getHeildarverd();
                break;
        }
        this.currencyPrice.set("Total Price: " + total + " " + currency);
    }

    public String getCurrentCurrency() {
        return currentCurrency;
    }

    public void setCurrentCurrency(String currentCurrency) {
        this.currentCurrency = currentCurrency;
    }



    }


