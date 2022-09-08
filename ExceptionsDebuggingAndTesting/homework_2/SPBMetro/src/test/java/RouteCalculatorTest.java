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
                new Line(1, "Первая"),
                new Line(2, "Вторая"),
                new Line(3, "Третья"));

        lines.forEach(l -> stationIndex.addLine(l));

        List<Station> stations = Arrays.asList(
                new Station("Петровская", stationIndex.getLine(1)),
                new Station("Арбузная", stationIndex.getLine(1)),
                new Station("Октябрьская", stationIndex.getLine(1)),
                new Station("Морковная", stationIndex.getLine(2)),
                new Station("Яблочная", stationIndex.getLine(2)),
                new Station("Пушкинская", stationIndex.getLine(2)),
                new Station("Московская", stationIndex.getLine(3)),
                new Station("Киевская", stationIndex.getLine(3)),
                new Station("Минская", stationIndex.getLine(3)));

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
                stationIndex.getStation("Пушкинская"),
                stationIndex.getStation("Петровская")));
        stationIndex.addConnection(Arrays.asList(
                stationIndex.getStation("Московская"),
                stationIndex.getStation("Яблочная")));


        route.add(new Station("Петровская", new Line(1, "Первая")));
        route.add(new Station("Арбузная", new Line(1, "Первая")));
        route.add(new Station("Октябрьская", new Line(1, "Первая")));
        route.add(new Station("Морковная", new Line(2, "Вторая")));
        route.add(new Station("Яблочная", new Line(2, "Вторая")));
        route.add(new Station("Пушкинская", new Line(2, "Вторая")));
        route.add(new Station("Московская", new Line(3, "Третья")));
        route.add(new Station("Киевская", new Line(3, "Третья")));
        route.add(new Station("Минская", new Line(3, "Третья")));
    }

    @Test
    public void testGetShortestRouteWithoutConnection() throws Exception {
        List<Station> actual = routeCalculator.getShortestRoute(stationIndex.getStation("Петровская"), stationIndex.getStation("Октябрьская"));
        List<Station> expected = List.of(route.get(0), route.get(1), route.get(2));
        assertEquals(expected, actual);
    }

    @Test
    public void testGetShortestRouteWithOneConnection() throws Exception {
        List<Station> actual = routeCalculator.getShortestRoute(stationIndex.getStation("Петровская"), stationIndex.getStation("Пушкинская"));
        List<Station> expected = List.of(route.get(0), route.get(5));
        assertEquals(expected, actual);
    }

    @Test
    public void testGetShortestRouteWithTwoConnection() throws Exception {
        List<Station> actual = routeCalculator.getShortestRoute(stationIndex.getStation("Петровская"), stationIndex.getStation("Московская"));
        List<Station> expected = List.of(route.get(0), route.get(5), route.get(4), route.get(6));
        assertEquals(expected, actual);
    }

    @Test
    public void testCalculateDuration() {
        double actual = RouteCalculator.calculateDuration(route);
        double expected = 22.0;
        assertEquals(expected, actual);
    }

    @After
    protected void tearDown() throws Exception {
        System.out.println("Tests finished");
    }
}
