import core.Line;
import core.Station;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class RouteCalculatorTest extends TestCase {

    List<Station> route = new ArrayList<>();
    StationIndex stationIndex = new StationIndex();
    RouteCalculator routeCalculator = new RouteCalculator(stationIndex);
    List<Station> oneConnection = new ArrayList<>();
    List<Station> twoConnection = new ArrayList<>();

    @Before
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

        stationIndex.addStation(station1);
        stationIndex.addStation(station2);
        stationIndex.addStation(station3);
        stationIndex.addStation(station4);
        stationIndex.addStation(station5);
        stationIndex.addStation(station6);

        stationIndex.addLine(line1);
        stationIndex.addLine(line2);
        stationIndex.addLine(line3);

        route.add(station1);
        route.add(station2);
        route.add(station3);
        route.add(station4);
        route.add(station5);
        route.add(station6);

        oneConnection.add(station2);
        oneConnection.add(station3);
        stationIndex.addConnection(oneConnection);

        twoConnection.add(station4);
        twoConnection.add(station5);
        stationIndex.addConnection(twoConnection);


    }
    @Test
    public void testGetShortestRoute() {
        stationIndex.addConnection(route);
        List<Station> actual = routeCalculator.getShortestRoute(stationIndex.getStation("Петровская"), stationIndex.getStation("Минская"));
        List<Station> expected = route.subList(0, route.size());
        assertEquals(expected,actual);
    }

        @Test
        public void testCalculateDuration() {
        double actual = RouteCalculator.calculateDuration(route);
        double expected = 14.5;
        assertEquals(expected,actual);
    }

    @After
    protected void tearDown() throws Exception {
        System.out.println("Tests finished");
    }
}
