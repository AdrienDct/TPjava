public class main {
    public static void main(String[] args){
        Aeroport A = new Aeroport(
                "CDG",
                "Charles de Gaulle",
                "France",
                27.7,
                47447.7373);

        System.out.println(A.getIATA());
        System.out.println(A.getLatitude());
        System.out.println(A.getLatitude());
        System.out.println(A.toString());
    }

}