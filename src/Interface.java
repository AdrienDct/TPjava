import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.PickResult;
import javafx.stage.Stage;

public class Interface extends Application {
    double PosX = 0;
    double PosY = 0;
    double Zoom = 0;
    double currentZoom = 1050;
    double newTranslation = 0;

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Hello World");
        Group earth = new Earth("earth_lights_4800.png");
        Scene ihm = new Scene(earth, 600, 400, true);
        primaryStage.setScene(ihm);
        primaryStage.show();
        World w = new World("./data/airport-codes_no_comma.csv");

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
            }
            if(event.getEventType() == MouseEvent.MOUSE_DRAGGED){
                Zoom = PosY - event.getSceneY();
                newTranslation = -currentZoom + Zoom;
                camera.setTranslateZ(-currentZoom + Zoom);
            }
        });

        ihm.addEventHandler(MouseEvent.ANY, event ->{
            if(event.getButton() == MouseButton.SECONDARY && event.getEventType() == MouseEvent.MOUSE_CLICKED){
                PickResult pickResult = event.getPickResult();
                if(pickResult.getIntersectedPoint() != null){
                    double localYpoint = pickResult.getIntersectedTexCoord().getY();
                    double localXpoint = pickResult.getIntersectedTexCoord().getX();

                    double longitude = 360 * (localXpoint - 0.5);
                    double calculLatitude = Math.exp((0.5-localYpoint)/0.2678);
                    double latitude = 2 * (Math.toDegrees(Math.atan(calculLatitude)))- 90;

                    Aeroport distanceFromPoint = w.findNearestAirport(latitude, longitude);
                    System.out.println("Nearest Airport : " + distanceFromPoint);

                    ((Earth) earth).displayRedSphere(distanceFromPoint);
                }
            }
        });
    }

    public static void main(String[] args){
        launch(args);
    }
}
