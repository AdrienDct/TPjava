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
    System.out.println("We found " + w.getList().size() + " airports");
    Aeroport paris = w.findNearestAirport(48.866, 2.316);
    Aeroport cdg = w.findByCode("CDG");
    double distanceCDG = w.Distance(48.866, 2.316, cdg.getLongitude(), cdg.getLatitude());
    double distanceParis = w.Distance(48.866, 2.316, paris.getLongitude(), paris.getLatitude());

    System.out.println("Researching aiport 'CDG' returned : " + cdg);
    System.out.println("Nearest airport from Paris : " + paris);
    System.out.println("Distance between Paris and CDG : " + distanceCDG);
    System.out.println("Distance between CDG and Paris : " + distanceParis);
    }
}