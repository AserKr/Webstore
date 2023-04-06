package vinnsla;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Matsedill {



    protected ObservableList<Veitingar> veitingar = FXCollections.observableArrayList();

    /**
     * a constructor for the menu, creates a menu of type observableList<Veitingar> where Veitingar is the class of the menu items.
     */
    public Matsedill(){
        this.veitingar = FXCollections.observableArrayList();
    }

    /**
     * a method that acts as a getter for the observable list.
     * @return returns all of the observable list's items in type Veitingar.
     */
    public ObservableList<Veitingar> getObs(){
        return veitingar;
    }

    /**
     * a method to set the menu items;
     */
    public void setjaGogn(){
        veitingar.add(new Veitingar(new SimpleStringProperty("iPhone 14 Pro Max"), new SimpleStringProperty("119995")));
        veitingar.add(new Veitingar(new SimpleStringProperty("Samsung Galaxy S22"), new SimpleStringProperty("109995")));
        veitingar.add(new Veitingar(new SimpleStringProperty("Google Pixel 6"), new SimpleStringProperty("99990")));
        veitingar.add(new Veitingar(new SimpleStringProperty("Sony Xperia IV"), new SimpleStringProperty("89990")));
        veitingar.add(new Veitingar(new SimpleStringProperty("iPad Air"), new SimpleStringProperty("89995")));
        veitingar.add(new Veitingar(new SimpleStringProperty("Google Pixel Tablet"), new SimpleStringProperty("79900")));
        veitingar.add(new Veitingar(new SimpleStringProperty("iPad Pro"), new SimpleStringProperty("105995")));
        veitingar.add(new Veitingar(new SimpleStringProperty("Galaxy Pad S7"), new SimpleStringProperty("69900")));
        veitingar.add(new Veitingar(new SimpleStringProperty("MacBook Pro"), new SimpleStringProperty("249900")));
        veitingar.add(new Veitingar(new SimpleStringProperty("Samsung Galaxy Book"), new SimpleStringProperty("169000")));
        veitingar.add(new Veitingar(new SimpleStringProperty("MacBook Air"), new SimpleStringProperty("199995")));
        veitingar.add(new Veitingar(new SimpleStringProperty("Galaxy Book Pro"), new SimpleStringProperty("189900")));
        veitingar.add(new Veitingar(new SimpleStringProperty("Phone Charger"), new SimpleStringProperty("7990")));
        veitingar.add(new Veitingar(new SimpleStringProperty("Tablet Pencil"), new SimpleStringProperty("15900")));
        veitingar.add(new Veitingar(new SimpleStringProperty("Laptop Charger"), new SimpleStringProperty("12995")));
        veitingar.add(new Veitingar(new SimpleStringProperty("Airpods"), new SimpleStringProperty("34995")));

    }


    /**
     *
     * @return returns the observableList of type Veitingar which contains the menu items.
     */
    public ObservableList<Veitingar> getVeitingar() {
        return veitingar;
    }

    /**
     *
     * @param index the index of the item, where the price needs to be found.
     * @return the price of the item at index.
     */
    public int getVerd (int index){
        return Integer.parseInt(veitingar.get(index).getVerd());
    }

    /**
     *
     * @param index the index of the item, where the item needs to be deleted.
     */
    public void deleteitem(int index) {
        veitingar.remove(index);

    }

    /**
     *
     * @return  returns the size of the observableList.
     */
    public int getsize() {
        return veitingar.size();

    }
}
