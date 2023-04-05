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
        veitingar.add(new Veitingar(new SimpleStringProperty("BBQ Pizza"), new SimpleStringProperty("2500")));
        veitingar.add(new Veitingar(new SimpleStringProperty("Ham Pizza"), new SimpleStringProperty("3600")));
        veitingar.add(new Veitingar(new SimpleStringProperty("Pepperoni Pizza"), new SimpleStringProperty("2690")));
        veitingar.add(new Veitingar(new SimpleStringProperty("Garlic bread"), new SimpleStringProperty("1200")));
        veitingar.add(new Veitingar(new SimpleStringProperty("Carbonara"), new SimpleStringProperty("3590")));
        veitingar.add(new Veitingar(new SimpleStringProperty("Lasagna"), new SimpleStringProperty("3300")));
        veitingar.add(new Veitingar(new SimpleStringProperty("Nocco"), new SimpleStringProperty("400")));
        veitingar.add(new Veitingar(new SimpleStringProperty("Pepsi Max "), new SimpleStringProperty("300")));
        veitingar.add(new Veitingar(new SimpleStringProperty("Pepsi"), new SimpleStringProperty("300")));


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
