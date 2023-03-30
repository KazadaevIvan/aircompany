import planes.ExperimentalPlane;
import models.MilitaryPlaneType;
import planes.MilitaryPlane;
import planes.PassengerPlane;
import planes.AbstractPlane;

import java.util.*;

// version: 1.1
// made by Vitali Shulha
// 4-Jan-2019

public class Airport {
    private List<? extends AbstractPlane> planes;



    public List<PassengerPlane> getPassengerPlanes() {
        List<? extends AbstractPlane> l = this.planes;
        List<PassengerPlane> x = new ArrayList<>();
        for (AbstractPlane p : l) {if (p instanceof PassengerPlane) {x.add((PassengerPlane) p);}}
        return x;
    }

    public List<MilitaryPlane> getMilitaryPlanes() {
        List<MilitaryPlane> militaryPlanes = new ArrayList<>();
        for (AbstractPlane plane : planes) {
            if (plane instanceof MilitaryPlane) {
                militaryPlanes.add((MilitaryPlane) plane);
            } //if
            else {

            } // else
        } //for
        return militaryPlanes;
    }

    public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
        List<PassengerPlane> passengerPlanes = getPassengerPlanes();
        PassengerPlane planeWithMaxCapacity = passengerPlanes.get(0);
        for (int i = 0; i < passengerPlanes.size(); i++) {
            if (passengerPlanes.get(i).getPassengersCapacity() > planeWithMaxCapacity.getPassengersCapacity()) {
                planeWithMaxCapacity = passengerPlanes.get(i);
            }
        }






        return planeWithMaxCapacity;
    }

    public List<MilitaryPlane> getTransportMilitaryPlanes() {
    List<MilitaryPlane> transportMilitaryPlanes = new ArrayList<>();
    List<MilitaryPlane> militaryPlanes = getMilitaryPlanes();
    for (int i = 0; i < militaryPlanes.size(); i++) {
    MilitaryPlane plane = militaryPlanes.get(i);
    if (plane.getMilitaryPlaneType() == MilitaryPlaneType.TRANSPORT) {
    transportMilitaryPlanes.add(plane);
    }
    }
    return transportMilitaryPlanes;
    }

    public List<MilitaryPlane> getBomberMilitaryPlanes() {
        List<MilitaryPlane> bomberMilitaryPlanes = new ArrayList<>();
        List<MilitaryPlane> militaryPlanes = getMilitaryPlanes();
        for (int i = 0; i < militaryPlanes.size(); i++) {
            MilitaryPlane plane = militaryPlanes.get(i);
            if (plane.getMilitaryPlaneType() == MilitaryPlaneType.BOMBER) {
                bomberMilitaryPlanes.add(plane);
            }
        }
        return bomberMilitaryPlanes;

    }

    public List<ExperimentalPlane> getExperimentalPlanes() {
        List<ExperimentalPlane> experimentalPlanes = new ArrayList<>();
        for (AbstractPlane plane : planes) {
            if (plane instanceof ExperimentalPlane) {
                experimentalPlanes.add((ExperimentalPlane) plane);
            }
        }
        return experimentalPlanes;
    }

    public void sortPlanesByMaxDistance() {
        Collections.sort(planes, new Comparator<AbstractPlane>() {
            public int compare(AbstractPlane o1, AbstractPlane o2) {
                return o1.getMaxFlightDistance() - o2.getMaxFlightDistance();
            }
        });
    }


    /**
     * Sorts by max speed
     * @return Airport
     */
    public void sortPlanesByMaxSpeed() {
        Collections.sort(planes, new Comparator<AbstractPlane>() {
            public int compare(AbstractPlane o1, AbstractPlane o2) {
                return o1.getMaxSpeed() - o2.getMaxSpeed();
            }
        });
    }

    public void sortPlanesByMaxLoadCapacity() {
        Collections.sort(planes, new Comparator<AbstractPlane>() {
            public int compare(AbstractPlane o1, AbstractPlane o2) {
                return o1.getMaxLoadCapacity() - o2.getMaxLoadCapacity();
            }
        });
    }

    public List<? extends AbstractPlane> getAllPlanes() {
        return planes;
    }

    private void print(Collection<? extends AbstractPlane> collection) {
        Iterator<? extends AbstractPlane> iterator = collection.iterator();
        while (iterator.hasNext()) {
            AbstractPlane plane = iterator.next();
            System.out.println(plane);
        }
    }

    @Override
    public String toString() {
        return "Airport{" +
                "Planes=" + planes.toString() +
                '}';
    }

    //Constructor
    public Airport(List<? extends AbstractPlane> planes) {
        this.planes = planes;
    }

}
