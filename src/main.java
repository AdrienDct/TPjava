public class main {
    public static void main(String[] args){
    // Test purpose : Manually create an airport and return values
        /*Aeroport A = new Aeroport(
                "CDG",
                "Charles de Gaulle",
                "France",
                27.7,
                47447.7373);

        System.out.println(A.getIATA());
        System.out.println(A.getLatitude());
        System.out.println(A.getLatitude());
        System.out.println(A.toString());
         */

    World w = new World("./data/airport-codes_no_comma.csv");
    Aeroport Paris = w.findNearestAirport(2.316, 48.866);
    System.out.println(Paris);
    }
}