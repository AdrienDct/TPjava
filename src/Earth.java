import javafx.animation.AnimationTimer;
import javafx.geometry.Point3D;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;
import javafx.scene.Group;
import javafx.scene.transform.Rotate;
import javafx.scene.image.Image;
import javafx.scene.transform.Translate;

import java.util.ArrayList;

public class Earth extends Group{
    private Sphere sph;
    private Sphere redSphere;
    private Sphere yellowSphere;
    private Object animationTimer;
    private Object animationTimer2;
    private Rotate ry;
    private ArrayList<Sphere> YellowSphere;
    private String path;
    PhongMaterial material;
    PhongMaterial AeroportMaterial;
    private double rayon = 5;
    private double X;
    private double Y;
    private double Z;

    public Earth(String path){
        material = new PhongMaterial();
        Sphere sph = new Sphere(300);
        Image layout = new Image(path);
        material.setDiffuseMap(layout);
        sph.setMaterial(material);
        Point3D pointRotation = new Point3D(0, 1, 0);
        Rotate ry = new Rotate(0, pointRotation);
        sph.getTransforms().add(ry);
        this.getChildren().add(sph);

        AnimationTimer animationTimer = new AnimationTimer(){
            @Override
            public void handle(long time){
                ry.setAngle( (0.01)*(2*Math.PI)*(0.00000024*time) );
            }
        };
        animationTimer.start();
    }

    public Sphere createSphere(Aeroport a, Color color){
        AeroportMaterial = new PhongMaterial(color);
        Sphere sphereAeroport = new Sphere(50);
        sphereAeroport.setMaterial(AeroportMaterial);
        X = Math.toDegrees(rayon * Math.cos(a.getLatitude() - 13) * Math.sin(a.getLongitude()));
        Y = Math.toDegrees(- rayon * Math.sin(a.getLatitude() - 13));
        Z = Math.toDegrees(- rayon * Math.cos(a.getLatitude() - 13) * Math.sin(a.getLongitude()));
        sphereAeroport.getTransforms().add(new Translate(X, Y, Z));

        System.out.println("X : " + X);
        System.out.println("Y : " + Y);
        System.out.println("Z : " + Z);

        return sphereAeroport;
    }

    public void displayRedSphere(Aeroport a){
        Sphere redSphere = createSphere(a, Color.RED);
        Point3D pointRotation = new Point3D(0, 1, 0);
        Rotate ry = new Rotate(0, pointRotation);
        redSphere.getTransforms().add(ry);
        this.getChildren().add(redSphere);
    }

    public void displayYellowSphere(Aeroport a){
        Sphere redSphere = createSphere(a, Color.YELLOW);
        Point3D pointRotation = new Point3D(0, 1, 0);
        Rotate ry = new Rotate(0, pointRotation);
        yellowSphere.getTransforms().add(ry);
        this.getChildren().add(yellowSphere);
    }
}
