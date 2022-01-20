import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;
import javafx.scene.Group;
import javafx.scene.transform.Rotate;
import javafx.scene.image.Image;
import java.util.ArrayList;

public class Earth extends Group{
    private Sphere sph;
    private Object sphere;
    private Rotate ry;
    private ArrayList<Sphere> yellowSphere;
    private double rayon;
    private String path;
    PhongMaterial material;

    public Earth(String path){
        material = new PhongMaterial();
        sph = createSphere(300);
        Image layout = new Image(path);
        material.setDiffuseMap(layout);
        sph.setMaterial(material);
        this.getChildren().add(sph);
    }

    public Sphere createSphere(double rayon){
        this.rayon = rayon;
        Sphere sphere = new Sphere(rayon);
        return sphere;
    }


}
