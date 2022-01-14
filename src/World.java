import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class World {
    private String filename;
    private ArrayList<Aeroport> list;

    public World(String filename){
        try{
            list = new ArrayList<Aeroport>();
            BufferedReader buf = new BufferedReader(new FileReader(filename));
            String s = buf.readLine();
            while(s!=null){
                s=s.replaceAll("\"",""); //Supprime les guillemets séparant les champs de données GPS
                String fields[]=s.split(",");
                if(fields[1].equals("large_airport")){
                    String IATA = fields[0];
                    String name = fields[2];
                    String country = fields[5];
                    String latitudeS = fields[12];
                    String longitudeS = fields[11];
                    double latitudeD = Double.parseDouble(latitudeS);
                    double longitudeD = Double.parseDouble(longitudeS);

                    Aeroport A = new Aeroport(IATA, name, country, latitudeD, longitudeD);
                    list.add(A);
                }
                s = buf.readLine();
            }
        }
        catch(Exception e){
            System.out.println("Maybe the file isn't there");
            System.out.println(list.get(list.size()-1));
            e.printStackTrace();
        }
    }


    public double Distance(double latitude1, double longitude1, double latitude2, double longitude2){
        double calcul1 = Math.pow( (latitude1 - latitude2), 2);      //Puissance 2
        double calcul2 = Math.pow(
                        ((longitude2 - longitude1)
                        + (Math.cos( (longitude2 + longitude1)/2) ))
                        , 2);
        double norme = calcul1 + calcul2;
        return norme;
    }

    public Aeroport findNearestAirport(double latitude, double longitude){
        for(int i=0; i<list.size(); i++){
            double latitude2 = list.get(i).getLatitude();
            double longitude2 = list.get(i).getLongitude();
            Aeroport B = new Aeroport B
            double norme = Distance(latitude, longitude, latitude2, longitude2);
            double distance_min = 100000.100;

            if(norme < distance_min){
                distance_min = norme;
            }
        }
        return A;
    }
}
