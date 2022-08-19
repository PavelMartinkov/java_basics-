import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Airport airport = Airport.getInstance();
        System.out.println(findPlanesLeavingInTheNextTwoHours(airport));
    }

    public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {

        List<Airport> airportList = new ArrayList<>();
        airportList.add(airport);
        return airportList.stream()
                .flatMap(a -> a.getTerminals().stream())
                .flatMap(p -> p.getFlights().stream())
                .filter(f -> f.getType().equals(Flight.Type.DEPARTURE))
                .filter(d -> d.getDate().toInstant().isBefore(Instant.now().plusSeconds(7200)))
                .filter(k -> k.getDate().toInstant().isAfter(Instant.now()))
                .collect(Collectors.toList());
    }
}