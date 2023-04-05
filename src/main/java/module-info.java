module hi.jaser.webstore {
    requires javafx.controls;
    requires javafx.fxml;


    opens hi.jaser.webstore to javafx.fxml;
    exports hi.jaser.webstore;
}