import core.Line;
import core.Station;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RouteCalculatorTest extends TestCase {

    List<Station> route;
    StationIndex stationIndex;
    RouteCalculator routeCalculator;

    @Before
    protected void setUp() throws Exception {
        route = new ArrayList<>();
        stationIndex = new StationIndex();
        routeCalculator = new RouteCalculator(stationIndex);

        List<Line> lines = Arrays.asList(
            new Line(1,"Первая"),
            new Line(2,"Вторая"),
            new Line(3,"Третья"));

        lines.forEach(l -> stationIndex.addLine(l));

        List<Station> stations = Arrays.asList(
                new Station("Петровская", stationIndex.getLine(1)),
                new Station("Арбузная", stationIndex.getLine(1)),
                new Station("Октябрьская", stationIndex.getLine(1)),
                new Station("Морковная", stationIndex.getLine(2)),
                new Station("Яблочная", stationIndex.getLine(2)),
                new Station("Пушкинская", stationIndex.getLine(2)),
                new Station("Московская",stationIndex.getLine(3)),
                new Station("Киевская",stationIndex.getLine(3)),
                new Station("Минская",stationIndex.getLine(3)));

        stations.forEach(s -> {
            s.getLine().addStation(s);
            stationIndex.addStation(s);
        });


        stationIndex.addConnection(Arrays.asList(
                stationIndex.getStation("Петровская"),
                stationIndex.getStation("Пушкинская")));
        stationIndex.addConnection(Arrays.asList(
                stationIndex.getStation("Яблочная"),
                stationIndex.getStation("Московская")));
        stationIndex.addConnection(Arrays.asList(
                stationIndex.getStation("Арбузная"),
                stationIndex.getStation("Минская")));


        route.add(stationIndex.getStation("Петровская"));
        route.add(stationIndex.getStation("Арбузная"));
        route.add(stationIndex.getStation("Октябрьская"));
        route.add(stationIndex.getStation("Морковная"));
        route.add(stationIndex.getStation("Яблочная"));
        route.add(stationIndex.getStation("Пушкинская"));
        route.add(stationIndex.getStation("Московская"));
        route.add(stationIndex.getStation("Киевская"));
        route.add(stationIndex.getStation("Минская"));
    }

    @Test
    public void testGetShortestRouteWithOneConnection() {
        List<Station> actual = routeCalculator.getShortestRoute(stationIndex.getStation("Петровская"), stationIndex.getStation("Морковная"));
        List<Station> expected = List.of(route.get(0),route.get(5), route.get(4), route.get(3));
        assertEquals(expected,actual);
    }

//    @Test
//    public void testGetShortestRouteWithTwoConnection() {
//        List<Station> actual = routeCalculator.getShortestRoute(stationIndex.getStation("Петровская"), stationIndex.getStation("Московская"));
//        List<Station> expected = List.of(route.get(0),route.get(5), route.get(4), route.get(3));
//        assertEquals(expected,actual);
//    }

        @Test
        public void testCalculateDuration() {
        double actual = RouteCalculator.calculateDuration(route);
        double expected = 22.0;
        assertEquals(expected,actual);
    }

    @After
    protected void tearDown() throws Exception {
        System.out.println("Tests finished");
    }
}
