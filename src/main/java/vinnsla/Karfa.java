package vinnsla;

import javafx.beans.property.*;

public class Karfa extends ProductList {


    private StringProperty currencyPrice = new SimpleStringProperty();


    private String currentCurrency;

    private IntegerProperty totalPrice;
    private BooleanProperty isEmptyProp = new SimpleBooleanProperty();


    /**
     * a constructor for the cart, the cart has one extra element than ProductList which is the total price of the elements inside it
     *
     * @param totalPrice the total price of the elements in the cart.
     */
    public Karfa(IntegerProperty totalPrice) {
        this.totalPrice = totalPrice;
    }


    public int getTotalPrice() {
        return totalPrice.get();
    }

    public IntegerProperty totalPriceProperty() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice.set(totalPrice);
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
                total = getTotalPrice() / 140;
                break;
            case "USD":
                total = getTotalPrice() / 135;
                break;
            case "ISK":
                total = getTotalPrice();
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


