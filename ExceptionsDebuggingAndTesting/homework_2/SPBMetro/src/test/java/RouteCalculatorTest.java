import core.Line;
import core.Station;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class RouteCalculatorTest extends TestCase {

    List<Station> route = new ArrayList<>();
    StationIndex stationIndex = new StationIndex();
    RouteCalculator routeCalculator = new RouteCalculator(stationIndex);
    List<Station> oneConnection = new ArrayList<>();
    List<Station> twoConnection = new ArrayList<>();

    @Override
    protected void setUp() throws Exception {

        Line line1 = new Line(1,"Первая");
        Line line2 = new Line(2,"Вторая");
        Line line3 = new Line(3,"Третья");

        Station station1 = new Station("Петровская", line1);
        Station station2 = new Station("Арбузная", line1);
        Station station3 = new Station("Морковная", line2);
        Station station4 = new Station("Яблочная", line2);
        Station station5 = new Station("Московская",line3);
        Station station6 = new Station("Минская",line3);

        line1.addStation(station1);
        line1.addStation(station2);
        line2.addStation(station3);
        line2.addStation(station4);
        line3.addStation(station5);
        line3.addStation(station6);

        stationIndex.addLine(line1);
        stationIndex.addLine(line2);
        stationIndex.addLine(line3);

        stationIndex.addStation(station1);
        stationIndex.addStation(station2);
        stationIndex.addStation(station3);
        stationIndex.addStation(station4);
        stationIndex.addStation(station5);
        stationIndex.addStation(station6);

        route.add(station1);
        route.add(station2);
        route.add(station3);
        route.add(station4);
        route.add(station5);
        route.add(station6);

        oneConnection.add(station2);
        oneConnection.add(station3);

        twoConnection.add(station2);
        twoConnection.add(station3);
        twoConnection.add(station4);
        twoConnection.add(station5);

//        stationIndex.addConnection(route);
//        stationIndex.addConnection(oneConnection);
//        stationIndex.addConnection(twoConnection);

    }

    public void testGetShortestRouteWithoutConnection() {
        stationIndex.addConnection(route);
        List<Station> actual = routeCalculator.getShortestRoute(route.get(0), route.get(route.size() - 1));
        List<Station> expected = route.subList(0, route.size());
        assertEquals(expected,actual);
    }
    public void testGetShortestRouteWithOneConnection() {
        stationIndex.addConnection(oneConnection);
        List<Station> actual = routeCalculator.getShortestRoute(stationIndex.getStation("Арбузная"), stationIndex.getStation("Морковная"));
        List<Station> expected = route.subList(0, route.size());
        assertEquals(expected,actual);
    }

    public void testGetShortestRouteWithTwoConnection() {
        stationIndex.addConnection(twoConnection);
        List<Station> actual = routeCalculator.getShortestRoute(stationIndex.getStation("Яблочная"), stationIndex.getStation("Московская"));
        List<Station> expected = route.subList(0, route.size());
        assertEquals(expected,actual);
    }



        public void testCalculateDuration() {
        double actual = RouteCalculator.calculateDuration(route);
        double expected = 14.5;

        assertEquals(expected,actual);
    }


    @Override
    protected void tearDown() throws Exception {

    }
}
