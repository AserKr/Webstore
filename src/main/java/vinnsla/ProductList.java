package vinnsla;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ProductList {



    protected ObservableList<Products> products = FXCollections.observableArrayList();

    /**
     * a constructor for the menu, creates a menu of type observableList<Products> where Products is the class of the menu items.
     */
    public ProductList(){
        this.products = FXCollections.observableArrayList();
    }

    /**
     * a method that acts as a getter for the observable list.
     * @return returns all of the observable list's items in type Products.
     */
    public ObservableList<Products> getObs(){
        return products;
    }

    /**
     * a method to set the menu items;
     */
    public void setjaItems(){
        products.add(new Products(new SimpleStringProperty("iPhone 14 Pro Max"), new SimpleStringProperty("119995")));
        products.add(new Products(new SimpleStringProperty("Samsung Galaxy S22"), new SimpleStringProperty("109995")));
        products.add(new Products(new SimpleStringProperty("Google Pixel 6"), new SimpleStringProperty("99990")));
        products.add(new Products(new SimpleStringProperty("Sony Xperia IV"), new SimpleStringProperty("89990")));
        products.add(new Products(new SimpleStringProperty("iPad Air"), new SimpleStringProperty("89995")));
        products.add(new Products(new SimpleStringProperty("Google Pixel Tablet"), new SimpleStringProperty("79900")));
        products.add(new Products(new SimpleStringProperty("iPad Pro"), new SimpleStringProperty("105995")));
        products.add(new Products(new SimpleStringProperty("Galaxy Pad S7"), new SimpleStringProperty("69900")));
        products.add(new Products(new SimpleStringProperty("MacBook Pro"), new SimpleStringProperty("249900")));
        products.add(new Products(new SimpleStringProperty("Samsung Galaxy Book"), new SimpleStringProperty("169000")));
        products.add(new Products(new SimpleStringProperty("MacBook Air"), new SimpleStringProperty("199995")));
        products.add(new Products(new SimpleStringProperty("Galaxy Book Pro"), new SimpleStringProperty("189900")));
        products.add(new Products(new SimpleStringProperty("Phone Charger"), new SimpleStringProperty("7990")));
        products.add(new Products(new SimpleStringProperty("Tablet Pencil"), new SimpleStringProperty("15900")));
        products.add(new Products(new SimpleStringProperty("Laptop Charger"), new SimpleStringProperty("12995")));
        products.add(new Products(new SimpleStringProperty("Airpods"), new SimpleStringProperty("34995")));

    }


    /**
     *
     * @return returns the observableList of type Products which contains the menu items.
     */
    public ObservableList<Products> getProducts() {
        return products;
    }

    /**
     *
     * @param index the index of the item, where the price needs to be found.
     * @return the price of the item at index.
     */
    public int getPrice(int index){
        return Integer.parseInt(products.get(index).getPrice());
    }

    /**
     *
     * @param index the index of the item, where the item needs to be deleted.
     */
    public void deleteitem(int index) {
        products.remove(index);

    }

    /**
     *
     * @return  returns the size of the observableList.
     */
    public int getsize() {
        return products.size();

    }
}
