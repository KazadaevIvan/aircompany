package planes;

import models.ExperimentalPlaneSecrecyLevel;
import models.ExperimentalPlaneType;

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

    public void setClassificationLevel(ExperimentalPlaneSecrecyLevel classificationLevel){
        this.classificationLevel = classificationLevel;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "experimentalPlane{" +
                "model='" + getModel() + '\'' +
                '}';
    }
}
