package hi.jaser.webstore;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class TakeAwayApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        Scene scene = new Scene(new Pane());
        //stage.initStyle(StageStyle.TRANSPARENT);
        ViewSwitcher.setScene(scene);
        ViewSwitcher.switchTo(View.PONTUN);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("TakeAway");
    }

    public static void main(String[] args) {
        launch();
    }
}