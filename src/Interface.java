import javafx.application.Application;
import javafx.event.EventType;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.transform.Transform;
import javafx.stage.Stage;
import javafx.scene.transform.Rotate;

public class Interface extends Application {
    double PosX = 0;
    double PosY = 0;
    double Zoom = 0;
    double currentZoom = 1050;
    double newTranslation = 0;

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Hello World");
        Group root = new Earth("earth_lights_4800.png");
        Pane pane  = new Pane(root);
        Scene ihm = new Scene(pane, 600, 400, true);
        primaryStage.setScene(ihm);
        primaryStage.show();

        PerspectiveCamera camera = new PerspectiveCamera(true);
        camera.setTranslateZ(-currentZoom);
        camera.setNearClip(0.1);
        camera.setFarClip(2000.0);
        camera.setFieldOfView(35);
        ihm.setCamera(camera);

        ihm.addEventHandler(MouseEvent.ANY, event ->{
            if(event.getEventType() == MouseEvent.MOUSE_PRESSED){
                PosY = event.getSceneY();
                PosX = event.getSceneX();
                System.out.println("Clicked on : (" + event.getSceneX() + ", " + event.getSceneY() + ")");
            }
            if(event.getEventType() == MouseEvent.MOUSE_DRAGGED){
                Zoom = PosY - event.getSceneY();
                newTranslation = -currentZoom + Zoom;
                camera.setTranslateZ(-currentZoom + Zoom);
            }
        });
    }

    public static void main(String[] args){
        launch(args);
    }
}
