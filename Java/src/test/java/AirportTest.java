import org.testng.annotations.BeforeClass;
import planes.ExperimentalPlane;
import models.ExperimentalPlaneSecrecyLevel;
import models.ExperimentalPlaneType;
import models.MilitaryPlaneType;
import org.testng.Assert;
import org.testng.annotations.Test;
import planes.MilitaryPlane;
import planes.PassengerPlane;
import planes.AbstractPlane;

import java.util.Arrays;
import java.util.List;

public class AirportTest {

    private Airport airport;
    private final static List<AbstractPlane> planes = Arrays.asList(
            new PassengerPlane("Boeing-737", 900, 12000, 60500, 164),
            new PassengerPlane("Boeing-737-800", 940, 12300, 63870, 192),
            new PassengerPlane("Boeing-747", 980, 16100, 70500, 242),
            new PassengerPlane("Airbus A320", 930, 11800, 65500, 188),
            new PassengerPlane("Airbus A330", 990, 14800, 80500, 222),
            new PassengerPlane("Embraer 190", 870, 8100, 30800, 64),
            new PassengerPlane("Sukhoi Superjet 100", 870, 11500, 50500, 140),
            new PassengerPlane("Bombardier CS300", 920, 11000, 60700, 196),
            new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000, MilitaryPlaneType.BOMBER),
            new MilitaryPlane("B-2 Spirit", 1030, 22000, 70000, MilitaryPlaneType.BOMBER),
            new MilitaryPlane("B-52 Stratofortress", 1000, 20000, 80000, MilitaryPlaneType.BOMBER),
            new MilitaryPlane("F-15", 1500, 12000, 10000, MilitaryPlaneType.FIGHTER),
            new MilitaryPlane("F-22", 1550, 13000, 11000, MilitaryPlaneType.FIGHTER),
            new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, MilitaryPlaneType.TRANSPORT),
            new ExperimentalPlane("Bell X-14", 277, 482, 500, ExperimentalPlaneType.HIGH_ALTITUDE
                    , ExperimentalPlaneSecrecyLevel.SECRET),
            new ExperimentalPlane("Ryan X-13 Vertijet", 560, 307, 500, ExperimentalPlaneType.VTOL
                    , ExperimentalPlaneSecrecyLevel.TOP_SECRET)
    );

    private final static PassengerPlane planeWithMaxPassengerCapacity = new PassengerPlane("Boeing-747", 980, 16100, 70500, 242);

    @BeforeClass
    public void initAirport() {
        airport = new Airport(planes);
    }

    @Test
    public void verifyAirportCanHaveTransportMilitaryPlanes() {
        Assert.assertTrue(airport.getTransportMilitaryPlanes().size() > 0);
    }

    @Test
    public void testGetPassengerPlaneWithMaxPassengerCapacity() {
        Assert.assertEquals(planeWithMaxPassengerCapacity, airport.getPassengerPlaneWithMaxPassengersCapacity());
    }

    @Test
    public void verifyPlanesCanBeSortedNaturallyByMaxLoadCapacity() {
        airport.sortPlanesByMaxLoadCapacity();
        List<? extends AbstractPlane> planesSortedByMaxLoadCapacity = airport.getAllPlanes();

        boolean isSortedNaturally = true;
        for (int i = 0; i < planesSortedByMaxLoadCapacity.size() - 1; i++) {
            AbstractPlane currentPlane = planesSortedByMaxLoadCapacity.get(i);
            AbstractPlane nextPlane = planesSortedByMaxLoadCapacity.get(i + 1);
            if (currentPlane.getMaxLoadCapacity() > nextPlane.getMaxLoadCapacity()) {
                isSortedNaturally = false;
                break;
            }
        }
        Assert.assertTrue(isSortedNaturally);
    }

    @Test
    public void verifyAirportCanHaveBomberMilitaryPlanes() {
        Assert.assertTrue(airport.getBomberMilitaryPlanes().size() > 0);
    }

    @Test
    public void verifyExperimentalPlanesHaveClassificationLevelHigherThanUnclassified() {
        boolean hasUnclassifiedPlanes = airport.getExperimentalPlanes()
                .stream()
                .allMatch(o -> o.getClassificationLevel() == ExperimentalPlaneSecrecyLevel.UNCLASSIFIED);
        Assert.assertFalse(hasUnclassifiedPlanes);
    }
}
