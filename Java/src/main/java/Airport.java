import planes.ExperimentalPlane;
import models.MilitaryPlaneType;
import planes.MilitaryPlane;
import planes.PassengerPlane;
import planes.AbstractPlane;

import java.util.*;
import java.util.stream.Collectors;

// version: 1.1
// made by Vitali Shulha
// 4-Jan-2019

public class Airport {
    private List<? extends AbstractPlane> planes;

    public Airport(List<? extends AbstractPlane> planes) {
        this.planes = planes;
    }

    public List<PassengerPlane> getPassengerPlanes() {
        return planes.stream()
                .filter(o -> o instanceof PassengerPlane)
                .map(o -> (PassengerPlane) o)
                .collect(Collectors.toList());
    }

    public List<MilitaryPlane> getMilitaryPlanes() {
        return planes.stream()
                .filter(o -> o instanceof MilitaryPlane)
                .map(o -> (MilitaryPlane) o)
                .collect(Collectors.toList());
    }

    public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
        return getPassengerPlanes().stream()
                .max(Comparator.comparingInt(PassengerPlane::getPassengersCapacity))
                .orElse(null);
    }

    public List<MilitaryPlane> getTransportMilitaryPlanes() {
        return getMilitaryPlanes().stream()
                .filter(o -> o.getMilitaryPlaneType() == MilitaryPlaneType.TRANSPORT)
                .collect(Collectors.toList());
    }

    public List<MilitaryPlane> getBomberMilitaryPlanes() {
        return getMilitaryPlanes().stream()
                .filter(o -> o.getMilitaryPlaneType() == MilitaryPlaneType.BOMBER)
                .collect(Collectors.toList());
    }

    public List<ExperimentalPlane> getExperimentalPlanes() {
        return planes.stream()
                .filter(o -> o instanceof ExperimentalPlane)
                .map(o -> (ExperimentalPlane) o)
                .collect(Collectors.toList());
    }

    public void sortPlanesByMaxFlightDistance() {
        planes.sort(Comparator.comparingInt(AbstractPlane::getMaxFlightDistance));
    }

    public void sortPlanesByMaxSpeed() {
        planes.sort(Comparator.comparingInt(AbstractPlane::getMaxSpeed));
    }

    public void sortPlanesByMaxLoadCapacity() {
        planes.sort(Comparator.comparingInt(AbstractPlane::getMaxLoadCapacity));
    }

    public List<? extends AbstractPlane> getAllPlanes() {
        return planes;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "Planes=" + planes.toString() +
                '}';
    }
}
