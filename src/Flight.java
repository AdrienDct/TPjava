public class Flight {
    String flight_date;
    Aeroport airport_Departure;
    Aeroport airport_Arrival;

    public Flight(String flight_date, Aeroport airport_Departure, Aeroport airport_Arrival){
        this.flight_date = flight_date;
        this.airport_Departure = airport_Departure;
        this.airport_Arrival = airport_Arrival;
    }
}
