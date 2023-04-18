package hi.jaser.webstore;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class ViewSwitcher {
    private static final Map<View, Parent> cache = new HashMap<>();
    private static final Map<View, Object> controllers = new HashMap<>();
    private static Scene scene;

    /**
     * sets the secene.
     * @param scene the scene to be set
     */
    public static void setScene(Scene scene) {
        ViewSwitcher.scene = scene;
    }

    /**
     * switch the scene to the given paramters
     * @param view the required variable which provied the scene (fxml) file to switch to.
     */
    public static void switchTo(View view) {
        if (scene == null) {
            return;
        }
        try {
            Parent root;
            FXMLLoader loader = null;
            if (cache.containsKey(view)) {
                root = cache.get(view);
            } else {
                loader = new
                        FXMLLoader(ViewSwitcher.class.getResource(view.getFileName()));
                root = loader.load();
                cache.put(view, root);
                scene.setRoot(root);
                controllers.put(view, loader.getController());
            }
            scene.setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param v a View variable which decides from where the controller object is to be fetched.
     * @return returns a controller object for the given view variable.
     */
    public static Object lookup(View v) {
        return controllers.get(v);
    }
}
