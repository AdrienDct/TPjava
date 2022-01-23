import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class JsonFlightFiller {
    private ArrayList<Flight> list;
    private String flight_date;
    private Aeroport airport_Departure;
    private Aeroport airport_Arrival;

    public JsonFlightFiller(String jsonString, World w){
        try{
            InputStream is = new ByteArrayInputStream((jsonString.getBytes(StandardCharsets.UTF_8)));
            JsonReader rdr = Json.createReader(is);
            JsonObject obj = rdr.readObject();
            JsonArray results = obj.getJsonArray("data");
            list = new ArrayList<Flight>();
            for(JsonObject result : results.getValuesAs(JsonObject.class)){
                try{
                    String flight_date = result.getString("flight_date");
                    String departure = result.getJsonObject("departure").getString("iata");
                    String arrival = result.getJsonObject("arrival").getString("iata");

                    Aeroport airport_Departure =  w.findByCode(departure);
                    Aeroport airport_Arrival =  w.findByCode(arrival);

                    Flight flight = new Flight(flight_date, airport_Departure, airport_Arrival);
                    list.add(flight);
                }
                catch(Exception e){
                    e.printStackTrace();
                }
                System.out.println(list);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        try{
            World w = new World("./data/airport-codes_no_comma.csv");
            BufferedReader br = new BufferedReader(new FileReader("./data/JsonOrly.txt"));
            String test = br.readLine();
            JsonFlightFiller jsonFlightFiller = new JsonFlightFiller(test, w);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
