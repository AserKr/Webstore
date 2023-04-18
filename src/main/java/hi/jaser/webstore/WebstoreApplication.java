package hi.jaser.webstore;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class WebstoreApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        Scene scene = new Scene(new Pane());
        ViewSwitcher.setScene(scene);
        ViewSwitcher.switchTo(View.PONTUN);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("WEBSTORE");
    }

    public static void main(String[] args) {
        launch();
    }
}