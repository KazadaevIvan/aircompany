package planes;

import java.util.Objects;

abstract public class AbstractPlane {
    private final String model;
    private final int maxSpeed;
    private final int maxFlightDistance;
    private final int maxLoadCapacity;

    public AbstractPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity) {
        this.model = model;
        this.maxSpeed = maxSpeed;
        this.maxFlightDistance = maxFlightDistance;
        this.maxLoadCapacity = maxLoadCapacity;
    }

    public String getModel() {
        return model;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public int getMaxFlightDistance() {
        return maxFlightDistance;
    }

    public int getMaxLoadCapacity() {
        return maxLoadCapacity;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "model='" + model + '\'' +
                ", maxSpeed=" + maxSpeed +
                ", maxFlightDistance=" + maxFlightDistance +
                ", maxLoadCapacity=" + maxLoadCapacity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractPlane that = (AbstractPlane) o;
        return maxSpeed == that.maxSpeed &&
                maxFlightDistance == that.maxFlightDistance &&
                maxLoadCapacity == that.maxLoadCapacity &&
                model.equals(that.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
    }
}
