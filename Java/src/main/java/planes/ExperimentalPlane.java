package planes;

import models.ExperimentalPlaneSecrecyLevel;
import models.ExperimentalPlaneType;

import java.util.Objects;

public class ExperimentalPlane extends AbstractPlane {

    private ExperimentalPlaneType experimentalPlaneType;
    private ExperimentalPlaneSecrecyLevel classificationLevel;

    public ExperimentalPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, ExperimentalPlaneType experimentalPlaneType, ExperimentalPlaneSecrecyLevel classificationLevel) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.experimentalPlaneType = experimentalPlaneType;
        this.classificationLevel = classificationLevel;
    }

    public ExperimentalPlaneSecrecyLevel getClassificationLevel(){
        return classificationLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ExperimentalPlane that = (ExperimentalPlane) o;
        return experimentalPlaneType == that.experimentalPlaneType &&
                classificationLevel == that.classificationLevel;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), experimentalPlaneType, classificationLevel);
    }

    @Override
    public String toString() {
        return super.toString()
                .replace("Plane", "ExperimentalPlane")
                .replace("}",
                "ExperimentalPlane{" +
                "type=" + experimentalPlaneType +
                ", classificationLevel=" + classificationLevel +
                '}');
    }
}
