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
        veitingar.add(new Veitingar(new SimpleStringProperty("iPhone1"), new SimpleStringProperty("2500")));
        veitingar.add(new Veitingar(new SimpleStringProperty("iPhone2"), new SimpleStringProperty("3600")));
        veitingar.add(new Veitingar(new SimpleStringProperty("iPhone3"), new SimpleStringProperty("2500")));
        veitingar.add(new Veitingar(new SimpleStringProperty("iPhone4"), new SimpleStringProperty("3600")));
        veitingar.add(new Veitingar(new SimpleStringProperty("Tablet1"), new SimpleStringProperty("3600")));
        veitingar.add(new Veitingar(new SimpleStringProperty("Tablet2"), new SimpleStringProperty("3600")));
        veitingar.add(new Veitingar(new SimpleStringProperty("Tablet3"), new SimpleStringProperty("3600")));
        veitingar.add(new Veitingar(new SimpleStringProperty("Tablet4"), new SimpleStringProperty("3600")));
        veitingar.add(new Veitingar(new SimpleStringProperty("Laptop1"), new SimpleStringProperty("3600")));
        veitingar.add(new Veitingar(new SimpleStringProperty("Laptop2"), new SimpleStringProperty("3600")));
        veitingar.add(new Veitingar(new SimpleStringProperty("Laptop3"), new SimpleStringProperty("3600")));
        veitingar.add(new Veitingar(new SimpleStringProperty("Laptop4"), new SimpleStringProperty("3600")));
        veitingar.add(new Veitingar(new SimpleStringProperty("Accessory1"), new SimpleStringProperty("3600")));
        veitingar.add(new Veitingar(new SimpleStringProperty("Accessory2"), new SimpleStringProperty("3600")));
        veitingar.add(new Veitingar(new SimpleStringProperty("Accessory3"), new SimpleStringProperty("3600")));
        veitingar.add(new Veitingar(new SimpleStringProperty("Accessory4"), new SimpleStringProperty("3600")));

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
