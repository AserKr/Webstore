module hi.jaser.webstore {
        requires javafx.controls;
        requires javafx.fxml;

        opens vinnsla;
        exports vinnsla to javafx.fxml;

        exports hi.jaser.webstore;
        opens hi.jaser.webstore;
        }